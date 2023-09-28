package com.wprotheus.mobile1drinknfood.model;

import java.io.Serializable;

public class Comida implements Serializable
{
    private String nomeComida;

    public Comida() {
    }

    public Comida(String nomeComida) {
        this.nomeComida = nomeComida;
    }

    public String getNomeComida() {

        return nomeComida;
    }

    public void setNomeComida(String nomeComida) {
        this.nomeComida = nomeComida;
    }

    @Override
    public String toString()
    {
        return nomeComida;
    }
}