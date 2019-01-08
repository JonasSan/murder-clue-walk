package com.SundayScaries.MurderClueWalk.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    int userID;

    @NonNull
    @Email
    @NotEmpty
    String loginName;

    @NonNull
    @Size(min = 5)
    String password;

    @NonNull
    @OneToOne // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
            int rankID;

    @NonNull
    double distance;

    @NonNull
    @ManyToOne // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
            int userMysteryID;

    @NonNull
    @NotEmpty
    int age;

    @NonNull
    @NotEmpty
    boolean gender;

    @NonNull
    @NotEmpty
    String country;

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", rankID=" + rankID +
                ", distance=" + distance +
                ", userMysteryID=" + userMysteryID +
                ", age=" + age +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                '}';
    }
}