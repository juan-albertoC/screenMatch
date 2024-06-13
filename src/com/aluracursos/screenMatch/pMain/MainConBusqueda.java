/*
Juan Alberto Cuevas Juarez
11/06/2024
Clase: MainConBusqueda
Implementar comunicacion Cliente-Servidor con Web Service
 */

package com.aluracursos.screenMatch.pMain;

import com.aluracursos.screenMatch.modelos.Titulo;
import com.google.gson.Gson;

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

        String direccion = "https://www.omdbapi.com/?t="+busqueda+"&apikey=e932da95"; //direccion del servidor, se concatena con el valor que ha ingresado el usuario y la apikey propia del cliente(Juan Cuevas)

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
        Gson gson = new Gson(); //crear objeto gson de Gson
        Titulo miTitulo = gson.fromJson(json, Titulo.class); //crear objeto miTitulo para transformar de un json a una clase de tipo Titulo
        //System.out.println("Titulo: "+miTitulo.getNombre()); //aparece Titulo: null que es como cero de una referencia
        //aparece null como no encontrado el titulo por ello hacer conversion entre json y nuestro objeto, ir a clase Titulo y hacer modificaciones
        System.out.println(miTitulo);



    }
}
