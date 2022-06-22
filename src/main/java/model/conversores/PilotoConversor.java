/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import model.Piloto;
import org.bson.Document;

public class PilotoConversor extends Conversor<Piloto> {

    @Override
    public Document toDocument(Piloto p) {
        Document doc = new Document("nome", p.getNome())
                        .append("genero", p.getGenero())
                        .append("veiculo", p.getVeiculo())
                        .append("anoVeiculo", p.getAnoVeiculo().toString())
                        .append("hp", p.getHp().toString());
        return doc;    
    }

    @Override
    public Piloto toModel(Document doc) {
        Document pilotoDoc = (Document) doc.get("piloto");  
        Piloto p = new Piloto();
        p.setNome((String) pilotoDoc.get("nome"));
        p.setGenero((pilotoDoc.get("genero").toString().charAt(0)));
        p.setVeiculo((String) pilotoDoc.get("veiculo"));
        p.setAnoVeiculo(Integer.parseInt((String) pilotoDoc.get("anoVeiculo")));
        p.setHp(Integer.parseInt((String) pilotoDoc.get("hp")));
        return p;        
    }
    
}
