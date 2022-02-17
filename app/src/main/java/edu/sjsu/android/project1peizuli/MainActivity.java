package edu.sjsu.android.project1peizuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.math.BigDecimal;

import edu.sjsu.android.project1peizuli.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.button.setOnClickListener(this::onClick);
        binding.button2.setOnClickListener(this::onClick2);
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                double p = progress / 10.0;
                String text = "" + p + "%";
                binding.textView7.setText(text);
                binding.textView6.setText(R.string.task);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onClick(View view){
        if(binding.textView.getText().length() == 0){
            binding.textView6.setText(R.string.noInput);
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
            return;
        }
        else if(BigDecimal.valueOf(Double.parseDouble(
                binding.textView.getText().toString())).scale()>2){
            binding.textView6.setText(R.string.wrongInput);
            Toast.makeText(this, "Invalid Input",Toast.LENGTH_LONG).show();
            return;
        }

        double principle = Double.parseDouble(binding.textView.getText().toString());
        double interest = binding.seekBar.getProgress()/1000.0;
        int year;
        boolean tax = false;
        if(binding.radioButton.isChecked()){
            year = 15;
        }
        else if(binding.radioButton2.isChecked()){
            year = 20;
        }
        else{
            year = 30;
        }
        if(binding.checkBox.isChecked()){
            tax = true;
        }

        String result = "Your monthly payment is " +
                MortgageCalculation.calc(principle, interest, year, tax);
        binding.textView6.setText(result);
    }

    public void onClick2 (View view){
        Intent delete = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + getPackageName()));
        startActivity(delete);
    }
}