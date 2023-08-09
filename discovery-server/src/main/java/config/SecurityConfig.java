//package config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            .requestMatchers("/eureka/.*").hasRole("ADMIN")
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic()
//            .and()
//            .csrf().disable();
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("eureka")
//            .password("password")
//            .roles("ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//}
