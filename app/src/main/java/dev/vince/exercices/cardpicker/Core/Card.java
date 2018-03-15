package dev.vince.exercices.cardpicker.Core;

/**
 * Created by vince on 01/03/2018.
 */

public class Card {

    private String value;
    private CardSymbole symbole;

    public Card(String value, CardSymbole symbole) {
        this.value = value;
        this.symbole = symbole;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CardSymbole getSymbole() {
        return symbole;
    }

    public void setSymbole(CardSymbole symbole) {
        this.symbole = symbole;
    }
}
