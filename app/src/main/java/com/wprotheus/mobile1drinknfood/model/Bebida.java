package com.wprotheus.mobile1drinknfood.model;

import java.io.Serializable;

public class Bebida implements Serializable
{
    private String nomeBebida;

    public Bebida() {
    }

    public Bebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }

    public String getNomeBebida() {

        return nomeBebida;
    }

    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        return sb.append(nomeBebida).toString().replaceAll("(\\],\\[)", "");
    }
}