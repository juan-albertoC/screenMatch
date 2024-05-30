/*
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
POO
 */
//clase Episodio es una subclase o clase hija que hereda de Titulo que a su vez hereda de Object
//Estructura de un objeto: modelos
//tras esta configuracion de ordenar codigo en paquetes debe indicar los modificadores de acceso para los atributos y metodos, que mas convengan a las reglas del negocio

package com.aluracursos.screenMatch.modelos;   //nombre del paquete creado: modelos, que tiene dentro a la clase Pelicula
import com.aluracursos.screenMatch.calculos.Clasificacion;  //importar la interfaz, que ayudan a implementar recursos

public class Episodio implements Clasificacion {     //implementa la interfaz
    //Atributos
    private int numero;        //numero del episodio
    private String nombre;     //nombre
    private Serie serie;       //relacionar el episodio con una serie  (tipo de dato Serie ya creado anteriormente)

    private int totalVisualizaciones;


    //----------------------getters and setters-----------------------

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


    //Regla de negocio
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
