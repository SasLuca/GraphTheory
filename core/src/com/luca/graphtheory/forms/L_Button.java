package com.luca.graphtheory.forms;

/**
 * Created by Sas on 11/5/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;
import com.luca.graphtheory.assets.L_Object;

public class L_Button extends L_Object
{

    //The text will always be rendered in the center of the sprite. In order to put it a little more to the right set
    //leftPadding to a positive value and a negative one if you want it more to the left
    //Same goes for bottomPadding, positive value to have it go up and negative value to have it go down
    protected       float                           leftPadding;
    protected       float                           bottomPadding;


    protected       L_Sprite clickableSprite        = new L_Sprite("GenericBtn-Clickable.png");
    protected       L_Sprite pressedSprite          = new L_Sprite("GenericBtn-Pressed.png");

    protected       L_Label text                    = new L_Label("New L_Button", "DEBUG_FONT", Color.BLACK, 1, position);

    public L_Button(String clickable, String pressed, L_Label text, Color color, Vector2 position)
    {

        this.clickableSprite                        = new L_Sprite(clickable, color, position);
        this.pressedSprite                          = new L_Sprite(pressed, color, position);

        this.text                                   = text;

        width                                       = this.clickableSprite.getWidth();
        height                                      = this.clickableSprite.getHeight();

        //By default the text is centered in the middle of the button
        this.text.                                  setPosition(width / 2 - text.getWidth() / 2, height / 2 - text.getHeight() / 2);

        leftPadding                                 = width / 2 - text.getWidth() / 2;
        bottomPadding                               = height / 2 - text.getHeight() / 2;

        text.                                       setPosition(clickableSprite.getX() + leftPadding, clickableSprite.getY() + bottomPadding);

        setPosition(position);

    }

    public static L_Button GenericBtn(String text)
    {

        return                                      new L_Button("GenericBtn-Clickable.png", "GenericBtn-Pressed.png", new L_Label(text, "DEBUG_FONT", Color.BLACK, 0.8f, new Vector2(0, 0)), Color.WHITE, new Vector2(0, 0));

    }

    public L_Button()
    {



    }

    //region Methods
    @Override
    public void render()
    {

        if(super.clickable)
        {

            if(isClicked())
            {

                pressedSprite.render();

                text.                               render();

            }
            else
            {

                clickableSprite.render();

                text.                               render();

            }

        }
        else
        {

            clickableSprite.render();

            text.                                   render();

        }

    }

    @Override
    public void drag()
    {



    }
    //endregion

    //region Anims
    @Override
    public boolean getGlRun()                { return glRun; }
    @Override
    public void goLeftAnim(float targetX, float speed, float time)
    {

        glRun                           = true;

        pressedSprite.                  goDownAnim(targetX, speed, time);
        clickableSprite.                goDownAnim(targetX, speed, time);
        text.                           setPosition(clickableSprite.getX() + leftPadding, clickableSprite.getY() + bottomPadding);

        if(!pressedSprite.getGlRun() || !clickableSprite.getGlRun())
        {

            glRun                            = false;

        }

    }

    @Override
    public boolean getGrRun()                { return grRun; }
    @Override
    public void goRightAnim(float targetX, float speed, float time)
    {

        grRun                           = true;

        pressedSprite.                  goRightAnim(targetX, speed, time);
        clickableSprite.                goRightAnim(targetX, speed, time);
        text.                           setPosition(clickableSprite.getX() + leftPadding, clickableSprite.getY() + bottomPadding);

        if(!pressedSprite.getGrRun() || !clickableSprite.getGrRun())
        {

            grRun                            = false;

        }

    }

    @Override
    public boolean getGuRun()                { return guRun; }
    @Override
    public void goUpAnim(float targetY, float speed, float time)
    {

        guRun                                = true;

        pressedSprite.                       goUpAnim(targetY, speed, time);
        clickableSprite.                     goUpAnim(targetY, speed, time);
        text.                                setPosition(clickableSprite.getX() + leftPadding, clickableSprite.getY() + bottomPadding);

        if(!pressedSprite.getGuRun() && !clickableSprite.getGuRun())
        {

            guRun                            = false;

        }

    }

    @Override
    public boolean getGdRun()                { return gdRun; }
    @Override
    public void goDownAnim(float targetY, float speed, float time)
    {

        gdRun                           = true;

        pressedSprite.                  goDownAnim(targetY, speed, time);
        clickableSprite.                goDownAnim(targetY, speed, time);
        text.                           setPosition(clickableSprite.getX() + leftPadding, clickableSprite.getY() + bottomPadding);

        if(!pressedSprite.getGdRun() || !clickableSprite.getGdRun())
        {

            gdRun                            = false;

        }

    }

    @Override
    public void increaseAnim(float targetSize, float speed, float time)
    {

        System.out.println("Method increaseAnim not yet implemented in L_Button");

    }
    //endregion

    //region Getters and Setters
    public void setClickableSprite(L_Sprite newClickable)
    {

        clickableSprite                             = newClickable;

        width                                       = clickableSprite.getWidth();
        height                                      = clickableSprite.getHeight();

    }

    public L_Sprite getClickableSprite() { return clickableSprite; }

    public void setPressedSprite(L_Sprite newPressed)
    {

        pressedSprite                                       = newPressed;

    }

    public L_Sprite getPressedSprite() { return pressedSprite; }

    public void setText(String newText)
    {

        text.                                               setText(newText);

    }

    public void setFont(String newFont)
    {

        text.                                               setFont(newFont);

    }

    public void setTextColor(Color newTextColor)
    {

        text.                                               setColor(newTextColor);

    }

    public void setLeftPadding(float newLeftPadding)
    {

        leftPadding                                         = newLeftPadding;

    }

    public void setBottomPadding(float newBottomPadding)
    {

        bottomPadding                                       = newBottomPadding;

    }

    @Override
    public void setPosition(Vector2 newPosition)
    {

        position                                            = newPosition;

        clickableSprite.                                    setPosition(newPosition);
        pressedSprite.                                      setPosition(newPosition);

        text.                                               setPosition(clickableSprite.getX() + leftPadding, clickableSprite.getY() + bottomPadding);

    }

    @Override
    public void setPosition(float newX, float newY)
    {

        position.x                                          = newX;
        position.y                                          = newY;

        clickableSprite.                                    setPosition(newX, newY);
        pressedSprite.                                      setPosition(newX, newY);

        text.                                               setPosition(clickableSprite.getX() + leftPadding, clickableSprite.getY() + bottomPadding);

    }

    public void setSize(int newWidth, int newHeight)
    {

        clickableSprite.                                    setSize(newWidth, newHeight);
        pressedSprite.                                      setSize(newWidth, newHeight);

        width                                               = newWidth;
        height                                              = newHeight;

        //Resizing the button resets the text padding so that the text will be rendered in the center
        leftPadding                                         = width/2 - text.getWidth()/2;
        bottomPadding                                       = height/2 - text.getHeight()/2;

    }

    public void setTextSize(float newSize)
    {

        text.setSize(newSize);

        leftPadding                                         = width/2 - text.getWidth()/2;
        bottomPadding                                       = height/2 - text.getHeight()/2;

    }

    public float getTextSize()                               { return text.getSize(); }

    public void setTextFont(String newFontName)
    {

        text.                                                setFont(newFontName);

    }

    public String getTextFont()                              { return text.fontName;}
    //endregion

}
