package dev.vince.exercices.cardpicker.Core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by vince on 01/03/2018.
 */

public class DeckManager {

    private LinkedList<Card> deck;
    private LinkedList<Card> discard;
    private Card currentCard;

    public DeckManager() {
        this.deck = new LinkedList<>();
        this.discard = new LinkedList<>();
        Initialize();
    }

    private void Initialize(){

        CardSymbole[] symboles = CardSymbole.values();
        String[] values = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "V", "D", "R"};

        deck.clear();
        discard.clear();
        currentCard = null;
        for (CardSymbole symbole : symboles) {
            for (String value : values) {
                deck.add(new Card(value, symbole));
            }
        }
    }

    public Card PickCard(){

        // si on n'a rien à piocher, on s'arrête
        if(deck.size() == 0){
            return null;
        }

        // si on avait déjà une carte sélectionnée, on la met dans la défausse
        if(currentCard != null){
            discard.add(currentCard);
        }

        // on sélectionne une nouvelle carte au hasar
        Random random = new Random();
        int index = random.nextInt(deck.size());
        currentCard = deck.get(index);

        // et on l'enlève de la pioche
        deck.remove(index);

        return currentCard;
    }

    public void Rest(){
        Initialize();
    }

    public String GetDeckCount(){
        return String.valueOf(deck.size());
    }

    public String GetDiscardCount(){
        return String.valueOf(discard.size());
    }

}

















