package com.sycs01.internetstatus;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/*SYcS 01*/
public class MainActivity extends AppCompatActivity {
    public static TextView internetStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internetStatus = (TextView)findViewById(R.id.txtstatus);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            changeTextStatus(true);
        } else{
            changeTextStatus(false);
        }
    }

    public void changeTextStatus(boolean isConnected){
        if(isConnected){
            internetStatus.setText("Internet Connected");
            internetStatus.setTextColor(Color.parseColor("#00ff00"));
        }else{
            internetStatus.setText("Internet Disconnected");
            internetStatus.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    private BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
                NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
                if(networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED){
                    changeTextStatus(true);
                } else if(networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED){
                    changeTextStatus(false);
                }
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if (networkReceiver != null)
            unregisterReceiver(networkReceiver);
    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, intentFilter);
    }

}
