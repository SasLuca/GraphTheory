package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/7/2015.
 */

import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameClass;
import com.luca.graphtheory.GameScreen;

import java.util.ArrayList;

public class DebugProcessor
{

    //This list contains all the logs. You can add logs using the addLog() method
    protected static      ArrayList<String>     log           = new ArrayList<String>();

    //This variable is used to remember the time up to one second in order to calculate the fps
    protected static      float                 time;

    //This variable remembers the last place where you clicked on the screen
    protected static      Vector2               lastClick     = new Vector2();

    //This variables are used to measure the fps. The fps var remembers the fps, the counter numbers all the frames drawn per second. logNum is the number of logs in the log list
    protected static      int                   counter;
    protected static      int                   fps           = 0;
    protected static      int                   logNum        = -1;

    public static void UPDATE_FPS()
    {

        //Each frame we ad 1 to the fps counter
        counter++;

        //We ad delta to time
        time                                                  += GameScreen.getDelta();

    }

    public static void UPDATE_INPUT(float x, float y)
    {

        lastClick.x                                           = x;
        lastClick.y                                           = y;

    }

    public static void CHECK_FPS()
    {

        //If time is equal or greater than one second, we reset the fps counter and the time variable, but before we set the fps to the value of the counter before we hit the 1 second mark
        if(time >= 1)
        {

            fps                                               = counter;

            counter                                           = 0;

            time                                              = 0;

        }

    }

    public static void addLog(String string)
    {

        log.                                                  add(string);

        logNum++;

    }

    public static void clearLOG()
    {

        log.                                                  clear();

    }

    public static int getFps()                                { return fps; }

    public static ArrayList<String> getLog()                  { return log; }

    public static Vector2 getLastClick()                      { return lastClick; }

    public static int getLogNum()                             { return logNum; }

    public static boolean isVsyncEnabled()                    { return GameClass.getVSync(); }

}
