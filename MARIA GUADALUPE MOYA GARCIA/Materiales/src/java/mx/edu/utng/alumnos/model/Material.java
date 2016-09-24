/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.alumnos.model;

/**
 *
 * @author Guadalupe Moya
 */
public class Material {
    private int idMaterial;
    private String nombre;
    private double precio;
    private double comision;
    private int existenciaMin;
    private int existenciaMax;
    

    public Material() {
        this(0,"", 0, 0,0,0);
    }

    public Material(int idMaterial, String nombre, double precio, double comision, int existenciaMin, int existenciaMax) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.precio = precio;
        this.comision = comision;
        this.existenciaMin = existenciaMin;
        this.existenciaMax = existenciaMax;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getExistenciaMin() {
        return existenciaMin;
    }

    public void setExistenciaMin(int existenciaMin) {
        this.existenciaMin = existenciaMin;
    }

    public int getExistenciaMax() {
        return existenciaMax;
    }

    public void setExistenciaMax(int existenciaMax) {
        this.existenciaMax = existenciaMax;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", nombre=" + nombre + ", precio=" + precio + ", comision=" + comision + ", existenciaMin=" + existenciaMin + ", existenciaMax=" + existenciaMax + '}';
    } 
  

}
