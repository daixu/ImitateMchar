package com.mchar.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.mchar.R;

public class MainActivity extends TabActivity implements TabHost.OnTabChangeListener, OnCheckedChangeListener {
  private TabHost mTabHost;

  @Override
  protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main);

    mTabHost = getTabHost();
    mTabHost.setOnTabChangedListener(this);

    initRadios();

    // Setup the tabs
    setupDialogueTab();
    setupBroadCastTab();
    setupFriendTab();
    setupVisitCardTab();
  }

  private void initRadios() {
    ((RadioButton) findViewById(R.id.radio_button0)).setOnCheckedChangeListener(this);
    ((RadioButton) findViewById(R.id.radio_button1)).setOnCheckedChangeListener(this);
    ((RadioButton) findViewById(R.id.radio_button2)).setOnCheckedChangeListener(this);
    ((RadioButton) findViewById(R.id.radio_button3)).setOnCheckedChangeListener(this);
  }

  /**
   * 对话
   */
  private void setupDialogueTab() {
    Intent intent = new Intent(this, DialogueActivity.class);

    mTabHost.addTab(mTabHost.newTabSpec("dialogue")
        .setIndicator(getString(R.string.dialogue), getResources().getDrawable(R.drawable.tab_bottom_icon_conv_hover))
        .setContent(intent));
  }

  /**
   * 广播
   */
  private void setupBroadCastTab() {
    Intent intent = new Intent(this, BroadActivity.class);

    mTabHost.addTab(mTabHost.newTabSpec("broadcast")
        .setIndicator(getString(R.string.broadcast), getResources().getDrawable(R.drawable.tab_bottom_icon_wall_hover))
        .setContent(intent));
  }

  /**
   * 好友
   */
  private void setupFriendTab() {
    Intent intent = new Intent(this, FriendActivity.class);

    mTabHost.addTab(mTabHost.newTabSpec("friend")
        .setIndicator(getString(R.string.friend),
            getResources().getDrawable(R.drawable.tab_bottom_icon_friend_hover)).setContent(intent));
  }

  private void setupVisitCardTab() {
    Intent intent = new Intent(this, VisitCardActivity.class);
    mTabHost.addTab(mTabHost.newTabSpec("visit_card")
        .setIndicator(getString(R.string.visit_card), getResources().getDrawable(R.drawable.tab_nc_pressed))
        .setContent(intent));
  }

  @Override
  public void onTabChanged(String arg0) {
  }

  @Override
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    if (isChecked) {
      switch (buttonView.getId()) {
      case R.id.radio_button0:
        this.mTabHost.setCurrentTabByTag("dialogue");
        break;
      case R.id.radio_button1:
        this.mTabHost.setCurrentTabByTag("broadcast");
        break;
      case R.id.radio_button2:
        this.mTabHost.setCurrentTabByTag("friend");
        break;
      case R.id.radio_button3:
        this.mTabHost.setCurrentTabByTag("visit_card");
        break;
      }
    }
  }
}