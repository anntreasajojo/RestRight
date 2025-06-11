package com.example.restright;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restright.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        //must select a skill type
        //must select a exercise goal
        //total of 9 different button combination

        //note: rest times may vary based on age, fiber type, and genetics

        //from healthline.com "the biggest difference in training for muscle size versus strength is in rest between sets.
        //                     Studies have found that to induce muscle hypertrophy [muscle mass], optimal rest intervals are between 30–90 seconds"
        //muscle mass= 30-90 seconds

        //from healthline.com "typical rest periods for increasing strength are between 2–5 minutes.
        //                     This allows the muscles to recover enough to produce a comparable amount of force for the next set."
        //strength = 120-300 seconds

        //from healthline.com "Muscular endurance training typically involves short rest periods between 20–60 seconds."
        //endurance = 20-60 seconds


        //key notes
        //beginner + strength = 300 seconds
        //beginner + muscle mass = 90 seconds
        //beginner + endurance = 60 seconds

        //intermediate + strength = 180 seconds
        //intermediate + muscle mass = 60 seconds
        //intermediate + endurance = 40 seconds

        //advanced + strength = 120 seconds
        //advanced + muscle mass = 30 seconds
        //advanced + endurance = 30 seconds


    }
}