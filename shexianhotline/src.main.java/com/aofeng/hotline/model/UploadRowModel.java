package com.aofeng.hotline.model;

import com.aofeng.hotline.modelview.UploadModel;

import gueei.binding.observables.StringObservable;


public class UploadRowModel {
	private UploadModel model;
	public UploadRowModel(UploadModel um) {
		this.model=um;
	}
	public StringObservable USERNAME = new StringObservable("");//�û����� 
	public StringObservable PHONE = new StringObservable("");//�û���ַ 
	public StringObservable SENDER = new StringObservable("");//�ɵ���
	public StringObservable CUCODE = new StringObservable("");//���ޱ��
	public StringObservable SENDTIME = new StringObservable("");//�ɵ�ʱ��
}
