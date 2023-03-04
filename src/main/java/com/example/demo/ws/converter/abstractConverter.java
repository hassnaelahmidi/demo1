package com.example.demo.ws.converter;

import com.example.demo.bean.Commande;
import com.example.demo.ws.dto.CommandeDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class abstractConverter<T, DTO> {

    public abstract DTO toDto(T  item);

    public abstract T toItem(DTO dto);
    public List<DTO> toDto(List<T> list){
        List<DTO> result = null;
        if (list != null) {
            result=list.stream().map(e ->toDto(e)).collect(Collectors.toList());
        }
        return result;
    }

public List<T> toItem(List<DTO> list){
        List<T> result = null;
        if (list != null) {
            result=list.stream().map(e ->toItem(e)).collect(Collectors.toList());
        }
        return result;
    }
}
