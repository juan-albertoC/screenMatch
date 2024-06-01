
package com.aluracursos.screenMatch.pMain;/* refactoring direccion de paquete pMain
Juan Alberto Cuevas Juarez
20/05/2024, 29/05/2024
Poo
 */
//Clase principal, para hacer test, crear instancias e instaciar objetos

//Importaciones con nomenclatura que tiene el nombre del paquete creado y el nombre de una clase especifica, se tiene asi el concepto de encapsulamiento
import com.aluracursos.screenMatch.calculos.FiltrosRecomendacion;
import com.aluracursos.screenMatch.modelos.Episodio;
import com.aluracursos.screenMatch.modelos.Pelicula;
import com.aluracursos.screenMatch.modelos.Serie;
import com.aluracursos.screenMatch.calculos.CalculadoraDeTiempo;

import java.util.ArrayList;  //importar para usar ArrayList

public class Main {
    public static void main(String[] args) {

        Pelicula miMovie = new Pelicula("Duro de Matar", 2007); //crear una instancia donde el compilador reserva espacio de memoria para ese objeto con sus respectivos atributos puedan ser almacenados dentro de ese objeto miMovie

        //miMovie.nombre = "Duro de Matar";  esta linea se cambia por setnombre
        //miMovie.setNombre("Duro de Matar"); //setter  que esta linea se cambia por el parametro del constructor
        //miMovie.setFechaDeLanzamiento(2007); //setter
        miMovie.setDuracionEnMinutos(125);   //setter
        miMovie.setIncluidoEnElPlan(true);  //setter
        //Anteriormente directamente en el main se imprimia:
              //System.out.println("Mi pelicula es: " + miMovie.nombre);
        //Ahora se imprime con metodo mostrarFichaTecnica() :
        miMovie.mostrarFichaTecnica();   //llamada del metodo mostrarFichaTecnica() para ver la informacion de la pelicula
        miMovie.evaluar(7.8);      //llamada del metodo evaluar() donde se agrega calificacion por parte del usuario
        miMovie.evaluar(9.5);      //llamada del metodo evaluar() donde se agrega calificacion por parte del usuario
        miMovie.evaluar(10);
        miMovie.evaluar(10);
        miMovie.evaluar(10);
        System.out.println(miMovie.getTotalDeLasEvaluaciones()); //Imprime y obtiene el total de las evaluaciones getter
        System.out.println(miMovie.isIncluidoEnElPlan());   //imprimir el getter si esta incluido en el plan
        System.out.println(miMovie.calcularMedia());    //Imprime por pantalla la Llamada del metodo calcularMedia
        System.out.println(miMovie);  //direccion de memoria unica del objeto

        //Restricciones para seguridad donde usuario no modifique directamente en el codigo, hace uso del concepto de encapsulamiento ()
        //Usuario se abstrae (Abstraccion) del conocimiento detras de la aplicacion por ello hacer uso de los MODFICADORES DE ACCESO O VISIBILIDAD: private, public, restricted





//----------------------------------------------REFACTORIZACION DE CODIGO----------------------------------------------------------------------
        //Instancia 2 para otro objeto
        //com.aluracursos.screenMatch.modelos.Pelicula otraMovie = new com.aluracursos.screenMatch.modelos.Pelicula();
        //otraMovie.nombre = "Harry potter piedra filosofal";
        //otraMovie.fechaDeLanzamiento = 2001;
        //otraMovie.duracionEnMinutos = 215;

        //Anteriormente directamente en el main se imprimia:
               //System.out.println("Mi otra Movie es: " + otraMovie.nombre);
               //System.out.println("su fecha de lanzamiento de otra Movie es: " + otraMovie.fechaDeLanzamiento);
               //System.out.println("su duracion de otra Movie es: " + otraMovie.duracionEnMinutos + "minutos");
        //Ahora se imprime con metodo mostrarFichaTecnica():
        //otraMovie.mostrarFichaTecnica();  //llamada del metodo mostrarFichaTecnica()
        //otraMovie.evaluar(10);
        //otraMovie.evaluar(9.8);
        //otraMovie.evaluar(10);
        //otraMovie.evaluar(10);
        //System.out.println(otraMovie.sumaDeLasEvaluaciones);      //se elimina esta linea que Imprime las sumas de las evaluaciones (Usuario no deberia ver)
        //System.out.println(otraMovie.totalDeLasEvaluaciones);    //se cambia esta linea por getter creado
        //System.out.println(otraMovie.getTotalDeLasEvaluaciones());  //Imprime y obtiene el total de las evaluaciones
        //System.out.println(otraMovie.calcularMedia());
        //System.out.println(otraMovie);  //direccion de memoria unica del objeto


        //-----------------Instancia para Serie-------------------------------------------------
        Serie casaDragon = new Serie("La Casa del Dragon", 2022);
        //casaDragon.setNombre("La Casa del Dragon");
        //casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.mostrarFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());  //imprimir y obtner la duracion total en minutos

        //-----------------Instancia para otra Pelicula-------------------------------------------------
        Pelicula otraPelicula = new Pelicula("Matrix", 1998);  //se cambia por parametro del constructor nombre
        //otraPelicula.setNombre("Matrix");                     //se elimina linea
        //otraPelicula.setFechaDeLanzamiento(1998);
        otraPelicula.setDuracionEnMinutos(180);

        //---------------Llamar al metodo creado de CalculadoraDeTiempo para ello crear una nueva Instancia de dicha clase
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miMovie);   //Pelicula
        calculadora.incluye(casaDragon); //Serie (no reconoce: para ello en CalculadoraDeTiempo.java importar la clase modelo Serie ademas crear metodo void para incluir de tipo Serie)
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver titulos favoritos: " + calculadora.getTiempoTotal() + " minutos");

