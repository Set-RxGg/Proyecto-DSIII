
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import org.mariadb.jdbc.Connection;

public class Conexion {
    
    protected Connection miConexion;
    private Statement miStatement;
    private String jdbc;
    private String url;
    private String usuario;
    private String contrasena;
    
    public Conexion(){
        this.miConexion = null;
        this.miStatement = null;
        this.jdbc = "org.mariadb.jdbc.Driver";
        this.url = "jdbc:mariadb://localhost:3306/cpel";
        this.usuario = "admincpel";
        this.contrasena = "cpel2023";
    }
    
    public Connection abrirConexionSQL() {
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar el driver JDBC", "AVISO!!!", JOptionPane.ERROR_MESSAGE);
        return null; 
    }

    try {
        miConexion = (Connection) DriverManager.getConnection(this.url, this.usuario, this.contrasena);
        this.miStatement = miConexion.createStatement();
        //JOptionPane.showMessageDialog(null, "Se ha conectado exitosamente con la base de datos", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
        return miConexion;
    } catch (SQLException e) {
        //JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "AVISO!!!", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}
    
    public void cerrarConexionSQL(){
        if (miConexion != null) {
            try {
                if (!miConexion.isClosed()) {
                    miConexion.close();
                    JOptionPane.showMessageDialog(null, "Base de datos cerrada exitosamente.");
                    }
            } 
            catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión a la base de datos.");
            }
        }
        else {
               JOptionPane.showMessageDialog(null, "No hay conexión abierta para cerrar.");
        }
    }
}

