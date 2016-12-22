package mobilesoftware.swproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

public class phoneBookDeleteProcess extends Activity {
    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        helper = new DBHelper(this);

        try {
            db = helper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }

        db.execSQL("DELETE FROM phoneBookTable WHERE _id = "+ id +";");
        intent = new Intent(this, phoneBookView.class);
        startActivity(intent);
    }
}
