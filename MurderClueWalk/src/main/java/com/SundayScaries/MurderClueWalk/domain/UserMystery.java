package com.SundayScaries.MurderClueWalk.domain;



import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserMystery {

    @Id
    @GeneratedValue
    int userMysteryID;

    @NonNull
    @OneToMany // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
            int userID;

    @NonNull
    @OneToMany // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
            int mysteryID;
}