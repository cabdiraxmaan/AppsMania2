package com.example.appsmania2;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	 TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
    text=(TextView)findViewById(R.id.textview);
  final EditText edit=(EditText)findViewById(R.id.edittext);

  LoadPreferences();
    Button button=(Button)findViewById(R.id.button);
    
    button.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			
             text.append(edit.getText().toString());	   
		}	   
    
    });
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        
        return true;
    }
  
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	 int id = item.getItemId();
         if (id == R.id.settings) {
             return true;
         }else if( id== R.id.menu1){
        	 Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
		    	
		    	startActivity(myIntent);
        	 
        	 return true;
         }else if (id==R.id.menu2){
        	 finish();
        	 return true;
         }else if (id==R.id.menu3){
        	 return true;
         }else if (id==R.id.menu4){
        	 return true;
         }
         return super.onOptionsItemSelected(item);
      
    
    }
    private void SavePreferences(String key, String value){
	    SharedPreferences sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
	    SharedPreferences.Editor editor = sharedPreferences.edit();
	    editor.putString(key, value);
	    editor.commit();
	   }
	  
	   private void LoadPreferences(){
	    SharedPreferences sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
	    String strSavedMem1 = sharedPreferences.getString("MEM1", "");
	    String strSavedMem2 = sharedPreferences.getString("MEM2", "");
	    
	  text.setText(strSavedMem1);
	    	   
	    //textSavedMem2.setText(strSavedMem2);
	   }
	
	   @Override
	   public void onBackPressed() {
		 
		   SavePreferences("MEM1", text.getText().toString());
	       
		 finish();
	         
	   }
}
