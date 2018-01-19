package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private SwitchToggleView mView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		mView = (SwitchToggleView) findViewById(R.id.stv);

		mView.setSwitchBackground(R.drawable.switch_background);
		mView.setSwitchSlide(R.drawable.slide_button_background);setContentView(R.layout.activity_main);

		mView = (SwitchToggleView) findViewById(R.id.stv);

		mView.setSwitchBackground(R.drawable.switch_background);
		mView.setSwitchSlide(R.drawable.slide_button_background);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
