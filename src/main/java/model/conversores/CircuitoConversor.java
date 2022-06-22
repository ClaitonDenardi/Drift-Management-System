/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import model.Circuito;
import org.bson.Document;

public class CircuitoConversor extends Conversor<Circuito> {

    @Override
    public Document toDocument(Circuito p) {
        Document doc = new Document("nome", p.getNome());
        return doc;
    }

    @Override
    public Circuito toModel(Document doc) {
        Document predioDoc = (Document) doc.get("circuito");        
        Circuito p = new Circuito();
        p.setNome((String) predioDoc.get("nome"));
        return p;    
    }
    
}
