package dev.vince.exercices.cardpicker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import dev.vince.exercices.cardpicker.Core.Card;

public class CardAdapter extends ArrayAdapter<Card> {

    private static int resourceLayout = R.layout.item_card;

    private List<Card> cards;

    public CardAdapter(Context context,
                       List<Card> objects) {
        super(context, resourceLayout, objects);

        this.cards = objects;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        // si pas de vue recyclée, instanciation
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());

            // xml > objet
            convertView = inflater.inflate(resourceLayout, null);
        }

        // récupération des vues dans notre ressource
        TextView text = (TextView) convertView.findViewById(R.id.text);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        // récupération de la carte à afficher
        Card currentCard = cards.get(position);

        // récupération du helper
        CardResourceHelper helper = CardResourceHelper.GetInstance();

        // affichage de la valeur
        text.setText(currentCard.getValue());

        // affichage du symbole
        int imageResource = helper.GetCardImage(currentCard.getSymbole());
        image.setImageResource(imageResource);

        // adapte la couleur en fonction du symbole de la carte
        int color = helper.GetCardColor(currentCard.getSymbole());
        text.setTextColor(color);
        image.setColorFilter(color);

        return convertView;
    }
}























