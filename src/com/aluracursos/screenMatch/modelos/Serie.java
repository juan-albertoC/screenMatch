package com.aluracursos.screenMatch.modelos;

//herencia con extends es un,es una,
public class Serie extends Titulo {     // en este caso Serie hereda o es hija de Titulo
    int temporadas;
    int episodiosPorTemporada;
    int minutosPorEpisodio;

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
