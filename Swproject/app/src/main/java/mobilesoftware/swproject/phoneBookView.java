package mobilesoftware.swproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class phoneBookView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book_view);
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
}
