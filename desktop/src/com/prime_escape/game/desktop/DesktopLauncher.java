package com.prime_escape.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.prime_escape.game.PrimeEscape;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PrimeEscape";
		config.width = 800;
		config.height = 480;
		config.vSyncEnabled = true;
		config.foregroundFPS = 60;
		new LwjglApplication(new PrimeEscape(), config);
	}
}
