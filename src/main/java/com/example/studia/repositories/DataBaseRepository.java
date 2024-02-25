package com.example.studia.repositories;

import com.example.studia.DataBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataBaseRepository extends JpaRepository<DataBase, Long>{
}
