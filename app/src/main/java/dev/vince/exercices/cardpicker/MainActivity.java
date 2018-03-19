package dev.vince.exercices.cardpicker;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

import dev.vince.exercices.cardpicker.Core.Card;
import dev.vince.exercices.cardpicker.Core.CardSymbole;
import dev.vince.exercices.cardpicker.Core.DeckManager;

public class MainActivity extends AppCompatActivity {

    private TextView discard;
    private TextView deck;
    private View card_layout;
    private TextView card_value_top;
    private ImageView card_image_top;
    private ImageView card_image_bottom;
    private TextView card_value_bottom;
    private Button reset;
    private Button draw;

    private DeckManager deckManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discard = (TextView) findViewById(R.id.discard);
        deck = (TextView) findViewById(R.id.deck);
        card_layout = findViewById(R.id.card_layout);
        card_value_top = (TextView)findViewById(R.id.card_value_top);
        card_image_top = (ImageView) findViewById(R.id.card_image_top);
        card_image_bottom = (ImageView) findViewById(R.id.card_image_bottom);
        card_value_bottom = (TextView) findViewById(R.id.card_value_bottom);
        reset = (Button) findViewById(R.id.reset);
        draw = (Button) findViewById(R.id.draw);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deckManager.Rest();
                DrawDrawnCard(null);
            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawDrawnCard(deckManager.PickCard());
            }
        });

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(deckManager.GetDiscard().size() == 0){
                    Toast.makeText(
                            MainActivity.this,
                            "Il n'y a rien dans la défausse!",
                            Toast.LENGTH_SHORT
                        ).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, ListCardActivity.class);
                Bundle extras = new Bundle();
                String cardJson = new Gson().toJson(deckManager.GetDiscard());
                extras.putString("json_cards", cardJson);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        deckManager = new DeckManager();
        DrawDrawnCard(null);
    }

    public void DrawDrawnCard(Card drawnCard){

        if(drawnCard == null){
            card_layout.setVisibility(View.INVISIBLE);
            return;
        }

        card_layout.setVisibility(View.VISIBLE);

        // màj des compteurs
        discard.setText(deckManager.GetDiscardCount());
        deck.setText(deckManager.GetDeckCount());

        // dessiner la carte
        card_value_top.setText(drawnCard.getValue());
        card_value_bottom.setText(drawnCard.getValue());

        CardResourceHelper helper = CardResourceHelper.GetInstance();

        // drawCard.getSymbole() => R.mipmap.??
        CardSymbole symbole = drawnCard.getSymbole();
        int imageReference = helper.GetCardImage(symbole);
        card_image_top.setImageResource(imageReference);
        card_image_bottom.setImageResource(imageReference);

        // gestion de la couleur
        int color = helper.GetCardColor(symbole);
        card_value_top.setTextColor(color);
        card_value_bottom.setTextColor(color);
        card_image_top.setColorFilter(color, PorterDuff.Mode.ADD);
        card_image_bottom.setColorFilter(color, PorterDuff.Mode.ADD);
    }





}




















