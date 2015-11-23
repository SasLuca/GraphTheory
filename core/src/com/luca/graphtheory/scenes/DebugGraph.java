package com.luca.graphtheory.scenes;

/**
 * Created by Sas on 11/7/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;
import com.luca.graphtheory.assets.*;
import com.luca.graphtheory.forms.L_Label;

public class DebugGraph extends Scene
{

    /*

        Notice that there is no need for a constructor, we get one for free when we extend Scene

    */

    private     L_Label         data;

    private     Vector2         position;

    private     Color           color;

    @Override
    protected void load()
    {

        color                   = Color.DARK_GRAY;

        position                = new Vector2(GameScreen.getCameraWidth(), 0);

        data                    = new L_Label(
                                                 "FPS: No available data"           +
                                                 "V-SYNC: "                         + DebugProcessor.isVsyncEnabled() + "\n" +
                                                 "INPUT STATUS: Not touching"       +
                                                 "INPUT X: No available data"       +
                                                 "INPUT Y: No available data"       +
                                                 "log: No available data",
                                                 "DEBUG_FONT", color, 1f, position
        );

        position.x              = 847;

        position.y              = 20;

        data.                   setPosition(position);

    }

    @Override
    protected void render()
    {

        data.                   render();

    }

    @Override
    protected void update()
    {

        data.setText(
                        "FPS: "             + DebugProcessor.getFps()                                               + "\n" +
                        "V-SYNC: "          + DebugProcessor.isVsyncEnabled()                                       + "\n" +
                        "INPUT STATUS: "    + (!InputSystem.isPressed() ? ("Not touching") : ("Pressing"))          + "\n" +
                        "INPUT X: "         + (int) DebugProcessor.getLastClick().x                                 + "\n" +
                        "INPUT Y: "         + (int) DebugProcessor.getLastClick().y                                 + "\n" +
                        "log: "             + (DebugProcessor.getLogNum() != -1 ? (DebugProcessor.getLog().get((DebugProcessor.getLogNum()))) : "No available data")
        );

    }

}
