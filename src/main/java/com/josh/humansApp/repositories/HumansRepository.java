package com.josh.humansApp.repositories;

import com.josh.humansApp.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumansRepository extends JpaRepository<Human,Long> {
}
