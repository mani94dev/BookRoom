package io.manivas.springmongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Teacher {
  @Id
  private String id;
  private String name;
  private String subject;
  private Integer age;

  public Teacher(String name, String subject, Integer age) {
    this.name = name;
    this.subject = subject;
    this.age = age;
  }
}
