package com.SundayScaries.MurderClueWalk.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Clue {

    @Id
    @GeneratedValue
    int clueID;

    @NonNull
    String clueName;

    @NonNull
    String location;

    @NonNull
    String images;

    @Override
    public String toString() {
        return "Clue{" +
                "clueID=" + clueID +
                ", clueName='" + clueName + '\'' +
                ", location='" + location + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}

