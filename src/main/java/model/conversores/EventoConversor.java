/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import java.util.ArrayList;
import java.util.Collection;
import model.Evento;
import model.Corrida;
import org.bson.Document;
import util.DateUtils;

/**
 *
 * @author isabella
 */
public class EventoConversor extends Conversor<Evento> {

    @Override
    public Document toDocument(Evento e) {
        Document doc = new Document("nome", e.getNome())
                        .append("descricao", e.getDescricao())
                        .append("autodromo", e.getAutodromo())
                        .append("dataInicio", DateUtils.toString(e.getDataInicio(), "dd/MM/yyyy"))
                        .append("dataFim", DateUtils.toString(e.getDataFim(), "dd/MM/yyyy"))
                        .append("circuito", new CircuitoConversor().toDocument(e.getCircuito()));
        Collection<Document> documents = new ArrayList<>();
        for (Corrida p : e.getCorridas()) 
            documents.add(new CorridaConversor().toDocument(p));
        doc.append("corridas", documents);
        return doc;
    }

    @Override
    public Evento toModel(Document doc) { 
        Evento e = new Evento();
        if ( doc.get("_id") != null )
            e.setId(doc.get("_id").toString());
        e.setNome((String) doc.get("nome"));
        e.setDescricao((String) doc.get("descricao"));
        e.setAutodromo((String) doc.get("autodromo"));
        e.setDataInicio(DateUtils.toDate((String) doc.get("dataInicio"), "dd/MM/yyyy"));
        e.setDataFim(DateUtils.toDate((String) doc.get("dataFim"), "dd/MM/yyyy"));
        e.setCircuito(new CircuitoConversor().toModel(doc));
        for (Document d : (Collection<Document>) doc.get("corridas")) 
            e.getCorridas().add(new CorridaConversor().toModel(d));
        return e;
    }
    
}
