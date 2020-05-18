package com.unimelb.swen30006.MonopolyExpress;

import java.util.ArrayList;

import com.unimelb.swen30006.MonopolyExpress.Dice.*;

public class DiceList {
	private static DiceList diceList = new DiceList();
    private ArrayList<Die> unPlacedDices;
    private ArrayList<Die> placedDices;

    private DiceList(){

    }

    public static DiceList getInstance(){
        return diceList;
    }

    public void initialDices(){
        placedDices = new ArrayList<>();
        unPlacedDices = new ArrayList<>();
        unPlacedDices.add(new Die1());
        unPlacedDices.add(new Die2());
        unPlacedDices.add(new Die34());
        unPlacedDices.add(new Die34());
        unPlacedDices.add(new Die5());
        unPlacedDices.add(new DiePolice());
        unPlacedDices.add(new DiePolice());
        unPlacedDices.add(new DiePolice());
        unPlacedDices.add(new DieUtility());
        unPlacedDices.add(new DieUtility());
    }
    public void rollDice(){
        for(Die d : unPlacedDices){
            d.roll();
        }
    }
    public void placeDice(Die d){
        placedDices.add(d);
        unPlacedDices.remove(d);
    }

    public ArrayList<Die> getPlacedDices(){
        return placedDices;
    }
    public ArrayList<Die> getunPlacedDices(){
        return unPlacedDices;
    }

}
