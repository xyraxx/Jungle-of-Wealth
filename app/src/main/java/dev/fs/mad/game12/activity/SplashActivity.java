package dev.fs.mad.game12.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.WindowManager;

import dev.fs.mad.game12.R;
import dev.fs.mad.game12.libs.NetworkLibrary;

public class SplashActivity extends AppCompatActivity {

    private NetworkLibrary networkReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_splash);

        networkReceiver = new NetworkLibrary();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (NetworkLibrary.isNetworkAvailable(this)) {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
                finish();
            } else {
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                finish();
            }
        }, 1800);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkReceiver);
    }
}