package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultas {
    private Connection conn;
    private Conexion conexion;
    
    public Consultas(){
        conexion = new Conexion();
        conn = conexion.getConnection();
    }
    
    public int eliminar(int transac){
        String sql = "call eliminar_duplicados(?)";
        try {
            CallableStatement cl = conn.prepareCall(sql);
            cl.setInt(1, transac);
            int rs = cl.executeUpdate();
            cl.close();
            conn.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int crear_tabla(String url){
        String sql = "drop table if exists cargo_lecturas; "
                + "create table cargo_lecturas("
                +       "no_contador varchar()"
                + ");";
        return 0;
    }
}
