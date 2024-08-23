package com.exampleCrud.exampleDemo01.repository;

import com.exampleCrud.exampleDemo01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //crud
}
