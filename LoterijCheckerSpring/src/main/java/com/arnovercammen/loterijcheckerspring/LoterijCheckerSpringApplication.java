package com.arnovercammen.loterijcheckerspring;

import com.arnovercammen.loterijcheckerspring.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class LoterijCheckerSpringApplication {

    @Value("${checker.user.name}")
    private String username;
    @Value("${checker.user.password}")
    private String password;
    public static void main(String[] args) {
        SpringApplication.run(LoterijCheckerSpringApplication.class, args);
    }

    @Autowired
    public void commandLineRunner(LottoService lottoService) {
        System.out.println(username);
        System.out.println(password);
    }

}
