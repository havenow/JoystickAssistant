package com.wf.joystickassistant;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.wf.joystickassistant.service.JoystickService;
import com.wf.joystickassistant.service.JoystickService.MyBinder;

public class SplashActivity extends Activity {
	private JoystickService m_bindService;
	private ServiceConnection m_conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			MyBinder binder = (MyBinder) service;
			m_bindService = binder.getService();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Intent intent = new Intent(SplashActivity.this, JoystickService.class);
		bindService(intent, m_conn, Context.BIND_AUTO_CREATE);
	}

}
