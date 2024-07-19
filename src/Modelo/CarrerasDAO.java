/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import Logica.Carreras;
import java.util.List;

/**
 *
 * @author roder
 */
public interface CarrerasDAO {
    public void insertar(Carreras carrera) throws Exception;
    public void modificar(Carreras carrera) throws Exception;
    public Carreras consultar(int id) throws Exception;
    public void eliminar(int id) throws Exception;
    public List<Carreras> mostrar() throws Exception;
    public List<Carreras> ordenar(boolean ascendente) throws Exception;
    public List<Carreras> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception;
}
