package com.SundayScaries.MurderClueWalk.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mystery {

    @Id
    @GeneratedValue
    private int mysteryID;

    @NonNull
    private String mysteryName;

    @NonNull
    private String images;

    @NonNull
    private String text;

    @NonNull
    private String location;

    @NonNull
    private int score;

    @NonNull
    @OneToMany(fetch = FetchType.EAGER)
            @JoinColumn(name = "mysteryID")
    List<Clue> clues = new ArrayList<>();

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