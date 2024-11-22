package com.example.Entidad;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entidad
public class Producto {
    @Id
    @GeneratedValue((strategy = GenerationType.IDENTITY))
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private int precio;

    @Column(name = "cantidadEnStock")
    private int cantidadEnStock;

    public long getId (){
        return id;
    }

    public void setId (long id){
        this.id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre;
    }

    public int getPrecio(){
        return precio;
    }

    public void setPrecio(int precio){
        this.precio;
    }

    public int getCantidadEnStock(){
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock){
        this.cantidadEnStock
    }
}