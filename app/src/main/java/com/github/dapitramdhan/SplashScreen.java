package com.github.dapitramdhan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent splashScreen = new Intent(SplashScreen.this,MainActivity.class);
				startActivity(splashScreen);
				finish();
			}
		}, 1500);
	}
}