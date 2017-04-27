package edu.ma.wa.nqueue.capstoneapp;
import java.util.HashMap;
/**
 * Created by drewh on 4/27/2017.
 */

public class Exercises {

    public static HashMap list;

    public Exercises(){
        list = new HashMap();
        String[] str = new String[2];
        str[1] = "Squats are done by sitting back in a chair with the knees at a 90 degree angle.";
        str[2] = "https//www.google.com";
        list.put(str,1);
        str[1] = "Push ups are done by starting with hands on the ground. Lower the body until the arms are at a 90 degree angle. Extend arms.";
        str[2] = "https//www.google.com";
        list.put(str,2);
        str[1] = "Do the workout.";
        str[2] = "https//www.google.com";
        list.put(str,3);
    }

    public String[] getExercise(int i){
        return (String[])list.get(i);
    }
}
