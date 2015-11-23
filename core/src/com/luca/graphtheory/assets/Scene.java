package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/1/2015.
 */

public class Scene
{
    /*

        This class is just the base class that every Scene will extend
        Not to be confused with the libGDX scene class

    */

//region Variables


    //This values dictate whether the scene is running, is drawing, is receiving input or if it loaded
    protected     boolean       run;
    protected     boolean       load;
    protected     boolean       update;
    protected     boolean       render;
    protected     boolean       receiveInput;


//endregion

//region Constructors


    public Scene()
    {



    }


//endregion

//region Methods


    //This method should not be override
    //This is the method that will be called in Render.render()
    public void anim()
    {

        if(!load)
        {

            run                 = true;

            load                = true;

            update              = true;

            render              = true;

            receiveInput        = true;

            load();

        }

        if(run)
        {

            if(receiveInput)    inputEvents();

            if(update)          update();

            if(render)          render();

        }

    }

    //Here is the code related to what will appear on screen each frame
    protected void render()
    {

        //Your code goes here

    }

    //Here is the code that updates your scene each frame
    protected void update()
    {

        //Your code goes here

    }

    //Here are all the input events related to this scene
    protected void inputEvents()
    {

        //Your code goes here

    }

    //This method is called the first time you render the scene
    protected void load()
    {

        //Your code goes here

    }


//endregion

//region Getters and Setters


    public boolean getRun()
    {

        return                  run;

    }

    public void setRun(boolean run)
    {

        this.run                = run;

        render                  = run;

        receiveInput            = run;

    }

    public boolean getRender()
    {

        return                  render;

    }

    public void setRender(boolean render)
    {

        this.render             = render;

    }

    public boolean getReceiveInput()
    {

        return                  receiveInput;

    }

    public void setReceiveInput(boolean receiveInput)
    {

        this.receiveInput       = receiveInput;

    }

    public void setUpdate(boolean update)
    {

        this.update             = update;

    }

    public boolean getUpdate()
    {

        return                  update;

    }

//endregion

}
