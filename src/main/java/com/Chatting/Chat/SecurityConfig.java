
package com.Chatting.Chat;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
    
     @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
      @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
       
        return authProvider;
    }
    
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        auth.inMemoryAuthentication()
                .withUser("Mario")
                .password("{noop}123")
                .roles("USER","ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/user/new","/user/Confi/**",
                        "/user/erase/**","/user/save",
                        "/community/new","/community/Confi/**",
                        "/community/erase/**","/community/save",
                        "/category/new","/category/Confi/**",
                        "/category/erase/**","/category/save","/UserLogin","sign_in",
                        "sign_in/Data_recolectation",
                        "/started_sesion/User_Main_Page",
                        "/","/started_sesion/Profile","Data_recolectation","started_sesion/User_Main_Page",
                                 "started_sesion/User_Main_Page/**","/community/join/**","/login"
                       ).authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/started_sesion/User_Main_Page")
                
            .and()
            .logout().logoutSuccessUrl("/").permitAll()
             .and().exceptionHandling().accessDeniedPage("/errors/403");
    }
    
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Mario")
                .password("{noop}123")
                .roles("USER","ADMIN")
                .and()
                .withUser("Milktank")
                .password("{noop}345")
                .roles("USER");
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/user/new","/user/Confi/**",
                        "/user/erase/**","/user/save",
                        "/community/new","/community/Confi/**",
                        "/community/erase/**","/community/save",
                        "/category/new","/category/Confi/**",
                        "/category/erase/**","/category/save")
                .hasRole("USER")
                .antMatchers("/user/list",
                        "/category/list",
                            "/community/list","/")
                .hasRole("USER")
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errors/403");
               
    }
*/
    
    
}
