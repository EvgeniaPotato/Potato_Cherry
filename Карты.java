import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Card{
    private final String rank;
    private final String suit;
    public Card(String rank, String suit){
    
            public String toString(){
                return rank + "of" + suit;
            }
            public String getRank(){
                return rank;
            }
            public String getSuit(){
                return suit;
            }
}
}
class Coloda{
    private List cards;
    public Coloda(){
        this.cards = new ArrayList<>();
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Q", "V", "K", "T"};
        String[] suits = {"Пики", "Крести", "Черви", "Бубны" };
        for (String suit: suits){
            for(String rank: ranks){
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card dealCard(){
        if(cards.isEmpty()){
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
    public boolean returnCard(Card card){
        if(!cards.contains(card)){
           cards.add(card);
           return true;
        }
        return false;
    }
    public int cardsRemaining(){
        return cards.size();
    }
}
        
