package mobilesoftware.swproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kimshinyanglee.db";
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_TABLE_NAME = "contactsTable";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contactsTable ( _id INTEGER PRIMARY KEY AUTOINCREMENT, num TEXT, userid TEXT, userpass TEXT);");
        db.execSQL("CREATE TABLE phoneTable ( _id INTEGER PRIMARY KEY AUTOINCREMENT, phoneNumber INTEGER, phoneName TEXT);");
        db.execSQL("CREATE TABLE scheduleTable ( _id INTEGER PRIMARY KEY AUTOINCREMENT, scheduleDate DATE, scheduleDescription TEXT);");
        db.execSQL("CREATE TABLE noteTable ( _id INTEGER PRIMARY KEY AUTOINCREMENT, noteContent TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contactsTable");
        db.execSQL("DROP TABLE IF EXISTS phoneTable");
        db.execSQL("DROP TABLE IF EXISTS scheduleTable");
        db.execSQL("DROP TABLE IF EXISTS noteTable");
        onCreate(db);
    }
}