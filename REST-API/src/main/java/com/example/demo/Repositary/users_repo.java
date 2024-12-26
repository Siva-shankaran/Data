package com.example.demo.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.Users;

public interface users_repo extends JpaRepository<Users, Integer> {

}