        //Test para filtro de recomendaciones para peliculas ----------Crear una instancia para filtros
        FiltrosRecomendacion filtrosRecomendacion = new FiltrosRecomendacion();
        filtrosRecomendacion.filtrar(miMovie);

        //Test para filtro de recomendaciones para Episodios ----------Crear una instancia para episodio
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa de  targarian");
        episodio.setSerie(casaDragon);
        //calculo para realizar la clasificacion que No aparece ya que no hay getters and setters del atributo privado int totalVisualizaciones de la clase Episodio
        episodio.setTotalVisualizaciones(50);  //test para 300, 50 visualizaciones
        filtrosRecomendacion.filtrar(episodio);


        //------------------------------------------Nueva Instancia para ejemplo de ArrayList--------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        //----forma 1: Pelicula peliculaJuan = new Pelicula(); //Pelicula() es el tipo de dato o el tipo de dato a guardar, donde Pelicula  es la variable de referencia  para peliculaJuan

        //----forma 2:
        //var peliculaJuan = new Pelicula();   //var es la inferencia del tipo de dato, java es tipado y no permite el cambio por otro tipo de dato
        //peliculaJuan.setNombre("El señor de los anillos");
        //peliculaJuan.setDuracionEnMinutos(180);
        //peliculaJuan.setFechaDeLanzamiento(2001);

        //----forma 3: -------------------- constructor-------------------
        var peliculaJuan = new Pelicula("El señor de los anillos", 2001); //iniciar con un nombre ya que es el atributo mas significativo
        //peliculaJuan.setNombre();  esta linea se elimina
        //peliculaJuan.setFechaDeLanzamiento(2001);
        peliculaJuan.setDuracionEnMinutos(180);




        //crear arrayLists
        //Acotar el arraylist con un integer para el tamaño: performance para sistemas mas complejos segun su diseño de sistemas
         ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();  //ArrayList<Pelicula>  es tipo de dato
         //agregar un item dentro de esa lista
        listaDePeliculas.add(peliculaJuan);    //item indice 0
        listaDePeliculas.add(miMovie);         //item indice 1
        listaDePeliculas.add(otraPelicula);    //item indice 2

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());  //Imprimir el tamaño de la lista
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());  //obtener un item de esa lista, para ello el indice de una lista comenzara en 0, getNombre() viene de Titulo

        //imprimir lista completa
        System.out.println(listaDePeliculas.toString());  //referencia al objeto dentro de la memoria
        //System.out.println(listaDePeliculas.get(0).toString());
        System.out.println(" toString de la pelicula: " + listaDePeliculas.get(0).toString());

        //test toString
        peliculaJuan.toString();  //toString hereda de clase madre Object

        //test de Object (super clase o clase madre),
        Object objeto = peliculaJuan;  //peliculaJuan es de tipo Pelicula y Pelicula hereda es Object







    }
}
