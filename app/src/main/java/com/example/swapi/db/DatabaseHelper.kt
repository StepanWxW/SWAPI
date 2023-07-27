package com.example.swapi.db
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.swapi.model.Character
import com.example.swapi.model.Starship

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "star_wars_database"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME_CHARACTERS = "characters"
        private const val TABLE_NAME_STARSHIPS = "starships"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_GENDER = "gender"
        private const val COLUMN_STARSHIPS_COUNT = "starships_count"
        private const val COLUMN_STARSHIP_NAME = "starship_name"
        private const val COLUMN_STARSHIP_MODEL = "starship_model"
        private const val COLUMN_STARSHIP_MANUFACTURER = "starship_manufacturer"
        private const val COLUMN_STARSHIP_PASSENGERS = "starship_passengers"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createCharactersTableQuery = "CREATE TABLE $TABLE_NAME_CHARACTERS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_GENDER TEXT, " +
                "$COLUMN_STARSHIPS_COUNT INTEGER);"
        db.execSQL(createCharactersTableQuery)

        val createStarshipsTableQuery = "CREATE TABLE $TABLE_NAME_STARSHIPS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_STARSHIP_NAME TEXT, " +
                "$COLUMN_STARSHIP_MODEL TEXT, " +
                "$COLUMN_STARSHIP_MANUFACTURER TEXT, " +
                "$COLUMN_STARSHIP_PASSENGERS TEXT" +
                ");"
        db.execSQL(createStarshipsTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_CHARACTERS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_STARSHIPS")
        onCreate(db)
    }

    fun insertCharacter(character: Character) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, character.name)
            put(COLUMN_GENDER, character.gender)
            put(COLUMN_STARSHIPS_COUNT, character.countShip)
        }
        db.insert(TABLE_NAME_CHARACTERS, null, values)
        db.close()
    }

    fun insertStarship(starship: Starship) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_STARSHIP_NAME, starship.name)
            put(COLUMN_STARSHIP_MODEL, starship.model)
            put(COLUMN_STARSHIP_MANUFACTURER, starship.manufacturer)
            put(COLUMN_STARSHIP_PASSENGERS, starship.passengers)
        }
        db.insert(TABLE_NAME_STARSHIPS, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllCharacters(): List<Character> {
        val characters = mutableListOf<Character>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_CHARACTERS", null)

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
            val gender = cursor.getString(cursor.getColumnIndex(COLUMN_GENDER))
            val starshipsCount = cursor.getInt(cursor.getColumnIndex(COLUMN_STARSHIPS_COUNT))
            val characterDB = Character(name,  gender, starshipsCount)
            characters.add(characterDB)
        }

        cursor.close()
        db.close()
        return characters
    }

    @SuppressLint("Range")
    fun getAllStarships(): List<Starship> {
        val starships = mutableListOf<Starship>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_STARSHIPS", null)

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_STARSHIP_NAME))
            val model = cursor.getString(cursor.getColumnIndex(COLUMN_STARSHIP_MODEL))
            val manufacturer = cursor.getString(cursor.getColumnIndex(COLUMN_STARSHIP_MANUFACTURER))
            val passengers = cursor.getString(cursor.getColumnIndex(COLUMN_STARSHIP_PASSENGERS))

            val starship = Starship(name, model, manufacturer, passengers)
            starships.add(starship)
        }

        cursor.close()
        db.close()
        return starships
    }
    fun clearAllTables() {
        val db = writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME_CHARACTERS")
        db.execSQL("DELETE FROM $TABLE_NAME_STARSHIPS")
        db.close()
    }
}