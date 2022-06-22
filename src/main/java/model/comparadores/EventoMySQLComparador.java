/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.comparadores;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Evento;
import model.Corrida;
import model.Circuito;
import model.dao.relacional.mysql.CorridaDAOMySQL;


public class EventoMySQLComparador {
    
    public Boolean comparaEventos(Evento antigo, Evento novo) {   
        Boolean eventoModificado = false;
        try {
            for ( Field f : Comparador.compararObjetos(antigo, novo) ) {
                switch ( f.getName() ) {
                    case "corridas":
                        palestrasModificadas(antigo.getCorridas(), novo.getCorridas(), antigo);
                        break;
                    default:
                        eventoModificado = true;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException ex) {
            Logger.getLogger(EventoMySQLComparador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventoModificado;
    }

    private Boolean predioModificado(Circuito predioAntigo, Circuito predioNovo) throws IllegalArgumentException, IllegalAccessException {
        return !Comparador.compararObjetos(predioAntigo, predioNovo).isEmpty();
    }

    private void palestrasModificadas(Collection<Corrida> antigas, Collection<Corrida> novas, Evento antigo) {
        // Verifica se existem novas palestras
        for (Corrida nova : novas) {
            if ( nova.getId() == null || nova.getId().equals(0) ) {
                nova.setEvento(antigo);
                new CorridaDAOMySQL().inserir(nova);
            } 
        } 
        // Verifica se alguma palestra antiga foi deletada
        for (Corrida antiga : antigas) {
            Boolean encontrou = false;
            for (Corrida nova: novas) {
                if ( nova.getId() != null ) {
                    if ( nova.getId().equals(antiga.getId()) ) {
                        encontrou = true;
                        break;
                    }
                }
            }
            if ( !encontrou )
                new CorridaDAOMySQL().excluir(antiga);
        }
    }
    
}
