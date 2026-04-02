package com.testemegasena.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MegaApplication {

    public static void main(String[] args) {

        System.out.println("🚀 Iniciando Mega-Sena AI...");

        SpringApplication.run(MegaApplication.class, args);

        System.out.println("🌐 API disponível em:");
        System.out.println("http://localhost:8080/mega/aposta");
        System.out.println("http://localhost:8080/mega/top10");
        System.out.println("http://localhost:8080/mega/tendencias");
        System.out.println("http://localhost:8080/mega/probabilidade");
    }
}