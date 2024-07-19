/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.TipoBusqueda;
import Modelo.UsuariosDAO;
import java.util.List;
import java.sql.*;
import Modelo.Conexion;
import java.util.ArrayList;

/**
 *
 * @author roder
 */
public class Usuario extends Conexion implements UsuariosDAO {
    
    private String cedula;
    private String primer_nombre;
    private String primer_apellido;
    private String telefono;
    private String correo;
    private String idcarrera;
    private String tipousuario;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(String idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
    
    
    
    @Override
    public void insertar(Usuario usuario) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "INSERT INTO usuarios (cedula, primer_nombre, primer_apellido, telefono, correo, idcarrera, tipousuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, usuario.getCedula());
            st.setString(2, usuario.getPrimer_nombre());
            st.setString(3, usuario.getPrimer_apellido());
            st.setString(4, usuario.getTelefono());
            st.setString(5, usuario.getCorreo());
            st.setString(6, usuario.getIdcarrera());
            st.setString(7, usuario.getTipousuario());
            st.executeUpdate();
        } catch (Exception e) {
            //
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public void modificar(Usuario usuario) throws Exception {
        try {
            this.abrirConexionSQL();
            String sql = "UPDATE usuarios SET primer_nombre = ?, primer_apellido = ?, "
                    + "telefono = ?, correo = ?, idcarrera = ?, tipousuario = ? WHERE cedula = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, usuario.getPrimer_nombre());
            st.setString(2, usuario.getPrimer_apellido());
            st.setString(3, usuario.getTelefono());
            st.setString(4, usuario.getCorreo());
            st.setString(5, usuario.getIdcarrera());
            st.setString(6, usuario.getTipousuario());
            st.setString(7, usuario.getCedula());
            st.executeUpdate();
        } catch (Exception e) {
           //
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public Usuario consultar(String cedula) throws Exception {
         Usuario usuario = null;
        try {
            this.abrirConexionSQL();
            String sql = "SELECT * FROM usuarios WHERE cedula = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, cedula);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setPrimer_nombre(rs.getString("primer_nombre"));
                usuario.setPrimer_apellido(rs.getString("primer_apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIdcarrera(rs.getString("idcarrera"));
                usuario.setTipousuario(rs.getString("tipousuario"));
            }
        } catch (Exception e) {
            //
        } finally {
            this.cerrarConexionSQL();
        }
        return usuario;
    }

    @Override
    public void eliminar(int cedula) throws Exception {
         try {
            this.abrirConexionSQL();
            String sql = "DELETE FROM usuarios WHERE cedula = ?";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setInt(1, cedula);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexionSQL();
        }
    }

    @Override
    public List<Usuario> mostrar() throws Exception {
       List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String sql = "SELECT * FROM usuarios";
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setPrimer_nombre(rs.getString("primer_nombre"));
                usuario.setPrimer_apellido(rs.getString("primer_apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIdcarrera(rs.getString("idcarrera"));
                usuario.setTipousuario(rs.getString("tipousuario"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            //
        } finally {
            this.cerrarConexionSQL();
        }
        return listaUsuarios;
    }

    @Override
    public List<Usuario> ordenar(boolean ascendente) throws Exception {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String orden = ascendente ? "ASC" : "DESC";
            String sql = "SELECT * FROM usuarios ORDER BY primer_nombre " + orden;
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setPrimer_nombre(rs.getString("primer_nombre"));
                usuario.setPrimer_apellido(rs.getString("primer_apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIdcarrera(rs.getString("idcarrera"));
                usuario.setTipousuario(rs.getString("tipousuario"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            //
        } finally {
            this.cerrarConexionSQL();
        }
        return listaUsuarios;
    }

    @Override
    public List<Usuario> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            this.abrirConexionSQL();
            String sql = "";
            switch (tipoBusqueda) {
                case PRIMER_NOMBRE:
                    sql = "SELECT * FROM usuarios WHERE primer_nombre LIKE ?";
                    break;
                case PRIMER_APELLIDO:
                    sql = "SELECT * FROM usuarios WHERE primer_apellido LIKE ?";
                    break;
                case CEDULA:
                    sql = "SELECT * FROM usuarios WHERE cedula LIKE ?";
                    break;
            }
            PreparedStatement st = this.miConexion.prepareStatement(sql);
            st.setString(1, "%" + filtro + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setPrimer_nombre(rs.getString("primer_nombre"));
                usuario.setPrimer_apellido(rs.getString("primer_apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIdcarrera(rs.getString("idcarrera"));
                usuario.setTipousuario(rs.getString("tipousuario"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            //
        } finally {
            this.cerrarConexionSQL();
        }
        return listaUsuarios;
    }
}
    

