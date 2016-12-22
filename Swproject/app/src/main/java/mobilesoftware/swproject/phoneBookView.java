package mobilesoftware.swproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class phoneBookView extends ActionBarActivity {
    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_view);

        list = (ListView) findViewById(R.id.list);
        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
        cursor = db.rawQuery("SELECT * FROM phoneBookTable", null);
        startManagingCursor(cursor);
        CustomList adapter = new CustomList(this, cursor);
        list.setAdapter(adapter);
    }

    public class CustomList extends CursorAdapter {

        public CustomList (Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(, parent, false);
            return v;
        }

        @Override
        public void bindView(View view, Context context, final Cursor cursor) {
            final TextView number = (TextView) view.findViewById(R.id.number);
            final TextView name = (TextView) view.findViewById(R.id.name);
            final Button delete = (Button) view.findViewById(R.id.deleteBtn);
            final int id;

            number.setText(cursor.getString(cursor.getColumnIndex("phoneNumber")));
            name.setText(cursor.getString(cursor.getColumnIndex("phoneName")));
            id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("_id")));

            delete.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(phoneBookView.this, phoneBookDeleteProcess.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });
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

    public void noteClick(View v) {
        Intent intent = new Intent(this, noteView.class);
        startActivity(intent);
    }

    public void scheduleAddClick(View v) {
        Intent intent = new Intent(this, scheduleAdd.class);
        startActivity(intent);
    }
}
