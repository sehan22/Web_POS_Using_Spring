package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.CustomerCRUDController;
import lk.ijse.spring.controller.ItemCRUDController;
import lk.ijse.spring.controller.PurchaseOrderController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {CustomerCRUDController.class, ItemCRUDController.class, PurchaseOrderController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("WebAppConfig : Instantiated..!");
    }
}
