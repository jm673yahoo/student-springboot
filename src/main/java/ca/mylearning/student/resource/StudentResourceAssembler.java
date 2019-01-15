package ca.mylearning.student.resource;

import ca.mylearning.student.model.Student;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Component
public class StudentResourceAssembler implements ResourceAssembler<Student,Resource<Student>> {

    @Override
    public Resource<Student> toResource(Student student) {

        return new Resource<>(student,
                linkTo(methodOn(StudentController.class).findOne(student.getId())).withSelfRel(),
                linkTo(methodOn(StudentController.class).getAll()).withRel("students"));
    }
}
