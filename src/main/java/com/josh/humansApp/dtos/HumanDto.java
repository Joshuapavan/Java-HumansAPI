package com.josh.humansApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HumanDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private boolean isAdult;
    private int age;
}
