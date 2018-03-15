package dev.vince.exercices.cardpicker;

import android.graphics.Color;
import java.util.HashMap;
import dev.vince.exercices.cardpicker.Core.CardSymbole;

public class CardResourceHelper {


    private static CardResourceHelper instance;
    public static CardResourceHelper GetInstance(){
        if(instance == null){
            instance = new CardResourceHelper();
        }
        return instance;
    }

    public HashMap<CardSymbole, Integer> resourceMapReference;
    public HashMap<CardSymbole, Integer> colorMapReference;
    private CardResourceHelper(){
        resourceMapReference = new HashMap<>();
        resourceMapReference.put(CardSymbole.Diamond, R.mipmap.ic_diamond);
        resourceMapReference.put(CardSymbole.Clubs, R.mipmap.ic_clover);
        resourceMapReference.put(CardSymbole.Heart, R.mipmap.ic_heart);
        resourceMapReference.put(CardSymbole.Spade, R.mipmap.ic_spades);

        colorMapReference = new HashMap<>();
        colorMapReference.put(CardSymbole.Spade, Color.BLACK);
        colorMapReference.put(CardSymbole.Clubs, Color.BLACK);
        colorMapReference.put(CardSymbole.Heart, Color.RED);
        colorMapReference.put(CardSymbole.Diamond, Color.RED);
    }

    public int GetCardImage(CardSymbole symbole){
        return resourceMapReference.get(symbole);
    }

    public int GetCardColor(CardSymbole symbole){
        return colorMapReference.get(symbole);
    }
























}
