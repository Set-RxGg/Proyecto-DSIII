/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.Conexion;
import Modelo.OperadoresDAO;
import Modelo.TipoBusqueda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class operadores extends Conexion implements OperadoresDAO {
    private String primer_nombre;
    private String primer_apellido;
    private Long cedula;

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    @Override
    public void insertar(operadores operador) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "INSERT INTO operadores (primer_nombre, primer_apellido, cedula) VALUES (?, ?, ?)";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, operador.getPrimer_nombre());
            st.setString(2, operador.getPrimer_apellido());
            st.setLong(3, operador.getCedula());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public void modificar(operadores operador) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "UPDATE operadores SET primer_nombre = ?, primer_apellido = ? WHERE cedula = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, operador.getPrimer_nombre());
            st.setString(2, operador.getPrimer_apellido());
            st.setLong(3, operador.getCedula());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public operadores consultar(Long cedula) throws Exception {
       operadores operador = null;
        try {
            this.abrirConexionSQL();
            String sql = "SELECT * FROM operadores WHERE cedula = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setLong(1, cedula);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                operador = new operadores();
                operador.setPrimer_nombre(rs.getString("primer_nombre"));
                operador.setPrimer_apellido(rs.getString("primer_apellido"));
                operador.setCedula(rs.getLong("cedula"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return operador;
    }

    @Override
    public void eliminar(Long cedula) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "DELETE FROM operadores WHERE cedula = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setLong(1, cedula);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public List<operadores> mostrar() throws Exception {
        List<operadores> listaOperadores = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String sql = "SELECT * FROM operadores";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                operadores operador = new operadores();
                operador.setPrimer_nombre(rs.getString("primer_nombre"));
                operador.setPrimer_apellido(rs.getString("primer_apellido"));
                operador.setCedula(rs.getLong("cedula"));
                listaOperadores.add(operador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaOperadores;
    }

    @Override
    public List<operadores> ordenar(boolean ascendente) throws Exception {
        List<operadores> listaOperadores = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String orden = ascendente ? "ASC" : "DESC";
            String sql = "SELECT * FROM operadores ORDER BY primer_nombre " + orden;
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                operadores operador = new operadores();
                operador.setPrimer_nombre(rs.getString("primer_nombre"));
                operador.setPrimer_apellido(rs.getString("primer_apellido"));
                operador.setCedula(rs.getLong("cedula"));
                listaOperadores.add(operador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaOperadores;
    }

    @Override
    public List<operadores> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception {
        List<operadores> listaOperadores = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String sql = "";
            switch (tipoBusqueda) {
                case PRIMER_NOMBRE:
                    sql = "SELECT * FROM operadores WHERE primer_nombre LIKE ?";
                    break;
                case PRIMER_APELLIDO:
                    sql = "SELECT * FROM operadores WHERE primer_apellido LIKE ?";
                    break;
                case CEDULA:
                    sql = "SELECT * FROM operadores WHERE cedula LIKE ?";
                    break;
            }
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, "%" + filtro + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                operadores operador = new operadores();
                operador.setPrimer_nombre(rs.getString("primer_nombre"));
                operador.setPrimer_apellido(rs.getString("primer_apellido"));
                operador.setCedula(rs.getLong("cedula"));
                listaOperadores.add(operador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaOperadores;
    }
}
