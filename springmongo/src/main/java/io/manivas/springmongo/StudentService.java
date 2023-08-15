package io.manivas.springmongo;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class StudentService {

  private final StudentRepository studentRepository;


  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
    if(studentByEmail.isPresent()){
      throw new IllegalArgumentException("Student email already present in the database");
    }
    studentRepository.insert(student);
  }

  public void deleteStudent(String studentId) {
    Optional<Student> byId = studentRepository.findById(studentId);
    if(byId.isPresent()){
      studentRepository.deleteById(studentId);
    }
  }

  @Transactional
  public void updateStudent(String studentId, String firstName, String email) {
    Optional<Student> byId = studentRepository.findById(studentId);
    if(!byId.isPresent()){
      throw new IllegalArgumentException("Student not found to update");
    }
    Student student = byId.get();
    student.setFirstName(firstName);
    student.setEmail(email);
    studentRepository.save(student);
  }
}
