/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billy
 */
public class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;
    
    public MyDate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    public String toString(){
        String date = month + "/" + day + "/" + year;
        return date;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setDate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    @Override
    public int compareTo(MyDate otherDate){
        if(this.year < otherDate.getYear()){
            return -1;
        }
        else if(this.year > otherDate.getYear()){
            return 1;
        }
        else{ //year is equal, compare month
            if(this.month < otherDate.getMonth()){
                return -1;
            }
            else if(this.month > otherDate.getMonth()){
                return 1;
            }
            else{//month is also equal, check day
                if(this.day < otherDate.getDay()){
                    return -1;
                }
                else if(this.day > otherDate.getDay()){
                    return 1;
                }
            }
        }
        return 0;
    }
}
