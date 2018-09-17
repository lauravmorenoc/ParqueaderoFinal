/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;

/**
 *
 * @author Laura M
 */
public class Posicion {
    private boolean ocupado;
    private String placa;
    private int horaE;
    private int horaS;
    public Posicion(boolean ocupado, String placa, int horaE){
        this.ocupado=ocupado;
        this.placa=placa;
        this.horaE=horaE;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca( String placa) {
        this.placa = placa;
    }

    public int getHoraE() {
        return horaE;
    }

    public void setHoraE(int horaE) {
        this.horaE = horaE;
    }

    public int getHoraS() {
        return horaS;
    }

    public void setHoraS(int horaS) {
        this.horaS = horaS;
    }
    
    
    
}
