package com.example.serversocke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    TextView textView ;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        text = (String) textView.getText().toString();
        new AsyncTask(){

            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    Socket socket = new Socket("192.168.1.100",30000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(text.getBytes());
                    outputStream.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }
}
