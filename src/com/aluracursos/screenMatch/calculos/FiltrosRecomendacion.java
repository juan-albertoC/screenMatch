package com.aluracursos.screenMatch.calculos;

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
