package com.example.demo.workflow.commande.payer;

import com.example.demo.bean.Commande;

public interface CommandePayerProcess {
    public int run(Commande commande);

    int run(String ref, double montant);
}
