package com.example.demo.workflow.commande.payer;

import com.example.demo.bean.Commande;
import com.example.demo.service.facade.CommandeService;

public class CommandePayerProcessImpl implements CommandePayerProcess {
    private  CommandeService commandeService;
    private CommandeService commendeService;


    @Override
    public int run(Commande commande) {
        return 0;
    }

    @Override
    public int run(String ref, double montant) {

            Commande commande = commandeService.findByRef(ref);
            if (commande == null) {
                return -1;
            } else if (commande.getTotalpaye() + montant> commande.getTotal()) {
                return -2;
            } else {
                double nvtotalpayer = commande.getTotalpaye() + montant;
                commande.setTotalPaye(nvtotalpayer);
                commendeService.update(commande);
                return 1;
            }
        }
    public CommandePayerProcessImpl(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    }


