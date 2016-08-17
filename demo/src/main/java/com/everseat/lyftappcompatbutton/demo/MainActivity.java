package com.everseat.lyftappcompatbutton.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.everseat.lyftappcompatbutton.LyftAppCompatButton;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    LyftAppCompatButton button = (LyftAppCompatButton) findViewById(R.id.lyft_button_2);
    button.setEtaInSeconds(180);
  }
}
