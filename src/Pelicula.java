/*
Juan Alberto Cuevas Juarez
18/05/2024
POO
 */
//Estructura de un objeto: clases modelo, en este caso clase Pelicula
public class Pelicula {
    //--------------------------------------------Atributos para diferentes peliculas u objetos
    String nombre;
    int fechaDeLanzamiento;
    int duracionEnMinutos;
    boolean incluidoEnElPlan;
    //nueva regla del negocio: evaluar las peliculas por lo que implica nueva variable
    double sumaDeLasEvaluaciones;

    int totalDeLasEvaluaciones;   //Atributo acumulativo de las sumatorias de las evaluaciones donde se incrementa cada vez que una persona evalua

//------------------------------------------------------------------------------------------------------------
    //METODOS VOID SIN RETORNO

    //metodo para mostrar la ficha tecnica o informacion acerca de la pelicula
    void mostrarFichaTecnica(){

        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("La fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("La duracion es: " + duracionEnMinutos + "minutos");

    }

    //metodo para evaluar la pelicula segun la nota, espera recibir un dato de tipo double
    void evaluar(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;  //variable que se incremnta cada vez que una persona evalua una pelicula
    }

    //METODO CON RETORNO
    //metodo que retorna un valor de tipo double para calcular la media
    double calcularMedia(){
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

}

