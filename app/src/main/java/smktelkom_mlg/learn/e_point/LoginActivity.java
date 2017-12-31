package smktelkom_mlg.learn.e_point;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MS on 31/12/2017.
 */

public class LoginActivity extends Activity {
    EditText username, password;
    Button btnLog;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLog = (Button) findViewById(R.id.btnLog);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        if (sp.contains("username") && sp.contains("password")) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginCheck();
            }
        });

    }

    void loginCheck() {
        //validasi
        if (username.getText().toString().equals("kesiswaan") && password.getText().toString().equals("123")) {
            SharedPreferences.Editor e = sp.edit();
            e.putString("username", "kesiswaan");
            e.putString("password", "123");
            e.apply();

            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Incorrect Username/Password", Toast.LENGTH_LONG).show();
        }
    }
}

