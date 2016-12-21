package mobilesoftware.swproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

public class scheduleDeleteProcess extends Activity {
    DBHelper helper;
    SQLiteDatabase db;

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

        db.execSQL("DELETE FROM scheduleTable WHERE _id = "+ id +";");
        intent = new Intent(this, scheduleView.class);
        startActivity(intent);
    }
}
