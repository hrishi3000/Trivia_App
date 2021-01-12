package com.appscrip.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appscrip.myapplication.R
import kotlinx.android.synthetic.main.activity_national_flag.*

//Activity for selecting flag color
class NationalFlagActivity : AppCompatActivity() {
    var player_name: String? = ""
    var cricketer_name: String? = ""
    var game_date: String? = ""

    var flag_colors = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_national_flag)
        //set the title and the back button on toolbar
        supportActionBar!!.title = "Select Flag Color";
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);

        //Getting Player Name and selected Cricketer Name from Cricketer Activity via bundle
        val bundle = intent.extras
        player_name = bundle!!.getString("player_name").toString()
        cricketer_name = bundle!!.getString("cricketer_name").toString()
        game_date = bundle!!.getString("game_date").toString()

        //Button to navigate to Summary Activity
        btnNextFlagActivity.setOnClickListener {


            //checks whether the ArrayList of flag is empty
            if (flag_colors.isNullOrEmpty()) {
                Toast.makeText(this, "Please Select at least one color", Toast.LENGTH_SHORT).show()


            } else {
                //Sending data through bundle
                //to Summary Activity
                val bundle = Bundle()
                bundle.putString("player_name", player_name)
                bundle.putString("cricketer_name", cricketer_name)
                bundle.putString("game_date", game_date)
                bundle.putString("flag_colors", flag_colors.joinToString())
                val intent = Intent(this, SummaryActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }


        }

        //Checkbox with option A
        cbOptionA.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                addFlagColors(buttonView.text.toString(), cbOptionA)

            } else {
                removeFlagColors(buttonView.text.toString())

            }
        }
        //Checkbox with option B
        cbOptionB.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                addFlagColors(buttonView.text.toString(), cbOptionB)

            } else {
                removeFlagColors(buttonView.text.toString())

            }
        }

        //Checkbox with option C
        cbOptionC.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                addFlagColors(buttonView.text.toString(), cbOptionC)

            } else {
                removeFlagColors(buttonView.text.toString())

            }
        }

        //Checkbox with option D
        cbOptionD.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                addFlagColors(buttonView.text.toString(), cbOptionD)

            } else {
                removeFlagColors(buttonView.text.toString())

            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    //Function to add the selected checkbox text to the flag_colors array list
    //if the flag_colors size exceeds 3 it will show a toast
    //else it will add the selected color in the checkbox
    private fun addFlagColors(color: String, checkBox: CheckBox) {

        if (flag_colors.size == 3) {
            checkBox.isChecked = false

            Toast.makeText(this, "You can select maximum 3 colors", Toast.LENGTH_SHORT).show()
        } else {

            flag_colors.add(color)
        }

    }

    //Function to remove the selected checkbox text from the flag_colors array list
    //if the flag_colors size exceeds 0 it will show a toast
    //else it will remove the selected color in the checkbox
    private fun removeFlagColors(color: String) {

        if (flag_colors.size <= 0) {

            Toast.makeText(this, "You need to select a color", Toast.LENGTH_SHORT).show()
        } else {

            flag_colors.remove(color)
        }

    }
}