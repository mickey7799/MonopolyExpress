package com.unimelb.swen30006.MonopolyExpress.Strategy;

import com.unimelb.swen30006.MonopolyExpress.DiceList;
import com.unimelb.swen30006.MonopolyExpress.Board.BoardGame;
import com.unimelb.swen30006.MonopolyExpress.Dice.Die;

public class ThirdTurnsStrategy implements IScoringStrategy {

	int score;
	public ThirdTurnsStrategy() {
		score =0;
	}
	@Override
	public int calculateScoring(BoardGame board, DiceList dices) {
		for(Die d:dices.getPlacedDices()) {
			score += d.getCurrentFaceValue();
		}
		return score;
	}
	

}
