package com.SundayScaries.MurderClueWalk.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Clue {

    @Id
    @GeneratedValue
    int clueID;

    @NonNull
    String clueText;

    @NonNull
    String location;

    @NonNull
    String images;

    @NonNull
    int mysteryID;

    @Override
    public String toString() {
        return "Clue{" +
                "clueID=" + clueID +
                ", clueText='" + clueText + '\'' +
                ", location='" + location + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}

