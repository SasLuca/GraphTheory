package com.luca.graphtheory.android;

import android.os.Bundle;

import android.view.WindowManager;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.luca.graphtheory.GameClass;

public class AndroidLauncher extends AndroidApplication
{

	@Override
	protected void onCreate (Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		config.useImmersiveMode = true;

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		initialize(new GameClass(), config);

	}

}