/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.relacional.mysql;

import banco.relacional.mysql.ConexaoMySQL;
import banco.relacional.mysql.RelacionalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Corrida;

public class CorridaDAOMySQL extends RelacionalDAO<Corrida> {

    public CorridaDAOMySQL() {
        setSqlInsercao("INSERT INTO corrida (id_piloto, id_evento, titulo, pontos, data_corrida, hora_inicio, hora_fim) VALUES (?, ?, ?, ?, ?, ?, ?)");
        setSqlAlteracao("UPDATE corrida set id_piloto = ?, id_evento = ?, titulo = ?, pontos = ?, data_corrida = ?, hora_inicio = ?, hora_fim = ? WHERE id_corrida = ?");
        setSqlExclusao("DELETE FROM corrida WHERE id_corrida = ?");
        setSqlBuscaChavePrimaria("SELECT * FROM corrida WHERE id_corrida = ?");
        setSqlBusca("SELECT * FROM corrida WHERE id_evento = ?"); 
        setSqlBuscaTodos("SELECT * FROM corrida");
    }
    
    @Override
    public Integer inserir(Corrida p) {
        Connection c = ConexaoMySQL.getConexao();
        try {           
            // realiza a insercao do piloto
            PilotoDAOMySQL pdao = new PilotoDAOMySQL();
            // recupera id_piloto
            Integer id_piloto = pdao.inserir(p.getPiloto());
            p.getPiloto().setId(id_piloto);
            // realiza a insercao da corrida
            PreparedStatement ps = c.prepareStatement(getSqlInsercao());
            preencherInsercao(ps, p);
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CorridaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1; // sucess
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Corrida p) throws SQLException {
        ps.setInt(1, p.getPiloto().getId());
        ps.setInt(2, Integer.parseInt(p.getEvento().getId()));
        ps.setString(3, p.getTitulo());
        ps.setInt(4, p.getPontos());
        ps.setDate(5, new java.sql.Date(p.getData().getTime()));
        ps.setTime(6, new java.sql.Time(p.getHoraInicio().getTime()));
        ps.setTime(7, new java.sql.Time(p.getHoraFim().getTime()));
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Corrida p) throws SQLException {
        ps.setInt(1, p.getPiloto().getId());
        ps.setInt(2, Integer.parseInt(p.getEvento().getId()));
        ps.setString(3, p.getTitulo());
        ps.setInt(4, p.getPontos());
        ps.setDate(5, new java.sql.Date(p.getData().getTime()));
        ps.setTime(6, new java.sql.Time(p.getHoraInicio().getTime()));
        ps.setTime(7, new java.sql.Time(p.getHoraFim().getTime()));
        ps.setInt(8, p.getId());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Corrida p) throws SQLException {
        ps.setInt(1, p.getId());
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Corrida p) throws SQLException {
        ps.setInt(1, Integer.parseInt(p.getEvento().getId()));
    }

    @Override
    protected Corrida preencher(ResultSet rs) throws SQLException {
        Corrida p = new Corrida();
        p.setId(rs.getInt("id_corrida"));
        Integer id_piloto = rs.getInt("id_piloto");
        p.setPiloto( new PilotoDAOMySQL().buscar(id_piloto.toString()) );
        // p.setEvento( new EventoDAOMySQL().buscar(rs.getInt("id_evento")) );
        p.setTitulo(rs.getString("titulo"));
        p.setPontos(rs.getInt("pontos"));
        p.setData(rs.getDate("data_corrida"));
        p.setHoraInicio(rs.getTime("hora_inicio"));
        p.setHoraFim(rs.getTime("hora_fim"));
        return p;
    }

    @Override
    protected Collection<Corrida> preencherLista(ResultSet rs) throws SQLException {
        Collection<Corrida> corridas = new ArrayList<>();
        while ( rs.next() )
            corridas.add(preencher(rs));
        return corridas;
    }
    
}
