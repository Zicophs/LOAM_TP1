package com.example.tp1_loam


import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val close : Button = findViewById(R.id.b_close)
        val flash : Button = findViewById(R.id.b_flash)
        val camera : Button = findViewById(R.id.b_camera)
        val selfie : Button = findViewById(R.id.b_selfie)
        val gps : Button = findViewById(R.id.b_gps)
        val steps : Button = findViewById(R.id.b_steps)

        flash.setOnClickListener(){
            val intent_flash = Intent(this, Flash::class.java)
            startActivity(intent_flash)
        }

        camera.setOnClickListener(){
            val intent_camera = Intent(this, Camera::class.java)
            startActivity(intent_camera)
        }

        selfie.setOnClickListener(){
            val intent_selfie = Intent(this, Selfie::class.java)
            startActivity(intent_selfie)
        }

        gps.setOnClickListener(){
            val intent_gps = Intent(this, GPS::class.java)
            startActivity(intent_gps)
        }

        steps.setOnClickListener(){
            val intent_steps = Intent(this, StepsCounter::class.java)
            startActivity(intent_steps)
        }

        close.setOnClickListener(){
            finishAffinity()
        }
    }
}