package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/2/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;

public class L_Object
{

    /*

        L_Object is a base class for object like L_Sprite or L_Label
        A L_Object simply holds the position, height, width and values of an object plus useful methods

    */

    //Hold the position of the object
    //Protected means it behaves like a public variable to any class that extends this class but to any class which does not extend this class it behaves like a private variable
    protected     Vector2     position       = new Vector2(0, GameScreen.getCameraHeight()/2);

    protected     Color       color          = Color.WHITE;

    protected     Vector2     lastTouch      = new Vector2(0,0);

    //Holds the width and height of the object
    //They are private since we do not need to change their values, their values are changed when updating other objects thus there is no reason to have them public
    protected     float       height         = 0;
    protected     float       width          = 0;

    protected     boolean     clicked        = false;
    protected     boolean     pressed        = false;
    protected     boolean     released       = false;

    protected     boolean     clickable      = true;
    protected     boolean     draggable      = false;

    public enum DrawMethod
    {

        TOP_TO_BOTTOM, BOTTOM_TO_TOP, CENTER_TO_POSITION;

    }

    public L_Object()
    {



    }

    //This method dictates how the object will appear on screen and is to overridden by any class extending L_Object, unless the object is invisible
    public void render()
    {



    }

    //This method renders the object based on a different draw method
    //Instead of overriding this method you simply override the methods of the specific drawing styles
    public void render(DrawMethod drawMethod)
    {

        switch(drawMethod)
        {

            case TOP_TO_BOTTOM:

                topToBottomRendering();

                break;

            case BOTTOM_TO_TOP:

                render();

                break;

            case CENTER_TO_POSITION:

                centerToPositionRendering();

                break;

        }

    }

    protected void topToBottomRendering()
    {



    }

    protected void centerToPositionRendering()
    {



    }

    //This method check whether the object has been clicked once and updates it's clicked variable accordingly
    //Do not override this unless the object is a special case
    public boolean isClicked()
    {

        return                               clicked;

    }

    //This method check whether the object is being pressedSprite
    //Do not override this unless the object is a special case
    public boolean isPressed()
    {

        return                               pressed;

    }

    public boolean isReleased()
    {

        return                               released;

    }

    public void drag()
    {

        if(!InputSystem.isClicked())         draggable = false;

        if(InputSystem.isPressed() && draggable)
        {

            if(lastTouch.x != InputSystem.getX() || lastTouch.y != InputSystem.getY())
            {

                setPosition(getX() + (InputSystem.getX() - lastTouch.x), getY() + (InputSystem.getY() - lastTouch.y));

                lastTouch                    = InputSystem.getPosition();

            }

        }

        if(isClicked())
        {

            lastTouch                        = InputSystem.getPosition();

            draggable                        = true;

        }

    }

    public void updateInput()
    {

        released                             = false;

        //An object is rendered bottom to top, so if we do hold(press continuously on the object, checked by InputSystem.isPressed()) and the x and y position of the point we
        //touched are smaller then the x and y position from which the object is rendered + it's size, but bigger then the point of origin from which the object is being rendered
        //it means we are pressing continuously on the object
        if(InputSystem.isClicked() && InputSystem.isPressed() && InputSystem.getX() < (position.x + width) && InputSystem.getX() > position.x && InputSystem.getY() < (position.y + height) && InputSystem.getY() > position.y)
        {

            pressed                          = true;

        }
        else
        {

            if(clicked || pressed) released  = true;

            clicked                          = false;

            pressed                          = false;

        }

        //An object is rendered bottom to top, so if we do not hold(press continuously on the object, checked by InputSystem.isPressed()) and the x and y position of the point we
        //touched are smaller then the x and y position from which the object is rendered + it's size, but bigger then the point of origin from which the object is being rendered
        //it means we had clicked once on the object
        if(!InputSystem.isPressed() && InputSystem.getX() < (position.x + width) && InputSystem.getX() > position.x && InputSystem.getY() < (position.y + height) && InputSystem.getY() > position.y)
        {

            clicked                          = true;

        }

    }

