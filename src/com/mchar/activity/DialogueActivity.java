package com.mchar.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mchar.R;

public class DialogueActivity extends Activity {

  private ListView mListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dialogue_activity);

    mListView = (ListView) findViewById(R.id.listView1);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);
    mListView.setAdapter(adapter);
    mListView.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Toast.makeText(DialogueActivity.this, String.valueOf(arg2), Toast.LENGTH_LONG).show();
      }
    });
  }

  private static final String[] mStrings = new String[] { "Action", "Adventure", "Animation", "Children", "Comedy",
    "Documentary", "Drama", "Foreign", "History", "Independent", "Romance", "Sci-Fi", "Television", "Thriller" };
}
