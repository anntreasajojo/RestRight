package com.example.restright;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restright.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    String clickedSkillButton = "";
    String clickedExerciseGoalButton = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        getInformationFromDisplay();
    }

    private void getInformationFromDisplay() {
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

        ///TODO: make it so that the user is only able to click one option for skill level
        //get skill level from UI

        //user clicked beginner
        binding.skillLevelBeginnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if a skill option is already selected

                //if clicked skill button variable  is already assigned (aka not empty) then let user know they can only make one option
                if(!clickedSkillButton.isEmpty()){
                    showLimitToast();
                    return;
                }
                clickedSkillButton = "Beginner";
                highlightSelectedOption("Beginner");
            }
        });

        //user clicked intermediate
        binding.skillLevelIntermediateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if an skill option is already selected
                if(!clickedSkillButton.isEmpty()){
                    showLimitToast();
                    return;
                }
                clickedSkillButton = "Intermediate";
                highlightSelectedOption("Intermediate");
            }
        });

        //user clicked advanced
        binding.skillLevelAdvancedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if an skill option is already selected
                if(!clickedSkillButton.isEmpty()){
                    showLimitToast();
                    return;
                }
                clickedSkillButton = "Advanced";
                highlightSelectedOption("Advanced");
            }
        });

        ///TODO: make it so that the user is only able to click one option for exercise goal
        //get exercise goal from UI

        //user clicked strength
        binding.strengthGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if an exercise goal is already selected
                if(!clickedExerciseGoalButton.isEmpty()){
                    showLimitToast();
                    return;
                }
                clickedExerciseGoalButton = "Strength";
                highlightSelectedOption("Strength");
            }
        });

        //user clicked muscle mass
        binding.muscleMassGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if an exercise goal is already selected
                if(!clickedExerciseGoalButton.isEmpty()){
                    showLimitToast();
                    return;
                }
                clickedExerciseGoalButton = "Muscle Mass";
                highlightSelectedOption("Muscle Mass");

            }
        });

        //user clicked endurance
        binding.enduranceGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if an exercise goal is already selected
                if(!clickedExerciseGoalButton.isEmpty()){
                    showLimitToast();
                    return;
                }
                clickedExerciseGoalButton = "Endurance";
                highlightSelectedOption("Endurance");
            }
        });

        //user clicks calculate button
        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(clickedSkillButton.isEmpty()){
//                    Toast toast = Toast.makeText(this, "Must Select Skill Level!", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
                calculateRest(clickedSkillButton, clickedExerciseGoalButton);
            }
        });


        //user clicks reset button
        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetOptions();
            }
        });

    }

    private void calculateRest(String skillLevel, String exerciseGoal) {
        //key notes
        //beginner + strength = 300 seconds
        //beginner + muscle mass = 90 seconds
        //beginner + endurance = 60 seconds

        //intermediate + strength = 180 seconds
        //intermediate + muscle mass = 60 seconds
        //intermediate + endurance = 40 seconds

        //advanced + strength = 120 seconds
        //advanced + muscle mass = 30 seconds
        //advanced + endurance = 20 seconds

        if(skillLevel.equalsIgnoreCase("Beginner") && exerciseGoal.equalsIgnoreCase("Strength")){
            binding.calculatedTimeTextView.setText("300 seconds");
        }else if(skillLevel.equalsIgnoreCase("Beginner") && exerciseGoal.equalsIgnoreCase("Muscle Mass")){
            binding.calculatedTimeTextView.setText("90 seconds");
        }else if(skillLevel.equalsIgnoreCase("Beginner") && exerciseGoal.equalsIgnoreCase("Endurance")){
            binding.calculatedTimeTextView.setText("60 seconds");
        }

        if(skillLevel.equalsIgnoreCase("Intermediate") && exerciseGoal.equalsIgnoreCase("Strength")){
            binding.calculatedTimeTextView.setText("180 seconds");
        }else if(skillLevel.equalsIgnoreCase("Intermediate") && exerciseGoal.equalsIgnoreCase("Muscle Mass")){
            binding.calculatedTimeTextView.setText("60 seconds");
        }else if(skillLevel.equalsIgnoreCase("Intermediate") && exerciseGoal.equalsIgnoreCase("Endurance")){
            binding.calculatedTimeTextView.setText("40 seconds");
        }

        if(skillLevel.equalsIgnoreCase("Advanced") && exerciseGoal.equalsIgnoreCase("Strength")){
            binding.calculatedTimeTextView.setText("120 seconds");
        }else if(skillLevel.equalsIgnoreCase("Advanced") && exerciseGoal.equalsIgnoreCase("Muscle Mass")){
            binding.calculatedTimeTextView.setText("30 seconds");
        }else if(skillLevel.equalsIgnoreCase("Advanced") && exerciseGoal.equalsIgnoreCase("Endurance")){
            binding.calculatedTimeTextView.setText("20 seconds");
        }

    }

    private void resetOptions() {
        if(clickedSkillButton.equalsIgnoreCase("Beginner")){
            binding.skillLevelBeginnerButton.setBackgroundColor(Color.parseColor("#948979"));
            binding.skillLevelBeginnerButton.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if(clickedSkillButton.equalsIgnoreCase("Intermediate")){
            binding.skillLevelIntermediateButton.setBackgroundColor(Color.parseColor("#948979"));
            binding.skillLevelIntermediateButton.setTextColor(Color.parseColor("#FFFFFF"));

        }

        if(clickedSkillButton.equalsIgnoreCase("Advanced")){
            binding.skillLevelAdvancedButton.setBackgroundColor(Color.parseColor("#948979"));
            binding.skillLevelAdvancedButton.setTextColor(Color.parseColor("#FFFFFF"));

        }

        if(clickedExerciseGoalButton.equalsIgnoreCase("Strength")){
            binding.strengthGoalButton.setBackgroundColor(Color.parseColor("#948979"));
            binding.strengthGoalButton.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if(clickedExerciseGoalButton.equalsIgnoreCase("Muscle Mass")){
            binding.muscleMassGoalButton.setBackgroundColor(Color.parseColor("#948979"));
            binding.muscleMassGoalButton.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if(clickedExerciseGoalButton.equalsIgnoreCase("Endurance")){
            binding.enduranceGoalButton.setBackgroundColor(Color.parseColor("#948979"));
            binding.enduranceGoalButton.setTextColor(Color.parseColor("#FFFFFF"));
        }

        clickedSkillButton = "";
        clickedExerciseGoalButton = "";

        binding.calculatedTimeTextView.setText("____ seconds");

        getInformationFromDisplay();

    }

    private void highlightSelectedOption(String option){
        ///TODO: create a reset button that lets you calculate other rest time combinations

        if(option.equalsIgnoreCase("Beginner")){
            binding.skillLevelBeginnerButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
            binding.skillLevelBeginnerButton.setTextColor(Color.parseColor("#948979"));
        }

        if(option.equalsIgnoreCase("Intermediate")){
            binding.skillLevelIntermediateButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
            binding.skillLevelIntermediateButton.setTextColor(Color.parseColor("#948979"));
        }

        if(option.equalsIgnoreCase("Advanced")){
            binding.skillLevelAdvancedButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
            binding.skillLevelAdvancedButton.setTextColor(Color.parseColor("#948979"));
        }

        if(option.equalsIgnoreCase("Strength")){
            binding.strengthGoalButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
            binding.strengthGoalButton.setTextColor(Color.parseColor("#948979"));
        }

        if(option.equalsIgnoreCase("Muscle Mass")){
            binding.muscleMassGoalButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
            binding.muscleMassGoalButton.setTextColor(Color.parseColor("#948979"));
        }

        if(option.equalsIgnoreCase("Endurance")){
            binding.enduranceGoalButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
            binding.enduranceGoalButton.setTextColor(Color.parseColor("#948979"));
        }

    }

    private void showLimitToast() {
        Toast toast = Toast.makeText(this, "One choice only! Reset to change.", Toast.LENGTH_SHORT);
        toast.show();
    }


}