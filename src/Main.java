//Nombre del paquete creado y nombre de la clase modelo Pelicula una vez movida al paquete
import com.aluracursos.screenMatch.modelos.Pelicula;
import com.aluracursos.screenMatch.modelos.Serie;

/*
Juan Alberto Cuevas Juarez
20/05/2024
Poo
 */
//Clase primcipal, para hacer test, crear instancias e instaciar objetos
public class Main {
    public static void main(String[] args) {
        //crear modelo de tipo de dato com.aluracursos.screenMatch.modelos.Pelicula, se tiene el concepto de encapsulamiento
        Pelicula miMovie = new Pelicula(); //crear una instancia donde el compilador reserva espacio de memoria para ese objeto con sus respectivos atributos puedan ser almacenados dentro de ese objeto miMovie
        //miMovie.nombre = "Duro de Matar";  esta linea se cambia por setnombre
        miMovie.setNombre("Duro de Matar"); //setter
        miMovie.setFechaDeLanzamiento(2007); //setter
        miMovie.setDuracionEnMinutos(125);   //setter
        miMovie.setIncluidoEnElPlan(true);  //setter
        //Anteriormente directamente en el main se imprimia
        //System.out.println("Mi pelicula es: " + miMovie.nombre);
        //Ahora se imprime con metodo mostrarFichaTecnica()
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

        //Anteriormente directamente en el main se imprimia
        //System.out.println("Mi otra Movie es: " + otraMovie.nombre);
        //System.out.println("su fecha de lanzamiento de otra Movie es: " + otraMovie.fechaDeLanzamiento);
        //System.out.println("su duracion de otra Movie es: " + otraMovie.duracionEnMinutos + "minutos");
        //Ahora se imprime con metodo mostrarFichaTecnica()
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
        Serie casaDragon = new Serie();
        casaDragon.setNombre("La Casa del Dragon");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.mostrarFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());  //imprimir y obtner la duracion total en minutos


    }
}
