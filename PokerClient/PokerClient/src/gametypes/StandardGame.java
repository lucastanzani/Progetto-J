/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametypes;

/**
 *
 * @author Nickelsilver
 */
public class StandardGame extends GameType{
    
    @Override
    public String getDescription() {  
        return "Standard Game: variante standard di poker Hold'em";
    }

    @Override
    public String toString() {
        return "Big Blind di base: " + this.bigBlind + "\nIl Big Blind raddoppia: " + !this.isBigBlindFixed + "\nMax giocatori: " + this.maxPlayers +"\nMax numero di raise: " + this.maxRaises;
    }
    
    @Override
    public String getName() {
        return "Standard Game";
    }

    public StandardGame(int amount) {
        this.maxPlayers = 5;
        this.maxRaises = 4;
        this.isBigBlindFixed = true;
        this.alwaysDoShowdown = true;
        this.startingStake = amount;
        this.bigBlind = 50;
    }
    
    
}
