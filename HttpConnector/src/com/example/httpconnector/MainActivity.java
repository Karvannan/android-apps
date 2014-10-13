package com.example.httpconnector;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	static {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		/* get("/hello", (req, res) -> testMethod()); */
	}

	String response = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView httpURL = (TextView) findViewById(R.id.httpURL);
		final Button btn_invoke = (Button) findViewById(R.id.btn_invoke);
		final TextView httpResponse = (TextView) findViewById(R.id.httpResponse);
		final String URL = httpURL.getText().toString();

		btn_invoke.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					String response = RestUtils.getInstance().GET(URL);
					Toast.makeText(getBaseContext(), response,
							Toast.LENGTH_LONG).show();
					httpResponse.setText(response);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
