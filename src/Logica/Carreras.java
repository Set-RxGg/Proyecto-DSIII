/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.CarrerasDAO;
import Modelo.Conexion;
import Modelo.TipoBusqueda;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author roder
 */
public class Carreras extends Conexion implements CarrerasDAO{

    private String nombre_carrera;
    private int idcarrera;

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }
    
     @Override
    public void insertar(Carreras carrera) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "INSERT INTO carreras (nombre_carrera, idcarrera) VALUES (?, ?)";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, carrera.getNombre_carrera());
            st.setInt(2, carrera.getIdcarrera());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public void modificar(Carreras carrera) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "UPDATE carreras SET nombre_carrera = ? WHERE idcarrera = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, carrera.getNombre_carrera());
            st.setInt(2, carrera.getIdcarrera());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public Carreras consultar(int idcarrera) throws Exception {
        Carreras carrera = null;
        try {
            this.abrirConexionSQL();
            String sql = "SELECT * FROM carreras WHERE idcarrera = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setInt(1, idcarrera);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                carrera = new Carreras();
                carrera.setNombre_carrera(rs.getString("nombre_carrera"));
                carrera.setIdcarrera(rs.getInt("idcarrera"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return carrera;
    }

    @Override
    public void eliminar(int idcarrera) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "DELETE FROM carreras WHERE idcarrera = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setInt(1, idcarrera);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public List<Carreras> mostrar() throws Exception {
        List<Carreras> listaCarreras = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String sql = "SELECT * FROM carreras";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carreras carrera = new Carreras();
                carrera.setNombre_carrera(rs.getString("nombre_carrera"));
                carrera.setIdcarrera(rs.getInt("idcarrera"));
                listaCarreras.add(carrera);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaCarreras;
    }

    @Override
    public List<Carreras> ordenar(boolean ascendente) throws Exception {
        List<Carreras> listaCarreras = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String orden = ascendente ? "ASC" : "DESC";
            String sql = "SELECT * FROM carreras ORDER BY nombre_carrera " + orden;
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carreras carrera = new Carreras();
                carrera.setNombre_carrera(rs.getString("nombre_carrera"));
                carrera.setIdcarrera(rs.getInt("idcarrera"));
                listaCarreras.add(carrera);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaCarreras;
    }

    @Override
    public List<Carreras> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception {
        List<Carreras> listaCarreras = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String sql = "";
            switch (tipoBusqueda) {
                case NOMBRE_CARRERA:
                    sql = "SELECT * FROM carreras WHERE nombre_carrera LIKE ?";
                    break;
                case IDCARRERA:
                    sql = "SELECT * FROM carreras WHERE idcarrera LIKE ?";
                    break;
            }
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, "%" + filtro + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carreras carrera = new Carreras();
                carrera.setNombre_carrera(rs.getString("nombre_carrera"));
                carrera.setIdcarrera(rs.getInt("idcarrera"));
                listaCarreras.add(carrera);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaCarreras;
    }
}
