package handtypes;

import java.util.List;
import model.Card;

/**
 * Mano che rappresenta la combinazione "Scala Colore"
 * Mano formata da una "Scala" le cui carte hanno lo stesso seme
 */
public class ScalaColore extends Hand {
    
    private Card high;
    
    public ScalaColore(List<Card> cards) {
        super(cards);
        this.high = this.cards.get(0);
    }
    
    @Override
    public double getPoints() {
        return 800 + high.getRank();
    }
    
    @Override
    public String toString()
    {
        return "Scala Colore di " + Card.getRankName(high.getRank());
    }
}