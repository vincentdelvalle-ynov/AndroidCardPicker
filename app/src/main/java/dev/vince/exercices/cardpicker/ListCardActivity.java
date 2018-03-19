package dev.vince.exercices.cardpicker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;
import java.util.List;

import dev.vince.exercices.cardpicker.Core.Card;

public class ListCardActivity extends AppCompatActivity {

    private ListView list_cards;
    private CardAdapter adapter;
    public LinkedList<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String cardString = extras.getString("json_cards");
            cards = new Gson().fromJson(
                    cardString,
                    new TypeToken<LinkedList<Card>>(){}.getType()
                );
        }

        list_cards = (ListView) findViewById(R.id.list_cards);
        adapter = new CardAdapter(this, cards);
    }

}




















