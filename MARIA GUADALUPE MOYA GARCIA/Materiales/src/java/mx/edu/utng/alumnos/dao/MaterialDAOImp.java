/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.alumnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.alumnos.model.Material;
import mx.edu.utng.alumnos.util.UtilDB;
import mx.edu.utng.alumnos.util.UtilDB;


public class MaterialDAOImp implements MaterialDAO{

    private Connection connection;
    
    public MaterialDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarMaterial(Material material) {
        try{
            String query = "INSERT INTO materiales(nombre, precio, comision,"
                    + " existencia_min, existencia_max) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, material.getNombre());
            ps.setDouble(2, material.getPrecio());
            ps.setDouble(3, material.getComision());
            ps.setInt(4, material.getExistenciaMin());
            ps.setInt(5, material.getExistenciaMax());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarMaterial(int idMaterial) {
        try{
            String query = "DELETE FROM materiales WHERE id_material=?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setInt(1, idMaterial);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarMaterial(Material material) {
        try{
            String query = "UPDATE materiales SET nombre=?, precio=?, comision=?, existencia_min=?, existencia_max=? "
                    + " WHERE id_material=?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, material.getNombre());
            ps.setDouble(2, material.getPrecio());
            ps.setDouble(3, material.getComision());
            ps.setInt(4, material.getExistenciaMin());
            ps.setInt(5, material.getExistenciaMax());
            ps.setInt(6, material.getIdMaterial());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Material> desplegarMaterial() {
        List<Material> materiales = new ArrayList<Material>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM materiales");
            while (resultSet.next()) {
                
                Material material = new Material(
                resultSet.getInt("id_material"), 
                resultSet.getString("nombre"),
                resultSet.getDouble("precio"),
                resultSet.getDouble("comision"),
                resultSet.getInt("existencia_min"),
                resultSet.getInt("existencia_max"));
                materiales.add(material); 
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return materiales;
    }

    @Override
    public Material elegirMaterial(int idMaterial) {
        Material material = new Material();
        try{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM materiales"
                + " WHERE id_material=?");
        statement.setInt(1, idMaterial);
        
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                material.setIdMaterial(resultSet.getInt("id_material")); 
                material.setNombre(resultSet.getString("nombre"));
                material.setPrecio(resultSet.getDouble("precio"));
                material.setComision(resultSet.getDouble("comision"));
                material.setExistenciaMin(resultSet.getInt("existencia_min"));
                material.setExistenciaMax(resultSet.getInt("existencia_max"));
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return material;
    }
}
