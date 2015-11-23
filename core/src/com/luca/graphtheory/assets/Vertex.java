package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/11/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.forms.L_Label;
import com.luca.graphtheory.forms.L_Sprite;

public class Vertex extends L_Object
{

    //TODO: Change the shade of blue

    private     L_Sprite        vertexClickable;
    private     L_Sprite        vertexPressed;
    private     L_Sprite        vertexSelected;

    private     L_Label         label;

    private     String          name;

    private     int             index;
    private     int             degree;

    private     boolean         selected;

    public Vertex(int index)
    {

        this.index              = index;

        vertexClickable         = new L_Sprite("Vertex_Clickable.png", Color.WHITE, position);

        vertexPressed           = new L_Sprite("Vertex_Pressed.png", Color.WHITE, position);

        vertexSelected          = new L_Sprite("Vertex_Selected.png", Color.BLUE, position);

        label                   = new L_Label(Integer.toString(index), Color.BLACK, 1f, new Vector2(0, 0));

        label.                  setPosition(vertexClickable.getX() - label.getWidth() / 2, vertexClickable.getY() - label.getHeight() / 2);

        width                   = vertexClickable.getWidth();

        height                  = vertexClickable.getHeight();

    }

    public Vertex()
    {



    }

    @Override
    public void render()
    {

        if(super.clickable)
        {

            if(isClicked() || draggable)
            {

                vertexPressed.                      render();

                label.                              render();

            }
            else
            {

                vertexClickable.                    render();

                label.                              render();

            }

        }
        else
        {

            vertexClickable.                        render();

            label.                                  render();

        }

        if(!getIaRun()) { label.                    render(); vertexSelected.render();}

    }

    @Override
    protected void centerToPositionRendering()
    {

        if(super.clickable)
        {

            if(isClicked())
            {

                vertexPressed.                      render(DrawMethod.CENTER_TO_POSITION);

            }
            else
            {

                vertexClickable.                    render(DrawMethod.CENTER_TO_POSITION);

            }

        }
        else
        {

            vertexClickable.                        render(DrawMethod.CENTER_TO_POSITION);

        }

    }

    @Override
    public void setSize(float newWidth, float newHeight)
    {

        width                   = newWidth;

        height                  = newHeight;

        vertexClickable.        setSize(newWidth, newHeight);

        vertexPressed.          setSize(newWidth, newHeight);

    }

    @Override
    public void setPosition(float newX, float newY)
    {

        position.x              = newX;

        position.y              = newY;

        vertexPressed.          setPosition(newX, newY);

        vertexClickable.        setPosition(newX, newY);

        vertexSelected.         setPosition(newX, newY);

        label.                  setPosition(newX - label.getWidth()/2 + 45, newY - label.getHeight()/2 + 45);

    }

    public int getIndex()       { return index; }
    public int getDegree()      { return degree; }

}
