package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String url;
    private final String user;
    private final String pass;
    private final String db;
    private final String ip;
    private Connection connection;
    
    public Conexion(){
        ip = "192.168.42";
        user = "";
        pass = "";
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
