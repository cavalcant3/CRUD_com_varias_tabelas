package crud10.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepistory studentRepistory;

    @Autowired
    public StudentService(StudentRepistory studentRepistory) {
        this.studentRepistory = studentRepistory;
    }

    public List<Student> getStudents() {
        return studentRepistory.findAll();
    }
}
