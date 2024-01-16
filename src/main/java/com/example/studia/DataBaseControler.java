package com.example.studia;

import com.example.studia.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/dataBase")
public class DataBaseControler {

     DataBaseRepository dataBaseRepository;

    public DataBaseControler(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public void addFamily(String name, String origin, long head) {
        DataBase dataBase = new DataBase(5, name, origin , head);
        dataBaseRepository.save(dataBase);
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void addFamily2() {
        DataBase dataBase = new DataBase(2, "123", "origin" , 3);
        dataBaseRepository.save(dataBase);
    }
}
