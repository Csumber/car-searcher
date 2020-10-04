package bme.vik.ambrustorok.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//based on https://github.com/shuaicj/zuul-auth-example
//and on https://github.com/szerhusenBC/jwt-spring-security-demo
//mostly https://github.com/svlada/springboot-security-jwt
//i like most https://github.com/TechPrimers/jwt-security-example/tree/master/src/main

@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

}
