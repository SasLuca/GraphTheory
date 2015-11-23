package com.luca.graphtheory.forms;

/**
 * Created by Sas on 11/23/2015.
 */

public class Notification
{

    protected   L_Sprite            card;

    protected   float               time;

    protected   float               timer;

    protected   boolean             goDown;

    protected   boolean             goUp = true;

    protected   boolean             onHold = false;

    protected   boolean             destroy = false;

    protected   int                 positionInStack;

    protected   boolean             positionInStackChanged;

    public Notification()
    {

    }

    public void render()
    {



    }

    public void inputEvents()
    {



    }

    public void goUp()
    {



    }

    public void goDown()
    {



    }

    public void setGoDown(boolean goDown)
    {

        this.goDown                 = goDown;

    }

    public void setGoUp(boolean goUp)
    {

        this.goUp                   = goUp;

    }

    public void setOnHold(boolean onHold)
    {

        this.onHold                 = onHold;

    }

    public void setPositionInStack(int newPositionInStack)
    {

        this.positionInStack        = newPositionInStack;

    }

    public void setPositionInStackChanged(boolean positionInStackChanged)
    {

        this.positionInStackChanged = positionInStackChanged;

    }

    public void setTimer(float newTimer)
    {

        timer                       = newTimer;

    }

    public void destroy()
    {

        destroy                     = true;

    }

    public float getTimer()         { return timer; }
    public boolean getGoDown()      { return goDown; }
    public boolean getGoUp()        { return goUp;   }
    public boolean getOnHold()      { return onHold; }
    public boolean getDestroy()     { return destroy; }
    public int getPositionInStack() { return positionInStack; }
    public boolean isPositionInStackChanged() { return positionInStackChanged; }

}
