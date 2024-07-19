/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.Conexion;
import Modelo.EquiposDAO;
import Modelo.TipoBusqueda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roder
 */
public class equipos extends Conexion implements EquiposDAO {
    private String modelo;
    private String placa_inventario;
    private String descripcion;
    private String foto;
    private int idequipo;
    private String fecha_compra;
    private int idcategoria;
    private int idestado_equipo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca_inventario() {
        return placa_inventario;
    }

    public void setPlaca_inventario(String placa_inventario) {
        this.placa_inventario = placa_inventario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdestado_equipo() {
        return idestado_equipo;
    }

    public void setIdestado_equipo(int idestado_equipo) {
        this.idestado_equipo = idestado_equipo;
    }

    @Override
    public void insertar(equipos equipo) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "INSERT INTO equipos (modelo, placa_inventario, descripcion, foto, idequipo, fecha_compra, idcategoria, idestado_equipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, equipo.getModelo());
            st.setString(2, equipo.getPlaca_inventario());
            st.setString(3, equipo.getDescripcion());
            st.setString(4, equipo.getFoto());
            st.setInt(5, equipo.getIdequipo());
            st.setString(6, equipo.getFecha_compra());
            st.setInt(7, equipo.getIdcategoria());
            st.setInt(8, equipo.getIdestado_equipo());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public void modificar(equipos equipo) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "UPDATE equipos SET modelo = ?, placa_inventario = ?, descripcion = ?, foto = ?, fecha_compra = ?, idcategoria = ?, idestado_equipo = ? WHERE idequipo = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, equipo.getModelo());
            st.setString(2, equipo.getPlaca_inventario());
            st.setString(3, equipo.getDescripcion());
            st.setString(4, equipo.getFoto());
            st.setString(5, equipo.getFecha_compra());
            st.setInt(6, equipo.getIdcategoria());
            st.setInt(7, equipo.getIdestado_equipo());
            st.setInt(8, equipo.getIdequipo());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public equipos consultar(int idequipo) throws Exception {
        equipos equipo = null;
        try {
            this.abrirConexionSQL();
            String sql = "SELECT * FROM equipos WHERE idequipo = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setInt(1, idequipo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                equipo = new equipos();
                equipo.setModelo(rs.getString("modelo"));
                equipo.setPlaca_inventario(rs.getString("placa_inventario"));
                equipo.setDescripcion(rs.getString("descripcion"));
                equipo.setFoto(rs.getString("foto"));
                equipo.setIdequipo(rs.getInt("idequipo"));
                equipo.setFecha_compra(rs.getString("fecha_compra"));
                equipo.setIdcategoria(rs.getInt("idcategoria"));
                equipo.setIdestado_equipo(rs.getInt("idestado_equipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return equipo;
    }

    @Override
    public void eliminar(int idequipo) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "DELETE FROM equipos WHERE idequipo = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setInt(1, idequipo);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
public List<equipos> mostrar() throws Exception {
    List<equipos> listaEquipos = new ArrayList<>();
    try {
        this.abrirConexionSQL();
        String sql = "SELECT * FROM equipos";
        PreparedStatement st = this.miConexion.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            equipos equipo = new equipos();
            equipo.setModelo(rs.getString("modelo"));
            equipo.setPlaca_inventario(rs.getString("placa_inventario"));
            equipo.setDescripcion(rs.getString("descripcion"));
            equipo.setFoto(rs.getString("foto"));
            equipo.setIdequipo(rs.getInt("idequipo"));
            equipo.setFecha_compra(rs.getString("fecha_compra"));
            equipo.setIdcategoria(rs.getInt("idcategoria"));
            equipo.setIdestado_equipo(rs.getInt("idestado_equipo"));
            listaEquipos.add(equipo);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new Exception("Error al mostrar los equipos", e);
    } finally {
        this.cerrarConexionSQL();
    }
    return listaEquipos;
}


    @Override
    public List<equipos> ordenar(boolean ascendente) throws Exception {
        List<equipos> listaEquipos = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String orden = ascendente ? "ASC" : "DESC";
            String sql = "SELECT * FROM equipos ORDER BY modelo " + orden;
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                equipos equipo = new equipos();
                equipo.setModelo(rs.getString("modelo"));
                equipo.setPlaca_inventario(rs.getString("placa_inventario"));
                equipo.setDescripcion(rs.getString("descripcion"));
                equipo.setFoto(rs.getString("foto"));
                equipo.setIdequipo(rs.getInt("idequipo"));
                equipo.setFecha_compra(rs.getString("fecha_compra"));
                equipo.setIdcategoria(rs.getInt("idcategoria"));
                equipo.setIdestado_equipo(rs.getInt("idestado_equipo"));
                listaEquipos.add(equipo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaEquipos;
    }

    @Override
    public List<equipos> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception {
        List<equipos> listaEquipos = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String sql = "";
            switch (tipoBusqueda) {
                case MODELO:
                    sql = "SELECT * FROM equipos WHERE modelo LIKE ?";
                    break;
                case PLACA_INVENTARIO:
                    sql = "SELECT * FROM equipos WHERE placa_inventario LIKE ?";
                    break;
                case DESCRIPCION:
                    sql = "SELECT * FROM equipos WHERE descripcion LIKE ?";
                    break;
            }
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, "%" + filtro + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                equipos equipo = new equipos();
                equipo.setModelo(rs.getString("modelo"));
                equipo.setPlaca_inventario(rs.getString("placa_inventario"));
                equipo.setDescripcion(rs.getString("descripcion"));
                equipo.setFoto(rs.getString("foto"));
                equipo.setIdequipo(rs.getInt("idequipo"));
                equipo.setFecha_compra(rs.getString("fecha_compra"));
                equipo.setIdcategoria(rs.getInt("idcategoria"));
                equipo.setIdestado_equipo(rs.getInt("idestado_equipo"));
                listaEquipos.add(equipo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexionSQL();
        }
        return listaEquipos;
    }
}
