package prueba;

import clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class Prueba {
    
    static Conexion conexion;
    Connection connection;
    
    public Prueba(){
        conexion = new Conexion();
        connection = conexion.getConnection();
    }
    
    void consulta(){
        String sql = "select * from cuenta where idbarrio = 13";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Prueba prueba = new Prueba();
        prueba.consulta();
    }
    
}
