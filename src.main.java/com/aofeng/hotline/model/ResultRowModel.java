package com.aofeng.hotline.model;

import com.aofeng.hotline.activity.RepairResultActivity;
import com.aofeng.utils.Util;

import gueei.binding.Command;
import gueei.binding.collections.ArrayListObservable;
import gueei.binding.observables.StringObservable;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultRowModel  {
	protected Activity mContext;
	public ResultRowModel(Activity context) {
		this.mContext = context;
	}

	//�����ĵ��е������ֶ�
	//resuleid=108848  resultCode=108847 slipDep=����� slipSpot=���� usertype=���� repairCode=B2010120800372 secDep=103 spaceDep=107 secDepname=��������վ spaceDepname=�ͷ�  

	//resuleid   ��ά�޼�¼��id
	//����������ݴӷ�����ά�޵��õ� ����
	//resultCode  �ӷ����õ���id
	//secDep=103 spaceDep=107 secDepname=��������վ spaceDepname=�ͷ�
	
	public StringObservable resuleid = new StringObservable(""); 
	public StringObservable resultCode = new StringObservable(""); 
	public StringObservable secDep = new StringObservable(""); 
	public StringObservable spaceDep = new StringObservable(""); 
	public StringObservable secDepname = new StringObservable(""); 
	public StringObservable spaceDepname = new StringObservable(""); 
	public String ID;
	//ά�޴���
	public StringObservable CUCODE = new StringObservable(""); 
	//�û�����
	public StringObservable usertype = new StringObservable(""); 
	//����λ��
	public StringObservable slipSpot = new StringObservable(""); 
	//�����豸
	public StringObservable slipDep = new StringObservable(""); 
	//��ϸ�����豸 �µ�
	public StringObservable slipDetadep = new StringObservable(""); 
	//����ԭ�� �µ�
	public StringObservable slipReason = new StringObservable(""); 
	//ά�޽�� �µ�
	public StringObservable repairResult = new StringObservable(""); 
	//�������� �µ�
	public StringObservable newIcType = new StringObservable(""); 
	//ת������ �µ�
	public StringObservable moveGas = new StringObservable(""); 
	//�Ƿ��շ� �µ�
	public StringObservable isMoney = new StringObservable(""); 
	//���� �µ�
	public StringObservable money = new StringObservable(""); 
	//����� �µ�
	public StringObservable biaonum = new StringObservable(""); 
	//��ע �µ�
	public StringObservable mark = new StringObservable(""); 
	//ά��ʱ�� �µ�
	public StringObservable repairDate = new StringObservable(""); 
	
	public ArrayListObservable<String>lstUsertype = new ArrayListObservable<String>(String.class);
	public ArrayListObservable<String>lstSlipSpot = new ArrayListObservable<String>(String.class);
	public ArrayListObservable<String>lstSlipDep = new ArrayListObservable<String>(String.class);
	public ArrayListObservable<String>lstSlipDetadep = new ArrayListObservable<String>(String.class);
	public ArrayListObservable<String>lstSlipReason = new ArrayListObservable<String>(String.class);
	public ArrayListObservable<String>lstRepairResult = new ArrayListObservable<String>(String.class);
	public ArrayListObservable<String>lstIcType = new ArrayListObservable<String>(String.class);
	public ArrayListObservable<String>lstIsMoney = new ArrayListObservable<String>(String.class);

	public static String[] aUserType = {"����","����","����"};
	public static String[] aSlipSpot = {"����","����"};
	public static String[][] aSlipDep = {
		{"��¥ѹ����","��¥ѹ����","��¥����","��¯��ѹ����","��¯��ѹ����","��¯������","����ܵ�","ͥԺ�ܵ�","ͥԺ����","��ѹ��","����"},
		{"���","���","�ܵ�","���Ź���","�����","����"},
		{"��¯��ѹ����","��¯��ѹ����","��¯������","����ܵ�","ͥԺ�ܵ�","ͥԺ����","��ѹ��","����"},
		{"���","���","�ܵ�","���Ź���","�����","����"},
		{"����ѹ����","����ѹ����","��������","����ܵ�","��ѹ��","����"},
		{"���","�ܵ�","���Ź���","�����","����"}
	}; 
	
	public static String[] pipes = {"��ǰ��", "�����"};
	public static String[] valves = {"�Աշ�", "ͭ��", "��ǰ��"};
	public static String[] pipeCauses = {"����", "©��"};
	public static String[] valveCauses ={"©��", "�ѻ�"};
	
	public static String[] aResults = {"����","���ܵ�", "����", "����", "����ǰ��", "�����", "����ѹ��", "���Աշ�", "���޺�", "��", "��ͭ��"};
	public static String[] aCards = {"���ݼ���(10)","���ݼ���(12)", "������ͨ(10)", "������ͨ(12)", "�ظ�", "�ش�", "����", "�����ϱ�", "�����±�", "�ظ۹�ҵ", "����", "��Ȼ������", "��ҵ����"};
	
	public static String[] bools = {"��", "��"};
	
	public void fillUserType()
	{
		lstUsertype.setArray(aUserType);
	}
	
	public void fillCharge()
	{
		lstIsMoney.setArray(bools);
	}
	
	public void fillSlipSpot()
	{
		lstSlipSpot.setArray(aSlipSpot);
	}
	
	public void fillResult()
	{
		lstRepairResult.setArray(ResultRowModel.aResults);
	}
	
	public void fillCards()
	{
		this.lstIcType.setArray(ResultRowModel.aCards);
	}
	
	public void fillSlipDep(String userType, String indoorOutdoor)
	{
		int idx1 = find(ResultRowModel.aUserType, userType);
		int idx2 = 0;
		if(indoorOutdoor.equals("����"))
			idx2 = 1;
		lstSlipDep.clear();
		lstSlipDep.setArray(ResultRowModel.aSlipDep[idx1*2 + idx2]);
	}

	private int find(String[] array, String item) {
		for(int i=0; i<array.length; i++)
			if(array[i].equals(item))
				return i;
		return 0;
	}
	
	public void fillSlipDetadep(String userType, String dev)
	{
		if(userType.equals("����"))
		{
			this.lstSlipDetadep.clear();
			this.lstSlipReason.clear();
			return;
		}
		if(dev.equals("�ܵ�"))
		{
			this.lstSlipDetadep.setArray(ResultRowModel.pipes);
			this.lstSlipReason.setArray(ResultRowModel.pipeCauses);
		}
		else if(dev.equals("���Ź���"))
		{
			if(userType.equals("����"))
			{
				this.lstSlipDetadep.setArray(ResultRowModel.pipes);
				this.lstSlipReason.setArray(ResultRowModel.pipeCauses);
			}
			else
			{
				this.lstSlipDetadep.setArray(ResultRowModel.valves);
				this.lstSlipReason.setArray(ResultRowModel.valveCauses);
			}
		}
		else if(dev.equals("���") ||dev.equals("���"))
		{
			this.lstSlipDetadep.clear();
			this.lstSlipReason.setArray(ResultRowModel.pipeCauses);
		}
		else
		{
			this.lstSlipDetadep.clear();
			this.lstSlipReason.clear();
		}
	}	
	
	public Command onDelete = new Command()
	{
		@Override
		public void Invoke(View arg0, Object... arg1) {
			TextView tv = new TextView(mContext);
			tv.setText("ȷ��Ҫɾ����");
			Dialog alertDialog = new AlertDialog.Builder(mContext).   
					setView(tv).
					setTitle("ȷ��").   
					setIcon(android.R.drawable.ic_dialog_info).
					setPositiveButton("ȷ��", new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface dialog, int which) {
							SQLiteDatabase db = null;
							try
							{
								db = mContext.openOrCreateDatabase(Util.getDBName(mContext), Context.MODE_PRIVATE, null);
								String sql ="delete from T_BX_REPAIR_RESULT where resuleid=?";
								db.execSQL(sql, new Object[]{resuleid.get()});
								((RepairResultActivity)mContext).deleteARow(ResultRowModel.this);
								Toast.makeText(mContext, "ɾ���ɹ���", Toast.LENGTH_SHORT).show();
							}
							catch(Exception e)
							{
								e.printStackTrace();
								Toast.makeText(mContext, "ɾ��ʧ�ܣ�", Toast.LENGTH_SHORT).show();
							}
							finally
							{
								if(db != null)
									db.close();
							}		
						}
					}).setNegativeButton("ȡ��", null).
					create();  
			alertDialog.setCancelable(false);
			alertDialog.show();
		}
		
	};
}
