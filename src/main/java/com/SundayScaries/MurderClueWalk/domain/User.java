package com.SundayScaries.MurderClueWalk.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Email
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String loginName;

    @NonNull
    @Size(min = 5)
    private String password;

//    @NonNull
////    @OneToOne(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//    Rank rank;

    @NonNull
    private double distance;

    @NonNull
    private double score;

    @NonNull
    private int rank;

//    @NonNull
//    @ManyToOne(fetch = FetchType.EAGER) // Låt denna vara på default EAGER men ändra till explicit EAGER om den inte fungerar
//            int userMysteryID;

    @NonNull
    private int age;

    @NonNull
    @NotEmpty
    private String gender;

    @NonNull
    @NotEmpty
    private String country;

    @NonNull
    @Column(nullable = true)
    private boolean enabled;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();


    public void addRole(Role role){
        roles.add(role);
    }

    public void addRoles(Set<Role> roles){
        roles.forEach(this::addRole);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    @Override
    public String getUsername() {
        return loginName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    public User(@NonNull @Email @NotEmpty String loginName, @NonNull @Size(min = 5) String password, @NonNull @NotEmpty String gender, @NonNull int age, @NonNull @NotEmpty String country) {
        this.loginName = loginName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", distance=" + distance +
                ", age=" + age +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                '}';
    }
}