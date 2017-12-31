package smktelkom_mlg.learn.e_point;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button logout;

    private CardView catatC, laporanC, helpC, aboutC, logoutC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catatC = (CardView) findViewById(R.id.catat_card);
        laporanC = (CardView) findViewById(R.id.laporan_card);
        helpC = (CardView) findViewById(R.id.help_card);
        aboutC = (CardView) findViewById(R.id.about_card);
        logoutC = (CardView) findViewById(R.id.logout_card);

        catatC.setOnClickListener(this);
        laporanC.setOnClickListener(this);
        helpC.setOnClickListener(this);
        aboutC.setOnClickListener(this);
        logoutC.setOnClickListener(this);

        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.clear();
                e.apply();

                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

        }

    }
}
