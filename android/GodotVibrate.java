package org.godotengine.godot;

//imports
import android.app.Activity;
import android.os.Build;
import android.content.Intent;
import android.os.Vibrator;
import android.os.VibrationEffect;
import android.content.Context;
import android.util.Log;

public class GodotVibrate extends Godot.SingletonBase {

	Activity m_pActivity;

	public void doVibrate(int ms) {
		Vibrator v = (Vibrator) m_pActivity.getSystemService(Context.VIBRATOR_SERVICE);

		if (v == null || !v.hasVibrator()) {
			return;
		}

		try {
			// Vibrate for ms milliseconds
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				v.vibrate(VibrationEffect.createOneShot(ms, VibrationEffect.DEFAULT_AMPLITUDE));
			} else {
				v.vibrate(ms);
			}
		} catch (NullPointerException e) {
			Log.d("godot", "Error while trying to make the device vibrate (known issue in Samsung Oreo (8.1.0) devices).");
		}
	}

	static public Godot.SingletonBase initialize(Activity p_activity) {
		return new GodotVibrate(p_activity);
	}

	public GodotVibrate(Activity p_activity) {
		m_pActivity = p_activity;

		// register class name and functions to bind
		registerClass("GodotVibrate", new String[] { "doVibrate" });
	}
}
