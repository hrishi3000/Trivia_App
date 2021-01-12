package com.appscrip.myapplication.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.appscrip.myapplication.R
import com.appscrip.myapplication.adapter.GameHistoryAdapter
import com.appscrip.myapplication.helpers.DatabaseHelper
import com.appscrip.myapplication.model.GameModel
import kotlinx.android.synthetic.main.activity_game_history.*

//Activity for showing Game History
class GameHistoryActivity : AppCompatActivity() {
    //Creating instance of DatabaseHelper class
    val dbHelper = DatabaseHelper(this, null)
    var gameModelArrayList = ArrayList<GameModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_history)
        supportActionBar!!.title = "Game History";
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);


        //Getting all the games from database to the array list and
        // showing it in the recyclerview

        gameModelArrayList = dbHelper.getAllGames() as ArrayList<GameModel>

        if (gameModelArrayList.isNullOrEmpty()) {
            //Show error message if no data in the database.
            tvErrorMsg.visibility = VISIBLE
        } else {
            tvErrorMsg.visibility = GONE

            rvGameList.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(this@GameHistoryActivity)
                // set the custom adapter to the RecyclerView
                adapter = GameHistoryAdapter(this@GameHistoryActivity, gameModelArrayList)
            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}