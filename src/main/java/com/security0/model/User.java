package com.security0.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_group")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String firstName;
    private String lastName;
    private String organisation;
    private String tel;
    private String email;
}
