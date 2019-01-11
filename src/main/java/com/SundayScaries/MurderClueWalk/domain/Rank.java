package com.SundayScaries.MurderClueWalk.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rank {

    @Id
    private int rankID;

    @NonNull
    private int rankNumber;

    @Override
    public String toString() {
        return "Rank{" +
                "rankID=" + rankID +
                ", rankNumber=" + rankNumber +
                '}';
    }
}