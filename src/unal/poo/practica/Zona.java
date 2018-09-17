/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unal.poo.practica;
import javax.swing.*;

/**
 *
 * @author Laura M
 */
public class Zona {
    public Posicion posicion[]=new Posicion[5];
    private int sitiosOcupados;
    private double ingParcial;
    private int coordenadaX;
    public Zona(int sitiosOcupados, Posicion posicion[], int coordenadaX){
        this.sitiosOcupados=sitiosOcupados;
        this.posicion=posicion;
        this.coordenadaX=coordenadaX;
    }

    public Posicion[] getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion[] posicion) {
        this.posicion = posicion;
    }

    public int getSitiosOcupados() {
        return sitiosOcupados;
    }

    public void setSitiosOcupados(int sitiosOcupados) {
        this.sitiosOcupados = sitiosOcupados;
    }
    
    public void addSitiosOcupados(int n){
        this.sitiosOcupados+=n;
    }

    public double getIngParcial() {
        return ingParcial;
    }

    public void setIngParcial(double ingParcial) {
        this.ingParcial = ingParcial;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    
    public boolean tieneEspacio(){
        if(this.sitiosOcupados>=5){
        return false;
        } else {
            return true;
        }
    }
    
    public void ingresarVehiculo(String placa){
        boolean repetido=false;
            for(int i=0; i<this.sitiosOcupados; i++){
                if(posicion[i].getPlaca().equals(placa)){
                    repetido=true;
                    System.out.println("El vehículo ya está registrado");
                    JOptionPane.showMessageDialog(null,"El vehículo ya está registrado");
                }
            }
        if(!repetido){
        posicion[this.sitiosOcupados].setOcupado(true);
        posicion[this.sitiosOcupados].setPlaca(placa);
        posicion[this.sitiosOcupados].setHoraE((int)(Math.random()*12));
        this.sitiosOcupados+=1;
            System.out.println("El vehiculo entro.");
        }
    }
    
    public void sacarVehiculo(String placa){
        boolean existe=false;
        if(this.sitiosOcupados>0){
            for(int i=0; i<this.sitiosOcupados; i++){
               if(posicion[i].getPlaca().equals(placa));
                   existe=true;
                   posicion[i].setOcupado(false);
                   this.sitiosOcupados--;
                   System.out.println("El vehículo salio.");
                   posicion[i].setHoraS(posicion[i].getHoraE()*3);
                   this.ingParcial+=(posicion[i].getHoraS()-posicion[i].getHoraE())*20000;
               }
            } if(!existe){
                System.out.println("El vehiculo no esta parqueado en este lugar.");
                JOptionPane.showMessageDialog(null,"El vehiculo no esta parqueado en este lugar");
            }
        }
     
    public String[]mostrarVehiculos(){
      String cadena[]=new String[5];
      cadena[0]=posicion[0].getPlaca();
      cadena[1]=posicion[1].getPlaca();
      cadena[2]=posicion[2].getPlaca();
      cadena[3]=posicion[3].getPlaca();
      cadena[4]=posicion[4].getPlaca();
      return cadena;
    }
}
