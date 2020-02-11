package com.sqra.san.optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menu1F(View view){
        Intent intent = new Intent(this, MenuOne.class);
        startActivity(intent);
    }

    public void menu2F(View view){
        Intent intent = new Intent(this, MenuTwo.class);
        startActivity(intent);
    }

}
