package hu.bme.vik.ambrustorok.authserver;

import hu.bme.vik.ambrustorok.authserver.workaround.WorkAroundFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.web.OAuth2TokenEndpointFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

public class AuthorizationServerWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfigurer<HttpSecurity> authorizationServerConfigurer =
                new OAuth2AuthorizationServerConfigurer<>();

        List<RequestMatcher> requestMatchers = new ArrayList<>(authorizationServerConfigurer.getEndpointMatchers());
        requestMatchers.add(new AntPathRequestMatcher(OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI, HttpMethod.OPTIONS.name()));

        http
                .cors().and()
                .addFilterAfter(new WorkAroundFilter(), SecurityContextPersistenceFilter.class)
                .requestMatcher(new OrRequestMatcher(requestMatchers))
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.ignoringRequestMatchers(tokenEndpointMatcher()))
                .apply(authorizationServerConfigurer);
    }

    private static RequestMatcher tokenEndpointMatcher() {
        return new AntPathRequestMatcher(
                OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI,
                HttpMethod.POST.name());
    }

}
