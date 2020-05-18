package com.unimelb.swen30006.MonopolyExpress.Strategy;

import com.unimelb.swen30006.MonopolyExpress.DiceList;
import com.unimelb.swen30006.MonopolyExpress.Board.BoardGame;
import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class SecondTurnsStrategy implements IScoringStrategy{
	private int score;
	public SecondTurnsStrategy() {
		score = 0;
	}
	@Override
	public int calculateScoring(BoardGame board, DiceList dices) {
		for (SquareSet g: board.getInCompleteGroup()) {
			if(g.getSumValue() > score){
                score = g.getSumValue();
            }
			
		}
		return score;
	}
	
	

}
