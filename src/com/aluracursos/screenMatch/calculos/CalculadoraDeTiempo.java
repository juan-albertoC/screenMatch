/*
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
Poo
 */

package com.aluracursos.screenMatch.calculos;           //nombre del paquete creado: calculos, que tiene dentro a la clase CalculadoraDeTiempo
import com.aluracursos.screenMatch.modelos.Titulo;     //importar la clase modelo padre Titulo en vez de Pelicula y Serie

public class CalculadoraDeTiempo {
    private int tiempoTotal;                 //variable privada de la clase

    public int getTiempoTotal() {           //Getter para obtener y no un setter para que usuario No cambie valores
        return tiempoTotal;
    }

    //---------------Test 1
    //public void incluye(Pelicula pelicula){  //metodo para incluir de tipo Pelicula
      //  tiempoTotal += pelicula.getDuracionEnMinutos();   //Calcular
    //}

    //----------------Test 2: No duplicar codigo en vez de eso hacer uso del concepto de polimorfismo
    //public void incluye(Serie serie){  //metodo para incluir de tipo Serie
        //tiempoTotal += serie.getDuracionEnMinutos();   //Calcular
    //}

    //---------------Test 3: Hacer polimorfismo donde: una pelicula es un titulo,una serie es un titulo se refiere a lo mismo de diferente manera,por lo tanto:
    public void incluye(Titulo titulo){  //metodo para incluir de tipo Pelicula
        this.tiempoTotal += titulo.getDuracionEnMinutos();   // this.tiempoTotal es la variable privada de la clase
    }

    //problema al trabajar con object(cambiar Titulo por Object en parametros) java no sabe que parametro recibir con solo Objectpor eso se escifica con Titulo
   // public void incluye(Object titulo){  //metodo para incluir de tipo Pelicula
       // this.tiempoTotal += titulo.getDuracionEnMinutos();   // this.tiempoTotal es la variable privada de la clase
    //}

}
