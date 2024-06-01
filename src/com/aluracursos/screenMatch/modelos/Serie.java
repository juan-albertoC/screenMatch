/*
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
Poo
 */
//clase Serie es una subclase o clase hija que hereda de Titulo que a su vez hereda de Object
//Estructura de un objeto: modelos
//tras esta configuracion de ordenar codigo en paquetes debe indicar los modificadores de acceso para los atributos y metodos, que mas convengan a las reglas del negocio

package com.aluracursos.screenMatch.modelos;    //nombre del paquete creado: modelos, que tiene dentro a la clase Serie

public class Serie extends Titulo {    //herencia con extends es un,es una,
    int temporadas;
    int episodiosPorTemporada;
    int minutosPorEpisodio;

    //-------Constructor----2 atributos parametros------------coincidencia entre constructor de serie y titulo
    public Serie(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }


    //getDuracionEnMinutos se incluye para Calcular el tiempo de duracion en minutos ya que com.aluracursos.screenMatch.pMain.Main.java su resultado era 0
    @Override                                 //override es notacion, es una sobrescritura de metodos (metodo original en Titulo y aqui se sobrescribe)
    public int getDuracionEnMinutos() {       // si en futuro hay cambios en el metodo original por alguna regla de negocio por ejemplo int valor este lo notificara

        //return super.getDuracionEnMinutos();   no nos interesa ya que retorna la super clase madre Titulo
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;  //si interesa calcular valor
    }

    //----------------Getters and Setters-----------------------

    public int getTemporadas() {                     //Getter de temporadas
        return temporadas;
    }

    public void setTemporadas(int temporadas) {     //Setter de temporadas
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Serie: " + this.getNombre() + " (" + this.getFechaDeLanzamiento() + ")";

    }
}
