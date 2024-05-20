/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.potis.hashmap;

// Oracle Libraries
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Potis
 */
public class FindFile {
        
    public FindFile() {
    }
    int i = 1;
    int j = 0;
    
    File f = null;
    
    //Method that finds and returns the complete path of a file(1st argument) 
    public String findFile(String name,File file) throws IOException, InterruptedException {
        
        //Array that stores the subdirectories and files of the the "file" directorie
        File[] list = file.listFiles();
        
        
        //Empty list Check
        if(list!=null){
            
            int counter = 0;
            //loop to run the contents of the "name" directory
            while(counter < list.length){
                
                f = list[counter];
                //Check if the element is directory or not
                if(f.isDirectory()){
                    findFile(name,f);
                    //System.out.println(f);
                    j++;
                //Check if the element is a file or not
                }else if(f.isFile()){
                    //System.out.println(f);
                    //Checks if the file is the the one the user wants or not 
                    if(name.equals(f.getName())){
                        i = 0;
                        return f.getParent() + "//" + name;
                    }
                }
                counter++;
                if(i == 0){
                    break;
                }
            }
        }
    return f.getParent() + "//" + name;
    }
   
}