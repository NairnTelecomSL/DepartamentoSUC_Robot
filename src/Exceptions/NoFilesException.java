/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Usuario
 */
public class NoFilesException extends Exception{
    public NoFilesException(){
        super("No se ha encontrado ningún fichero. Recuerda poner los siguientes nombres a los fichero:"
                + "\n -'actual.csv'  en el robot 2021."
                + "\n -'Robot_Tesa_W49.csv'  en el robot 2020'");
    }    
}
