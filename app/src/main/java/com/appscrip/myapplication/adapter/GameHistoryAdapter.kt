package com.appscrip.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appscrip.myapplication.model.GameModel
import com.appscrip.myapplication.R

class GameHistoryAdapter(
    context: Context?,
    gameModelList: List<GameModel>
) : RecyclerView.Adapter<GameHistoryAdapter.ViewHolder>() {
    private val gameModelList: List<GameModel>
    private val mInflater: LayoutInflater
    var mContext: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.layout_list_games, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gameModel = gameModelList[position]

        //Showing all the data from the database in the recyclerview adapter
        holder.tvGameId.text = "GAME ${gameModel.id} :"
        holder.tvDateTime.text = "${gameModel.dateTime}"
        holder.tvPlayerName.text = "Name : ${gameModel.playerName}"
        holder.tvCricketerName.text = "Answer : ${gameModel.selectedCricketer}"
        holder.tvFlagColors.text = "Answer : ${gameModel.selectedFlagColor}"
    }

    override fun getItemCount(): Int {
        return gameModelList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvGameId: TextView
        var tvDateTime: TextView
        var tvPlayerName: TextView
        var tvCricketerName: TextView
        var tvFlagColors: TextView

        init {
            tvGameId = itemView.findViewById(R.id.tvGameId)
            tvDateTime = itemView.findViewById(R.id.tvDateTime)
            tvPlayerName = itemView.findViewById(R.id.tvPlayerName)
            tvCricketerName = itemView.findViewById(R.id.tvCricketerName)
            tvFlagColors = itemView.findViewById(R.id.tvFlagColors)

        }
    }

    // initializing the components;
    init {
        mInflater = LayoutInflater.from(context)
        this.gameModelList = gameModelList
    }
}
