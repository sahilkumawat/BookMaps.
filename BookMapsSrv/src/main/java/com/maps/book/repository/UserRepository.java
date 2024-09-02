package com.maps.book.repository;

import com.maps.book.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //crud
}
