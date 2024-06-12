/*
Juan Alberto Cuevas Juarez
11/06/2024
Clase: MainConBusqueda
Implementar comunicacion Cliente-Servidor con Web Service
 */

package com.aluracursos.screenMatch.pMain;

import java.io.IOException;        //excepciones
import java.net.URI;               //metodo o parametro
import java.net.http.HttpClient;   //client
import java.net.http.HttpRequest;  //request
import java.net.http.HttpResponse; //response

public class MainConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        //request hacer peticion a un servidor con protocolo HTTP, en javadoc class HttpRequest
        HttpClient client = HttpClient.newHttpClient();  //Instancia de client (somos el cliente) que pide datos a un servidor
        HttpRequest request = HttpRequest.newBuilder()   //patron de diseño builder build es plantilla de construir una o muchas cosas como una URI para instancia de peticion request
                .uri(URI.create("https://www.omdbapi.com/?t=matrix&apikey=e932da95"))
                .build();

        //Instancia no valida  de HttpRequest,  HttpRequest req = new HttpRequest();  no se puede ya que parece una interface es abstracto,

        //obtener respuesta del servidor
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());  //manejo de excepciones con importar throws IOEXCEPTION y aplicarlo en public static void main
        System.out.println(response.body()); //como en postman tiene respuesta de consulta, mostrar el json de  forma raw tipo string

    }
}
