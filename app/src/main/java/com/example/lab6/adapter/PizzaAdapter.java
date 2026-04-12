package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import java.util.List;

/**
 * Adaptateur personnalisé pour afficher la liste des pizzas dans un ListView.
 * Chaque ligne correspond à un objet Produit affiché via row_pizza.xml.
 */
public class PizzaAdapter extends BaseAdapter {

    private final Context ctx;
    private final List<Produit> pizzas;

    public PizzaAdapter(Context ctx, List<Produit> pizzas) {
        this.ctx = ctx;
        this.pizzas = pizzas;
    }

    @Override public int getCount()              { return pizzas.size(); }
    @Override public Object getItem(int i)       { return pizzas.get(i); }
    @Override public long getItemId(int i)       { return pizzas.get(i).getId(); }

    /**
     * Appelée pour chaque élément visible du ListView.
     * ViewHolder pattern : on réutilise la vue si elle existe déjà (convertView != null).
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // Inflation uniquement si la vue n'est pas recyclée
        if (convertView == null)
            convertView = LayoutInflater.from(ctx)
                    .inflate(R.layout.row_pizza, parent, false);

        // Récupération des vues du layout
        ImageView img   = convertView.findViewById(R.id.imgPizza);
        TextView tvNom  = convertView.findViewById(R.id.tvNom);
        TextView tvPrix = convertView.findViewById(R.id.tvPrix);
        TextView tvDuree = convertView.findViewById(R.id.tvDuree);

        Produit p = pizzas.get(pos);

        // Remplissage avec les données de la pizza courante
        img.setImageResource(p.getImageRes());
        tvNom.setText(p.getNom());
        tvPrix.setText(p.getPrix() + " €");
        tvDuree.setText(p.getDuree());

        return convertView;
    }
}