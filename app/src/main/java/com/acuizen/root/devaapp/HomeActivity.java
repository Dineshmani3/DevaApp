package com.acuizen.root.devaapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends Activity {

    private TextView mTextMessage;
    Button[] btnWord = new Button[3];
    LinearLayout linear;
    //Button pro1,pro2,pro3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        test();
    }

    private void test() {
        linear = (LinearLayout) findViewById(R.id.linear);
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setMargins(20,40,20,0);
        for (int i = 0; i < btnWord.length; i++) {
            btnWord[i] = new Button(this);
            btnWord[i].setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
            btnWord[i].setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            btnWord[i].setText("Project "+(i+1));
            btnWord[i].setCompoundDrawables(null,null,getResources().getDrawable(R.drawable.ic_chevron_right_white_24dp),null);
            btnWord[i].setBackgroundColor(Color.parseColor("#16A085"));
            btnWord[i].setLayoutParams(layout);
            btnWord[i].setGravity(Gravity.CENTER);
            btnWord[i].setTextColor(Color.WHITE);
            btnWord[i].setOnClickListener(btnClicked);
            linear.addView(btnWord[i]);
        }
    }
    View.OnClickListener btnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             Intent i =new Intent(HomeActivity.this,ProjectDetailActivity.class);
             Button b = (Button)v;
             String buttonText = b.getText().toString();
             i.putExtra("title",buttonText);
             Log.d("Btn Text",buttonText);
             startActivity(i);
        }
    };

}
