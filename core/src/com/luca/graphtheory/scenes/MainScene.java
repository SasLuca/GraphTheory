package com.luca.graphtheory.scenes;

/**
 * Created by Sas on 11/8/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.assets.*;
import com.luca.graphtheory.forms.L_Button;
import com.luca.graphtheory.forms.L_Label;
import com.luca.graphtheory.forms.L_Sprite;

public class MainScene extends Scene
{

    /*

        Notice that there is no need for a constructor, we get one for free when we extend Scene

    */

    //TODO: Add ability to create multiple graphs with different colors
    //TODO: Add buttons to check graph properties

    //Initialize a sprite
    private     L_Sprite                                            leftBar;

    private     L_Label                                             title;

    private     L_Button                                            createEdgeBtn;
    private     L_Button                                            createVertexBtn;
    private     L_Button                                            enableDebugDataBtn;
    private     L_Button                                            checkConnectComponents;

    private     boolean                                             enterAnim;
    private     boolean                                             setEdge;
    private     boolean                                             edgeCreated;

    private     Graph                                               graph;

    private     int                                                 ce;
    private     int                                                 fv;

    //Override necessary methods
    @Override
    protected void load()
    {

        //Here you initialize the variables

        graph                                                       = new Graph();

        leftBar                                                     = new L_Sprite("Left-Bar.png", new Vector2(0, 0));
        leftBar.                                                    setPosition(0 - leftBar.getWidth(), 0);

        createVertexBtn                                             = L_Button.GenericBtn("Create Vertex");
        createVertexBtn.                                            setPosition(new Vector2(leftBar.getX() + leftBar.getWidth() / 2 - 25 - createVertexBtn.getWidth() / 2, 720 - 85 - 135));

        createEdgeBtn                                               = L_Button.GenericBtn("Create Edge");
        createEdgeBtn.                                              setPosition(new Vector2(leftBar.getX() + leftBar.getWidth() / 2 - 25 - createEdgeBtn.getWidth() / 2, createVertexBtn.getY() - createEdgeBtn.getHeight()));

        enableDebugDataBtn                                          = L_Button.GenericBtn("Enable Debug Data");
        enableDebugDataBtn.                                         setPosition(new Vector2(leftBar.getX() + leftBar.getWidth() / 2 - 25 - enableDebugDataBtn.getWidth() / 2, createEdgeBtn.getY() - enableDebugDataBtn.getHeight()));

        title                                                       = new L_Label("Graph Theory", "DEBUG_FONT", Color.WHITE, 1, new Vector2(leftBar.getX() + leftBar.getWidth()/2 - 25, 720 - 55));
        title.                                                      setPosition(title.getX() - title.getWidth() / 2, title.getY() - title.getHeight());

        enterAnim                                                   = true;

        setReceiveInput(false);

    }

    //Draws the sprite to the screen
    @Override
    protected void render()
    {

        leftBar.                                                    render();

        createVertexBtn.                                            render();

        createEdgeBtn.                                              render();

        enableDebugDataBtn.                                         render();

        title.                                                      render();

        graph.                                                      render();

    }

    @Override
    protected void update()
    {

        if (!setEdge)
        {

            enableDebugDataBtn.                                     updateInput();

            createVertexBtn.                                        updateInput();

            createEdgeBtn.                                          updateInput();

            edgeCreated                                             = false;

        }

        graph.                                                      updateInput();

        if (enterAnim)
        {

            leftBar.                                                goLeftAnim(0, 20f, 0.00001f);

            createEdgeBtn.                                          setPosition(new Vector2(leftBar.getX() + leftBar.getWidth() / 2 - 25 - createEdgeBtn.getWidth() / 2, createVertexBtn.getY() - createEdgeBtn.getHeight()));

            createVertexBtn.                                        setPosition(new Vector2(leftBar.getX() + leftBar.getWidth() / 2 - 25 - createVertexBtn.getWidth() / 2, 720 - 85 - 135));

            enableDebugDataBtn.                                     setPosition(new Vector2(leftBar.getX() + leftBar.getWidth() / 2 - 25 - enableDebugDataBtn.getWidth() / 2, createEdgeBtn.getY() - enableDebugDataBtn.getHeight()));

            title.                                                  setPosition(leftBar.getX() + leftBar.getWidth() / 2 - 25 - title.getWidth() / 2, title.getY());

            if(!leftBar.getGlRun())
            {

                enterAnim                                           = false;

                setReceiveInput(true);

                Render.getNotificationManager().                    setRun(true);

            }

        }

    }

    @Override
    protected void inputEvents()
    {

        if (!setEdge)
        {

            if(enableDebugDataBtn.isReleased())
            {

                if(!Render.getGraph().getRun())
                {

                    Render.getGraph().                              setRun(true);

                    enableDebugDataBtn.                             setText("Disable Debug Data");

                    Render.getNotificationManager().                addSimpleNotification("Debug data enabled", 2.5f);

                }
                else
                {

                    Render.getGraph().                              setRun(false);

                    enableDebugDataBtn.                             setText("Enable Debug Data");

                    Render.getNotificationManager().                addSimpleNotification("Debug data disabled", 2.5f);

                }

            }

            if(createVertexBtn.isReleased())
            {

                graph.                                              addVertex();

                Render.getNotificationManager().                    addSimpleNotification("Vertex " + graph.getNumberOfVertices() + " added", 2.5f);

            }

            if(createEdgeBtn.isReleased() && !edgeCreated)
            {

                if(graph.getNumberOfVertices() >= 2)
                {

                    ce                                              = 1;

                    setEdge                                         = true;

                    edgeCreated                                     = true;

                    Render.getNotificationManager().                addAddEdgeNotification();

                }
                else
                {

                    Render.getNotificationManager().                addErrorNotification("You need at least two vertices \nto create an edge", 5f);

                }

            }

            graph.                                                  drag();

        }

        //region Edge Generation
        if(ce == 2 && graph.getReleasedVertex() != 0 && !graph.getVertices().get(fv).isClicked())
        {

            graph.                                                  addEdge(fv, graph.getReleasedVertex());

            ce                                                      = 3;

            graph.                                                  setDraggable(true);

            Render.getNotificationManager().                        addSimpleNotification("Edge created between Vertex " + fv + " and " + graph.getReleasedVertex(), 2.5f);

        }

        if(ce == 1)
        {

            fv                                                      = graph.getReleasedVertex();

            if(fv != 0) ce                                          = 2;

            if(graph.getDraggable()) graph.                         setDraggable(false);

        }
        //endregion

    }

    public void resetSetEdge()
    {

        ce                                                          = 0;

        fv                                                          = 0;

        setEdge                                                     = false;

        graph.                                                      setDraggable(true);

    }

    public int getCe()                                              { return ce; }

}
