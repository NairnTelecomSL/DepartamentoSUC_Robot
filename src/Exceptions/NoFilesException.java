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
        super("No se ha encontrado ningún fichero. Recuerda introducir en la carpeta File los siguientes fichero:"
                + "\n -'Robot_Tesa_2020-2021_WXX.csv'  como Robot_2021."
                + "\n -'Robot_Tesa_W49.csv'  como Robot_2020'");
    }    
}
