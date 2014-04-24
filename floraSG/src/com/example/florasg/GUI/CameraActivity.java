package com.example.florasg.GUI;

import com.example.florasg.R;

import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.view.View;
//import android.widget.ImageView;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
import android.app.Activity;
import android.os.Bundle;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

//import com.hoho.android.usbserial.driver.UsbSerialDriver;
//import com.hoho.android.usbserial.driver.UsbSerialProber;
//import com.hoho.android.usbserial.util.HexDump;
//import com.hoho.android.usbserial.util.SerialInputOutputManager;


/*public class CameraActivity extends Activity implements SurfaceHolder.Callback {	


	//===camera var================
	private TextView mTitleTextView;
	static Camera mCamera; // shared var with picHandler
	private int mCameraId = 0;
	private SurfaceView mSurfaceView;
	private SurfaceHolder mSurfaceHolder;
	boolean myPreviewState = false;
	static boolean myTakeState = false;// shared var with picHandler
	private int count = 0;
	private final static String DEBUG_TAG = "CameraActivity";
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.camera, menu);
//		return true;
//	}

	//====sys function for camera==========
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);

		getWindow().setFormat(PixelFormat.UNKNOWN);
		mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview);
		mSurfaceHolder = mSurfaceView.getHolder();
		mSurfaceHolder.addCallback(this);

		mCameraId = findBackCamera();// ret cam found.
		mCamera = Camera.open(mCameraId);
		setCameraParam();
		 Button buttonTakePhoto= (Button)findViewById(R.id.captureBack);
		    buttonTakePhoto.setOnClickListener(new View.OnClickListener(){
		    	public void onClick(View view) {

					if (myTakeState == true) {//still taking pic. do nothing
						//appendLog("true myTakeState");
						Log.e(DEBUG_TAG, "true myTakeState");


					} else {
						//appendLog("false myTakeState");
						Log.e(DEBUG_TAG, "false myTakeState");
						if (mCamera != null) {
							myTakeState = true;
							count++;
						mCamera.takePicture(null, null, new picHandler(
								getApplicationContext()));
						//appendLog("mCamera.autoPic" + " " + count);
						Toast.makeText(getBaseContext(), "mCamera.autoPic",
								Toast.LENGTH_SHORT).show();
						}
					}
				}// end auto pic
		    });*
			
	}

	@Override
	protected void onPause() {
		super.onPause();

		if (mCamera != null && myPreviewState) {
			mCamera.stopPreview();
			mCamera.release();
			mCamera = null;

			myPreviewState = false;
		}
	}

	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onResume() {
		super.onResume();

		if (mCamera == null) {// camera was released when pause
			mCamera = Camera.open(mCameraId);
			setCameraParam();// reopen cam
		}
	}
	
	//==functions for camera===================
	// after take pic refresh preview on surface
	private void refreshSurfacePreview() {
			// start preview after pic taken
			mCamera.startPreview();
			myPreviewState = true;
			myTakeState = false;// guard for take pic
			System.out.println("refresh surface preview");
		}

		// After a picture is taken, you must restart the preview before the user
		// can take another picture
	public void onClick(View view) {

		if (myTakeState == true) {//still taking pic. do nothing
			//appendLog("true myTakeState");
			Log.e(DEBUG_TAG, "true myTakeState");


		} else {
			//appendLog("false myTakeState");
			Log.e(DEBUG_TAG, "false myTakeState");
			if (mCamera != null) {
				myTakeState = true;
				count++;
			mCamera.takePicture(null, null, new picHandler(
					getApplicationContext()));
			//appendLog("mCamera.autoPic" + " " + count);
			Toast.makeText(getBaseContext(), "mCamera.autoPic",
					Toast.LENGTH_SHORT).show();
			}
		}
	}// end auto pic

		
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		setCameraParam();

		//style1
		try {
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
			myPreviewState = true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//appendLog("set preview disp holder");
		}
	}// end surface changed
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		// put mCamera preview in the surface
		//appendLog("surface created");

		if (mCamera != null) {
			try {
				//appendLog("Created set Camera Param");
				// mCamera param
				Camera.Parameters params = mCamera.getParameters();
				// set the focus mode
				params.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
				// set Camera parameters
				mCamera.setParameters(params);

				// preview param
				mCamera.setPreviewDisplay(holder);
				mCamera.startPreview();
				myPreviewState = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}// end if
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		// ==shin==========
		if (mCamera != null && myPreviewState) {
			mCamera.stopPreview();
			mCamera.release();
			mCamera = null;
			myPreviewState = false;
		}
		// =============
	}// end surface destroy
	
	public static void setCameraParam() {
		if (mCamera != null) {
			try {

				// mCamera param
				Camera.Parameters params = mCamera.getParameters();
				// set the focus mode
				params.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
				// set Camera parameters
				mCamera.setParameters(params);
				// mCamera.setDisplay(surfaceHolder);//method unavail
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}// end if
	}// end set mCamera
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	private int findBackCamera() {
		int mCameraId = -1;
		String mCameraState = "";
		// Search for the back mCamera
		int numberOfCameras = Camera.getNumberOfCameras();
		for (int i = 0; i < numberOfCameras; i++) {
			CameraInfo info = new CameraInfo();
			Camera.getCameraInfo(i, info);
			if (info.facing == CameraInfo.CAMERA_FACING_BACK) {
				Log.d(DEBUG_TAG, "Camera found");
				mTitleTextView.setText("Camera Found");
				mCameraId = i;
				mCameraState = "mCamera found=" + " " + mCameraId;
				Toast.makeText(getBaseContext(), "mCamera found",
						Toast.LENGTH_LONG).show();
				break;
			}
		}
		return mCameraId;
	}// end find mCamera

}//end class
*/

@SuppressLint("NewApi")
public class CameraActivity extends Activity {
	  private final static String DEBUG_TAG = "TakePhotoActivity";
	  private Camera camera;
	  private int cameraId = 0;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_camera);

	    // do we have a camera?
	    if (!getPackageManager()
	        .hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
	      Toast.makeText(this, "No camera on this device", Toast.LENGTH_LONG)
	          .show();
	    } else {
	      cameraId = findBackFacingCamera();
	      if (cameraId < 0) {
	        Toast.makeText(this, "No front facing camera found.",
	            Toast.LENGTH_LONG).show();
	      } else {
	        camera = Camera.open(cameraId);
	      }
	    }
	  }

	  public void onClick(View view) {
	    camera.takePicture(null, null,
	        new picHandler(getApplicationContext()));
	  }

	  private int findBackFacingCamera() {
	    int cameraId = -1;
	    // Search for the front facing camera
	    int numberOfCameras = Camera.getNumberOfCameras();
	    for (int i = 0; i < numberOfCameras; i++) {
	      CameraInfo info = new CameraInfo();
	      Camera.getCameraInfo(i, info);
	      if (info.facing == CameraInfo.CAMERA_FACING_BACK) {
	        Log.d(DEBUG_TAG, "Camera found");
	        cameraId = i;
	        Toast.makeText(getBaseContext(), "mCamera found",
					Toast.LENGTH_LONG).show();
	        break;
	      }
	    }
	    return cameraId;
	  }// end find mCamera
	  
	  @Override
	  protected void onPause() {
	    if (camera != null) {
	      camera.release();
	      camera = null;
	    }
	    super.onPause();
	  }

	}
