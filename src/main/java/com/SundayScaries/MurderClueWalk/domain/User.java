package com.SundayScaries.MurderClueWalk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public String dogFact() {

        String fact = "";

        try {
            String url = "jdbc:mysql://localhost:3306/nestingdoll?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "lösenord");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM User");
            while (rs.next()) {
                fact = rs.getString("fact");
                System.out.println(fact);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return fact;
    }
}