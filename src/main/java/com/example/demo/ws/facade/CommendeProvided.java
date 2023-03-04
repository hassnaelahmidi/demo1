package com.example.demo.ws.facade;

import com.example.demo.bean.Commande;
import com.example.demo.service.facade.CommandeService;
import com.example.demo.service.impl.CommandeServiceImpl;
import com.example.demo.workflow.commande.payer.CommandePayerProcess;
import com.example.demo.ws.converter.CommandeConverter;
import com.example.demo.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commande")
public class CommendeProvided {
    @PostMapping("/")
    public int save(@RequestBody CommandeDto commandeDto) {
        Commande commande = commandeConverter.toItem(commandeDto);
        return commandeService.save(commande);
    }


    @GetMapping("/ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande commande = commandeService.findByRef(ref);
        CommandeDto commandeDto = commandeConverter.toDto(commande);
      return commandeDto;
    }
@GetMapping("/")
    public List<CommandeDto> findAll() {
    List<Commande> commandes = commandeService.findAll();
    List <CommandeDto> commandeDtos  = commandeConverter.toDto(commandes);
    return commandeDtos;
    }
    @GetMapping("/ref/{ref}/total/{total}")
    public List<Commande> findbyRefLikeAndTotalCreaterThan(@PathVariable String ref, double total){
        List <Commande> commandes = commandeService.findByRefLikeAndTotalGreaterThan(ref, total);
        List<CommandeDto> commandeDtos = commandeConverter.toDto(commandes);
        return commandes;
    }
@PutMapping("/payer/ref/{ref}/mt/{mt}")
public  int payer(@PathVariable String ref , @PathVariable double mt){

    return commandePayerProcess.run(ref,mt);
}
@Autowired
    private CommandePayerProcess commandePayerProcess;
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return commandeService.deleteByRef(ref);
    }
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CommandeConverter commandeConverter;
}
