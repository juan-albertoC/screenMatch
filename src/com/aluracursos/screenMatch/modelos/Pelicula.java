/*
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
POO
 */
//clase Pelicula es una subclase o clase hija que hereda de Titulo que a su vez hereda de Object
//Estructura de un objeto: modelos
//tras esta configuracion de ordenar codigo en paquetes debe indicar los modificadores de acceso para los atributos y metodos, que mas convengan a las reglas del negocio

package com.aluracursos.screenMatch.modelos;                  //nombre del paquete creado: modelos, que tiene dentro a la clase Pelicula
import com.aluracursos.screenMatch.calculos.Clasificacion;    //importar la interfaz, que ayudan a implementar recursos



public class Pelicula extends Titulo implements Clasificacion {  //herencia con extends es un,es una,
    //marca error en implements, necesita un metodo getClasificacion dentro de la clase


    private String director;               //Atributo privado de tipo String

    //constructor sirve para reservar espacio en memmoria por lo tanto colocar los atributos a esa pelicula, asi estos atributos en memoria la computadora pueda trabajar, operar, modificar con ellos con el fin de obtner valores, validacion de atributos
    //constructor usa encapsulamineto para mantener sistema acotado,colocar informacion vital por ejemplo conexion base datos: login,password,direccion-ip, o tambien para register_web: email, password
   // public Pelicula(String nombre) {      //Crear Constructor 1 atributo parametro: no tiene retorno, como parametro recibe un String nombre para colocar varias peliculas
     //   this.setNombre(nombre);           //metodo void setNombre de la clase Titulo con parametro nombre
    //}

    //Si no se usa Constructor por defecto estandar de Object,entonces implemnetar constructor para cada una de las subclases
    //--constructor
    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);  //super llama al contructor de la clase padre Titulo
    }

    public String getDirector() {         //Getter de director
        return director;
    }

    public void setDirector(String director) {     //Setter de director
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        //casteo de int a double
        return (int) (calcularMedia() / 2);   //a partir de aqui se crea regla de negocio  para obtener esa clasificacion
    }

    //reescrbir ese toString para tener otro comportamiento dentro de nuestra clase
    @Override
    public String toString() {
        return "Pelicula: " + this.getNombre() + " (" + getFechaDeLanzamiento() + ")";
    }
}

