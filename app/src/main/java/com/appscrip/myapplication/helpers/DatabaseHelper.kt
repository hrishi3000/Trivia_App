package com.appscrip.myapplication.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.appscrip.myapplication.model.GameModel
import java.util.*

class DatabaseHelper(
    context: Context,
    factory: SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " +
                TABLE_GAMES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_DATE_TIME
                + " TEXT," + COLUMN_PLAYER_NAME
                + " TEXT," + COLUMN_CRICKETER
                + " TEXT," + COLUMN_FLAG_COLOR + " TEXT" + ")")
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_GAMES")
        onCreate(db)
    }


    fun addGame(game: GameModel) {

        val values = ContentValues()
        values.put(COLUMN_DATE_TIME, game.dateTime)
        values.put(COLUMN_PLAYER_NAME, game.playerName)
        values.put(COLUMN_CRICKETER, game.selectedCricketer)
        values.put(COLUMN_FLAG_COLOR, game.selectedFlagColor)

        val db = this.writableDatabase

        db.insert(TABLE_GAMES, null, values)
        db.close()
    }

    fun getAllGames(): List<GameModel>? {
        val gameModelArrayList: MutableList<GameModel> = ArrayList<GameModel>()

        // Select All Query
        val selectQuery = "SELECT  * FROM $TABLE_GAMES;"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                val gameModel = GameModel()
                gameModel.id = (cursor.getInt(cursor.getColumnIndex(COLUMN_ID)))
                gameModel.dateTime = (cursor.getString(cursor.getColumnIndex(COLUMN_DATE_TIME)))
                gameModel.playerName = (cursor.getString(cursor.getColumnIndex(COLUMN_PLAYER_NAME)))
                gameModel.selectedCricketer = (cursor.getString(
                    cursor.getColumnIndex(
                        COLUMN_CRICKETER
                    )
                ))
                gameModel.selectedFlagColor = (cursor.getString(
                    cursor.getColumnIndex(
                        COLUMN_FLAG_COLOR
                    )
                ))
                gameModelArrayList.add(gameModel)
            } while (cursor.moveToNext())
        }

        // close db connection
        db.close()

        // return notes list
        return gameModelArrayList
    }


    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "trivia.db"
        val TABLE_GAMES = "games"

        val COLUMN_ID = "_id"
        val COLUMN_DATE_TIME = "date_time"
        val COLUMN_PLAYER_NAME = "player_name"
        val COLUMN_CRICKETER = "selected_cricketer"
        val COLUMN_FLAG_COLOR = "selected_flag_color"

    }
}