/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.potis.hashmap;

import com.potis.hashmap.Dictionary.Entry;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Potis
 */
public class App {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        HashMap<String,Integer> wordCounter = new HashMap(4);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        String fileName = scanner.next();
        File nameFile = new File(fileName);
        
        RootFinder fr = new RootFinder();
        File dir0= fr.findRoot();
        //String dirS0 = dir0.toString()+"\\Users";
        //dir0 = new File(dirS0);
        
        
            
            FindFile fileSearcher = new FindFile();
            File[] list1 = dir0.listFiles();
            String dir2S = dir0.toString()+"home";
            File dir2F = new File(dir2S);
            String projDir = System.getProperty("user.dir");
            File projDirF = new File(projDir);
            //System.out.println(projDirF);

            //Case: user entered the whole path of the file

            //Case of a Linux system
            if(fileName.startsWith("/")){
                if(fileName.endsWith(".txt")){
                    nameFile = new File(fileName);
                }
            //Case of a Windows system
            }else if(fileName.startsWith("C:")){
                if(fileName.endsWith(".txt")){
                    nameFile = new File(fileName);
                }
            //Case: user entered only the name.txt
            }else{
                nameFile = new File(fileSearcher.findFile(fileName,projDirF));
                if(nameFile.exists()){
                    //continue with the rest of the code 
                }else {
                    nameFile = new File(fileSearcher.findFile(fileName, dir2F));
                }
                if(nameFile.exists()){
                    //continue with the rest of the code 
                } else{
                    nameFile = new File(fileSearcher.findFile(fileName, dir0));
                }
                if(nameFile.exists()){
                    //continue with the rest of the code 
                }
            }
            if(nameFile.exists()){
                
            }
        
        
        
        FileInputStream fstream;
        try {
                fstream = new FileInputStream(nameFile.getAbsolutePath());
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            try {
                while((strLine = br.readLine()) != null){
                    String[] words = strLine.split(" ");
                    for(String word : words){
                        word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                        if( !word.equals("")){
                            if(wordCounter.contains(word)){
                                wordCounter.put(word, wordCounter.get(word)+1);
                            }else{
                                wordCounter.put(word, 1);
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                System.err.println("ERROR: Unable to read the file");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("ERROR: File doesn't exists");
        }    
            
        for(Entry<String,Integer > e: wordCounter) { 
            System.out.println("Word " + e.getKey() + " appeared " + e.getValue() + " times");
        }
        scanner.close();
    }
    
}

