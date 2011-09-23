package com.mchar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.mchar.R;

public class LogoActivity extends Activity {

  private final int SPLASH_DISPLAY_LENGHT = 3000; // 延迟三秒

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.logo);
    new Handler().postDelayed(new Runnable() {

      @Override
      public void run() {
        Intent mainIntent = new Intent(LogoActivity.this, MainActivity.class);
        LogoActivity.this.startActivity(mainIntent);
        LogoActivity.this.finish();
      }
    }, SPLASH_DISPLAY_LENGHT);
  }
}
