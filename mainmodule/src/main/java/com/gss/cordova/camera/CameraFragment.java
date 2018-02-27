package com.gss.cordova.camera;

import java.io.File;

import com.gss.app.R;
import com.gss.cordova.camera.listener.ClickListener;
import com.gss.cordova.camera.listener.JCameraListener;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CameraFragment extends Fragment {

	private JCameraView mJCameraView;
	private boolean granted;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT >= 19) {
			View decorView = getActivity().getWindow().getDecorView();
			decorView.setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		} else {
			View decorView = getActivity().getWindow().getDecorView();
			int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(option);
		}

		getPermissions();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_media, container, false);
		initWidget(view);
		return view;
	}

	private void initWidget(View view) {
		mJCameraView = (JCameraView) view.findViewById(R.id.jcameraview);

		mJCameraView.setSaveVideoPath(Environment.getExternalStorageDirectory().getPath() + File.separator + "JCamera");
		mJCameraView.setMediaQuality(JCameraView.MEDIA_QUALITY_MIDDLE);

		mJCameraView.setJCameraLisenter(new JCameraListener() {
			@Override
			public void captureSuccess(Bitmap bitmap) {
				// 获取图片bitmap
			}

			@Override
			public void recordSuccess(String url, Bitmap firstFrame) {
				// 获取视频路径
				getActivity().finish();
			}

		});

		// 左边按钮点击事件
		mJCameraView.setLeftClickListener(new ClickListener() {
			@Override
			public void onClick() {
				getActivity().finish();
			}
		});
	}

	/**
	 * 获取权限
	 */
	private void getPermissions() {
		/*
		 * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) { if
		 * (ContextCompat.checkSelfPermission(getActivity(),
		 * Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
		 * PackageManager.PERMISSION_GRANTED &&
		 * ContextCompat.checkSelfPermission(getActivity(),
		 * Manifest.permission.RECORD_AUDIO) ==
		 * PackageManager.PERMISSION_GRANTED &&
		 * ContextCompat.checkSelfPermission(getActivity(),
		 * Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
		 * // 具有权限 granted = true; } else { // 不具有获取权限，需要进行权限申请
		 * ActivityCompat.requestPermissions(getActivity(), new String[] {
		 * Manifest.permission.WRITE_EXTERNAL_STORAGE,
		 * Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA }, 101);
		 * granted = false; } }
		 */
	}

	@Override
	public void onResume() {
		super.onResume();
		mJCameraView.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		mJCameraView.onPause();
	}
}
