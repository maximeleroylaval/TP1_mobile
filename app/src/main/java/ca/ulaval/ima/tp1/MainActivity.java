package ca.ulaval.ima.tp1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Profil profil;
    private String UrlToLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profil = new Profil(getString(R.string.firstname), getString(R.string.lastname),
                this.getDate(
                        getResources().getInteger(R.integer.birth_day),
                        getResources().getInteger(R.integer.birth_month),
                        getResources().getInteger(R.integer.birth_year)
                ),
                getString(R.string.idul));
        UrlToLoad = getString(R.string.mobile_url);
    }

    public Date getDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    public void browseWebExt(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(UrlToLoad));
        startActivity(i);
    }

    public void startActivityWebWv(View view) {
        Intent myIntent = new Intent(MainActivity.this, BrowserActivity.class);
        myIntent.putExtra("url", UrlToLoad);
        MainActivity.this.startActivity(myIntent);
    }

    public void startActivityUniversity(View view) {
        Intent myIntent = new Intent(MainActivity.this, UniversityActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void startActivityProfil(View view) {
        Intent myIntent = new Intent(MainActivity.this, ProfilActivity.class);
        myIntent.putExtra("parcel_profil", profil);
        MainActivity.this.startActivity(myIntent);
    }
}
