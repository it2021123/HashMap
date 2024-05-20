/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.potis.hashmap;

import java.io.File;

/**
 *
 * @author Potis
 */
public class RootFinder {

    public RootFinder() {
    }
    
    //Method that finds and returns the root file of the system
    public File findRoot(){
        
        File[] drives = File.listRoots();
            String temp = "";
            for (int i = 0; i < drives.length; i++) {
                temp += drives[i];
            }

            var dir = temp.split("////");
            
            File dir0 = new File(dir[0]);
            
        return dir0;
        
    } 
    
}