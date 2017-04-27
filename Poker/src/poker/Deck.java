package poker;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
    
    private ArrayList<Carta> mazzo;
  
    /**
     *
     */
    public Deck() {
        this.mazzo = new ArrayList();
        for(int i=0; i<4 ; i++){
            for(int j=0; j<13 ; j++){
                mazzo.add(new Carta(j,new Seed(i)));
            }
        }
    }
    
    /**
     *
     * @Metodo che estrae una carta dal mazzo e successivamente la rimuove dal mazzo, evitando duplicati
     */
    public Carta chooseCard() {
        Random random = new Random();
        Carta cartaEstratta = mazzo.get(random.nextInt(mazzo.size()));
        mazzo.remove(cartaEstratta);
        return cartaEstratta;
    }

    /**
     *
     * @Ritorna un arraylist del mazzo
     */
    public ArrayList<Carta> getMazzo() {
        return mazzo;
    }


}