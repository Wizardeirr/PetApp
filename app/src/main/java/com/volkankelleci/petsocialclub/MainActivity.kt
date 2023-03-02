package com.volkankelleci.petsocialclub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //when i click to any editText window will be move to upside with view
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //we are hiding to ActionBar for splash screen
        supportActionBar?.hide()
        // for splash screen how much second will stop during activity open
        Handler().postDelayed({
        val intent=Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)

        },3000)

            }
        }

