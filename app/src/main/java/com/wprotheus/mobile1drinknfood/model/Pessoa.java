package com.wprotheus.mobile1drinknfood.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Pessoa implements Serializable
{
    private String nome;
    private String idade;
    private String sexo;
    private Set<Bebida> bebidas = new HashSet<>();
    private Set<Comida> comidas = new HashSet<>();

    public Pessoa(){ }

    public Pessoa(String nome, String idade, String sexo, HashSet<Bebida> bebidas, HashSet<Comida> comidas) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.bebidas = bebidas;
        this.comidas = comidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Set<Bebida> getBebidas() {
        return bebidas;
    }

    public boolean bebidaIgual(Bebida bebidaSet)
    {
        boolean existe = false;
        for (Bebida b:bebidas)
        {
            if(b.getNomeBebida().contains(bebidaSet.getNomeBebida()))
            {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public void setBebidas(Set<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public void setComidas(Set<Comida> comidas) {
        this.comidas = comidas;
    }

    public boolean comidaIgual(Comida comidaSet)
    {
        boolean existe = false;
        for (Comida c:comidas)
        {
            if(c.getNomeComida().contains(comidaSet.getNomeComida()))
            {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public Set<Comida> getComidas()
    {
        return comidas;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        return sb.append("Nome: ").append(nome)
                .append("Idade: ").append(idade)
                .append("Sexo: ").append(sexo)
                .append("Bebidas: ").append(getBebidas().toString())
                .append("Comidas: ").append(getComidas().toString()).toString().replaceAll("(\\],\\[)", "");
    }
}