import java.util.LinkedList;
import java.util.Queue;

public class Cine {
    //En el diseño del Formulario existe un label actualice a su Nombre y Apellido
    //No borre ninguna sección del codigo proporcionado,
    // Si borra tendrá la nota minima 1.0
    //Se necesita completar las clases Cine y Formulario
    //Con los algoritmos y métodos necesarios de la estructura FIFO
    //Enunciado: Cada sala de cine tiene una capacidad de 23 espacios, solo se
    //pueden comprar como máximo 3 entradas por cliente a una pelicula, VALIDAR Y GARANTIZAR QUE NO SE PUEDAN VENDER MÁS VOLETOS DE LOS DISPONIBLES 
    //Desplegar cada una de las compras en el textArea.
    //Se necesita consultar cuántos espacios quedan disponibles por cada una
    //de las peliculas. DESPLEGAR DESPUES DE CADA COMPRA
    //Rubrica de calificación:
    //Completar la clase Cine 4 Puntos.
    //Agregar elemento a la Cola y mostrar en el textArea 2 Puntos.
    //Programar los botones para conocer la cantidad de espacios disponibles 4 Puntos.
    //Suba su programa a la plataforma hasta que finalice la hora.

    //Declare la referencia  Cola para almacenar asistentes
    private Queue<Asistente> asistente;

    public Cine(){
        asistente = new LinkedList<Asistente>();

    }

    //inicialice el objeto





    public boolean esVacia(){
     // cambie el método para que funcione correctamente


        return asistente.isEmpty();
    }

    public int tamanio(){
        //actualice la sentencia para que devuelva el tamaño de elementos en la cola
        return asistente.size();
    }

    public void encolar(String pelicula, int cantidad){
      //complete el método
        asistente.add(new Asistente(pelicula,cantidad));
    }

    public Asistente desencolar() {
       //actualice el método para eliminar el elemento del inicio.
        return asistente.poll();
    }

    //cree un método para listar los elementos en una textArea.
    public String listarAsistente(){
        String mensaje =" ";
        for (Asistente a:asistente){
            mensaje += a.toString();
        }
        return mensaje;
    }


    //cree un método para conocer la cantidad de entradas disponibles
    public int entradasDisponibles() throws Exception{

        int entradas =0;
        for (Asistente a:asistente){
            entradas += a.getCantidad();
        }
        int entradasLibres = 23 - entradas;
        if (entradasLibres <=0){
            throw new Exception("Entradas agotadas");
        }
        return entradasLibres;
    }


}
