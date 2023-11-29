package com.example.studia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/dataBase")
public class DataBaseControler {

     DataBaseRepository dataBaseRepository;

    public DataBaseControler(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }
    public void addFamily(String name, String origin, long head) {
        DataBase dataBase = new DataBase(1, name, origin , head);
        dataBaseRepository.save(dataBase);
    }

    public void addFamily2() {
        DataBase dataBase = new DataBase(2, "123", "origin" , 3);
        dataBaseRepository.save(dataBase);
    }
}
