//nombre del paquete creado
//tras esta configuracion de ordenar codigo en paquetes debe indicar los modificadores de acceso para los atributos y metodos, que mas convengan a las reglas del negocio
package com.aluracursos.screenMatch.modelos;

/*
Juan Alberto Cuevas Juarez
20/05/2024
POO
 */
//Estructura de un objeto: clases modelo, en este caso clase com.aluracursos.screenMatch.modelos.Pelicula

//herencia con extends es un,es una,
public class Pelicula extends Titulo {     // en este caso Pelicula hereda o es hija de Titulo

    private String director;               //Atributo

    public String getDirector() {         //Getter de director
        return director;
    }

    public void setDirector(String director) {     //Setter de director
        this.director = director;
    }
}

