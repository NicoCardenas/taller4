package edu.eci.pdsw.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
//@ApplicationScoped
@SessionScoped
public class BackingBean {
    private int numRandom = (int)(Math.random() * 100) + 1;
    private int inputUser;
    private int intentos = 0;
    private int premioAcum = 100000;
    private String estado = "En Juego";
    private boolean win = false;
    private List<Integer> attents = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
    
    public BackingBean(){
        
    }
    
    public void guess(){
        boolean temp;
        intentos++;

        System.out.println("numero: " + Integer.toString(inputUser)+ " numero de comparacion: "+ Integer.toString(numRandom));
        
        temp = inputUser == numRandom;
        
        //attents.add(inputUser);
        if (intentos < 11) {
            attents.set(intentos-1, inputUser);
        }     
        inputUser = 0;
        if (win) {
            restart();
        } else if (temp) {
            estado = "Ganó. Premio: " + premioAcum;          
            win = true;
        } else if (!temp) {         
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
        attents = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
        win = false;
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
    
    public int getInputUser(){
        return inputUser;
    }
    
    public void setInputUser(int input){
        this.inputUser = input;
    }
    
    public String getAttents(){
        String temp = "[";
        for (int attent : attents) {
            temp += (" " + Integer.toString(attent));
        }
        return temp + " ]";
    }
    
    public String getAttent(int position) {
        return Integer.toString(attents.get(position));
    }
}