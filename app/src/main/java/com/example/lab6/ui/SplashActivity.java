package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzarecipes.R;

/**
 * Écran de démarrage affiché 2,5 secondes avant d'ouvrir la liste.
 * finish() empêche de revenir en arrière sur cet écran.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_splash);

        new Thread(() -> {
            try {
                Thread.sleep(2500); // Pause de 2,5 secondes
            } catch (InterruptedException ignored) {}

            // Lancement de la liste sur le thread principal
            runOnUiThread(() -> {
                startActivity(new Intent(this, ListPizzaActivity.class));
                finish(); // Ferme le Splash pour ne pas y revenir
            });
        }).start();
    }
}