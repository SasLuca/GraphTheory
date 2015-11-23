package com.luca.graphtheory;

/**
 * Created by Sas on 11/1/2015.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.luca.graphtheory.assets.DebugProcessor;
import com.luca.graphtheory.assets.InputSystem;
import com.luca.graphtheory.assets.Render;

public class GameScreen implements Screen
{

    /*

        In this file you will have the OrthographicCamera, SpriteBatch and the main loop
        Those objects are static but the class does have a constructor since it implements Screen and it's instance is required in GameClass.java

    */

    protected                GameClass               game;

    protected static         OrthographicCamera      camera;

    protected static         SpriteBatch             batch;

    protected static         float                   delta;
    protected static         float                   cameraWidth;
    protected static         float                   cameraHeight;

    protected static         Orientation             orientation;

    public enum Orientation
    {

        PORTRAIT, LANDSCAPE

    }

    public GameScreen(GameClass game)
    {

        //In the constructor we simply initialize the values

        this.game                                    = game;

        camera                                       = new OrthographicCamera();

        batch                                        = new SpriteBatch();

        //The camera object is the resolution you will work with. Usually I choose full hd(1080x1920 or 1920x1080 depending on the orientation)
        //If you work with a lot of textures that you consider would scale without much pixelation even from hd(720x1280) then choose that as you will save computer power and memory
        //Also if you work with really small textures (16 bit textures for example) go on google and find a good resolution
        //The camera will scale your game from your resolution to any screen, thus your 1080p game will work any screen because it will be scaled by libGDX

        if(game.getRealWidth() < game.getRealHeight())
        {

            orientation                              = Orientation.PORTRAIT;
            camera.                                  setToOrtho(false, 720, 1280);

        }
        else
        {

            orientation                              = Orientation.LANDSCAPE;
            camera.                                  setToOrtho(false, 1280, 720);

        }

        cameraWidth                                  = game.getRealWidth();
        cameraHeight                                 = game.getRealHeight();

        Render.getIntro().                           setRun(true);

    }

    @Override
    public void render(float delta)
    {

        //delta represents the time (in milliseconds) it took the computer to render the last frame and get to this one
        //delta is very important when working with animations therefore we will store it inside a static variable delta
        GameScreen.delta                             = delta;

        DebugProcessor.                              UPDATE_FPS();

        camera.                                      update();

        //This method clears the screen in just one color
        Gdx.gl.                                      glClearColor(1F, 1F, 1F, 1F);

        //This method clears the buffer bit.
        //If you do not clear it then all the elements that change position, color, etc in this new frame will just overlapped to the previous frame
        Gdx.gl.                                      glClear(GL20.GL_COLOR_BUFFER_BIT);

        //The InputSystem requires that we pass it the camera each frame
        InputSystem.                                 input(GameScreen.camera);

        //This method scales our game from the resolution of the camera to the resolution of our screen
        batch.                                       setProjectionMatrix(camera.combined);

        //Here the main loop starts
        batch.                                       begin();

        //Everything that happens in a frame is basically done in the Render class's render() method
        Render.                                      render();

        //Here the main loop ends
        batch.                                       end();

        DebugProcessor.                              CHECK_FPS();

    }

    //This method is called when our app closes, if you need to write an event that happens at the end of the program call it from here
    @Override
    public void dispose()
    {

        Gdx.app.                                     exit();

    }

    @Override
    public void show()                               { }

    @Override
    public void hide()                               { }

    @Override
    public void pause()                              { }

    @Override
    public void resume()                             { }

    @Override
    public void resize(int width, int height)        { }

    public static float getDelta()                   { return delta; }

    public static SpriteBatch getBatch()             { return batch; }

    public static OrthographicCamera camera()        { return camera; }

    public static float getCameraWidth()             { return cameraWidth; }

    public static Orientation getOrientation()       { return orientation; }

    public static float getCameraHeight()            { return cameraHeight; }

}

