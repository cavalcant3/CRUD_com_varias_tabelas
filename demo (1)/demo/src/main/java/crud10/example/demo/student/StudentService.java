package crud10.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    //@Transactional
   // public void replace(Student student) {
   //     deleteStudent(student.getId());
   //     studentRepistory.save(student);
 //   }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepistory.findById(studentId)
                .orElseThrow(()-> new IllegalStateException(
                        "student with id" + studentId + "does not exists"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email != null &&
             email.length()> 0 &&
        !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepistory
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
