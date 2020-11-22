package hu.bme.vik.ambrustorok.vehicleservice;

import hu.bme.vik.ambrustorok.common.configuration.apidocs.ApiDocsConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Import({ApiDocsConfiguration.class,
        VehicleServiceWebSecurityConfig.class})
@Slf4j
@EnableSwagger2
@EnableFeignClients
public class VehicleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
        log.info("VehicleService has started successfully!");
    }
}
