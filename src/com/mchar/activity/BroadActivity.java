package com.mchar.activity;

import android.app.Activity;
import android.os.Bundle;

import com.mchar.R;

public class BroadActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.logo);
  }

}
