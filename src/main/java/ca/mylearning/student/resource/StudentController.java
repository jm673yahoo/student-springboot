package ca.mylearning.student.resource;

import ca.mylearning.student.model.Student;
import ca.mylearning.student.repository.StudentRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
class StudentController {
    private final StudentRepository studentRepository;
    private final StudentResourceAssembler studentResourceAssembler;

    StudentController(StudentRepository studentRepository, StudentResourceAssembler assembler){
        this.studentRepository = studentRepository;
        studentResourceAssembler = assembler;
    }

    @GetMapping("/students")
    Resources<Resource<Student>> getAll() {

        List<Resource<Student>> students = studentRepository.findAll().stream()
                .map(studentResourceAssembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(students,
                linkTo(methodOn(StudentController.class).getAll()).withSelfRel());
    }

    @GetMapping("/students/{id}")
    Resource<Student> findOne(@PathVariable Long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        return studentResourceAssembler.toResource(student);
    }
}
