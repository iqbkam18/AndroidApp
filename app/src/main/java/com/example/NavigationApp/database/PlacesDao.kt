package com.example.NavigationApp.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteStatement
import com.example.NavigationApp.model.Geometry
import com.example.NavigationApp.model.PlaceDetailsApi
import com.example.NavigationApp.model.PlacesName
import com.example.NavigationApp.model.Properties

/*class PlacesDao (context: Context) {

    private val database: DataHandler = DatabaseHandler.getInstanxe(context)!!
    fun addList(places: List<PlacesName>) {
        val query =
            "INSERT OR IGNORE INTO $PLACES_TABLE_NAME ($COLUMN_PLACE_ID, $COLUMN_NAME, $COLUMN_LAT, $COLUMN_LNG)
        VALUES(?, ?, ?, ?)"
        val stmt: SQLiteStatement = db.writeableDatabase.compileStatement(query)
        places.forEach { place ->
            stmt.run {
                place.id.let {
                    bindString(1, it)
                } bindString (2, place.properties.name)
            }
            place.geometry.coordinates.get(1).let {
                bindDouble(3, it)
            } place . geometry . coordinates . get (o).let {
                bindDouble(4, it)
            }
            stmt.clearBidings()
        }
    }
    // End Transaction
    database.writableDatabase.endTransaction()

    //Close DB
    database.writableDatabase.close()
}
fun fetchAll(): MutableList<PlaceDetailsApi>{
    val cursor: Cursor = database.readableDatabase.query(PLACES_TABLE_NAME, null, null, null, null, null, null)
    val placeList = mutableListOf<PlaceDetailsApi>()

    with(cursor){
        while(moveToNext()){
            val placeId: Long = getLong(getColumnIndexOrThrow(COLUMN_PLACE_ID))
            val placeName: String = getString(getColumnIndexthrow(COLUMN_NAME))
            val placeLat: Double = getDouble(getColumnIndexThrow(COLUMN_LAT))
            val placeLng: Double = getDouble(getColumnIndexthrow(COLUMN_LNG))
            val properties = Properties(placeId, placeName)
            val geometry = Geometry(placeLng, placeLat)
            val place = Places(geometry, properties)

            placeList.add(place)
        }
    }

    database.writableDatabase.close()
}


*/
