package com.aluracursos.screenMatch.modelos;
import com.aluracursos.screenMatch.calculos.Clasificacion;
public class Episodio implements Clasificacion {
    //Atributos
    private int numero;        //numero del episodio
    private String nombre;     //nombre
    private Serie serie;       //relacionar el episodio con una serie  (tipo de dato Serie ya creado anteriormente)

    private int totalVisualizaciones;
    //getters and setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    @Override
    public int getClasificacion() {
        //regla de negocio diferente
        if (totalVisualizaciones > 100){
            return 4;
        }else {
            return 2;
        }

    }
}
