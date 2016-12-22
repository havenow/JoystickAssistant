package com.wf.joystickassistant.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class JoystickService extends Service {
	private MyBinder myBinder = new MyBinder();

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		JoystickController.getInstace(this).startMonitor();
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		JoystickController.getInstace(this).stopMonitor();
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return myBinder;
	}

	public class MyBinder extends Binder {

		public JoystickService getService() {
			return JoystickService.this;
		}
	}

}
