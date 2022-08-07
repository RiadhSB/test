package com.test.application.repository;

import com.test.application.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonneRepository extends JpaRepository<Personne, Long> {
    public List<Personne> findAllByOrderByPrenomAsc();
}

