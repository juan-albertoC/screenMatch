/*
Juan Alberto Cuevas Juarez
18/05/2024
Poo
 */
//Clase primcipal, para hacer test, crear instancias e instaciar objetos
public class Main {
    public static void main(String[] args) {
        //crear modelo de tipo de dato Pelicula, se tiene el concepto de encapsulamiento
        Pelicula miMovie = new Pelicula(); //crear una instancia donde el compilador reserva espacio de memoria para ese objeto con sus respectivos atributos puedan ser almacenados dentro de ese objeto miMovie
        miMovie.nombre = "Duro de Matar";
        miMovie.fechaDeLanzamiento = 2007;
        miMovie.duracionEnMinutos = 125;

        System.out.println("Mi pelicula es: " + miMovie.nombre);
        System.out.println("Su fecha de lanzamiento es: " + miMovie.fechaDeLanzamiento);
        System.out.println("Su duracion es: " + miMovie.duracionEnMinutos + "minutos");

        //Instancia 2
        Pelicula otraMovie = new Pelicula();
        otraMovie.nombre = "Harry potter piedra filosofal";
        otraMovie.fechaDeLanzamiento = 2001;
        otraMovie.duracionEnMinutos = 215;

        System.out.println("Mi otra Movie es: " + otraMovie.nombre);
        System.out.println("su fecha de lanzamiento de otra Movie es: " + otraMovie.fechaDeLanzamiento);
        System.out.println("su duracion de otra Movie es: " + otraMovie.duracionEnMinutos + "minutos");

        System.out.println(otraMovie);  //direccion de memoria unica del objeto

    }
}
