package com.aofeng.hotline.activity;

import android.app.Activity;
import android.widget.Toast;

public class BaseSetupActivity extends Activity{
	public boolean isBusy;
	
	@Override
	public void onBackPressed() {
		if(isBusy)
		{
			Toast.makeText(this, "��ȴ��ϴβ�����ɡ�", Toast.LENGTH_SHORT).show();
		}
		else
			super.onBackPressed();
	}

	public void onComplete() {
	}
}
