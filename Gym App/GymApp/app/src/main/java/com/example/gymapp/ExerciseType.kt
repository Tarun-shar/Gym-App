package com.example.gymapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymapp.databinding.ActivityExerciseTypeBinding

class ExerciseType : AppCompatActivity() {

    private lateinit var exAdapterObj : ExItemAdapter
    private lateinit var exDataList : ArrayList<ModelClass2>

    lateinit var binding: ActivityExerciseTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.exToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Back"

        val obj = intent
        val id = obj.getIntExtra("id",-1)

        exDataList = ArrayList()

        when(id){
            0 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest1.gif" , "Normal Push- Ups"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest2.gif" , "Plyometric push- ups"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest3.gif" , "Barbell Bench Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest4.gif" , "Incline Bench Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest5.gif" , "Decline Bench Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest6.gif" , "Chest Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest7.gif" , "Dumbbell Flyes"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest8.gif" , "Dumbbell Chest Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest9.gif" , "Cable Cross- Overs"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest10.gif" , "Chest Dip"))
            }
            1 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep1.gif" , "Close Grip Bench Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep2.gif" , "Triceps Dumbbell Lying Extension"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep3.gif" , "Dips"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep4.gif" , "Triceps Dumbbell Overhead Extension"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep5.gif" , "Triceps Dumbbell One Arm Kickback"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep6.gif", "Triceps Barbell Overhead Extension"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep7.gif" , "Rope PushDown"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep8.gif" , "Triceps Cable PressDown"))
            }
            2 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back1.gif" , "Lat Pulldown"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back2.gif" , "Neutral-Grip Pulldown"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back3.gif" , "Pull-Up"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back4.gif" , "Seated Cable Row"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back5.gif", "Wide-Grip Cable Row"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back6.gif" , "Single-Arm Row"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back7.gif" , "Straight-Arm Pulldown"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back8.gif" , "Face Pull"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back9.gif" , "Bent-Over Row"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back10.gif", "Deadlift"))

            }
            3 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep1.gif" , "Barbell Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep2.gif" , "Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep3.gif" , "Preacher Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep4.gif" , "Dumbbell Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep5.gif", "Incline Dumbbell Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep6.gif" , "Hammer Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep8.gif" , "Concentration Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep9.gif" , "Rope Hammer Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep10.gif" , "Cable Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bicep11.gif" , "Single-Arm High Cable Curl"))
            }
            4 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/shoulder1.gif","Lateral Raise"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/shoulder2.gif","Front Raise"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/shoulder3.gif","Barbell Shoulder Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/shoulder4.gif","Upright Row"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/shoulder5.gif","Barbell Shrug"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/shoulder6.gif","cable stretch"))
            }
            5 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm1.gif","Palms-down Wrist Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm2.gif","Palms-up Wrist Curl"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm3.gif","Reverse Grip EZ Bar Curls"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm4.gif","Plate Pinches"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm5.gif","Grip Roll-Outs"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm6.gif","Palms-Up Cable Behind The Back Wrist Curls"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm7.gif","Towel Cable Row"))
            }
            6 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs1.gif","Crunches"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs2.gif","Bicycle Crunches"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs3.gif","Mountain Climbers"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs4.gif","V-Ups"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs5.gif","Rocking plank"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs6.gif","Russian Twists"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs7.gif","Hanging Leg Raises"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs9.gif","The hundred"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs10.gif","Flutter Kick"))
            }
            7 -> {
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg1.gif","Lunges"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg3.gif","Bulgarian Split Squats"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg4.gif","Lunges"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg5.gif","Hip Thrusts"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg6.gif","Seated Leg Extensions"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg7.gif","Barbell Squats"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg8.gif","Prone Hamstring Curls"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg9.gif","Leg Press"))
                exDataList.add(ModelClass2("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg11.gif","Leg Press Advance"))
            }
            else -> {
                Toast.makeText(this, "Something went wrong!!", Toast.LENGTH_SHORT).show()
            }
        }

        exAdapterObj = ExItemAdapter(exDataList , this)

        binding.exRecyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)

        binding.exRecyclerView.adapter = exAdapterObj

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}