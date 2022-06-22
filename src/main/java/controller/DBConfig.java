package controller;
import model.dao.nosql.mongodb.EventoDAOMongo;
import model.dao.relacional.mysql.EventoDAOMySQL;
import banco.InterfaceDAO;

public class DBConfig {
   //private static final InterfaceDAO registroDAO = new EventoDAOMySQL();
   private static final InterfaceDAO registroDAO = new EventoDAOMongo();
    
    public static InterfaceDAO getRegistroDAO() {
        return registroDAO;
    }
}