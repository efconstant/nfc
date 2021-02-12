package com.mbds.android.nfc.code;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mbds.android.nfc.code.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //TODO C'est quoi le View Binding ? https://developer.android.com/topic/libraries/view-binding
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        binding.radioButton1.setVisibility(View.INVISIBLE);
        binding.radioButton2.setVisibility(View.INVISIBLE);
        binding.radioButton3.setVisibility(View.INVISIBLE);
        binding.valInput.setVisibility(View.INVISIBLE);
        binding.btnOK.setVisibility(View.INVISIBLE);

//        radioButton1.setVisibility(View.INVISIBLE);
//        radioButton2.setVisibility(View.INVISIBLE);
//        radioButton3.setVisibility(View.INVISIBLE);
//        valInput.setVisibility(View.INVISIBLE);
//        btn_OK.setVisibility(View.INVISIBLE);


        handleActions();
    }

    private void handleActions() {
        binding.btnReadTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NFCReaderActivity.class));
            }
        });

        binding.btnWriteTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show form on click
                binding.radioButton1.setVisibility(View.VISIBLE);
                binding.radioButton2.setVisibility(View.VISIBLE);
                binding.radioButton3.setVisibility(View.VISIBLE);
                binding.valInput.setVisibility(View.VISIBLE);
                binding.btnOK.setVisibility(View.VISIBLE);
                binding.btnOK.setEnabled(false);
                binding.btnWriteTag.setEnabled(false);

                //startActivity(new Intent(MainActivity.this, NFCWriterActivity.class));
            }
        });

        binding.btnBeamP2p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NDEFPushActivity.class));
            }
        });

        binding.btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NFCWriterActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
