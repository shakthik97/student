package edu.project.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private String gender;
    private String address;
    private String contactNumber;
}
