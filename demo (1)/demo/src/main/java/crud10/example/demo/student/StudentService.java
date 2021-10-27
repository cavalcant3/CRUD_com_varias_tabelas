package crud10.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        //validação
        Optional<Student> studentOptional = studentRepistory
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepistory.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepistory.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("student with id" + studentId + "does not exists");

        }
        studentRepistory.deleteById(studentId);


       
    }

    public void replace(Student student) {
        deleteStudent(student.getId());
        studentRepistory.save(student);
    }
}
