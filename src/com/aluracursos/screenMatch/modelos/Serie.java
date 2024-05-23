package com.aluracursos.screenMatch.modelos;

//herencia con extends es un,es una,
public class Serie extends Titulo {     // en este caso Serie hereda o es hija de Titulo
    int temporadas;
    int episodiosPorTemporada;
    int minutosPorEpisodio;


    //Se incluye para Calcular eltiempo de duracion en minutos ya que Main.java su resultado era 0

    @Override                                 //notacion que es una sobrescritura de metodos (metodo original en Titulo y aqui se sobrescribe)
    public int getDuracionEnMinutos() {       // si en futuro hay cambios en el metodo original por alguna regla de negocio por ejemplo int valor este lo notificara

        //no nos interesa ya que retorna la super clase madre Titulo
        //return super.getDuracionEnMinutos();
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;  //si interesa calcular valor
    }

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
}
