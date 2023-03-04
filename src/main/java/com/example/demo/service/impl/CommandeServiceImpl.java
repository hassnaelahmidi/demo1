package com.example.demo.service.impl;

import com.example.demo.bean.Commande;
import com.example.demo.service.facade.CommandeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CommendeDao;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Override
    @Deprecated

    public int save(Commande commande) {
        if(findByRef(commande.getRef())!=null){
            return -1;
        }else if(commande.getTotalpaye()>commande.getTotal()){
            return -2;
        }else{
            commendeDao.save(commande);
            return 1;
        }
    }
    @Override
    public Commande update(Commande commande){
        return commendeDao.save(commande);
    }
    @Override
    public Commande findByRef(String ref) {
        return commendeDao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return commendeDao.deleteByRef(ref);
    }

    @Override
    public List<Commande> findAll() {
        return commendeDao.findAll();
    }

    @Autowired
    private CommendeDao commendeDao;

    @Override
    public List<Commande> findByRefLikeAndTotalGreaterThan(String ref, double total) {
        return null;
    }
}
