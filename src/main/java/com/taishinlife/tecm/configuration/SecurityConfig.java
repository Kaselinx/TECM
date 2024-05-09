package com.taishinlife.tecm.configuration;


import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.core.userdetails.User; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.provisioning.InMemoryUserDetailsManager; 
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	// create a default admin in every environment but prod. 
	@Profile("!prod")
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) { 
  
        // InMemoryUserDetailsManager 
        UserDetails admin = User.withUsername("taishianAdm") 
                .password(encoder.encode("123")) 
                .roles("ADMIN", "USER") 
                .build(); 
  
        UserDetails user = User.withUsername("taishianUser") 
                .password(encoder.encode("123")) 
                .roles("USER") 
                .build(); 
  
        return new InMemoryUserDetailsManager(admin, user); 
    } 
  

	// Configuring HttpSecurity quick setting
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
    	   return http.csrf().disable() 
    	            .authorizeHttpRequests() 
    	            .requestMatchers(("/auth/welcome")).permitAll() 
    	             // allow static resource to be access without login js,css and images folder
    	            .requestMatchers("/js/**", "/css/**", "/images/**").permitAll() 
    	            // allow access after login.
    	            .requestMatchers("/auth/user/**", "/auth/admin/**").authenticated() 
    	            .anyRequest().authenticated()
    	            .and().formLogin() 
    	            .and().build(); 
    }
}
