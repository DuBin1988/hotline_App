package com.aofeng.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SMSSender {
	//�����������
	private Context context;
	
	public SMSSender(Context context)
	{
		this.context = context;
	}
	
	/**
	 * ���Ͷ���
	 * 
	 * @param phoneNumber
	 * @param message
	 */
	public void sendSMS(String phoneNumber, String message) {
	    String SENT = "SMS_SENT";
	    String DELIVERED = "SMS_DELIVERED";
	    
	    //�ѷ��͵ȴ�������ͼ
	    PendingIntent sentPI = PendingIntent.getBroadcast(context, 0, new Intent(SENT), 0);
	    //���ʹ�ȴ�������ͼ
	    PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,  new Intent(DELIVERED), 0);

	    //�ѷ��͹㲥������
	    BroadcastReceiver sendSMS = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context arg0, Intent arg1) {
	            switch (getResultCode()) {
	            case Activity.RESULT_OK:
	                Toast.makeText(context, "�����ѷ��͡�", Toast.LENGTH_SHORT).show();
	                break;
	            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
	                Toast.makeText(context, "��ͨ����", Toast.LENGTH_SHORT).show();
	                break;
	            case SmsManager.RESULT_ERROR_NO_SERVICE:
	                Toast.makeText(context, "���񲻴��ڡ�", Toast.LENGTH_SHORT).show();
	                break;
	            case SmsManager.RESULT_ERROR_NULL_PDU:
	                Toast.makeText(context, "��PDU��", Toast.LENGTH_SHORT).show();
	                break;
	            case SmsManager.RESULT_ERROR_RADIO_OFF:
	                Toast.makeText(context, "���߱��رա�", Toast.LENGTH_SHORT).show();
	                break;
	            }
	        }
	    };

	    //�ʹ�㲥������
	    BroadcastReceiver deliverSMS = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context arg0, Intent intent) {
	            switch (getResultCode()) {
	            case Activity.RESULT_OK:
	                Toast.makeText(context, "�����ѱ����ա�", Toast.LENGTH_SHORT).show();
	                break;
	            case Activity.RESULT_CANCELED:
	                Toast.makeText(context, "���ŷ���ʧ�ܡ�", Toast.LENGTH_SHORT).show();
	                break;
	            }
	        }
	    };

	    //ע�����������ѷ��͹㲥
	    context.registerReceiver(sendSMS, new IntentFilter(SENT));
	    //ע�������������ʹ�㲥
	    context.registerReceiver(deliverSMS, new IntentFilter(DELIVERED));

	    SmsManager sms = SmsManager.getDefault();
	    sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
	 }
}
