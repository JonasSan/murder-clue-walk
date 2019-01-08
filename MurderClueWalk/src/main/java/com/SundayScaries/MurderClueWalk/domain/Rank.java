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
    int rankID;

    @NonNull
    int rankNumber;

    @NonNull
    int score;

    @Override
    public String toString() {
        return "Rank{" +
                "rankID=" + rankID +
                ", rankNumber=" + rankNumber +
                ", score=" + score +
                '}';
    }
}