package mobilesoftware.swproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    private TextView idView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void modifyProcess(View v){
        Intent intent = new Intent(this, memberChange.class);
        startActivity(intent);
    }

    public void logoutProcess(View v){
        Intent intent = new Intent(this, beforeLogin.class);

        startActivity(intent);
        finish();
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
