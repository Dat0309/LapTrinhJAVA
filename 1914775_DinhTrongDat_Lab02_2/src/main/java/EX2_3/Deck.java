/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2_3;

/**
 *
 * @author ADMIN
 */
public class Deck {
    private Card[] deck;
    private int cardUsed;
    
    public Deck(){
        this(false);
    }
    public Deck(boolean includeJoker){
        if(includeJoker)
            deck=new Card[54];
        else
            deck=new Card[52];
        int cardCt=0;
        for (int suit = 0; suit <=3; suit++) {
            for (int value = 0; value <=13; value++) {
                deck[cardCt]=new Card(value,suit);
                cardCt++;
                
            }
            
        }
        if (includeJoker){
            deck[52] = new Card(1,Card.JOKER);
            deck[53]=new Card(2,Card.JOKER);
        }
        cardUsed=0;
    }
    
    public void shuffle(){
        for (int i =  deck.length-1;i>0; i--) {
            int rand =(int)(Math.random()*(i+1));
            Card temp=deck[i];
            deck[i] = deck[rand];
            deck[rand]=temp;
            
        }
        cardUsed=0;
    }
    
    public int cardsLeft(){
        return deck.length-cardUsed;
    }
    
    public Card dealCard(){
        if(cardUsed==deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardUsed++;
        return deck[cardUsed-1];
    }
    
    public boolean hasJoker(){
        return (deck.length==54);
    }
}
