package com.appscrip.myapplication.model

//model class for games
class GameModel {

    var id: Int = 0
    var dateTime: String? = null
    var playerName: String? = null
    var selectedCricketer: String? = null
    var selectedFlagColor: String? = null

    constructor()

    constructor(
        id: Int,
        dateTime: String?,
        playerName: String?,
        selectedCricketer: String?,
        selectedFlagColor: String?
    ) {
        this.id = id
        this.dateTime = dateTime
        this.playerName = playerName
        this.selectedCricketer = selectedCricketer
        this.selectedFlagColor = selectedFlagColor
    }

    constructor(dateTime:String?,playerName: String?, selectedCricketer: String?, selectedFlagColor: String?) {
        this.dateTime = dateTime
        this.playerName = playerName
        this.selectedCricketer = selectedCricketer
        this.selectedFlagColor = selectedFlagColor
    }
}