    public void updateInput(DrawMethod drawMethod)
    {

        switch(drawMethod)
        {

            case BOTTOM_TO_TOP:
                //An object is rendered bottom to top, so if we do hold(press continuously on the object, checked by InputSystem.isPressed()) and the x and y position of the point we
                //touched are smaller then the x and y position from which the object is rendered + it's size, but bigger then the point of origin from which the object is being rendered
                //it means we are pressing continuously on the object

                released                     = false;

                if(InputSystem.isClicked() && InputSystem.isPressed() && InputSystem.getX() < (position.x + width) && InputSystem.getX() > position.x && InputSystem.getY() < (position.y + height) && InputSystem.getY() > position.y)
                {

                    pressed                  = true;

                }
                else
                {

                    clicked                  = false;

                    pressed                  = false;

                    released                 = true;

                }

                //An object is rendered bottom to top, so if we do not hold(press continuously on the object, checked by InputSystem.isPressed()) and the x and y position of the point we
                //touched are smaller then the x and y position from which the object is rendered + it's size, but bigger then the point of origin from which the object is being rendered
                //it means we had clicked once on the object
                if(!InputSystem.isPressed() && InputSystem.getX() < (position.x + width) && InputSystem.getX() > position.x && InputSystem.getY() < (position.y + height) && InputSystem.getY() > position.y)
                {

                    clicked                  = true;

                }

                break;

            case TOP_TO_BOTTOM:

                released                     = false;

                //This means it the object will be rendered at position(x, y - height)
                if(InputSystem.isClicked() && InputSystem.isPressed() && InputSystem.getX() < (position.x + width) && InputSystem.getX() > position.x && InputSystem.getY() < (position.y) && InputSystem.getY() > position.y - height)
                {

                    pressed                  = true;

                }
                else
                {

                    clicked                  = false;

                    pressed                  = false;

                    released                 = true;

                }

                if(!InputSystem.isPressed() && InputSystem.getX() < (position.x + width) && InputSystem.getX() > position.x && InputSystem.getY() < (position.y) && InputSystem.getY() > position.y - height)
                {

                    clicked                  = true;

                }

                break;

            case CENTER_TO_POSITION:

                released                     = false;

                //This means it the object will be rendered at position(x - width/2, y - height/2)
                if(InputSystem.isClicked() && InputSystem.isPressed() && InputSystem.getX() < (position.x + width/2) && InputSystem.getX() > (position.x - width/2) && InputSystem.getY() < (position.y + height/2) && InputSystem.getY() > position.y - height/2)
                {

                    pressed                  = true;

                }
                else
                {

                    clicked                  = false;

                    pressed                  = false;

                    released                 = true;

                }

                if(!InputSystem.isPressed() && InputSystem.getX() < (position.x + width) && InputSystem.getX() > position.x && InputSystem.getY() < (position.y) && InputSystem.getY() > position.y - height)
                {

                    clicked                  = true;

                }

                break;

        }

    }

    protected float iaTime                   = 0;
    protected boolean iaRun                  = false;
    public boolean getIaRun()                { return iaRun; }
    public void increaseAnim(float targetSize, float speed, float time)
    {

        if (getHeight() < targetSize)
        {

            iaRun                            = true;

            iaTime                           += GameScreen.getDelta();

            if(iaTime >= time)
            {

                iaTime                       = 0;

                setSize(getWidth() + speed, getHeight() + speed);

            }

        }
        else
        {

            iaRun                            = false;

        }

    }

    protected float glTime                   = 0;
    protected boolean glRun                  = false;
    public boolean getGlRun()                { return glRun; }
    public void goLeftAnim(float targetX, float speed, float time)
    {

        if (getX() < targetX)
        {

            glRun                            = true;

            glTime                           += GameScreen.getDelta();

            if(glTime >= time)
            {

                glTime                       = 0;

                setX(getX() + speed);

            }

        }
        else
        {

            glRun                            = false;

        }

    }

    protected float grTime                   = 0;
    protected boolean grRun                  = false;
    public boolean getGrRun()                { return grRun; }
    public void goRightAnim(float targetX, float speed, float time)
    {

        if (getX() > targetX)
        {

            grRun                            = true;

            grTime                           += GameScreen.getDelta();

            if(grTime >= time)
            {

                grTime                       = 0;

                setX(getX() - speed);

            }

        }
        else
        {

            grRun                            = false;

        }

    }

    protected float guTime                   = 0;
    protected boolean guRun                  = false;
    public boolean getGuRun()                { return guRun; }
    public void goUpAnim(float targetY, float speed, float time)
    {

        if (getY() < targetY)
        {

            guRun                            = true;

            guTime                           += GameScreen.getDelta();

            if(guTime >= time)
            {

                guTime                       = 0;

                setY(getY() + speed);

            }

        }
        else
        {

            guRun                            = false;

        }

    }

    protected float gdTime                   = 0;
    protected boolean gdRun                  = false;
    public boolean getGdRun()                { return gdRun; }
    public void goDownAnim(float targetY, float speed, float time)
    {

        if (getY() > targetY)
        {

            gdRun                            = true;

            gdTime                           += GameScreen.getDelta();

            if(gdTime >= time)
            {

                gdTime                       = 0;

                setY(getY() - speed);

            }

        }
        else
        {

            gdRun                            = false;

        }

    }

    public void setPosition(Vector2 newPosition)
    {

        position.x                           = newPosition.x;
        position.y                           = newPosition.y;

    }

    public void setPosition(float newX, float newY)
    {

        position.x                           = newX;
        position.y                           = newY;

    }

    public void setX(float newX)
    {

        position.x                           = newX;

    }

    public void setY(float newY)
    {

        position.y                           = newY;

    }

    public void setTransparency(float alpha)
    {

        color.a                              = alpha;

    }

    public void setColor(Color newColor)
    {

        color                                = newColor;

    }

    public void setClickable(boolean clickable)
    {

        this.clickable                       = clickable;

    }

    public void setSize(float newWidth, float newHeight)
    {



    }

    public Color getColor()                  { return color; }

    public float getWidth()                  { return width; }

    public float getHeight()                 { return height; }

    public Vector2 getPosition()             { return position; }

    public boolean getClickable()            { return clickable; }

    public float getY()                      { return position.y; }

    public float getX()                      { return position.x; }

    public boolean getDraggable()            { return draggable; }

}
