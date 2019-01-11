package com.SundayScaries.MurderClueWalk.domain;

import lombok.*;

import javax.persistence.*;

@Entity
//@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserMystery {

    @Id
    @GeneratedValue
    private int userMysteryID;

//    @NonNull
//    @OneToMany(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//            int userID;
//
//    @NonNull
//    @OneToMany(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//            int mysteryID;
}