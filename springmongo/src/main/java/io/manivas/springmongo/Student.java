package io.manivas.springmongo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Student {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private Gender gender;
  @Indexed(unique = true)
  private String email;
  private Address address;
  private List<String> favSubjects;
  private BigDecimal totalSpentOnBooks;
  private LocalDateTime createdAt;

  public Student(String firstName, String lastName, Gender gender, String email, Address address,
      List<String> favSubjects, BigDecimal totalSpentOnBooks, LocalDateTime createdAt) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.email = email;
    this.address = address;
    this.favSubjects = favSubjects;
    this.totalSpentOnBooks = totalSpentOnBooks;
    this.createdAt = createdAt;
  }

}
