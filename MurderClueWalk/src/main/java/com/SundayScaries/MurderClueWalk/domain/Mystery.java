package com.SundayScaries.MurderClueWalk.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mystery {

    @Id
    @GeneratedValue
    int mysteryID;

    @NonNull
    String mysteryName;

    @NonNull
    String images;

    @NonNull
    String text;

//    @NonNull
//    @ManyToOne(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//    int clueID;

    @NonNull
    int score;

//    @NonNull
//    @ManyToOne(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//    int userMysteryID;

    @Override
    public String toString() {
        return "Mystery{" +
                "mysteryID=" + mysteryID +
                ", mysteryName='" + mysteryName + '\'' +
                ", images='" + images + '\'' +
                ", text='" + text + '\'' +
                ", score=" + score +
                '}';
    }
}