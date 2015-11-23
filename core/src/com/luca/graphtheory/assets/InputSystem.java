package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/2/2015.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class InputSystem
{

//region Variables


    /*

        This booleans are used to tell whether you have clicked or are still pressing the button

    */
    protected static      boolean     click       = false;
    protected static      boolean     pressing    = false;

    protected static      Vector3     touch       = new Vector3();


//endregion

//region Methods


    public static void input(OrthographicCamera camera)
    {

        resetInput();
        getInput(camera);
        checkInput(camera);

    }

    private static void resetInput()
    {

        touch.x                                   = 0;
        touch.y                                   = 0;

    }

    public static void checkInput(OrthographicCamera camera)
    {

        if(Gdx.input.isTouched() && click)
        {

            pressing                              = true;

            DebugProcessor.                        UPDATE_INPUT(touch.x, touch.y);

        }

        if(Gdx.input.isTouched() && !click)
        {

            click                                 = true;

            DebugProcessor.                        UPDATE_INPUT(touch.x, touch.y);


        }

        if(!Gdx.input.isTouched())
        {

            pressing                              = false;
            click                                 = false;

        }

    }

    public static void getInput(OrthographicCamera camera)
    {

        if(Gdx.input.isTouched())
        {

            touch.                                set(Gdx.input.getX(), Gdx.input.getY(), 0);

            camera.                               unproject(touch);

        }

    }


//endregion

//region Getters and Setters


    public static boolean isClicked()
    {

        return                                    click;

    }

    public static boolean isPressed()
    {

        return                                    pressing;

    }

    public static Vector2 getPosition()
    {

        return                                    new Vector2(touch.x, touch.y);

    }

    public static float getX()
    {

        return                                    touch.x;
        
    }

    public static float getY()
    {

        return                                    touch.y;

    }


//endregion

}
