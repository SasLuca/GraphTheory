package com.luca.graphtheory.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.luca.graphtheory.GameClass;

public class DesktopLauncher
{

	static LwjglApplicationConfiguration     config;

	public static void main (String[] arg)
	{

		config 								 = new LwjglApplicationConfiguration();

		config.title 						 = "GraphTheory";
		config.resizable 					 = false;
		config.width 						 = 1280;
		config.height 						 = 720;

		new LwjglApplication(new GameClass(config.width, config.height, vSync(true)), config);

	}

	public static boolean vSync(boolean enable)
	{

		if(!enable)
		{

			config.vSyncEnabled 			 = false; 	// Setting to false disables vertical sync
			config.foregroundFPS 			 = 0; 		// Setting to 0 disables foreground fps throttling
			config.backgroundFPS 			 = 0; 		// Setting to 0 disables background fps throttling

			return 							 false;

		}


		return 								 true;

	}

}
