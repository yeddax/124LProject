/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author ranip
 */
public class NoteFunction {
    
    Notes notes;
    String fileName, fileAddress;
    FileDialog fd;
    
    public NoteFunction(Notes notes){
        this.notes = notes;
    }
    
    public void newNote(){
        notes.textArea.setText("");
        notes.window.setTitle("New Note");
        fileName = null;
        fileAddress = null;
            
    }
    
    public void saveNote(){
        if(fileName == null){
            saveAsNote();
        }
        else{
            try{
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(notes.textArea.getText());
                notes.window.setTitle(fileName);
                fw.close();
            }catch(Exception e){
                System.out.println("Error");
            }
        }
            
    }
    
     public void saveAsNote(){
        fd = new FileDialog(notes.window, "SaveAs", FileDialog.SAVE);
        fd.setVisible(true);
        
        try{
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(notes.textArea.getText());
            fw.close();
        }catch (Exception e){
            System.out.println("Error");
        }
        
        if (fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notes.window.setTitle(fileName);
        }
    }
    
    public void openNote(){
        fd = new FileDialog(notes.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            notes.textArea.setText(" ");
            
            String line = null;
                while((line = br.readLine()) != null){
                    notes.textArea.append(line + "/n" );
                }
                    br.close();
        }catch (Exception e){
            System.out.println("File note opened");
        }
        
            if (fd.getFile() != null) {
                fileName = fd.getFile();
                fileAddress = fd.getDirectory();
                notes.window.setTitle(fileName);
            }
    }
    
   
}