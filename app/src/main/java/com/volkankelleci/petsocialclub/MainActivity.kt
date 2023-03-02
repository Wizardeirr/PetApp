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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


                Handler().postDelayed(Runnable { //This method will be executed once the timer is over
                    // Start your app main activity
                    val i = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(i)
                    // close this activity
                    finish()
                }, 3000)
            }
        }

    }

}
