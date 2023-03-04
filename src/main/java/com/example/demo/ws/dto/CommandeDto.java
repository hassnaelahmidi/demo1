package com.example.demo.ws.dto;

import com.example.demo.bean.Commande;

public class CommandeDto extends Commande {
    private Long id;
    private String ref;
    private double total;
    private double  Totalpaye;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalpaye() {
        return Totalpaye;
    }

    public void setTotalPaye(double nvtotalpayer) {
    }
}
