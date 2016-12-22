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

public class phoneBookAdd extends Activity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText phoneName, phoneNumber;
    static final int REQUEST_ACT = 1;
    int number;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book_add);
        helper = new DBHelper(this);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        phoneName = (EditText) findViewById(R.id.phoneName);

        try {
            db = helper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
    }

    public void mainClick(View v) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    public void phoneBookClick(View v) {
        Intent intent = new Intent(this, phoneBookView.class);
        startActivity(intent);
    }

    public void scheduleClick(View v) {
        Intent intent = new Intent(this, scheduleView.class);
        startActivity(intent);
    }

    public void noteClick(View v) {
        Intent intent = new Intent(this, noteView.class);
        startActivity(intent);
    }

    public void phoneBookAddClick(View target) {
        String numberString = phoneNumber.getText().toString();
        name = phoneName.getText().toString();

        if(numberString.getBytes().length <= 0)
            number = 0;
        else
            number = Integer.parseInt(numberString);

        if(name.getBytes().length <= 0)
            name = null;

        Intent intent = new Intent(this, phoneBookAddProcess.class);
        intent.putExtra("phoneNumber", number);
        intent.putExtra("phoneName", name);
        startActivityForResult(intent,REQUEST_ACT);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ACT) {
            if (resultCode == RESULT_OK) {
                db.execSQL("INSERT INTO phoneBookTable VALUES (null, '" + name + "', '" + number + "');");
                Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, scheduleView.class);
                startActivity(intent);
            }
        }
    }
}
