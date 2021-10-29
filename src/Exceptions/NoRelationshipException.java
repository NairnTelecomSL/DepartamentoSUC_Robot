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
public class NoRelationshipException extends Exception{
    public NoRelationshipException(){
        super("No existe relacion entre registros");
    }    
}
