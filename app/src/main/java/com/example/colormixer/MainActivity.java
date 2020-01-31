package com.example.colormixer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int color = 0xff000000;

    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private TextView redSeekBarValueDisplay, greenSeekBarValueDisplay, blueSeekBarValueDisplay;
    private View colorDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFields();
        initListeners();
    }

    private void initFields()
    {
        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);
        redSeekBarValueDisplay = findViewById(R.id.redSeekBarValueDisplay);
        greenSeekBarValueDisplay = findViewById(R.id.greenSeekBarValueDisplay);
        blueSeekBarValueDisplay = findViewById(R.id.blueSeekBarValueDisplay);
        colorDisplay = findViewById(R.id.colorDisplay);
    }

    private void initListeners()
    {
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redSeekBarValueDisplay.setText(progress+"");
                color = (color&0xFF00FFFF)+(progress*0x10000);
                colorDisplay.setBackgroundColor(color);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenSeekBarValueDisplay.setText(progress+"");
                color = (color&0xFFFF00FF)+(progress*0x100);
                colorDisplay.setBackgroundColor(color);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueSeekBarValueDisplay.setText(progress+"");
                color = (color&0xFFFFFF00)+progress;
                colorDisplay.setBackgroundColor(color);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
