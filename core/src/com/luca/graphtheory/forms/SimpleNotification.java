package com.luca.graphtheory.forms;

/**
 * Created by Sas on 11/23/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;

public class SimpleNotification extends Notification
{

    private     L_Label     message;

    public SimpleNotification(int positionInStack, String text)
    {

        timer               = 5f;

        card                = new L_Sprite("GenericNotification.png", new Vector2(0, 0));

        card.               setPosition(GameScreen.getCameraWidth() - card.getWidth(), 0 - card.getHeight());

        message             = new L_Label(text, Color.BLACK, 0.75f, new Vector2(0, 0));

        this.positionInStack = positionInStack;

    }

    @Override
    public void render()
    {

        if(goUp)
        {

            card.           goUpAnim(card.getHeight() * positionInStack, 10f, 0.00001f);

            message.        setPosition(card.getX() + card.getWidth() / 2 - message.getWidth() / 2, card.getY() + card.getHeight() / 2 - message.getHeight() / 2);

            if(!card.getGuRun()) goUp = false;

        }

        if(!goUp)
        {

            time            += GameScreen.getDelta();

            if(timer <= time && !onHold) goDown = true;

        }

        if(goDown)
        {

            card.           goDownAnim(-card.getHeight(), 10f, 0.00001f);

            message.        setPosition(card.getX() + card.getWidth() / 2 - message.getWidth() / 2, card.getY() + card.getHeight() / 2 - message.getHeight() / 2);

            if(!card.getGdRun()) destroy = true;

        }

        if(positionInStackChanged)
        {

            time            -= GameScreen.getDelta();

            card.           goDownAnim(card.getHeight() * positionInStack, 10f, 0.00001f);

            message.        setPosition(card.getX() + card.getWidth() / 2 - message.getWidth() / 2, card.getY() + card.getHeight() / 2 - message.getHeight() / 2);

            if(!card.getGdRun())
            {

                positionInStackChanged = false;

            }

        }

        card.               render();

        message.            render();

    }

}
