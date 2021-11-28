/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataClass;

import Exceptions.FicherosException;
import Exceptions.NoFilesException;
import java.io.File;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class DataFile {
    private String fileName_W49;
    private String fileName_WActual;
    private final String DIRECTORY_FILES = "Files";
    private final String DIRECTORY_MANUAL = DIRECTORY_FILES + "//Manual";
    private final File DIRECTORY_ROBOTS_ROUTE = new File(DIRECTORY_FILES);
    private File [] files;
    
    
    /**
     * Reconoce el nombre de todas las rutas de todos los archivos contenidos en la carpeta Files.
     * @throws NoFilesException Excepcion que se lanza cuando no se introduce ningún robot.
     * @throws FicherosException Excepcion que se lanza cuando no se recnoce correctamente algún robot.
     */
    public DataFile() throws NoFilesException, FicherosException{
        this.files = DIRECTORY_ROBOTS_ROUTE.listFiles();
        
        if (this.files != null) {
            switch (this.files.length) {
                case 1:
                    throw new NoFilesException();
                case 2:
                    //Si solo hay un fichero, veremos cual falta y lo indicaremos
                    //Vemos si falta el 2021
                    if(this.files[1].getName().contains("W49"))            { throw new FicherosException("Introducza el fichero Robot_Tesa de este año 'Robot_Tesa_2020-2021_WXX.csv'. \n¡¡Importante!!, Debe incluir como nombre el texto '2020'");}
                    //Vemos si falta W49
                    else if(this.files[1].getName().contains("2020")) { throw new FicherosException("Introducza el fichero Robot_Tesa_2020 (''Robot_Tesa_W49.csv'')");}
                    break;
                case 3:
                    //Sino, es que están los dos
                    for (int i = 1; i < 3; i++) {
                        if(this.files[i].getName().contains("2020")) { this.fileName_WActual = this.files[i].getName();}
                        else                                         { this.fileName_W49 = this.files[i].getName();}
                    }
                    break;
                default:
                    throw new FicherosException("Se han detectado más de dos archivos Robot en la carpeta Files");
            }
        }
        
    }
           
    /**
     * Devuelve la ruta del robot 2020_W49
     * @return Devuelve la ruta del robot 2020_w49
     */
    public String getRobotW49Route(){
        return DIRECTORY_FILES + "//" + this.fileName_W49;
    }
    
           
    /**
     * Devuelve la ruta del robot 2021_Actual
     * @return Devuelve la ruta del robot 2020_w49
     */
    public String getRobotWActRoute(){
        return DIRECTORY_FILES + "//" + this.fileName_WActual;
    }
           
    /**
     * Devuelve la ruta del Manual de Sucs
     * @return Devuelve la ruta del Manual de Sucs
     */
    public String getManualRoute(){
        return DIRECTORY_MANUAL;
    }
        
}
