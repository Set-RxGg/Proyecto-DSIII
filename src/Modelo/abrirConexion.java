package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class abrirConexion {
    protected Connection miConexion;

    public void abrirConexionSQL() throws SQLException {
        if (miConexion == null || miConexion.isClosed()) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                miConexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cpel", "admincpel", "cpel2023");
            } catch (ClassNotFoundException e) {
                throw new SQLException("No se encontró el driver de MariaDB", e);
            }
        }
    }

    public void cerrarConexionSQL() throws SQLException {
        if (miConexion != null && !miConexion.isClosed()) {
            miConexion.close();
        }
    }
}

