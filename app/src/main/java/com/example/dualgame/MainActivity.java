package com.example.dualgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button logoutButton;
    Button botonIdiomaSenas;

    Button botonIdiomaBraille;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        auth = FirebaseAuth.getInstance();
        logoutButton = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        botonIdiomaSenas = findViewById(R.id.boton_idioma_senas);
        botonIdiomaBraille= findViewById(R.id.boton_sistema_braille);

        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }

        logoutButton.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        });

        botonIdiomaSenas.setOnClickListener(v -> {
            // Crear un Intent para ir a LevelsActivity
            Intent intent = new Intent(MainActivity.this, LevelsActivity.class);
            startActivity(intent);
        });

        botonIdiomaBraille.setOnClickListener(v -> {
            // Crear un Intent para ir a LevelsActivityBraille
            Intent intent = new Intent(MainActivity.this, LevelsActivityBraille.class);
            startActivity(intent);
        });



    }
}

