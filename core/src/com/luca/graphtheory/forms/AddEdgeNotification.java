package com.luca.graphtheory.forms;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;
import com.luca.graphtheory.assets.Render;

/**
 * Created by Sas on 11/23/2015.
 */

public class AddEdgeNotification extends Notification
{

    private     L_Label     message;

    private     L_Sprite    sprite;

    public AddEdgeNotification(int positionInStack)
    {

        timer               = 5f;

        card                = new L_Sprite("GenericNotification.png", new Vector2(0, 0));

        card.               setPosition(GameScreen.getCameraWidth() - card.getWidth(), 0 - card.getHeight());

        sprite              = new L_Sprite("close.png", new Vector2(0, 0));

        sprite.             setPosition(card.getX() + 10, card.getY() + card.getHeight() / 2 - sprite.getHeight() / 2);

        sprite.             setSize(85, 85);

        sprite.             setColor(Color.RED);

        message             = new L_Label("", Color.BLACK, 0.75f, new Vector2(0, 0));

        this.positionInStack = positionInStack;

    }

    @Override
    public void render()
    {

        if(Render.getScene().getCe() == 1) message.setText("Select vertex 1");
        if(Render.getScene().getCe() == 2) message.setText("Select vertex 2");
        if(Render.getScene().getCe() == 3) goDown = true;

        if(goUp)
        {

            card.           goUpAnim(card.getHeight() * positionInStack, 10f, 0.00001f);

            sprite.         setPosition(card.getX() + 10, card.getY() + card.getHeight() / 2 - sprite.getHeight() / 2);

            message.        setPosition(card.getX() + card.getWidth() / 2 - message.getWidth() / 2, card.getY() + card.getHeight() / 2 - message.getHeight() / 2);

            if(!card.getGuRun()) goUp = false;

        }

        if(goDown)
        {

            card.           goDownAnim(-card.getHeight(), 10f, 0.00001f);

            sprite.         setPosition(card.getX() + 10, card.getY() + card.getHeight() / 2 - sprite.getHeight() / 2);

            message.        setPosition(card.getX() + card.getWidth() / 2 - message.getWidth() / 2, card.getY() + card.getHeight() / 2 - message.getHeight() / 2);

            if(!card.getGdRun()) destroy();

        }

        if(positionInStackChanged)
        {

            time            -= GameScreen.getDelta();

            card.           goDownAnim(card.getHeight() * positionInStack, 10f, 0.00001f);

            sprite.         setPosition(card.getX() + 10, card.getY() + card.getHeight() / 2 - sprite.getHeight() / 2);

            message.        setPosition(card.getX() + card.getWidth() / 2 - message.getWidth() / 2, card.getY() + card.getHeight() / 2 - message.getHeight() / 2);

            if(!card.getGdRun())
            {

                positionInStackChanged = false;

            }

        }

        card.               render();

        sprite.             render();

        message.            render();

    }

    @Override
    public void inputEvents()
    {

        sprite.             updateInput();

        if(sprite.isReleased())
        {

            goDown          = true;

        }

    }

    @Override
    public void destroy()
    {

        destroy             = true;

        Render.getScene().  resetSetEdge();

    }

}
