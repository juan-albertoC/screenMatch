/*
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
25/06/2024
Poo
 */

package com.aluracursos.screenMatch.modelos;   //nombre del paquete creado: modelos, que tiene dentro a la clase Titulo
import com.aluracursos.screenMatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName; //importar una annotations

//aplicar Logica de Comparacion con implements Comparable <Titulo> e implementar metodo compareTo
public class Titulo implements Comparable<Titulo>{  //subclase o clase hija que hereda de Object
    //aparece null como no encontrado el titulo por ello hacer conversion entre json y nuestro objeto
    //@SerializedName("Title") //convertir esa estructura de datos a un String
    //--------------------------------------------Atributos: privados para diferentes peliculas u objetos
    private String nombre;   //se ha agregado un modificador de acceso privado al tipo de dato String nombre
    //-------------------------------------------------
    //@SerializedName("Year")  // annotation que aparece en el json llamada Year
    //-------------------------------------------------
    private int fechaDeLanzamiento;
    //--------------------------------------------

    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    //nueva regla del negocio: evaluar las peliculas por lo que implica nueva variable
    private double sumaDeLasEvaluaciones;  //hacer uso de los modificadores de acceso: Private, donde usuario no podra ni ver ni sobreescribir

    private int totalDeLasEvaluaciones;   //Atributo acumulativo de las sumatorias de las evaluaciones donde se incrementa cada vez que una persona evalua

    //--------------------------------------------Constructor 2 atributos parametros-----------------------


    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
    //----------------------------------------------Constructor 3------------------------
    //Nuevo constructor que recibe parametro un miTituloOmdb de tipo TituloOmdb, sea capaz de  compreder pasar datos TituloOmdb a Titulo
    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());//casting de un valueOf
        if(miTituloOmdb.runtime().contains("N/A")){    //crear mi propia exception
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion, porque contiene un N/A ");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ", "")); //error convertir int a string valueof 60 min, propiedad de los strings para recortar valores con primeros 3 digitos y convertir a String
                                                                                       //replace ya que matrix daba error 60 min, remplazar ese espacio por nada
    }

    //---------------------------------Getters: regla de negocio o escenario para obtener
    public int getTotalDeLasEvaluaciones(){
        //retornar el tipo de dato (usuario no consigue modificar un valor )
        return totalDeLasEvaluaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }
    //---------------------------------Setters: Colocar un valor especifico para cada uno de los atributos

    public void setNombre(String nombre) {   //recibe parametro nombre de tipo String
        this.nombre = nombre;   //this.nombre se refiere al atributo de esta(this) clase, en cambio nombre se refiere al valor que el usuario ingresara
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    //------------------METODOS VOID SIN RETORNO------------------------------------------------------------------------------------------

    //metodo para mostrar la ficha tecnica o informacion acerca de la pelicula
    public void mostrarFichaTecnica(){

        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("La fecha de lanzamiento es: " + fechaDeLanzamiento);
       // System.out.println("La duracion es: " + duracionEnMinutos + "minutos");   //setter por el usuario
        //para Pelicula o para Serie
        System.out.println("La duracion en minutos es: " + getDuracionEnMinutos());  //Se cambia ya que en com.aluracursos.screenMatch.pMain.Main.java daba 0

    }

    //metodo para evaluar la pelicula segun la nota, espera recibir un dato de tipo double
    public void evaluar(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;  //variable que se incremnta cada vez que una persona evalua una pelicula
    }

    //------------------METODO CON RETORNO
    //metodo que retorna un valor de tipo double para calcular la media
    public double calcularMedia(){
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    //Implementacion de metodo compareTo
    @Override
    public int compareTo(Titulo otroTitulo) {
        //delegar logica de orden a los nombres de strings

        return this.getNombre().compareTo(otroTitulo.getNombre());
    }
    //Implementacion de metodo toString para comprender que se ve dentro del titulo
    @Override
    public String toString() {
        return "(nombre=" + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento+
                ", duracion="+duracionEnMinutos+")";
    }
}
