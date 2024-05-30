/*
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
POO
 */

package com.aluracursos.screenMatch.calculos;  //nombre del paquete creado: calculos, que tiene dentro a la clase FiltrosRecomendacion

public class FiltrosRecomendacion {

    //filtro de recomedaciones
    public void filtrar(Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >= 4){
            System.out.println("Muy bien evaluado en el momento");
        }else if(clasificacion.getClasificacion() >= 2){
            System.out.println("Popular en el momento");
        } else {
            System.out.println("Colocalo en tu lista para verlo despues");
        }
    }
}
