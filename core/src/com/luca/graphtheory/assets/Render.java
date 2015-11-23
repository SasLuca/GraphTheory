package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/1/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;
import com.luca.graphtheory.scenes.DebugGraph;
import com.luca.graphtheory.scenes.IntroScene;
import com.luca.graphtheory.scenes.MainScene;
import com.luca.graphtheory.scenes.NotificationManager;

public class Render
{

    /*

        In this class we handle what happens each frame
        The class also contains a few helpful methods

    */

    //Here we declare variables like the Scenes
    private     static      DebugGraph              debug                   = new DebugGraph();
    private     static      MainScene               scene                   = new MainScene();
    private     static      IntroScene              intro                   = new IntroScene();
    private     static      NotificationManager     notificationManager     = new NotificationManager();

    //region Useful methods
    //This method will render a sprite to the position indicated by a vector2 (holds x and y components) at a transparency a
    public static void draw(Sprite spr, Vector2 vec2, float a)
    {

        //Set location
        spr.                                                                setBounds(vec2.x, vec2.y, spr.getWidth(), spr.getHeight());

        //Set transparency
        spr.                                                                setAlpha(a);

        //Draw
        spr.                                                                draw(GameScreen.getBatch());

    }

    //This method will render a sprite to the position indicated by a vector2 (holds x and y components) at a color c
    public static void draw(Sprite spr, Vector2 vec2, float a, Color c)
    {

        //Set color
        spr.                                                                setColor(c);

        //Set location
        spr.                                                                setBounds(vec2.x, vec2.y, spr.getWidth(), spr.getHeight());

        //Set transparency
        spr.                                                                setAlpha(a);

        //Draw
        spr.                                                                draw(GameScreen.getBatch());

    }

    //This method will return a color based on floats
    //If you were to use a color picker to choose a color you will see that the r, g, b and a components all have a value from 0 to 255, but if you were to set a new Color(r, g, b, a)
    //it will ask for values between 0.0 and 1.0
    //This method allows you to create a new color using the float range 0 to 255 just like in an online color picker without having to calculate every value
    public static Color colorFromFloats(float r, float g, float b, float a)
    {

        return                                                              new Color((r/255), (g/255), (b/255), a);

    }

    public static boolean compareVectors(Vector2 a, Vector2 b)
    {

        if(a.x > b.x && a.y > b.y)
        {

            return                                                          true;

        } else return                                                       false;

    }
    //endregion

    //Everything that happens in a frame is coded in here
    public static void render()
    {

        if(intro.getRun())                                                  intro.anim();

        if(scene.getRun())                                                  scene.anim();

        if(notificationManager.getRun())                                    notificationManager.anim();

        //debug is by default not running, in order to make it run type in a load method (debug.setRun(true))
        if(debug.getRun())                                                  debug.anim();

    }

    //region Getters and Setters
    public static Scene getGraph()                                          { return debug; }
    public static Scene getScene()                                          { return scene; }
    public static Scene getIntro()                                          { return intro; }
    public static Scene getNotificationManager()                            { return notificationManager; }
    //endregion

}

