package com.luca.graphtheory.forms;

/**
 * Created by Sas on 11/2/2015.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;
import com.luca.graphtheory.assets.L_Object;
import com.luca.graphtheory.assets.Render;

public class L_Sprite extends L_Object
{


    private       Texture                   texture;

    private       Sprite                    sprite;

    private       String                    spriteName;

    //region Constructors
    public L_Sprite(String spriteName, Color color, Vector2 position)
    {

        this.spriteName                     = spriteName;

        texture                             = new Texture(Gdx.files.internal(spriteName));

        texture.                            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sprite                              = new Sprite(texture);

        this.color                          = color;

        sprite.                             setColor(color);

        width                               = sprite.getWidth();

        height                              = sprite.getHeight();

        setPosition(position);

    }

    public L_Sprite(String spriteName, Color color)
    {

        this.spriteName                     = spriteName;

        texture                             = new Texture(Gdx.files.internal(spriteName));

        texture.                            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sprite                              = new Sprite(texture);

        this.color                          = color;

        sprite.                             setColor(color);

        width                               = sprite.getWidth();

        height                              = sprite.getHeight();

    }

    public L_Sprite(String spriteName, Vector2 position)
    {

        this.spriteName                     = spriteName;

        texture                             = new Texture(Gdx.files.internal(spriteName));

        texture.                            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sprite                              = new Sprite(texture);

        width                               = sprite.getWidth();

        height                              = sprite.getHeight();

        setPosition(position);

    }

    public L_Sprite(String spriteName)
    {

        this.spriteName                     = spriteName;

        texture                             = new Texture(Gdx.files.internal(spriteName));

        texture.                            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sprite                              = new Sprite(texture);

        width                               = sprite.getWidth();

        height                              = sprite.getHeight();

    }

    public L_Sprite()
    {



    }
    //endregion

    //region Methods

    @Override
    public void render()
    {

        Render.                             draw(sprite, position, color.a);

    }

    @Override
    protected void topToBottomRendering()
    {

        Render.                             draw(sprite, new Vector2(position.x, position.y - height), color.a);

    }

    @Override
    protected void centerToPositionRendering()
    {

        Render.                             draw(sprite, new Vector2(position.x - width / 2, position.y - height / 2), color.a);

    }
    //endregion

    //region Anims
    @Override
    public boolean getIaRun()                { return iaRun; }
    @Override
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

    @Override
    public boolean getGlRun()                { return glRun; }
    @Override
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

    @Override
    public boolean getGrRun()                { return grRun; }
    @Override
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

    @Override
    public boolean getGuRun()                { return guRun; }
    @Override
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

    @Override
    public boolean getGdRun()                { return gdRun; }
    @Override
    public void goDownAnim(float targetY, float speed, float time)
    {

        if (position.y > targetY)
        {

            gdRun                            = true;

            gdTime                           += GameScreen.getDelta();

            if(gdTime >= time)
            {

                gdTime                       = 0;

                setY(position.y - speed);

            }

        }
        else
        {

            gdRun                            = false;

        }

    }
    //endregion

    //region Getters and Setters
    public void setSprite(String spriteName)
    {

        this.spriteName                     = spriteName;

        texture                             = new Texture(Gdx.files.internal(spriteName));

        texture.                            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sprite                              = new Sprite(texture);

        position.x                          = sprite.getX();
        position.y                          = sprite.getY();

        width                               = sprite.getWidth();

        height                              = sprite.getHeight();

    }

    @Override
    public void setColor(Color newColor)
    {

        this.color                          = newColor;

        sprite.                             setColor(newColor);

        sprite.                             setColor(color);

    }

    @Override
    public void setTransparency(float a)
    {

        color.a                             = a;

        sprite.                             setAlpha(a);

    }

    @Override
    public void setPosition(Vector2 newPosition)
    {

        position.x                          = newPosition.x;
        position.y                          = newPosition.y;

        sprite.                             setPosition(newPosition.x, newPosition.y);

    }

    @Override
    public void setPosition(float newX, float newY)
    {

        position.x                          = newX;
        position.y                          = newY;

        sprite.                             setPosition(newX, newY);

        lastTouch.x                         = newX;
        lastTouch.y                         = newY;

    }

    @Override
    public void setX(float newX)
    {

        position.x                          = newX;

        sprite.                             setPosition(newX, position.y);

    }

    @Override
    public void setY(float newY)
    {

        position.y                          = newY;

        sprite.                             setPosition(position.x, newY);

    }

    public void setSize(float newWidth, float newHeight)
    {

        sprite.                             setSize(newWidth, newHeight);

        width                               = newWidth;
        height                              = newHeight;

    }

    public Sprite getSprite()               { return sprite; }

    public Texture getTexture()             { return texture; }

    public String getSpriteName()           { return spriteName; }
    //endregion

}
