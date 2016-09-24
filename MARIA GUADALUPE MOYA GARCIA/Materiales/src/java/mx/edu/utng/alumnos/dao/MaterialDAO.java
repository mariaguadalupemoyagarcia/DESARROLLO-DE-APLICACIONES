/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.alumnos.dao;

import java.util.List;
import mx.edu.utng.alumnos.model.Material;
/**
 *
 * @author Guadalupe Moya
 */
public interface MaterialDAO {
    void agregarMaterial (Material material);
    void borrarMaterial (int idMatrial);
    void cambiarMaterial (Material material);
    List<Material> desplegarMaterial();
    Material elegirMaterial (int idMaterial);
    
}
