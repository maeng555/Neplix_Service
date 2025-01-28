package com.example.security2.repository;

import com.example.security2.domain.CreateUser;
import com.example.security2.domain.EncryptionAlogrithm;
import com.example.security2.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.security.auth.kerberos.EncryptionKey;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private EncryptionAlogrithm algorithm;
    @OneToMany(mappedBy = "userEntity",fetch = FetchType.EAGER)
    private List<AuthorityEntity> authorities;

    public UserEntity(String username,String password,EncryptionAlogrithm algorithm){
        this.username = username;
        this.password =password;
        this.algorithm = algorithm;
    }
    public User touser(){
        return User.builder()
                .username(this.username)
                .password(this.password)
                .algorithm(this.algorithm)
                .authorities(this.authorities.stream().map(AuthorityEntity::toAuthority).toList())
                .build();

    }
    public void replaceAuthority(List<AuthorityEntity> authorities){this.authorities= authorities;}

    public static UserEntity newUser(CreateUser create){
        return new UserEntity(
                create.getUsername(),
                create.getPassword(),
                EncryptionAlogrithm.BCRYPT

        ); //새로운 유저를 만들기 위한 스태틱메서드
    }

}
