package com.aluracursos.screenMatch.calculos;            //paquete name
//import com.aluracursos.screenMatch.modelos.Pelicula;     //importar la clase modelo Pelicula
//import com.aluracursos.screenMatch.modelos.Serie;     //importar la clase modelo Serie
import com.aluracursos.screenMatch.modelos.Titulo;     //importar la clase modelo Titulo

public class CalculadoraDeTiempo {           //clase
    private int tiempoTotal;                 //variable privada de la clase

    public int getTiempoTotal() {           //Getter para obtner y no un setter para que usuario No cambie valores
        return tiempoTotal;
    }

    //public void incluye(Pelicula pelicula){  //metodo para incluir de tipo Pelicula
      //  tiempoTotal += pelicula.getDuracionEnMinutos();   //Calcular
    //}

    //No duplicar codigo en vez de eso hacer uso del concepto de polimorfismo
    //public void incluye(Serie serie){  //metodo para incluir de tipo Serie
        //tiempoTotal += serie.getDuracionEnMinutos();   //Calcular
    //}

    //polimosfirsmo una pelicula es un titulo,una serie es un titulo se refiere a lo mismo de diferente manera
    public void incluye(Titulo titulo){  //metodo para incluir de tipo Pelicula
        this.tiempoTotal += titulo.getDuracionEnMinutos();   // this.tiempoTotal es la variable privada de la clase
    }
}
