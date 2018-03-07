/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billy
 */
import java.util.ArrayList;

public class Workout implements Comparable<Workout>{
    
    private MyDate date;
    private String description;
    private ArrayList<Exercise> workout = new ArrayList<>();
    
    public Workout(MyDate date){
        this.date = date;
        description = "A Great Workout!";
    }
    
    public void setDate(MyDate date){
        this.date = date;
    }
    public void addExercise(Exercise exercise){
        workout.add(exercise);
    }
    
    public MyDate getDateAsObject(){
        return date;
    }
    
    public String getDateAsString(){
        return date.toString();
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String toString(){
        String str = date.toString() + "\n" + description + "\n";
        
        for(Exercise e: workout){
            str += e.toString() + "\n";
        }
        
        return str;
    }

    public int compareTo(Workout workout) {
        return this.date.compareTo(workout.getDateAsObject());
    }    
}
