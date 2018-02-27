package com.gss.cordova.camera;

import com.gss.app.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class CameraActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
			fragmentManager.beginTransaction().add(R.id.fragment_container, new CameraFragment()).commit();
		}
	}
}
