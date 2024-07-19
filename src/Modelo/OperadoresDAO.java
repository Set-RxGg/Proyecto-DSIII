/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author roder
 */
public interface OperadoresDAO {
    public void insertar(Operador operador) throws Exception;
    public void modificar(Operador operador) throws Exception;
    public Operador consultar(String id) throws Exception;
    public void eliminar(String id) throws Exception;
    public List<Operador> mostrar() throws Exception;
    public List<Operador> ordenar(boolean ascendente) throws Exception;
    public List<Operador> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception;
}
}
