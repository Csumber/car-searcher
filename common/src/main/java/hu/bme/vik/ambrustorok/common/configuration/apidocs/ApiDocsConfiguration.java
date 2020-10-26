package hu.bme.vik.ambrustorok.common.configuration.apidocs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

import java.util.Collections;

@Configuration
public class ApiDocsConfiguration {

    @Value("http://localhost:9000/oauth2")
    private String authServerUrl;

    private static final String CLIENT_SECRET = "ca8831eb-e504-46f1-a514-8be84ba892ed";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("hu.jlaci.ac"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new AuthorizationCodeGrantBuilder()
                .tokenEndpoint(b -> b.url(authServerUrl + "/token").tokenName("oauthtoken"))
                .tokenRequestEndpoint(b -> b.url(authServerUrl + "/authorize").clientSecretName(CLIENT_SECRET)).build();

        return new OAuthBuilder().name("spring_oauth")
                .grantTypes(Collections.singletonList(grantType))
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("spring_oauth", new AuthorizationScope[]{})))
                .operationSelector(s -> !s.requestMappingPattern().matches(".*/public.*"))
                .build();
    }
}
