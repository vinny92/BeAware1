package com.application.beaware;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Main extends Activity {
//This is the splash screen
	MediaPlayer logoThemeMusic;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		//music
		logoThemeMusic =  MediaPlayer.create(Main.this, R.raw.introtheme);
		logoThemeMusic.start();
		
		//runs splash screen for 6s
		Thread logoTimer = new Thread(){
			public void run(){
				try{
					sleep(4000);
					Intent menuIntent = new Intent("com.application.beaware.MENU");
					startActivity(menuIntent);
				} 
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				finally{
					finish();
				}
			}
		};
		logoTimer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		logoThemeMusic.release();
	}

}


