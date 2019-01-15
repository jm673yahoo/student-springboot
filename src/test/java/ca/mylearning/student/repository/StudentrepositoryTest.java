package ca.mylearning.student.repository;

import ca.mylearning.student.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentrepositoryTest {

    @Autowired
    StudentRepository repository;

    @Test
    public void findsAllNotes() {
        List<Student> notes = this.repository.findAll();
        assertTrue("has 2 ", notes.size()==2);
    }

}
