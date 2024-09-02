package com.maps.book.repository;

import com.maps.book.model.Follows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowsRepository extends JpaRepository<Follows,Long> {
    //crud
}
