/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.relacional.mysql;

import banco.relacional.mysql.RelacionalDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import model.Piloto;

public class PilotoDAOMySQL extends RelacionalDAO<Piloto> {
    
    public PilotoDAOMySQL() {
        setSqlInsercao("INSERT INTO piloto (nome_piloto, genero, veiculo, ano_veiculo, hp) VALUES (?, ?, ?, ?, ?)");
        setSqlAlteracao("UPDATE piloto SET nome_piloto = ?, genero = ?, veiculo = ?, ano_veiculo = ?, hp = ? WHERE id_piloto = ?");
        setSqlExclusao("DELETE FROM piloto");
        setSqlBuscaChavePrimaria("SELECT * FROM piloto WHERE id_piloto = ?");
        setSqlBusca("SELECT * FROM piloto WHERE nome_piloto = ?");
        setSqlBuscaTodos("SELECT * FROM piloto");
    }

    @Override
    protected void preencherInsercao(PreparedStatement ps, Piloto p) throws SQLException {
        ps.setString(1, p.getNome());
        ps.setString(2, String.valueOf(p.getGenero()));
        ps.setString(3, (String) p.getVeiculo());
        ps.setInt(4, p.getAnoVeiculo());
        ps.setInt(5, p.getHp());
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Piloto p) throws SQLException {
        ps.setString(1, p.getNome());
        ps.setString(2, String.valueOf(p.getGenero()));
        ps.setString(3, (String) p.getVeiculo());
        ps.setInt(4, p.getAnoVeiculo());
        ps.setInt(5, p.getHp());    
        ps.setInt(6, p.getId());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Piloto p) throws SQLException {
        ps.setInt(1, p.getId());
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Piloto p) throws SQLException {
        ps.setString(1, p.getNome());
    }

    @Override
    protected Piloto preencher(ResultSet rs) throws SQLException {
        Piloto p = new Piloto();
        p.setId(rs.getInt("id_piloto"));
        p.setNome(rs.getString("nome_piloto"));
        p.setGenero(rs.getString("genero").charAt(0));
        p.setVeiculo(rs.getString("veiculo"));
        p.setAnoVeiculo(rs.getInt("ano_veiculo"));
        p.setHp(rs.getInt("hp"));
        return p;
    }

    @Override
    protected Collection<Piloto> preencherLista(ResultSet rs) throws SQLException {
        Collection<Piloto> pilotos = new ArrayList<>();
        while (rs.next())
            pilotos.add( preencher(rs) );
        return pilotos;
    }
    
}
