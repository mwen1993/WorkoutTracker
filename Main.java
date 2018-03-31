1
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billy
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
    private static final List<Workout> workoutList = new ArrayList<>(); ;

    public static void main(String[] args){
        System.out.println("Welcome to Your Workout Tracker!");
        System.out.println("--------------------------------------------------");
        prompt();
    }
    
    // function to display main option and prompt for user interaction
    private static void prompt(){
        //initiator
        System.out.println("1. ADD a Workout (given date, and workout)");
        System.out.println("2. REMOVE a Workout (specify a date to remove)");
        System.out.println("3. LOOKUP a Workout (by date, month, or year)");
        System.out.println("4. EDIT a Workout (edit a previous workout)");
        System.out.println();
        
        promptLoop();
        System.out.println();
    }
    
 
    private static void promptLoop(){
        
        int input = promptUserInt("Please enter a number corresponding an option (1-4):");
        
        switch(input){
            case 1:
                addWorkout();
                break;
                
            case 2:
                removeWorkout();
                break;
                
            case 3:
                lookupWorkout();
                break;
                
            case 4:
                editWorkout();
                break;
                
            default:
                System.out.println("Invalid option, Please enter a number corresponding to an option");
                promptLoop();
                break;
        }
    }
    
    //to ADD a workout
    private static void addWorkout(){
        
        int day, month, year;
        String strDate;
        Workout workout;
        MyDate date;
        
        //prompt user to enter correct formatted date
        strDate = promptUserForDate();
        
        //save string date into int variables
        String[] integerDate = strDate.split("/");
        month = Integer.parseInt(integerDate[0]);
        day = Integer.parseInt(integerDate[1]);
        year = Integer.parseInt(integerDate[2]);
        
        //instantiate date
        date = new MyDate(month, day, year);
        //instantiate workout with date
        workout = new Workout(date);
        
        //prompt user to add optional description
        promptUserForDescription(workout);
        
        //prompt user to add exercises
        promptUserForExercises(workout);
        System.out.println(workout);
        
        //save new workout in a new text file
        save(workout);
    }
    
    private static void removeWorkout(){
        //TODO remove a workout
    }
    
    private static void lookupWorkout(){
        //TODO display workouts in selected range
    }
    
    private static void editWorkout(){
        //TODO edit a workout
    }
    
    //helper function to choose exercise, used by addWorkout
    private static Exercise chooseExercise(){
        Scanner scan = new Scanner(System.in);
        String name; 
        String sets = "";
        int intExercise, setCounter, weight, reps;
        
        displayExercises();//display exercises
        //prompt user to choose exercise
        while(true){
          
            intExercise = promptUserInt("Please Enter the number correspond to the Exercise");
            
            if(intExercise >= 1 && intExercise <= WorkoutList.workoutList.length){
                name = WorkoutList.workoutList[intExercise - 1];
                System.out.println(name);
                break;
            }
        }
        
        //prompt user to get number of sets
        setCounter = promptUserInt("How many sets Did you perform?");
        
        //prompt user to add weight and reps per set
        for(int i = 1; i <= setCounter; i++){
            System.out.println("For set " + i + ", how much weight did you do?(Lbs)");
            weight = promptUserInt("Please enter a number weight");
            System.out.println("How many reps?");
            reps = promptUserInt("Please enter a number reps");
            sets += "\tSet " + i + ", " + weight + "Lbs for " + reps + " reps. \n";
        }
        //construct new exercise object
        Exercise exercise = new Exercise(name, sets);
        
        return exercise;
    }
    
    //loops through a list of all workouts and display for user to choose from
    private static void displayExercises(){
        for(int i = 0; i < WorkoutList.workoutList.length; i++){
            if(i % 3 == 0 && i != 0)
                System.out.println();
            String currentNumber = i+1 + ".";
            String currentWorkout = WorkoutList.workoutList[i];
            System.out.printf("%-4s%-40s", currentNumber, currentWorkout);            
        }
        System.out.println();
        System.out.println();
    }
    
    //use to save workout into a text file
    private static void save(Workout workout){
        String fileName;
        fileName = workout.getDateAsString().replaceAll("/", "_");
        
        try{
            File file = new File(fileName + ".txt");
            //BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            FileWriter writer = new FileWriter(file);
            writer.write(workout.toString());
            writer.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Oops, file was not saved.   ");
        }
        System.out.println("Workout Saved!");
    }
    
    // prompt user to enter an integer
    private static int promptUserInt(String message){
        
        Scanner scan = new Scanner(System.in); 
        
        System.out.print(message);
        
        while(!scan.hasNextInt()){
            System.out.print(message);
            scan.next();
        }
        int userInt = scan.nextInt();
        
        return userInt;
    }
    
    //prompt user to enter the date, must be in correct format
    private static String promptUserForDate() {
        
        Scanner scan = new Scanner(System.in);
        String strDate;
        
         while(true){
            do{
                System.out.println("Please enter today's date (mm/dd/yyyy)");
                strDate = scan.next();
            }while(!strDate.matches("(([0][1-9])|([1][0-2]))/(([0-2][0-9])|([3][0|1]))/([0-9]{4})"));

            System.out.print("Date is " + strDate + ", confirm? (y/n)");
            
            if(scan.next().matches("[y|Y]"))
                break;
        }
         
        return strDate;
    }
    
    // prompt user to enter a description for workout, then sets description for workout
    private static void promptUserForDescription(Workout workout) {
        
        Scanner scan = new Scanner(System.in);
        String description;
        
        while(true){
            System.out.println("would you like to add a short description on the workout? (i.e. \"chest day\") [y/n]");
            if(scan.next().matches("[y|Y]")){
                System.out.print("Please enter a description: ");
                scan.nextLine();//consume empty new line or else skip user input
                description = scan.nextLine();
                System.out.print("confirm description? [y/n]: ");
                if(scan.next().matches("[y|Y]")){
                    workout.setDescription(description);
                    break;
                }
                description = "A Great Workout!";//reset description
            }
            else
                break;
        }
        
 
    }
    
    // prompt user to enter exercises, then sets the exercises in the workout1
    private static void promptUserForExercises(Workout workout) {
        
        Scanner scan = new Scanner(System.in);
        
        while(true){
            Exercise exercise = chooseExercise();
            workout.addExercise(exercise);
            System.out.print("Would you like to add another exercise?: ");
            if(!scan.next().matches("[y|Y]"))
                break;
        }
    }
}
