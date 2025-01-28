package com.example.security2.domain;

import lombok.Builder;
import lombok.Getter;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;

import java.util.List;

@Builder
@Getter
public class User {
    private String username;
    private String password;
    private EncryptionAlogrithm algorithm;
    private List<Authority> authorities;
}
