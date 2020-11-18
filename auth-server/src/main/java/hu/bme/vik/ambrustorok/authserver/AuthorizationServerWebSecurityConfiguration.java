package hu.bme.vik.ambrustorok.authserver;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.web.OAuth2TokenEndpointFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * This is the defualt auth server web security config with added cors and modified rquest matchers to catch the pre-flight OPTIONS requests.
 */
public class AuthorizationServerWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static RequestMatcher tokenEndpointMatcher() {
        return new AntPathRequestMatcher(
                OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI,
                HttpMethod.POST.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfigurer<HttpSecurity> authorizationServerConfigurer =
                new OAuth2AuthorizationServerConfigurer<>();

        List<RequestMatcher> requestMatchers = new ArrayList<>(authorizationServerConfigurer.getEndpointMatchers());
        requestMatchers.add(new AntPathRequestMatcher(OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI, HttpMethod.OPTIONS.name()));

        http
                .cors().and()
                .requestMatcher(new OrRequestMatcher(requestMatchers))
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.ignoringRequestMatchers(tokenEndpointMatcher()))
                .apply(authorizationServerConfigurer);
    }

}
