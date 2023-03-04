package com.example.demo.workflow.util;

import com.example.demo.service.facade.CommandeService;
import com.example.demo.service.impl.CommandeServiceImpl;
import com.example.demo.workflow.commande.payer.CommandePayerProcess;
import com.example.demo.workflow.commande.payer.CommandePayerProcessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class injector {
    @Bean
    public CommandePayerProcess commandePayerPtocess(CommandeService commandeService){
        return new CommandePayerProcessImpl(commandeService);
    }
}
