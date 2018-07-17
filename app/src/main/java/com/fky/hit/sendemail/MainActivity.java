package com.fky.hit.sendemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText address;
    private EditText title;
    private EditText message;
    private Button myBut;
    private String Saddress;
    private String Ssubject;
    private String Scontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        address = findViewById(R.id.address);
        title = findViewById(R.id.Title);
        message = findViewById(R.id.mail);
        myBut = findViewById(R.id.myBut);
        address.getText().toString();
        Saddress = address.getText().toString();
        Ssubject = title.getText().toString();
        Scontent = message.getText().toString();
        this.myBut.setOnClickListener(new OnClickListenerEmail());
    }
    private class OnClickListenerEmail implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL,Saddress);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,Ssubject);
            emailIntent.putExtra(Intent.EXTRA_TEXT,Scontent);
            MainActivity.this.startActivity(emailIntent);
        }
    }
}
