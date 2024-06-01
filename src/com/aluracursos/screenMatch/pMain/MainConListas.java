package com.aluracursos.screenMatch.pMain;

import com.aluracursos.screenMatch.modelos.Pelicula;
import com.aluracursos.screenMatch.modelos.Serie;
import com.aluracursos.screenMatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;  //coleecciones para ordenar

public class MainConListas {
    public static void main(String[] args) {

        Pelicula miMovie = new Pelicula("Duro de Matar", 2007); //crear una instancia donde el compilador reserva espacio de memoria para ese objeto con sus respectivos atributos puedan ser almacenados dentro de ese objeto miMovie
        miMovie.evaluar(8);
        Pelicula otraPelicula = new Pelicula("Matrix", 1998);  //se cambia por parametro del constructor nombre
        otraPelicula.evaluar(10);
        var peliculaJuan = new Pelicula("El señor de los anillos", 2001); //iniciar con un nombre ya que es el atributo mas significativo
        peliculaJuan.evaluar(10);
        Serie casaDragon = new Serie("La Casa del Dragon", 2022);
        casaDragon.evaluar(9);

        //---objetos
        //Pelicula p1 = miMovie;   //varaoblr que hace referencia al objeto en la memoria, por lo tanto p1 and miMovie hacen refeencia al mismo objeto pelicula en memoria


        //crear arrayLists (Lista de peliculas y series)
        //Acotar el arraylist con un integer para el tamaño: performance para sistemas mas complejos segun su diseño de sistemas
        //ArrayList<Pelicula> lista = new ArrayList<>();  //ArrayList<Pelicula>  es tipo de dato
        //marcacion de error en lista.add agregar serie para tipo Serie ya que solo hay de tipo Pelicula y no de Serie, en cambio para series y peliculas la super clase en comun es Titulo
        ArrayList<Titulo> lista = new ArrayList<>();  //ArrayList<Pelicula>  es tipo de dato, donde Titulo hereda de Object,  <> se llama generics
        //agregar un item dentro de esa lista
        lista.add(peliculaJuan);    //item indice 0
        lista.add(miMovie);         //item indice 1
        lista.add(otraPelicula);    //item indice 2
        lista.add(casaDragon);      //item indice 3

        //for each para iterar en cada item de la lista, mostrar toString
        for(Titulo item: lista) {
            System.out.println(item.getNombre());
            //Error en la ejecucion de no poder convertir series en peliculas, para ello se haceun if
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2){  //gracias a java 17 se tiene que pelicula variable de referencia hace como un casting, es decir que transforma la referencia de la variable que apunta a ese objeto, ademas operaciones &&

                //para evaluar una pelicula o serie se usara metodo evaluar asi obtener su clasificacion con getClasificacion
                //getClasificacion solo existe en Pelicula no en Serie, ni tampoco en Titulo
                //forzar o hacer un casting casteo:
                //Pelicula pelicula = (Pelicula) item;   //nueva variable pelicula donde es igual a item de tipo Titulo, por lo tanto convertir Titulo a Pelicula castear antes de la variable item
                System.out.println(pelicula.getClasificacion());


            }


        }


        //Ordenar una lista
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Gael Garcia Bernal");
        System.out.println(listaDeArtistas);  //lista  no ordenada


        //coleccion de lista de artistas
        Collections.sort(listaDeArtistas); //metodo estatico sort sin hacer instancia
        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);

        //ordenar otra lista, tener una logica de comparacion
        Collections.sort(lista);  //error titulo no implemta tipo comparado
        //verificar documentacion de javadoc 17 Sting, java lang String, dentro se tiene a Interface Comparable<T> que compara dos objetos mismo tipo e implemnta un unico metodo y tarea especifica

        //Imprimir lista
        System.out.println("Lista de titulos ordenados: " + lista);


    }
}
