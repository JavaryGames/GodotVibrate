package org.godotengine.godot;

//imports
import android.app.Activity;
import android.content.Intent;
import android.os.Vibrator;
import android.content.Context;

public class GodotVibrate extends Godot.SingletonBase {

	Activity m_pActivity;

    	public void doVibrate(int ms)
	{
		Vibrator v = (Vibrator) m_pActivity.getSystemService(Context.VIBRATOR_SERVICE);
 		
		// Vibrate for ms milliseconds
 		v.vibrate(ms);
	}

	static public Godot.SingletonBase initialize(Activity p_activity) {
		return new GodotVibrate(p_activity);
    	}

    	public GodotVibrate(Activity p_activity) {
		m_pActivity = p_activity;

		//register class name and functions to bind
		registerClass("GodotVibrate", new String[]{"doVibrate"});
    	}
}
