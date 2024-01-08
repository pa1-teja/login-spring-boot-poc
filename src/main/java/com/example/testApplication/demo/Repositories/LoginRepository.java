package com.example.testApplication.demo.Repositories;


import com.example.testApplication.demo.Entities.LoginTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginTable, Long> {
    LoginTable findUserByName(String name);
}
