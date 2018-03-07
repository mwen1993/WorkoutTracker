/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billy
 */
public class Exercise{
    
    private String name;
    private String sets;
    
    
    public Exercise(String name, String sets){
        this.name = name;
        this.sets = sets;
    }
    
    public String toString(){
        return name + ":\n" + sets;
    }
    
    public String getName(){
        return name;
    } 
}
