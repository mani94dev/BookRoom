package io.manivas.springmongo;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherService {

  private final TeacherRepository teacherRepository;


  public List<Teacher> getAllTeachers() {
    return teacherRepository.findAll();
  }

  public Boolean addTeacher(Teacher teacher) {
    Optional<Teacher> isTeacherPresent = teacherRepository.findByName(teacher.getName());
    if (!isTeacherPresent.isPresent()) {
      teacherRepository.insert(teacher);
      return true;
    } else {
      return false;
    }
  }

  public Teacher getTeacher(String name) {
    Optional<Teacher> byName = teacherRepository.findByName(name);
    if (byName.isPresent()) {
      return byName.get();
    } else {
      return null;
    }
  }
}
