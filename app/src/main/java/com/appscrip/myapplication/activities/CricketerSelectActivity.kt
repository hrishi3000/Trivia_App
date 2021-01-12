package com.appscrip.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appscrip.myapplication.R
import kotlinx.android.synthetic.main.activity_cricketer_select.*


//Activity for selecting Best Cricketer
class CricketerSelectActivity : AppCompatActivity() {

    var player_name: String? = ""
    var game_date: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricketer_select)
        //set the title and the back button on toolbar
        supportActionBar!!.title = "Select Cricketer";
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);


        //Getting Player Name from Main Activity via bundle
        val bundle = intent.extras
        player_name = bundle!!.getString("player_name").toString()
        game_date = bundle!!.getString("game_date").toString()


        // Get selected radio button text on clicking the next button
        btnNextCricketerActivity.setOnClickListener {
            // Get the selected radio button id from  the radio group
            var id: Int = rbgCricketer.checkedRadioButtonId
            if (id != -1) {
                // If any radio button is selected from the radio group
                // We will get the instance of radio button using id
                val radio: RadioButton = findViewById(id)

                //Sending the player_name and selected cricketer name through bundle
                //to National Flag Activity to select Flag Colors
                val bundle = Bundle()
                bundle.putString("player_name", player_name)
                bundle.putString("cricketer_name", radio.text.toString())
                bundle.putString("game_date", game_date)
                val intent = Intent(this, NationalFlagActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

            } else {
                // If no radio button checked in this radio group
                Toast.makeText(
                    applicationContext, "Please select a cricketer",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    //overrided function to execute back functionality when clicked on the back arrow
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}