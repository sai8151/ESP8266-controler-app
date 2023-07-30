package com.saipavan.espcontrolerv4;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class controler extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controler);
        final int[] i = {0};
        final AtomicBoolean b = new AtomicBoolean(true);
//buttons init

        Button gpio_0_1 = findViewById(R.id.gpio_0_1);
        TextView tv=findViewById(R.id.log);
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


        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.post(() -> scrollView.smoothScrollTo(0, tv.getBottom()));
//listeners init
//gpio 0 d3 on front
        gpio_0_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio0/1");
                addjs(webView,tv, i[0]++);
                b.set(false);
            }
        });

//gpio 0 d3 off button
        gpio_0_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio0/0");
                addjs(webView,tv, i[0]++);
            }
        });
        gpio_2_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio2/0");
                addjs(webView,tv, i[0]++);
            }
        });
        gpio_2_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio2/1");
                addjs(webView,tv, i[0]++);
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
                addjs(webView,tv, i[0]++);
            }
        });
        gpio_4_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio4/1");
                addjs(webView,tv, i[0]++);
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
                addjs(webView,tv, i[0]++);
            }
        });
        gpio_5_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio5/1");
                addjs(webView,tv, i[0]++);
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
                addjs(webView,tv, i[0]++);
            }
        });
        gpio_16_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://"+ip_adr+"/gpio16/1");
                addjs(webView,tv, i[0]++);
            }
        });
    }

    private void addjs(WebView webView,TextView tv,final int i) {
        webView.evaluateJavascript("(function(){return document.documentElement.innerText})();", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                //display log.....
                String str = value.replace("\\n", Objects.requireNonNull(System.getProperty("line.separator")));
                tv.append(str + '\n'+'\n');
                if(i==19){
                    tv.setText("");
                }
            }
        });
    }
}
