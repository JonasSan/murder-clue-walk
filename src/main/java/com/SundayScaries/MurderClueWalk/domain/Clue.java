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
    private int clueID;

    @NonNull
    private String clueText;

    @NonNull
    private String location;

    @NonNull
    private String images;

    @NonNull
    private int mysteryID;

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

