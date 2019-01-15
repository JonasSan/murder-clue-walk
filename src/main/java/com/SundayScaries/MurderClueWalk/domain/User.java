package com.SundayScaries.MurderClueWalk.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private int userID;

    @NonNull
    @Email
    @NotEmpty
    private String loginName;

    @NonNull
    @Size(min = 5)
    private String password;

//    @NonNull
////    @OneToOne(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//    Rank rank;

    @NonNull
    private double distance;

    @NonNull
    private double score;

    @NonNull
    private int rank;

//    @NonNull
//    @ManyToOne(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//            int userMysteryID;

    @NonNull
    private int age;

    @NonNull
    @NotEmpty
    private String gender;

    @NonNull
    @NotEmpty
    private String country;


    public User(@NonNull @Email @NotEmpty String loginName, @NonNull @Size(min = 5) String password, @NonNull @NotEmpty String gender,@NonNull int age,  @NonNull @NotEmpty String country) {
        this.loginName = loginName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", distance=" + distance +
                ", age=" + age +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                '}';
    }
}