package ca.ulaval.ima.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ProfilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        this.setValues();
    }

    private void setValues() {
        Intent intent = getIntent();
        Profil profil = intent.getParcelableExtra("parcel_profil");

        TextView myTextFirstname = findViewById(R.id.firstname_input);
        myTextFirstname.setText(profil.getFirstname());

        TextView myTextLastname = findViewById(R.id.lastname_input);
        myTextLastname.setText(profil.getLastname());

        TextView myTexBirthdate = findViewById(R.id.birthdate_input);
        DateFormat formatter = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.CANADA_FRENCH);
        myTexBirthdate.setText(formatter.format(profil.getBirthdate()));

        TextView myTextIdul = findViewById(R.id.idul_input);
        myTextIdul.setText(profil.getIdul());
    }
}
