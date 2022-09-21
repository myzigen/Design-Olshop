package com.github.dapitramdhan.UserSetting;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.github.dapitramdhan.MainActivity;
import com.github.dapitramdhan.R;
import android.view.View;

public class LoginActivity extends AppCompatActivity{
	
	CardView cardViewLogin;
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.login_activity);
		
		cardViewLogin = findViewById(R.id.cardview_login);
		cardViewLogin.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent login = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(login);
				finish();
			}
		});
		
		
	}
}