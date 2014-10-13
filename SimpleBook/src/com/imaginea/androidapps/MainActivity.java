package com.imaginea.androidapps;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	int requestCode = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText loginEmailIdText = (EditText) findViewById(R.id.editText_emailId);
		final EditText loginPasswordText = (EditText) findViewById(R.id.editText_password);

		Button btn_login = (Button) findViewById(R.id.btn_login);

		btn_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if ((loginEmailIdText.getText() != null && !""
						.equalsIgnoreCase(loginEmailIdText.getText().toString()))
						&& (loginPasswordText.getText() != null && !""
								.equalsIgnoreCase(loginPasswordText.getText()
										.toString()))) {
					Toast.makeText(getBaseContext(), "Login Successful !!",
							Toast.LENGTH_LONG).show();
					loginEmailIdText.setText(null);
					loginPasswordText.setText(null);

					Intent crudIntent = new Intent(getBaseContext(),
							CRUDActivity.class);

					startActivity(crudIntent);
				} else {
					Toast.makeText(getBaseContext(),
							"Login Failed, Invalid Email Id or Password !!",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		Button btn_clear = (Button) findViewById(R.id.btn_clear);

		btn_clear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				loginEmailIdText.setText(null);
				loginPasswordText.setText(null);
			}
		});

		Button btn_exit = (Button) findViewById(R.id.btn_exit);

		btn_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent homeIntent = new Intent(Intent.ACTION_MAIN);
				homeIntent.addCategory(Intent.CATEGORY_HOME);
				startActivity(homeIntent);
				finish();
				/*
				 * android.os.Process.killProcess(android.os.Process.myPid());
				 * System.exit(1);
				 */
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
