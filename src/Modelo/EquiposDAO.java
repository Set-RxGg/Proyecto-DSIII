/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author roder
 */
public interface EquiposDAO {
    public void insertar(Equipo equipo) throws Exception;
    public void modificar(Equipo equipo) throws Exception;
    public Equipo consultar(String id) throws Exception;
    public void eliminar(String id) throws Exception;
    public List<Equipo> mostrar() throws Exception;
    public List<Equipo> ordenar(boolean ascendente) throws Exception;
    public List<Equipo> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception;
}
}
