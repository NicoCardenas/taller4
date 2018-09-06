package edu.eci.pdsw.mvc;

import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class BackingBean {
    private int numRandom;
    private int intentos;
    private int premioAcum;
    private String estado;
    
    public BackingBean(){
        restart();       
    }
    
    public void guess(int numero){
        intentos++;
        if (numero == numRandom) {
            estado = "Ganó. Premio: " + premioAcum;
            restart();
        } else if (numero != numRandom) { 
            premioAcum -= 10000;           
            if(premioAcum==0){
                estado = "No Ganó";
                restart();
            }
        }

    }
    
     public void restart(){
        numRandom = (new Random().nextInt());       
        intentos = 0;
        premioAcum = 100000;
        estado = "En Juego";
    } 
    

    public int getNumRandom() {
        return numRandom;
    }

    public void setNumRandom(int numRandom) {
        this.numRandom = numRandom;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getPremioAcum() {
        return premioAcum;
    }

    public void setPremioAcum(int premioAcum) {
        this.premioAcum = premioAcum;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }       
}
