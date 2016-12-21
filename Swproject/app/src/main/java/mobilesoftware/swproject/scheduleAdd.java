package mobilesoftware.swproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class scheduleAdd extends Activity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText scheduleDate, scheduleDescription;
    static final int REQUEST_ACT = 1;
    String date;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_add);
        helper = new DBHelper(this);
        scheduleDate = (EditText) findViewById(R.id.scheduleDate);
        scheduleDescription = (EditText) findViewById(R.id.scheduleDescription);
        try {
            db = helper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
    }

    public void phoneBookClick(View v) {
        Intent intent = new Intent(scheduleAdd.this, phoneBookView.class);
        startActivity(intent);
    }

    public void scheduleClick(View v) {
        Intent intent = new Intent(scheduleAdd.this, scheduleView.class);
        startActivity(intent);
    }

    public void noteClick(View v) {
        Intent intent = new Intent(scheduleAdd.this, noteView.class);
        startActivity(intent);
    }

    public void scheduleAddClick(View target) {
        date = scheduleDate.getText().toString();
        description = scheduleDescription.getText().toString();
        //date = Integer.parseInt(intent.getStringExtra("scheduleDate"));
        Intent intent = new Intent(this, scheduleAddProcess.class);
        intent.putExtra("scheduleDate", date);
        intent.putExtra("scheduleDescription", description);
        startActivityForResult(intent,REQUEST_ACT);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ACT) {
            if (resultCode == RESULT_OK) {
                db.execSQL("INSERT INTO scheduleTable VALUES (null, '" + date + "', '" + description + "');");
                Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, scheduleView.class);
                startActivity(intent);
            }
        }
    }
}
