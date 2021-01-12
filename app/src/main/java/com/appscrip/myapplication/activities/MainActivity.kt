package com.appscrip.myapplication.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appscrip.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

//Main Activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Validating on button click whether the name is entered
        btnNextMainPage.setOnClickListener {

            if (etPlayerName.text.isNullOrEmpty()) {
                etPlayerName.requestFocus()
                etPlayerName.error = "Please Enter the Name"
            } else {
                //Passing data to the Cricketer Activity using Bundle
                val bundle = Bundle()
                //Passing Player name
                bundle.putString("player_name", etPlayerName.text.toString())
                //Formatting date
                bundle.putString("game_date", getCurrentDateTime().toString("dd MMMM h:mm a"))
                val intent = Intent(this, CricketerSelectActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)


            }
        }


        //Button to view previous game history
        btnViewHistory.setOnClickListener {
            val intent = Intent(this, GameHistoryActivity::class.java)
            startActivity(intent)
        }
    }


    //When back button us presses the app gets closed
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }


    //Function to format date
    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    //Function to get current date and time
    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}