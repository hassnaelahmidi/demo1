package com.example.demo.ws.converter;

import com.example.demo.bean.Commande;
import com.example.demo.ws.dto.CommandeDto;
import org.springframework.stereotype.Component;

@Component
public class CommandeConverter extends abstractConverter<Commande,CommandeDto> {
    @Override
    public CommandeDto toDto(Commande item){
        CommandeDto dto=null;
        if (item != null) {
            dto = new CommandeDto();
            dto.setId(item.getId());
            dto.setRef(item.getRef());
            dto.setTotal(item.getTotal());
            dto.setTotalPaye(item.getTotalpaye());
        }
        return dto;
    }
    @Override
    public Commande toItem(CommandeDto dto){
        Commande item = null;
        if (dto != null) {
            dto = new CommandeDto();
            dto.setId(dto.getId());
            dto.setRef(dto.getRef());
            dto.setTotal(dto.getTotal());
            dto.setTotalPaye(dto.getTotalpaye());
        }
        return item ;
    }
}
