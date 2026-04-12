package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;
import java.util.List;

/**
 * Activité principale : affiche la liste scrollable de toutes les pizzas.
 * Au clic sur une pizza, l'ID est passé à PizzaDetailActivity.
 */
public class ListPizzaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list_pizza);

        ListView lv = findViewById(R.id.lvPizzas);

        // Récupération de toutes les pizzas via le Singleton
        List<Produit> pizzas = ProduitService.getInstance().findAll();

        // Liaison données → adapter → ListView
        lv.setAdapter(new PizzaAdapter(this, pizzas));

        // Navigation vers le détail en passant l'ID de la pizza cliquée
        lv.setOnItemClickListener((parent, view, pos, id) -> {
            Intent it = new Intent(this, PizzaDetailActivity.class);
            it.putExtra("pizza_id", id); // id = getId() retourné par getItemId()
            startActivity(it);
        });
    }
}