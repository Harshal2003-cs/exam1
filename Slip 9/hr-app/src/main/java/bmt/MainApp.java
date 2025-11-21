package bmt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context from AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Bean
        EmployeeService service = context.getBean(EmployeeService.class);

        // Use Bean
        service.addEmployee("Alice");
        service.addEmployee("Bob");
    }
}
