package edu.ma.wa.nqueue.capstoneapp;
import java.util.HashMap;

import edu.ma.wa.nqueue.capstoneapp.Fragment.Exercise;

/**
 * Created by drewh on 4/27/2017.
 */

public class Exercises {

    private static ExerciseStep pushup = new ExerciseStep(new String[]{
            "Step 1: Lay on the ground stomach-down with hands shoulder width apart",
            "Step 2: Hold the body up with straight arms and toes on the ground",
            "Step 3: Slowly bend at the elbows to a 90° angle",
            "Step 4: Slowly straighten the arms, keeping a straight back",
    });
    private static ExerciseStep situp = new ExerciseStep(new String[]{
            "Step 1: Begin lying on the back with knees at a 90° angle, feet on ground",
            "Step 2: Cross arms on chest and engage the core",
            "Step 3: Use the core to lift the upper body to an upright position",
    });

    private static ExerciseStep burpee = new ExerciseStep(new String[]{
            "Step 1: From a standing position, reach the hands down to the ground",
            "Step 2: Kick the feet back so that you are in push up position",
            "Step 3: Do a push up",
            "Step 4: Pull the feet back towards the body",
            "Step 5: In one motion, jump straight up and extends the arms upward"
    });


    private static ExerciseStep squat = new ExerciseStep(new String[]{
            "Step 1: Sit back on the knees until they reach a 90° angle",
            "Step 2: Keep the knees in line with the feet, as well as keeping the chest up"
    });

    private static ExerciseStep plank = new ExerciseStep(new String[]{
            "Step 1: Lay on the ground stomach-down on the elbows",
            "Step 2: Keep a straight back, hold hands together but elbows shoulder width apart",
            "Step 3: Rest after a minute or a length of your choosing"
    });


    private static ExerciseStep vup = new ExerciseStep(new String[]{
            "Step 1: Lay on the ground stomach up, arms extends past the head",
            "Step 2: In one motion, use the core to throw arms and legs up so they reach",
            "Step 3: Slowly bring the arms and legs down"
    });


    private static ExerciseStep pullup = new ExerciseStep(new String[]{
            "Step 1: Grab the bar with hands roughly shoulder width apart",
            "Step 2: When grabbing the bar, have all fingers on your side of the bar",
            "Step 3: Starting from a dead hang, push chest up as you pull your body up",
            "Step 4: Once your chest reaches the bar, lower yourself  back to the dead hang"
    });

    private static ExerciseStep biceptcurl = new ExerciseStep(new String[]{
            "Step 1: Hold weight in hand down by your side",
            "Step 2: Pivot weight around the elbow until your hand reaches your shoulder",
            "Step 3: Lower weight down to resting position"
    });
    private static ExerciseStep deadlift = new ExerciseStep(new String[]{
            "Step 1: Position the bar above your feet, feet shoulder width apart",
            "Step 2: Squat down to grab the bar with straight arms keeping the chest up",
            "Step 3: In one exhale, extends the legs and push out the waist to engage the core",
            "Step 4: Lower the bar back to the ground"
    });
    private static ExerciseStep rows = new ExerciseStep(new String[]{
            "Step 1: Stand with a slight bend in the knees bending forward with a straight back",
            "Step 2: Holding the bar, pull it straight to your chest while engaging your back",
            "Step 3: Focus on exhaling as the bar comes up and inhaling as it goes down"
    });


    public static ExerciseStep[] tutList = new ExerciseStep[]{pushup, situp, burpee, squat, plank, vup, pullup, biceptcurl, deadlift, rows};
    public static String[] linkList = new String[]{
            "SzWwcOdeQJs", "aLwQ4HDXN2M", "WGkDsQ4DE38", "uo5koUNWuk4",
            "G0B-_UDIeFE", "V6Ix4wv_s8g", "W7rCsNaLsrc", "pRlSZYUWhw8",
            "lEbKk8ifnJw", "epiAd4OAl2I"
    };
}

