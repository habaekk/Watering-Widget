package com.bada.widgetprac

import java.text.SimpleDateFormat
import java.util.Date

class PreferenceManager {

    fun getDate(): String {
        val date = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate = formatter.format(date)

        return formattedDate
    }
}

/*

Shared Preferences

"2020-11-11"
 -> numCups : 3
 -> numTums : 2
 -> numBots : 1

 "2020-11-12"
 -> numCups : 3
 -> numTums : 2
 -> numBots : 1

 "2020-11-13"
 -> numCups : 3
 -> numTums : 2
 -> numBots : 1


xxxxxxxxxxx delete xxxxxxxxxxxxxx
 */

