package com.greenfox.books.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.greenfox.books.security.AppUserPermission.ADMIN_READ;
import static com.greenfox.books.security.AppUserPermission.ADMIN_WRITE;
import static com.greenfox.books.security.AppUserRole.ADMIN;
import static com.greenfox.books.security.AppUserRole.USER;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index").permitAll()
                .antMatchers(HttpMethod.DELETE, "/admin").hasAuthority(ADMIN_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/admin").hasAuthority(ADMIN_WRITE.getPermission())
                .antMatchers("/admin/**").hasRole(ADMIN.name())
                .antMatchers("/search/**").hasAnyRole(ADMIN.name(), USER.name())
                .anyRequest()
                .authenticated()
                .and()
//                .formLogin();
                .httpBasic();
    }


/*    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((userDetailsService));
    }*/

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("user1")
                .password(passwordEncoder.encode("pw1"))
//                .roles(USER.name())
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails admin1 = User.builder()
                .username("admin1")
                .password(passwordEncoder.encode("pw"))
 //               .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(user1, admin1);
    }
}