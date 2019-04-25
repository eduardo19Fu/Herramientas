package clases;

import java.sql.Connection;

public class Consultas {
    private Connection conn;
    private Conexion conexion;
    
    public Consultas(){
        conexion = new Conexion();
        conn = conexion.getConnection();
        
        
    }
}
