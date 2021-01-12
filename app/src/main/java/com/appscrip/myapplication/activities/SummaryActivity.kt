package com.appscrip.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.appscrip.myapplication.R
import com.appscrip.myapplication.helpers.DatabaseHelper
import com.appscrip.myapplication.model.GameModel
import kotlinx.android.synthetic.main.activity_summary.*

//Activity for showing summary
class SummaryActivity : AppCompatActivity() {
    //Creating instance of DatabaseHelper class
    val dbHelper = DatabaseHelper(this, null)

    var player_name: String? = ""
    var cricketer_name: String? = ""
    var flag_colors: String? = ""
    var game_date: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        //Hiding the actionbar/toolbar
        supportActionBar!!.hide();
        //Getting all data from National Flag Activity via bundle
        val bundle = intent.extras
        if (bundle != null) {
            player_name = bundle.getString("player_name").toString()
            cricketer_name = bundle.getString("cricketer_name").toString()
            game_date = bundle.getString("game_date").toString()
            flag_colors = bundle.getString("flag_colors").toString()

            tvPlayerNameSummary.text = "Hello, $player_name"
            tvCricketerSummary.text = "Answer : $cricketer_name"
            tvFlagColors.text = "Answer : $flag_colors"

        }


        //On clicking finish; all the data is added in the database and
        //user is navigated to MainActivity
        btnFinish.setOnClickListener {

            val game = GameModel(game_date, player_name, cricketer_name, flag_colors)
            dbHelper.addGame(game)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}