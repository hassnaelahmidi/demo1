package com.example.demo.service.facade;

import com.example.demo.bean.Commande;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CommandeService {
    @Deprecated
    int save(Commande commande);

    Commande update(Commande commande);

    Commande findByRef(String ref);

    @Transactional
    int deleteByRef(String ref);

    List<Commande> findAll();


    List<Commande> findByRefLikeAndTotalGreaterThan(String ref, double total);
}
