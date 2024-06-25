/*
Juan Alberto Cuevas Juarez
11/06/2024
Clase: MainConBusqueda
Implementar comunicacion Cliente-Servidor con Web Service
 */

package com.aluracursos.screenMatch.pMain;

import com.aluracursos.screenMatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenMatch.modelos.Titulo;
import com.aluracursos.screenMatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;        //excepciones
import java.net.URI;               //metodo o parametro
import java.net.http.HttpClient;   //client
import java.net.http.HttpRequest;  //request
import java.net.http.HttpResponse; //response
import java.util.Scanner;

public class MainConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);  //Colocar una pelicula que el usuario requiera con metodo Scanner System.in para datos de entrada
        System.out.println("Escriba el nombre de la pelicula: ");
        var busqueda = lectura.nextLine();       //Guarda el valor que ha ingresado el usuario en variable var busqueda

        String direccion = "https://www.omdbapi.com/?t="+
                busqueda.replace(" ", "+")  //utilizar mejor class URL Encoder  que replace
                +"&apikey=e932da95"; //direccion del servidor, se concatena con el valor que ha ingresado el usuario y la apikey propia del cliente(Juan Cuevas)

        try{   //tratar el problema encoding, capturar la exception
            //request hacer peticion a un servidor con protocolo HTTP, en javadoc class HttpRequest
            HttpClient client = HttpClient.newHttpClient();  //Instancia de client (somos el cliente) que pide datos a un servidor
            HttpRequest request = HttpRequest.newBuilder()   //patron de diseño builder build es plantilla de construir una o muchas cosas como una URI para instancia de peticion request
                    //.uri(URI.create("https://www.omdbapi.com/?t=matrix&apikey=e932da95"))
                    .uri(URI.create(direccion))
                    .build();

            //Instancia no valida  de HttpRequest,  HttpRequest req = new HttpRequest();  no se puede ya que parece una interface es abstracto,

            //obtener respuesta del servidor
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());  //manejo de excepciones con importar throws IOEXCEPTION y aplicarlo en public static void main

            String json = response.body();
            //anterior se tenia que System.out.println(response.body()); //como en postman tiene respuesta de consulta, mostrar el json de  forma raw tipo string
            System.out.println(json);

            //biblioteca para convertir json a clases java: jackson and Gson este ultimo con tools gestores de paquetes para bajar dependencias como file jar con una version y lineas de codigo necesario
            //gestores de paquetes en Java: Maven,Gradle,Ant. En Node: NPM. En Python: PIP. Asi descargar dependencias
            //gson:
            //estructura de proyecto -> modules, dependencias -> ubicacion de file JAR

            //Gson gson = new Gson(); //crear objeto gson de Gson
            //mecanismo de Gson para comprender valores del Json son en mayuscula converttir en minusculas como buena pratica
            //documentacion de Gson -> json field naming support -> setFieldNamingPolicy del patron de diseño Builder usar politica de upper camel case
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            //Titulo miTitulo = gson.fromJson(json, Titulo.class); //crear objeto miTitulo para transformar de un json a una clase de tipo Titulo
            //System.out.println("Titulo: "+miTitulo.getNombre()); //aparece Titulo: null que es como cero de una referencia
            //aparece null como no encontrado el titulo por ello hacer conversion entre json y nuestro objeto, ir a clase Titulo y hacer modificaciones
            //System.out.println(miTitulo);

            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);  //de json a un Record TituloOmdb
            System.out.println(miTituloOmdb);                                 //imprime objeto
            // opcion poco viable Titulo miTitulo = new Titulo(miTituloOmdb.title(), miTituloOmdb.year());


            Titulo miTitulo = new Titulo(miTituloOmdb);    //pasar datos de miTituloOmdb a Titulo,   creacion de objeto miTitulo de tipo Titulo llama al nuevo constructor 3 de Titulo cuyos atributos son nombre, fechaDeLanzamiento, duracionEnMinutos
            System.out.println("Titulo ya convertido: " + miTitulo);
        } catch(NumberFormatException e) {
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        } catch(IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la direccion ");

        } catch(ErrorEnConversionDeDuracionException e){   //Exception generica se cambio por ErrorEnConversionDeDuracionException, que fue llamada en un principio como Exception con su variable e
            System.out.println(e.getMessage());   //anterior se tenia un mensaje "Ocurrio un error inesperado", pero ahora llama a e.getMessage()
        }
        //crear propio exception es una buena idea, pero tambien un file que guarde todos los logs que fueron aconteciendo es buena idea

        //Titulo miTitulo = new Titulo(miTituloOmdb);    //pasar datos de miTituloOmdb a Titulo,   creacion de objeto miTitulo de tipo Titulo llama al nuevo constructor 3 de Titulo cuyos atributos son nombre, fechaDeLanzamiento, duracionEnMinutos
        //System.out.println(miTitulo);

        System.out.println("Finalizo la ejecucion del programa: ");

    }
}
