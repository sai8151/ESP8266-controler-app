package com.esphome.esphomev2;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import java.util.concurrent.atomic.AtomicBoolean;
public class controler extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controler);
        final AtomicBoolean b = new AtomicBoolean(true);
//buttons init
        Button gpio_0_1 = findViewById(R.id.gpio_0_1);
        Button gpio_0_0 = findViewById(R.id.gpio_0_0);
        Button gpio_2_0 = findViewById(R.id.gpio_2_0);
        Button gpio_2_1 = findViewById(R.id.gpio_2_1);
        Button gpio_4_0 = findViewById(R.id.gpio_4_0);
        Button gpio_4_1 = findViewById(R.id.gpio_4_1);
        Button gpio_5_0 = findViewById(R.id.gpio_5_0);
        Button gpio_5_1 = findViewById(R.id.gpio_5_1);
        Button gpio_16_0 = findViewById(R.id.gpio_16_0);
        Button gpio_16_1 = findViewById(R.id.gpio_16_1);
        Bundle bundle=getIntent().getBundleExtra("DATA");
        String ip_adr=bundle.getString("IP");
//listeners init
//gpio 0 d3 on front
        gpio_0_1.setOnClickListener(v -> {
            WebView webView = findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://"+ip_adr+"/gpio0/1");
            b.set(false);
        });
//gpio 0 d3 off button
        gpio_0_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio0/0");
            }
        });
        gpio_2_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio2/0");
            }
        });
        gpio_2_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio2/1");
            }
        });
        //D2
        gpio_4_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio4/0");
            }
        });
        gpio_4_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio4/1");
            }
        });
        //D1
        gpio_5_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio5/0");
            }
        });
        gpio_5_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio5/1");
            }
        });
        //D0 gpio16
        gpio_16_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio16/0");
            }
        });
        gpio_16_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio16/1");
            }
        });
    }
}
