package hu.bme.vik.ambrustorok.authserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.keys.KeyManager;
import org.springframework.security.crypto.keys.StaticKeyGeneratingKeyManager;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class AuthorizationServerConfig {

    @Bean
    public WebSecurityConfigurer<WebSecurity> defaultOAuth2AuthorizationServerSecurity() {
        return new AuthorizationServerWebSecurityConfiguration();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    /**
     * Itt most beégetjük milyen klienseink (alkalmazás komponenseink) vannak a rendszerben.
     * @return
     */
    @Bean
    public RegisteredClientRepository registeredClientRepository() {
//        // A frontend
//        RegisteredClient frontendClient = RegisteredClient.withId("1138c5af-fd56-4a58-8c8f-769c2e327433")
//                .clientId("adventure-capital-frontend")
//                .clientSecret("ca8831eb-e504-46f1-a514-8be84ba892ed") // Ezt elvileg public clientnél nem kellene megadni
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri("http://localhost:4200/*")
//                .redirectUri("http://localhost:8080/swagger-ui/oauth2-redirect.html")
//                .build();

        // Az API-Gateway
        RegisteredClient apiGateway = RegisteredClient.withId("c681c3d5-fa87-4cd7-b8fc-650862c0cc6e")
                .clientId("api-gateway")
                .clientSecret("546c5e7b-bd66-4df3-a601-8a31a4bee482")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .build();

        // Car service
        RegisteredClient carService = RegisteredClient.withId("1b233dee-7150-4334-b50e-99943ce00479")
                .clientId("car-service")
                .clientSecret("eb2d6d80-417c-44d0-8e4a-3b105e154258")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .build();

//        // Investment service
//        RegisteredClient investmentService = RegisteredClient.withId("d99642ac-78ca-47e1-ae13-85d8836ed5ca")
//                .clientId("investment-sevice")
//                .clientSecret("16092ceb-a272-4e02-a286-abc28a3b1b97")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .build();

//        // Startup service
//        RegisteredClient startupService = RegisteredClient.withId("8a1d5246-b465-4672-a14b-796559ff1d34")
//                .clientId("startup-sevice")
//                .clientSecret("65584896-10bc-4965-9e2f-824765977736")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .build();

//        // VC service
//        RegisteredClient vcService = RegisteredClient.withId("02032352-50dd-4c5f-92c8-2b53fb2b764b")
//                .clientId("vc-sevice")
//                .clientSecret("f3c2557d-ab7c-4b9f-a287-9e5b9b5eb599")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .build();


        return new InMemoryRegisteredClientRepository(
                //frontendClient,
                apiGateway,
                carService
                //investmentService,
                //startupService,
                //vcService
        );
    }

    @Bean
    public KeyManager keyManager() {
        return new StaticKeyGeneratingKeyManager();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}