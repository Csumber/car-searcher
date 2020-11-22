package hu.bme.vik.ambrustorok.vehicleservice;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class VehicleServiceWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/swagger-resources/**", "/swagger-ui/", "/webjars/springfox-swagger-ui/**", "/v2/api-docs**", "/swagger**").permitAll()
                .antMatchers("/vehicle/**").hasRole("ADMIN")
                .antMatchers("/option/**").hasAnyRole("ADMIN", "USER", "MANUFACTURER")
                .antMatchers("/engine/**").permitAll()
                .anyRequest().authenticated()
                .and().oauth2ResourceServer().jwt();
    }
}
