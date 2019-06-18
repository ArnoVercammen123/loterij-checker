package com.arnovercammen.loterijcheckerspring;

import com.arnovercammen.loterijcheckerspring.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class LoterijCheckerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoterijCheckerSpringApplication.class, args);
    }

    @Autowired
    public void commandLineRunner(LottoService lottoService) {
        HashMap<String,Double> map = new HashMap<>();
        map.put("a", 0.0);
        map.put("a", 1.0);

        for (Map.Entry<String,Double> e : map.entrySet()){
            System.out.println(e.getKey() + e.getValue());
        }

    }
}
