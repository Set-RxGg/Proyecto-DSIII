/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import Logica.operadores;
import java.util.List;

/**
 *
 * @author roder
 */
public interface OperadoresDAO {
    public void insertar(operadores operador) throws Exception;
    public void modificar(operadores operador) throws Exception;
    public operadores consultar(Long cedula) throws Exception;
    public void eliminar(Long cedula) throws Exception;
    public List<operadores> mostrar() throws Exception;
    public List<operadores> ordenar(boolean ascendente) throws Exception;
    public List<operadores> buscar(TipoBusqueda tipoBusqueda, String filtro) throws Exception;
}

