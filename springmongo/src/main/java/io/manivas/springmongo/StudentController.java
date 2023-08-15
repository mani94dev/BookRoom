package io.manivas.springmongo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

  private StudentService studentService;

  @GetMapping
  List<Student> getAllStudents(){
    return studentService.getAllStudents();
  }

  @PostMapping
  void insertNewStudent(@RequestBody Student student){
    studentService.addNewStudent(student);
  }

  @DeleteMapping("{student_id}")
  void deleteStudent(@PathVariable("student_id") String studentId){
    studentService.deleteStudent(studentId);
  }

  @PutMapping("{student_id}")
  void updateStudent(@PathVariable("student_id") String studentId,
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String email){
    studentService.updateStudent(studentId,firstName,email);
  }

}
