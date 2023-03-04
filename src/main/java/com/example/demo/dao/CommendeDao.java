package com.example.demo.dao;

import com.example.demo.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommendeDao extends JpaRepository<Commande,Long> {
    Commande findByRef(String ref);
    int deleteByRef(String ref);
}
