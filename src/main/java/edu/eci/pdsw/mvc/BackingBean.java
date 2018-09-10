package edu.eci.pdsw.mvc;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped
@Singleton
public class BackingBean {
    private static int numRandom = (int)(Math.random() * 100) + 1;
    private static int inputUser;
    private static int intentos = 0;
    private static int premioAcum = 100000;
    private static String estado = "En Juego";
    private static boolean win = false;
    
    public BackingBean(){
        
    }
    
    public void guess(){
        intentos++;
        String a = "numero: " + Integer.toString(inputUser)+ " numero de comparacion: "+ Integer.toString(numRandom);
        System.out.println(a);
        if (win) {
            restart();
        } else if (inputUser == numRandom) {
            estado = "Ganó. Premio: " + premioAcum;  
            win = true;
        } else if (inputUser != numRandom) { 
            premioAcum -= 10000;
            if (estado.equals("No Ganó")) {
                restart();
            }else if(premioAcum == 0){
                estado = "No Ganó";               
            }
        }
    }
    
    public void restart(){
        numRandom = (int)(Math.random() * 100) + 1;  
        intentos = 0;
        premioAcum = 100000;
        estado = "En Juego";
    } 
    

    public int getNumRandom() {
        return numRandom;
    }

    public void setNumRandom(int numRandom) {
        BackingBean.numRandom = numRandom;
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
    
    public int getInputUser(){
        return inputUser;
    }
    
    public void setInputUser(int input){
        this.inputUser = input;
    }
}
