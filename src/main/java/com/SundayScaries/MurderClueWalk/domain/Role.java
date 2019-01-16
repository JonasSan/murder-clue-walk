package com.SundayScaries.MurderClueWalk.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String name;

    @ManyToMany( mappedBy = "roles")
    private Collection<User> users;

    public Role(int id, String name, Collection<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
}