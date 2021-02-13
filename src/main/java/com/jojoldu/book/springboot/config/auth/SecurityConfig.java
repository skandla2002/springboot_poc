package com.jojoldu.book.springboot.config.auth;


import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션 disable
                .and()
                    .authorizeRequests() // URL별 권한 관리 설정옵션의 시작점, 이후 antMachers옵션 사용 가능
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // 권한 대상을 지정하는 옵션, URL, HTTP 메소드별로 관리가 가능,
                    // "/"등 지정된 URL들은 permitAll()옵션을 통해 전체 열람 권한 줌
                    .anyRequest().authenticated() //설정된 값 이외 나머지 URL
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 기능시 여러 설정의 진입점
                .and()
                    .oauth2Login() // OAuth 2 로그인 기능에 대한 여러 설정 진입점
                        .userInfoEndpoint() // OAuth 2 로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당함
                            // 소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스 구현체
                            .userService(customOAuth2UserService);
    }
}
