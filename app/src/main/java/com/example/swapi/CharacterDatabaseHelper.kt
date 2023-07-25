package com.example.swapi
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.swapi.model.CharacterDB

class CharacterDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "character_database"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "characters"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_GENDER = "gender"
        private const val COLUMN_STARSHIPS_COUNT = "starships_count"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_GENDER TEXT, " +
                "$COLUMN_STARSHIPS_COUNT INTEGER);"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertCharacter(character: CharacterDB) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, character.name)
            put(COLUMN_GENDER, character.gender)
            put(COLUMN_STARSHIPS_COUNT, character.countShip)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllCharacters(): List<CharacterDB> {
        val characters = mutableListOf<CharacterDB>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
            val gender = cursor.getString(cursor.getColumnIndex(COLUMN_GENDER))
            val starshipsCount = cursor.getInt(cursor.getColumnIndex(COLUMN_STARSHIPS_COUNT))
            val characterDB = CharacterDB(name,  gender, starshipsCount)
            characters.add(characterDB)
        }

        cursor.close()
        db.close()
        return characters
    }
}