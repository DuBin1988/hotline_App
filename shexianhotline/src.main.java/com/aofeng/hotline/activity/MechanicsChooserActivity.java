package com.aofeng.hotline.activity;

import gueei.binding.Binder;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aofeng.hotline.R;
import com.aofeng.hotline.modelview.SetupModel;
import com.aofeng.hotline.service.ServiceManager;
import com.aofeng.utils.Util;

public class MechanicsChooserActivity extends BaseSetupActivity {
	SetupModel model;
	Button saveButton;
	Button setButton;
	Button goUploadButton;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		model = new SetupModel(this);
		Binder.setAndBindContentView(this, R.layout.mechanics_chooser, model);
		saveButton =(Button)findViewById(R.id.saveButton);
		setButton =(Button)findViewById(R.id.setButton);
		goUploadButton =(Button)findViewById(R.id.goUploadButton);
		saveButton.setEnabled(false);
		setButton.setEnabled(false);
		goUploadButton.setEnabled(false);
		saveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saveMechanics();
			}
		});
		setButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setMechanics();
			}
		});
		goUploadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				goUploadMechanics();
			}
		});
		CreateDBIfNotExist();
	}
/**
 * ����ҳ��
 */
	private void setMechanics() {
		// ҳ����ת
		Intent intent = new Intent(this, SetupActivity.class);
		startActivity(intent);
	}
	
/**
 * �ϴ�ҳ��
 */
	private void goUploadMechanics() {
		// ҳ����ת
		Intent intent = new Intent(this, UploadActivity.class);
		startActivity(intent);
	}
	
/**
 * ��ʼ����
 */
	private void saveMechanics() {
		// ҳ����ת
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	private void CreateDBIfNotExist() {
		if (!Util.DBExists(this)) 
		{
			Toast.makeText(this, "���ڽ���ϵͳ��ʼ�������Ե�...", Toast.LENGTH_LONG).show();
			model.GetRepairManList(true);
		}
//		else
//		{
//			Toast.makeText(this, "���ڽ���ϵͳ���ø��£����Ե�...", Toast.LENGTH_LONG).show();
//			model.GetRepairManList(false);
//		}
		saveButton.setEnabled(true);
		setButton.setEnabled(true);
		goUploadButton.setEnabled(true);
	}
//	@Override
//	public void onBackPressed() {
//		TextView tv = new TextView(this);
//		tv.setText("ȷ��Ҫ�˳���");
//		Dialog alertDialog = new AlertDialog.Builder(this).   
//				setView(tv).
//				setTitle("ȷ��").   
//				setIcon(android.R.drawable.ic_dialog_info).
//				setPositiveButton("ȷ��", new DialogInterface.OnClickListener(){
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						
//					}
//				}).setNegativeButton("ȡ��", null).
//				create();  
//		alertDialog.setCancelable(false);
//		alertDialog.show();
//		
//	}
}
