package com.example.fcss_01.config;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        //return new InMemoryUserDetailsManager(); //재정의 햇기에 이제 터미널에 패스워드 uuid안나옴
        InMemoryUserDetailsManager inMemoryUserDetailsManager= new InMemoryUserDetailsManager();
        UserDetails danny = User.builder().username("danny").password("password").build();
        inMemoryUserDetailsManager.createUser(danny);
        return inMemoryUserDetailsManager; //이렇게 만들고 포스트맨가서 인증권한에 user: uuid 친것처럼 danny passwor하면
        //당연히 오류  이유- > 패스워드를 넣엇는데 패스워드인코더를 관리하는 정의를 안함 즉 재정의를해야함
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    } //재정의 근데 저 No~~ 가뭐야? 인코더를 안하고 바로 패스워드 관리  테스트용으로만 하기
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .authorizeHttpRequests((auth)->auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()); //모든요청에대한 요구
        return httpSecurity.build();
    }
}
