/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import Logica.Usuario;
import java.util.List;

/**
 *
 * @author roder
 */
public interface UsuariosDAO {
    public void insertar(Usuario usuario) throws Exception;
    public void modificar(Usuario usuario) throws Exception;
    public Usuario consultar(String cedula) throws Exception;
    public void eliminar(int cedula) throws Exception;
    public List<Usuario> mostrar() throws Exception;
    public List<Usuario> ordenar(boolean ascendente) throws Exception;
    public List<Usuario> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception;
}

