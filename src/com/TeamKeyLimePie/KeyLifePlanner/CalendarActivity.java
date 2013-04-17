package com.TeamKeyLimePie.KeyLifePlanner;



import java.util.ArrayList;
import java.util.Date;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class CalendarActivity extends Activity implements OnClickListener{

	
	EditText taskedit;
	MediaPlayer backgroundCalendar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
		backgroundCalendar = MediaPlayer.create(CalendarActivity.this, R.raw.neogardens);
		backgroundCalendar.setLooping(true);
		backgroundCalendar.start();
		
		Button addTask = (Button)findViewById(R.id.addtask);
		
		addTask.setOnClickListener(this);
       /*taskedit = (EditText)findViewById(R.id.taskname);
       
       taskedit.setOnEditorActionListener(new OnEditorActionListener() {
    	   

		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent arg2) {
			if(actionId == EditorInfo.IME_ACTION_DONE){
				String strvalue = taskedit.getText().toString();
	    		   Log.d("EditText value:", strvalue);
	    		   Log.d("Done", "pressed");
	    		   return true;
			}else
			{
				return false;
			}
		}
       });
      */
		
		
		Task t = new Task("Do homework", "ten");
		Task t1 = new Task("Brush teeth", "six");
		
		ListView task_listview = (ListView) findViewById(R.id.task_list);
		
		
		//task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Sunday));
		
	}
	public class UserItemAdapter extends ArrayAdapter<Task>{

		private ArrayList<Task> tasks;
		
		public UserItemAdapter(Context context, int textViewResourceId,
				ArrayList<Task> tasks) {
			super(context, textViewResourceId, tasks);
			
			this.tasks = tasks;
			// TODO Auto-generated constructor stub
		}
		
		@Override 
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View v = convertView;
			if(v == null){
				Log.d("view", "isnull");
				LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.listitem,null);
			}
			String pos =Integer.toString(position);
			Log.d("pos", pos);
			Task t = tasks.get(position);
			
		
			Log.d("desc", t.description);
			//Log.d("timedue", t.timedue);
			if(t != null){
				TextView description = (TextView)v.findViewById(R.id.description);
				TextView timedue = (TextView)v.findViewById(R.id.timedue);
				if(description != null){
					description.setText(t.description);
				}
				
				if(timedue != null)
				{
					timedue.setText(t.timedue);
				}
				
			
			
		}
			
			return v;

		}

	}
	

	
	@Override
	protected void onPause()
	{
		super.onPause();
		backgroundCalendar.stop();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		backgroundCalendar.start();
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
    	
    	switch (v.getId()){
    	case R.id.addtask:
    		Log.d("click", "Add Task was clicked");
    		
    		i = new Intent (this, AddTaskActivity.class);
    		
    		
    		startActivity(i);
    		break;
    	case R.id.sunday:
    		break;
    	case R.id.monday:
    		break;
    	case R.id.tuesday:
    		break;
    	case R.id.wednesday:
    		break;
    	case R.id.thursday:
    		break;
    	case R.id.friday:
    		break;
    	case R.id.saturday:
    		break;
    	}
	}

	

}

