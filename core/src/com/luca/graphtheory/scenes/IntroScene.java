package com.luca.graphtheory.scenes;

/**
 * Created by Sas on 11/20/2015.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;
import com.luca.graphtheory.assets.Render;
import com.luca.graphtheory.assets.Scene;
import com.luca.graphtheory.forms.L_Button;
import com.luca.graphtheory.forms.L_Label;
import com.luca.graphtheory.forms.L_Sprite;

public class IntroScene extends Scene
{

    private     L_Sprite        card;
    private     L_Label         title;
    private     L_Label         author;
    private     L_Button        start;
    private     L_Button        exit;
    private     boolean         transitionToScene;

    //This method is called the first time you render the scene
    protected void load()
    {

        card                    = new L_Sprite("Card.png", new Vector2(0, 0));
        card.                   setPosition(GameScreen.getCameraWidth()/2 - card.getWidth()/2, 0 - card.getHeight());

        title                   = new L_Label("Graph Theory", "DEBUG_FONT", Color.BLACK, 1.4f, new Vector2(0, 0));
        title.                  setPosition(card.getX() + card.getWidth() / 2 - title.getWidth() / 2, card.getY() + card.getHeight() - title.getHeight()*2 - 20);

        author                  = new L_Label("by Sas Luca", "DEBUG_FONT", Color.BLACK, 0.7f, new Vector2(0, 0));
        author.                 setPosition(card.getX() + card.getWidth() - author.getWidth() - 40, title.getY() - author.getHeight() - 15);

        start                   = L_Button.GenericBtn("Start");
        start.                  setPosition(card.getX() + card.getWidth() / 2 - start.getWidth() / 2, card.getY() + card.getHeight() / 2 - start.getHeight() / 2);

        exit                    = L_Button.GenericBtn("Exit");
        exit.                   setPosition(start.getX(), start.getY() - exit.getHeight());

    }

    //Here is the code related to what will appear on screen each frame
    protected void render()
    {

        card.                   render();

        title.                  render();

        author.                 render();

        start.                  render();

        exit.                   render();

    }

    //Here is the code that updates your scene each frame
    protected void update()
    {

        if (!card.getGdRun())
        {

            start.              updateInput();

            exit.               updateInput();

        }

        if(!transitionToScene)  card.goUpAnim(GameScreen.getCameraHeight() / 2 - card.getHeight() / 2, 20f, 0.00001f);

        if(transitionToScene)   card.goDownAnim(0 - card.getHeight(), 20f, 0.00001f);

        if(card.getGuRun() || card.getGdRun())
        {

            title.              setPosition(card.getX() + card.getWidth() / 2 - title.getWidth() / 2, card.getY() + card.getHeight() - title.getHeight() * 2 - 20);

            author.             setPosition(card.getX() + card.getWidth() - author.getWidth() - 40, title.getY() - author.getHeight() - 15);

            start.              setPosition(card.getX() + card.getWidth() / 2 - start.getWidth() / 2, card.getY() + card.getHeight() / 2 - start.getHeight() / 2);

            exit.               setPosition(start.getX(), start.getY() - exit.getHeight());

        }

        if(transitionToScene && card.getY() == 0 - card.getHeight())
        {

            this.               setRun(false);

            Render.             getScene().setRun(true);

        }

    }

    //Here are all the input events related to this scene
    protected void inputEvents()
    {

        if(exit.isReleased())
        {

            Gdx.app.            exit();

        }

        if(start.isReleased())
        {

            transitionToScene   = true;

        }

    }

}
