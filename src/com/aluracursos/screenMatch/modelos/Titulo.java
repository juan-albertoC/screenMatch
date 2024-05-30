/*
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
Poo
 */

package com.aluracursos.screenMatch.modelos;   //nombre del paquete creado: modelos, que tiene dentro a la clase Titulo

public class Titulo {  //subclase o clase hija que hereda de Object
    //--------------------------------------------Atributos: privados para diferentes peliculas u objetos
    private String nombre;   //se ha agregado un modificador de acceso privado al tipo de dato String nombre
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    //nueva regla del negocio: evaluar las peliculas por lo que implica nueva variable
    private double sumaDeLasEvaluaciones;  //hacer uso de los modificadores de acceso: Private, donde usuario no podra ni ver ni sobreescribir

    private int totalDeLasEvaluaciones;   //Atributo acumulativo de las sumatorias de las evaluaciones donde se incrementa cada vez que una persona evalua

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
        System.out.println("La duracion en minutos es: " + getDuracionEnMinutos());  //Se cambia ya que en Main.java daba 0

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
}
