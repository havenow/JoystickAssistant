package com.wf.joystickassistant.utils;

import android.util.Log;

public class LOG {
	private static String LOG_TAG = "joystick";

	public static void prointLog(String content) {
		Log.i(LOG_TAG, content);
	}

	public static void prointLog(String tag, String content) {
		Log.i(tag, content);
	}

	public static void prointError(String content) {
		Log.e(LOG_TAG, content);
	}

	public static void prointError(String tag, String content) {
		Log.e(tag, content);
	}
}
