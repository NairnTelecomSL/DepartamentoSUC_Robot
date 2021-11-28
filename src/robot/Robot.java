/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import ClassApplication.CalendarUse;
import ClassApplication.FilesReader;
import DataClass.Centrales;
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
        ArrayList<Centrales> centrales = FilesReader.readTesaMigaXLSX();
        
        for (int i = 0; i < centrales.size() ; i++) {
            System.out.println(centrales.get(i).toString());
        }
        

    }
    
}
