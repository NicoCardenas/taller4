package edu.eci.pdsw.mvc;


import java.util.List;
import java.util.ArrayList;
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
    private List<Integer> attents = new ArrayList<Integer>();
    
    public BackingBean(){
        
    }
    
    public void guess(){
        intentos++;
        String a = "numero: " + Integer.toString(inputUser)+ " numero de comparacion: "+ Integer.toString(numRandom);
        System.out.println(a);
        attents.add(inputUser);
        inputUser = 0;
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
        attents = new ArrayList<Integer>();
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
}