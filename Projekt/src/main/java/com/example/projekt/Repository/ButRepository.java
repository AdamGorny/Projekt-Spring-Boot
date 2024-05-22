package com.example.projekt.Repository;

import com.example.projekt.Model.But;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButRepository extends JpaRepository<But, Integer> {
    But findById(int id);
}
