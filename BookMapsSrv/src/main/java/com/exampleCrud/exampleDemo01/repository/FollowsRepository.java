package com.exampleCrud.exampleDemo01.repository;

import com.exampleCrud.exampleDemo01.model.Follows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowsRepository extends JpaRepository<Follows,Long> {
    //crud
}
