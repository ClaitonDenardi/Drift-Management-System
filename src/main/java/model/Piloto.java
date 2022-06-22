/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import banco.Registro;

public class Piloto extends Registro {

    private Integer id;
    private String nome;
    private char genero;
    private String veiculo;
    private Integer anoVeiculo;		
    private Integer hp;	

    public Piloto() {
        
    }
   
    public Piloto(Integer id) {
        this.id = id;
    }
    
    public Piloto(String nome, char genero, String veiculo, Integer anoVeiculo, Integer hp) {
        this.nome = nome;
        this.genero = genero;
        this.veiculo = veiculo;
        this.anoVeiculo = anoVeiculo;
        this.hp = hp;
    }
    
    public Piloto(Integer id, String nome, char genero, String veiculo, Integer anoVeiculo, Integer hp) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.veiculo = veiculo;
        this.anoVeiculo = anoVeiculo;
        this.hp = hp;
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * @return the veiculo
     */
    public String getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the anoVeiculo
     */
    public Integer getAnoVeiculo() {
        return anoVeiculo;
    }

    /**
     * @param anoVeiculo the anoVeiculo to set
     */
    public void setAnoVeiculo(Integer anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    /**
     * @return the hp
     */
    public Integer getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Piloto{" + "id=" + id + ", nome=" + nome + ", genero=" + genero + ", veiculo=" + veiculo + ", anoVeiculo=" + anoVeiculo + ", hp=" + hp + '}';
    }
}
