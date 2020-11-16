package hu.bme.vik.ambrustorok.searchservice;

import hu.bme.vik.ambrustorok.common.configuration.apidocs.ApiDocsConfiguration;
import hu.bme.vik.ambrustorok.common.configuration.apidocs.ResourceServerWebSecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Import({ApiDocsConfiguration.class, ResourceServerWebSecurityConfig.class})
@Slf4j
@EnableSwagger2
@EnableFeignClients
public class SearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
        log.info("VehicleService has started successfully!");
    }
}
