package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase1
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot karel;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            karel = new Robot(objetos,0, 1, Direction.SOUTH,10);
           
            
	   /* //Mover una interseccion en el sentido al cual este apuntando el objeto.
            estudiante.move ();
            //Girar a la izquierda
            estudiante.turnLeft();
            //Tomando decisiones, Si puedo tomar un Thing
            boolean puedeTomar = estudiante.canPickThing();
            //Tomar un Thing
            if(puedeTomar == true)
            //Especifica el numero de Thing que tiene en robot en el bolso
            int numeroThings = estudiante.countThingsInBackpack();
            //Poner Thing, se debe validar que tenga things en el bolso
            estudiante.putThing();
            //Si el frente esta libre de Wall
            estudiante.frontIsClear();
            //Invocando una funcion
            creacionFuncion(4);
            //Toman un Thing
            estudiante.pickThing();   
	} */
}
        public static void turnRight(){
            karel.turnLeft(); karel.turnLeft(); karel.turnLeft();
        }
        public static void moverVariasVeces(int a){
            for(int n=0; n<a; n++){
                karel.move();
            }
        }
        public static void countAndPick(){
            int cantidad=0;
            while(karel.canPickThing()){
                cantidad++;
                karel.pickThing();
            }
        }
      
}
