package com.saipavan.espcontrolerv4;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String ipPattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    EditText ip_address1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button IP_btn = findViewById(R.id.ip_btn);
        ip_address1 = findViewById(R.id.ip_address);
        IP_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String ip = ip_address1.getText().toString();
        if (validate(ip)) {
            Bundle bundle = new Bundle();
            bundle.putString("IP", ip);
            Intent intent = new Intent(this, controler.class);
            intent.putExtra("DATA", bundle);
            startActivity(intent);
        }else{
            Toast.makeText(this,"invalid ip formate",Toast.LENGTH_LONG).show();
        }
    }
    private boolean validate(String ip) {
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
