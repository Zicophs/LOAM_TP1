package com.example.tp1_loam

import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Flash : AppCompatActivity() {

    var hasFlash : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
        val cameraManager : CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        val back : Button = findViewById(R.id.b_back_flash)

        var flash : Switch = findViewById(R.id.s_flash)

        if(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
                Toast.makeText(this@Flash, "This device has flash", Toast.LENGTH_SHORT).show()
                flash.isEnabled = true;
                cameraManager.setTorchMode("0",true)
                hasFlash = true
            }else {
                Toast.makeText(this@Flash, "This device has no flash", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this@Flash, "This device has no camera", Toast.LENGTH_SHORT).show()
        }

        if(hasFlash){
            flash.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    try {
                        cameraManager.setTorchMode("0", false)
                        flash.text = "Flash Off"
                    } catch (e : CameraAccessException){
                        e.printStackTrace()
                    }
                } else {
                    try {
                        cameraManager.setTorchMode("0", true)
                        flash.text = "Flash On"
                    } catch (e : CameraAccessException){
                        e.printStackTrace()
                    }
                }
            }
        }


        back.setOnClickListener(){
            cameraManager.setTorchMode("0", false)
            val intent_menu = Intent(this, MainActivity::class.java)
            startActivity(intent_menu)
        }
    }
}