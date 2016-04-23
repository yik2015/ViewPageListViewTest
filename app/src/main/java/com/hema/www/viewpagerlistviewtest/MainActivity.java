package com.hema.www.viewpagerlistviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager's layout(layout_viewpager) need to set to a specific value, such as 120dp,
        // not match_parent or wrap_content, thus it displays.
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ListViewAdapter(this));
    }
}
