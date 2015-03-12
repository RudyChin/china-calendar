package com.china.calendar;

import java.util.Calendar;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.widget.RemoteViews;

public class MyTimeSetReceiver extends BroadcastReceiver {
	
	private static String[] weekArray ={"日","一","二","三","四","五","六"}; 
	
	 public void onReceive(Context context, Intent intent) {
		 
		 Log.d("TimeSetReceiver", "onReceive");
		 
		 RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.my_widget);
		 
		 ComponentName thisWidget; //组件名
	     AppWidgetManager manager; // AppWidget管理器

	     thisWidget = new ComponentName(context, CalendarWidget.class);
	     manager = AppWidgetManager.getInstance(context);	     
	     
		 
		Calendar calendar = Calendar.getInstance();		
		
		int day = calendar.get(Calendar.DAY_OF_MONTH);				
		int month = calendar.get(Calendar.MONTH)+1;		
		int week = calendar.get(Calendar.DAY_OF_WEEK)-1;			
		Lunar lunar = new Lunar(calendar);  
		
		Log.d("TimeSetReceiver", month+","+day+lunar.toString());
		
		String month_week = month+"月"+"          周"+weekArray[week];			
		views.setTextViewText(R.id.month_week,month_week);
		views.setTextViewText(R.id.nongli,lunar.toString());
		views.setTextViewText(R.id.day,Html.fromHtml("<B>"+String.valueOf(day)+"</B>"));
		
		manager.updateAppWidget(thisWidget, views);
		
		Log.d("TimeSetReceiver", "updateAppWidget finish");
				
			
	 }

}
