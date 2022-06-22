/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import banco.Registro;
import java.util.Date;

public class Corrida extends Registro {

    private Integer id;
    private Piloto piloto;
    private Evento evento; // referencia para criar obj mysql
    private String titulo;
    private Integer pontos;
    private Date data;
    private Date horaInicio;
    private Date horaFim;

    public Corrida(Piloto piloto, Evento evento, String titulo, Integer pontos, Date data, Date horaInicio, Date horaFim) {
        this.piloto = piloto;
        this.evento = evento;
        this.titulo = titulo;
        this.pontos = pontos;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Corrida(Integer id, Piloto piloto, Evento evento, String titulo, Integer pontos, Date data, Date horaInicio, Date horaFim) {
        this.id = id;
        this.piloto = piloto;
        this.evento = evento;
        this.titulo = titulo;
        this.pontos = pontos;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Corrida() {
        
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
     * @return the piloto
     */
    public Piloto getPiloto() {
        return piloto;
    }

    /**
     * @param piloto the piloto to set
     */
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the sala
     */
    public Integer getPontos() {
        return pontos;
    }

    /**
     * @param sala the sala to set
     */
    public Integer setPontos(Integer pontos) {
        this.pontos = pontos;
        return null;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
    
    /**
     * @return the horaInicio
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFim
     */
    public Date getHoraFim() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public String toString() {
        return "Corrida{" + "id=" + id + ", piloto=" + piloto + ", evento=" + evento + ", titulo=" + titulo + ", pontos=" + pontos + ", data=" + getData() + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + '}';
    }

}
