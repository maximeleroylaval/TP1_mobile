package ca.ulaval.ima.tp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class UniversityActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
    }

    public void close(View view) {
        finish();
    }
}
