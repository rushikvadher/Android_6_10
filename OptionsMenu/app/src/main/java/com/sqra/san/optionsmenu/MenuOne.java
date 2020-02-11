package com.sqra.san.optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_one);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_option1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        int  menuId = mi.getItemId();
        switch (menuId){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 selected",Toast.LENGTH_LONG).show();
                break;
            case  R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                Toast.makeText(getApplicationContext(),"Item 4 selected",Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(mi);
        }

        return true;
    }
}
