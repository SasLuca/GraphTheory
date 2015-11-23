package com.luca.graphtheory;

/**
 * Created by Sas on 11/1/2015.
 */

import com.badlogic.gdx.Game;

public class GameClass extends Game
{

	protected 		    GameScreen 		gameScreen;

	protected static 	float		    realWidth;
	protected static	float			realHeight;

	protected static    boolean         vsync;

	public GameClass(float a, float b, boolean vsync)
	{

		realWidth				= a;

		realHeight				= b;

		this.vsync				= vsync;

	}

	public GameClass()
	{

		realWidth				= 1280;

		realHeight				= 720;

	}

	@Override
	public void create ()
	{

		//loading stuff

		//IOSystem.				load();

		gameScreen 				= new GameScreen(this);

		setScreen				(gameScreen);

	}

	public static  boolean getVSync()       { return vsync; }
	public static  float   getRealWidth()   { return realWidth; }
	public static  float   getRealHeight()  { return realHeight; }

}
