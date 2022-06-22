/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import model.Corrida;
import org.bson.Document;
import util.DateUtils;


public class CorridaConversor extends Conversor<Corrida> {

    @Override
    public Document toDocument(Corrida p) {
        Document doc = new Document("titulo", p.getTitulo())
                        .append("data", DateUtils.toString(p.getData(), "dd/MM/yyyy"))
                        .append("inicio", DateUtils.toString(p.getHoraInicio(), "HH:mm"))
                        .append("fim", DateUtils.toString(p.getHoraFim(), "HH:mm"))
                        .append("pontos", p.getPontos().toString())
                        .append("piloto", new PilotoConversor().toDocument(p.getPiloto()));
                        //.append("AAAAAAAAAAAAAAAAAA", new SalaConversor().toDocument(p.getSala()));
        return doc;
    }

    @Override
    public Corrida toModel(Document doc) {
        Corrida p = new Corrida();
        if ( doc.get("id") != null )
            p.setId((Integer) doc.get("id"));
        p.setTitulo((String) doc.get("titulo"));
        p.setData(DateUtils.toDate((String) doc.get("data"), "dd/MM/yyyy"));
        p.setHoraInicio(DateUtils.toDate((String) doc.get("inicio"), "HH:mm"));
        p.setHoraFim(DateUtils.toDate((String) doc.get("fim"), "HH:mm"));
        p.setPontos(Integer.parseInt((String) doc.get("pontos")));
        p.setPiloto(new PilotoConversor().toModel(doc));
        return p;      
    }
    
}
