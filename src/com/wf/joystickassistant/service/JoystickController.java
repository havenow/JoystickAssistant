package com.wf.joystickassistant.service;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.papa.controller.core.ControllerListener;
import com.papa.controller.core.ControllerManager;
import com.papa.controller.core.ControllerMonitor;
import com.papa.controller.core.PadKeyEvent;
import com.papa.controller.core.PadMotionEvent;
import com.papa.controller.core.PadStateEvent;
import com.wf.joystickassistant.utils.LOG;

public class JoystickController implements ControllerListener {
	private ControllerMonitor mControllerMonitor;
	Context context;
	private static JoystickController gtc = null;

	private JoystickController(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public static JoystickController getInstace(Context context) {
		if (null == gtc) {
			gtc = new JoystickController(context);

		}

		return gtc;
	}

	public void startMonitor() {
		try {
			// event listener
			if (mControllerMonitor == null) {
				mControllerMonitor = new ControllerMonitor(context);
				mControllerMonitor.setListener(this, new Handler());

				// connect listener
				setControllerDeviceListener();
			}

			if (mControllerMonitor != null) {
				mControllerMonitor.startMonitor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopMonitor() {
		if (mControllerMonitor != null) {
			mControllerMonitor.stopMonitor();
		}
	}

	private void setControllerDeviceListener() {

		if (mControllerMonitor != null) {
			// connect listener
			mControllerMonitor
					.setControllerDeviceListener(new ControllerManager.ControllerDeviceListener() {
						@Override
						public void onControllerDeviceAdded(
								ControllerManager.ControllerDevice device) {
							int count = mControllerMonitor
									.getControllerDeviceCount();
							LOG.prointLog("onControllerDeviceAdded", "count="
									+ count);
							if (count == 1) {
								LOG.prointLog("all devices are connected",
										"手柄已连接");
								Toast.makeText(context, "手柄已连接",
										Toast.LENGTH_SHORT).show();
							}
						}

						@Override
						public void onControllerDeviceRemoved(
								ControllerManager.ControllerDevice device) {
							int count = mControllerMonitor
									.getControllerDeviceCount();
							LOG.prointLog("onControllerDeviceRemoved", "count="
									+ count);
							if (count == 0) {
								LOG.prointLog("all devices are disconnected",
										"手柄已断开");
								Toast.makeText(context, "手柄已断开",
										Toast.LENGTH_SHORT).show();
							}
						}
					});
		}
	}

	@Override
	public void onKeyPressure(int arg0, float arg1, PadKeyEvent arg2) {// A B X Y L1 R1 L2 R2
		// TODO Auto-generated method stub
		LOG.prointLog("onKeyPressure" + arg0 + "--" + arg2.getKeyCode());
	}

	@Override
	public void onKeyUp(int arg0, PadKeyEvent arg1) {// 上 下 左 右  左摇杆按下 右摇杆按下 i键 start select
		// TODO Auto-generated method stub
		LOG.prointLog("onKeyUp" + arg0 + "--" + arg1.getKeyCode());
	}

	@Override
	public void onLeftStick(float arg0, float arg1, PadMotionEvent arg2) {//左摇杆
		// TODO Auto-generated method stub
		LOG.prointLog("onLeftStick" + arg0 + "--" + arg1 + "--"+ arg2.getKeyCode());
	}

	@Override
	public void onRightStick(float arg0, float arg1, PadMotionEvent arg2) {//右摇杆
		// TODO Auto-generated method stub
		LOG.prointLog("onRightStick" + arg0 + "--" + arg2.getKeyCode());
	}

	@Override
	public void onStateEvent(PadStateEvent arg0) {
		// TODO Auto-generated method stub
		LOG.prointLog(arg0.toString());
	}

	@Override
	public void onKeyDown(int arg0, PadKeyEvent arg1) {
		// TODO Auto-generated method stub
		LOG.prointLog("onKeyDown" + arg0 + "--" + arg1.getKeyCode());
	}
}
