package com.example.medilink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MediLinkApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MediLinkApplication.class, args);

        // Для демонстрации - бесконечный цикл, чтобы приложение не завершалось сразу
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
