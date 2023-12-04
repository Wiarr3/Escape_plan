package com.example.escapePlan.model;

import com.example.escapePlan.dto.userAccountDto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_junction",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Plan> plans;

    public User(String email,String username, String password) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.authorities = new HashSet<>();
    }

    public User(String username, String password){
        super();
        this.username = username;
        this.password = password;
        this.authorities = new HashSet<>();
    }

    public User() {
        super();
        this.authorities = new HashSet<>();
    }

    public void copyFromDto(UserDto dto) {
        setPassword(dto.getPassword());
        setEmail(dto.getEmail());
        setUsername(dto.getUsername());
    }
    public UserDto createDto(){
        return new UserDto(email,username,password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
