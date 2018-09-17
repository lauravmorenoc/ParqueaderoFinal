package unal.poo.practica;

import becker.robots.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Parqueadero
{    
    private Zona zona[]=new Zona[3];
    private Zona zonaLibre;
    private double ingTotal;
    public static int trayectoria;
    public Parqueadero(Zona zona[], Zona zonaLibre, double ingTotal){
        this.zona=zona;
        this.zonaLibre=zonaLibre;
        this.ingTotal=ingTotal;
    };
    
    public void contarVehiculos(){
        int cantidad=0;
        for(int i=0; i<3;i++){
        moverVariasVeces(13-(zona[i].getCoordenadaX()));
        turnRight();
        for(int j=0; j<5; j++){
            karel.move();
            if(karel.canPickThing()){
                cantidad++;
            }
        }
        zona[i].setSitiosOcupados(cantidad);
        zona[i].setIngParcial(cantidad*20000);
        cantidad=0;
        turnTwice();
        moverVariasVeces(5);
        karel.turnLeft();
        moverVariasVeces(13-zona[i].getCoordenadaX());
        turnTwice();
    }
        
    }
    
    public void pickCar(){
        turnRight();
        int j=0;
        while((!karel.canPickThing())&&(j<6)){
            karel.move();
            j++;
        }
        if(karel.canPickThing()){
            karel.pickThing();
        }
        turnTwice();
        moverVariasVeces(j);
        turnRight();
    }
    
    public void ingVehiculo(String placa){
        if(karel.countThingsInBackpack()>0){
        int menor=0;
        int ocs[]=new int[3];
        for(int i=0; i<3; i++){
            ocs[i]=zona[i].getSitiosOcupados();
        }
        if((ocs[0]<=ocs[1])&&(ocs[0]<=ocs[2])){
            menor=0;
        }else if((ocs[1]<=ocs[2])&&(ocs[1]<=ocs[0])){
            menor=1;
        }else if((ocs[2]<=ocs[1])&&(ocs[2]<=ocs[0])){
            menor=2;
        }
        if(zona[menor].getSitiosOcupados()<5){
        zona[menor].ingresarVehiculo(placa);
        moverVariasVeces(13-zona[menor].getCoordenadaX());
        turnRight();
        moverVariasVeces(5-zona[menor].getSitiosOcupados()+1);
        karel.putThing();
        turnTwice();
        moverVariasVeces(5-zona[menor].getSitiosOcupados()+1);
        karel.turnLeft();
        moverVariasVeces(13-zona[menor].getCoordenadaX());
        turnTwice();
        JOptionPane.showMessageDialog(null, "La zona a la que ha ingresado su vehiculo es: " + (menor+1) + ", NO LO OLVIDE");
        } else{
            System.out.println("El parqueadero está lleno.");
        }
        }
    }
    
    
    public void outVehiculo(String placa, int pos, Zona _zona){
        
        int p=5, q=0;
        for(int h=0; h<5; h++){
        if(_zona.mostrarVehiculos()[h].equals(placa)){
            pos=h;
        }
        }
        _zona.sacarVehiculo(placa);
        moverVariasVeces(13-_zona.getCoordenadaX());
        turnRight();
        while((p>=0)&&(p!=pos)){
            
        if(karel.canPickThing()){
           karel.pickThing();
           turnTwice();
           moverVariasVeces(q);
           karel.turnLeft();
           moverVariasVeces(zonaLibre.getCoordenadaX()-_zona.getCoordenadaX());
           karel.turnLeft();
           karel.move();
           turnRight();
           moverVariasVeces(3-zonaLibre.getSitiosOcupados());
           zonaLibre.ingresarVehiculo(_zona.posicion[p].getPlaca());
           karel.putThing();
           turnTwice();
           moverVariasVeces(4-zonaLibre.getSitiosOcupados());
           karel.turnLeft();
           karel.move();
           turnRight();
           moverVariasVeces(zonaLibre.getCoordenadaX()-_zona.getCoordenadaX());
           turnRight();
           q=0;
           p=5;
        }
        karel.move();
            p--;
            q++;
//
    } if(p==pos){
        karel.pickThing();
           turnTwice();
           moverVariasVeces(q);
           karel.turnLeft();
           moverVariasVeces(13-_zona.getCoordenadaX()+5);
           karel.putThing();
           turnTwice();
           moverVariasVeces(5);
    }
    if(zonaLibre.getSitiosOcupados()>0){
    for(int i=0; i<4; i++){
      moverVariasVeces(13-zonaLibre.getCoordenadaX());
      turnRight();
      karel.move();
      turnRight();
      moverVariasVeces(i);
      if(karel.canPickThing()){
          karel.pickThing();
      }
      turnTwice();
      moverVariasVeces(i);
      karel.turnLeft();
      karel.move();
      turnRight();
      moverVariasVeces(zonaLibre.getCoordenadaX()-_zona.getCoordenadaX());
      turnRight();
      int k=0;
      while(!karel.canPickThing()&&(k<5)){
          karel.move();
          k++;
      }
      turnTwice();
      if(karel.canPickThing()){
          karel.move();
          k--;
      }
      if(karel.countThingsInBackpack()>0){
          karel.putThing();
      }
      moverVariasVeces(k);
      karel.turnLeft();
      moverVariasVeces(13-_zona.getCoordenadaX());
      turnTwice();
    }
    }
    }
    
    public double calcularIngresos(){
    return zona[0].getIngParcial()+zona[1].getIngParcial()+zona[2].getIngParcial();
    }
    
    
       //variables estáticas
        public static City Bogota;
        public static Robot karel;
        
	public static void main (String[] args){
            Bogota= new City("Field.txt");
	    Bogota.showThingCounts(true);
            
            karel = new Robot(Bogota,7, 14, Direction.WEST,0);
            karel.move();
            
            Posicion posicion[]=new Posicion[5];
            posicion[0]=new Posicion(false, "aaa 000", 0);
            posicion[1]=new Posicion(false, "aaa 001", 0);
            posicion[2]=new Posicion(false, "aaa 002", 0);
            posicion[3]=new Posicion(false, "aaa 003", 0);
            posicion[4]=new Posicion(false, "aaa 004", 0);
            
            Posicion _posicion[]=new Posicion[4];
            _posicion[0]=new Posicion(false, null, 0);
            _posicion[1]=new Posicion(false, null, 0);
            _posicion[2]=new Posicion(false, null, 0);
            _posicion[3]=new Posicion(false, null, 0);
            
            Zona zona[]=new Zona[3];
            zona[0]=new Zona(0, posicion, 2);
            zona[1]=new Zona(0, posicion, 4);
            zona[2]=new Zona(0, posicion, 6);
            
            Zona zonaLibre=new Zona(0, _posicion, 8);
            
            Parqueadero p1= new Parqueadero(zona, zonaLibre, 0);
            
            p1.contarVehiculos();
            
            int a=Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer?: "
                    + "1 => Ingresar un vehiculo, "
                    + "2 => Sacar un vehiculo, "));
            switch (a){
                case 1: 
                    if(zona[0].getSitiosOcupados()+zona[1].getSitiosOcupados()+zona[2].getSitiosOcupados()!=15){
                    String placa=JOptionPane.showInputDialog(null, "Introduce la placa");
                    p1.pickCar();
                    p1.ingVehiculo(placa);
                    }else{
                        JOptionPane.showMessageDialog(null,"El parqueadero está lleno");
                    }
                    break;
                case 2:
                    String placa2=JOptionPane.showInputDialog(null, "Introduce la placa");
                    int seccion=Integer.parseInt(JOptionPane.showInputDialog("Introduce zona de parqueo"));
                    if((seccion<1)||(seccion>3)){
                        JOptionPane.showMessageDialog(null,"El número de la zona es incorrecto");
                    } else{
                        p1.outVehiculo(placa2, 0, zona[seccion-1]);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Intente de nuevo mas tarde");
            }
            int seleccion = JOptionPane.showConfirmDialog(null, "¿Desea conocer los ingresos?");
            if(seleccion==0){
                JOptionPane.showMessageDialog(null,"Ingresos del dia: $" + p1.calcularIngresos());
            }
}

        
        
        //Funciones que se habían hecho antes para evitar repetición de código
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
        public static void turnTwice(){
            karel.turnLeft();
            karel.turnLeft();
        }    
}
