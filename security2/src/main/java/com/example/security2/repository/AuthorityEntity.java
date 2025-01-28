package com.example.security2.repository;

import com.example.security2.domain.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities")
public class AuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @JoinColumn(name = "userEntity")
    @ManyToOne
    private UserEntity userEntity;

    public AuthorityEntity(String name,UserEntity user){
        this.name =name;
        this.userEntity = user;
    }
    public Authority toAuthority(){
        return Authority.builder()
                .name(this.name)
                .build();
    }

}
