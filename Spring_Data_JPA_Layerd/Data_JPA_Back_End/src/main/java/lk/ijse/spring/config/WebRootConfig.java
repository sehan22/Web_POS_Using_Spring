package lk.ijse.spring.config;

import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.service.impl.ItemServiceImpl;
import lk.ijse.spring.service.impl.PurchaseOrderServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {CustomerServiceImpl.class, ItemServiceImpl.class, PurchaseOrderServiceImpl.class})
public class WebRootConfig {
    public WebRootConfig() {
        System.out.println("WebRootConfig : Instantiated..!");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
