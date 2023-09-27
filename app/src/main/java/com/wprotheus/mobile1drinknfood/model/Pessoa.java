package com.wprotheus.mobile1drinknfood.model;

import java.io.Serializable;
import java.util.HashSet;

public class Pessoa implements Serializable
{
    private String nome;
    private String idade;
    private String sexo;
    private HashSet<Bebida> bebidas = new HashSet<>();
    private HashSet<Comida> comidas = new HashSet<>();

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

    public HashSet<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(String bebida) {
        bebidas.add(new Bebida(bebida));
    }

    public HashSet<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(String comida) {
        comidas.add(new Comida(comida));
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