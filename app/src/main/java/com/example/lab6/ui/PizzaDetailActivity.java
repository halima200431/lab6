package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

/**
 * Affiche les détails complets d'une pizza sélectionnée.
 * Reçoit l'ID via l'Intent et charge la pizza depuis le service.
 */
public class PizzaDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_pizza_detail);

        // Lecture de l'ID passé par ListPizzaActivity (-1 si absent)
        long id = getIntent().getLongExtra("pizza_id", -1);

        // Recherche de la pizza correspondante
        Produit p = ProduitService.getInstance().findById(id);

        ImageView img       = findViewById(R.id.img);
        TextView title      = findViewById(R.id.title);
        TextView meta       = findViewById(R.id.meta);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView desc       = findViewById(R.id.desc);
        TextView steps      = findViewById(R.id.steps);
        
        ScrollView scrollView = findViewById(R.id.scrollView);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnScrollTop = findViewById(R.id.btnScrollTop);

        if (p != null) {
            img.setImageResource(p.getImageRes());
            title.setText(p.getNom());
            meta.setText("⏱ " + p.getDuree() + "   💶 " + p.getPrix() + " €");
            desc.setText(p.getDescription());
            ingredients.setText(p.getIngredients());
            steps.setText(p.getEtapes());
        } else {
            // Cas d'erreur (ID invalide)
            title.setText("Pizza introuvable !");
        }

        // Action du bouton Retour
        btnBack.setOnClickListener(v -> finish());

        // Action du bouton Scroll vers le haut
        btnScrollTop.setOnClickListener(v -> {
            scrollView.smoothScrollTo(0, 0);
        });
    }
}