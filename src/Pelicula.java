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
    private double sumaDeLasEvaluaciones;  //hacer uso de los modificadores de acceso: Private, donde usuario no podra ni ver ni sobreescribir

    private int totalDeLasEvaluaciones;   //Atributo acumulativo de las sumatorias de las evaluaciones donde se incrementa cada vez que una persona evalua

    //regla de negocio o escenario para obtener (getters)
    int getTotalDeLasEvaluaciones(){
        //retornar el tipo de dato (usuario no consigue modificar un valor )
        return totalDeLasEvaluaciones;
    }
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

