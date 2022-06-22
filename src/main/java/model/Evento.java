/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 
package model;

import banco.Registro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Evento extends Registro {
    
    private String id; // string para incluir uso do mongodb 
    private Circuito circuito; 
    private String nome;
    private String descricao;
    private String autodromo;
    private Date dataInicio;
    private Date dataFim;
    private Collection<Corrida> corridas = new ArrayList<>(); // referencia para criar obj mongo

    public Evento() {
        this.descricao = "";
    }

    public Evento(String id) {
        this.id = id;
    }
    
    public Evento(Circuito circuito, String nome, String descricao, String autodromo, Date dataInicio, Date dataFim) {
        this.circuito = circuito;
        this.nome = nome;
        this.descricao = descricao;
        this.autodromo = autodromo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Evento(String id, Circuito circuito, String nome, String descricao, String autodromo, Date dataInicio, Date dataFim) {
        this.id = id;
        this.circuito = circuito;
        this.nome = nome;
        this.descricao = descricao;
        this.autodromo = autodromo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @return the circuito
     */
    public Circuito getCircuito() {
        return circuito;
    }

    /**
     * @param circuito the circuito to set
     */
    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the autodromo
     */
    public String getAutodromo() {
        return autodromo;
    }

    /**
     * @param autodromo the autodromo to set
     */
    public void setAutodromo(String autodromo) {
        this.autodromo = autodromo;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }    
    
    /**
     * @return the corridas
     */
    public Collection<Corrida> getCorridas() {
        return corridas;
    }

    /**
     * @param corridas the corridas to set
     */
    public void setCorridas(Collection<Corrida> corridas) {
        this.corridas = corridas;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", circuito=" + circuito + ", nome=" + nome + ", descricao=" + descricao + ", autodromo=" + autodromo + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }

}
