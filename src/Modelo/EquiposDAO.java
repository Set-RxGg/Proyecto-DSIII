/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import Logica.equipos;
import java.util.List;

/**
 *
 * @author roder
 */
public interface EquiposDAO {
    public void insertar(equipos equipo) throws Exception;
    public void modificar(equipos equipo) throws Exception;
    public equipos consultar(int id) throws Exception;
    public void eliminar(int id) throws Exception;
    public List<equipos> mostrar() throws Exception;
    public List<equipos> ordenar(boolean ascendente) throws Exception;
    public List<equipos> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception;
}

