package com.unimelb.swen30006.MonopolyExpress.Strategy;

import java.util.ArrayList;

import com.unimelb.swen30006.MonopolyExpress.DiceList;
import com.unimelb.swen30006.MonopolyExpress.Board.BoardGame;

public class CompositeStrategy implements IScoringStrategy {
	protected ArrayList<IScoringStrategy> compositeStrategies = new ArrayList<>();
	
	
	@Override
	public int calculateScoring(BoardGame board, DiceList dices) {
		int highestScore = 0;
		for(IScoringStrategy i: this.compositeStrategies) {
			int score = i.calculateScoring(board, dices);
			if(score > highestScore) {
				highestScore = score;
			}
		}

		return highestScore;
	}
	public void add(IScoringStrategy strategy) {
		compositeStrategies.add(strategy);
		
	}

}
