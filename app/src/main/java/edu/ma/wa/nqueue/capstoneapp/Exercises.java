package edu.ma.wa.nqueue.capstoneapp;
import java.util.HashMap;
/**
 * Created by drewh on 4/27/2017.
 */

public class Exercises {

    public Exercise[] list;

    public Exercises(){
        list = new Exercise[2];
        Exercise ex = new Exercise("Squats are done by sitting back in a chair with the knees at a 90 degree angle.","https//www.google.com");
        list[0]=ex;
        ex = new Exercise("Push ups are done by starting with hands on the ground. Lower the body until the arms are at a 90 degree angle. Extend arms.","https//www.google.com");
        list[1]=ex;
        ex = new Exercise("Do the workout.","https//www.google.com");
        list[2]=ex;}

    public Exercise getExercise(int i){
        return list[i];}

    public class Exercise{
        private String instruction;
        private String vidLink;

        public Exercise(String i,String v){
            instruction = i;
            vidLink = v;}

        public String getIntruction(){
            return instruction;}

        public String getLink(){
            return vidLink;}
    }
}
