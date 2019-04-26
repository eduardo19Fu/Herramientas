package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String url;
    private String user;
    private String pass;
    private String db;
    private String ip;
    private Connection connection;
    
    public Conexion(){
        ip = "192.168.1.42";
        user = "sigees_dba";
        pass = "sigees_dba1210";
        db = "sigees_db";
        url = "jdbc:mysql://" + ip + "/" + db ;
    }
    
    private Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection(url,user,pass);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Connection getConnection(){
        return conectar();
    }
    
    public void desconectar() throws SQLException{
        getConnection().close();
    }
}
