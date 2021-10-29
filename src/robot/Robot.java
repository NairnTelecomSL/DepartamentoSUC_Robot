/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import ClassApplication.RegistroApplication;
import DataClass.Registro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Robot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> solve = new ArrayList<>() , copy;
        int index = 0;
        int i = 1;
        boolean repetidos = false;
        solve.add("1111-OCUPADO-1");
        solve.add("1111-OCUPADO-2");//
        solve.add("2222-OCUPADO-1");
        solve.add("1111-OCUPADO-4");//
        solve.add("2222-OCUPADO-1");//
        solve.add("2222-OCUPADO-1");//
        copy = new ArrayList<>(solve);
        
        
        while(index < solve.size()){
            String [] linea1 = solve.get(index).split("-");
            while(i < copy.size()/* && !repetidos*/){
                String [] linea2 = solve.get(i).split("-");
                if(linea1[0].equals(linea2[0]) && linea1[1].equals(linea2[1])){
                    //repetidos = true;
                    solve.remove(i);
                    //index = 0;
                    copy = new ArrayList<>(solve);
                }else i++;
                
            }
            index++;
            i = index + 1;
        }
        
    }
    
}
