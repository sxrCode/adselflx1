package com.gss.cordova.camera;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.util.Log;

public class GssCameraPlugin extends CordovaPlugin {

	private CallbackContext callbackContext;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		Intent intent = new Intent(cordova.getActivity(), CameraActivity.class);
		cordova.getActivity().startActivity(intent);
		Log.e("sxr", "execute GssCameraPlugin!");
		return true;
	}
}
