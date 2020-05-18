package com.unimelb.swen30006.MonopolyExpress.Strategy;

import com.unimelb.swen30006.MonopolyExpress.DiceList;
import com.unimelb.swen30006.MonopolyExpress.Board.BoardGame;
import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class EveryTurnsStrategy implements IScoringStrategy {
	private int score;
	
	public EveryTurnsStrategy(){
	        score = 0;
	}
	
	@Override
	public int calculateScoring(BoardGame board, DiceList dices) {
		for (SquareSet g : board.getCompleteGroup()) {
			switch (g.getGroupName()) {
				case "50":
					score += 600;
				    break;
                case"100":
                    score += 1000;
                    break;
                case"150":
                    score += 1500;
                    break;
                case"200":
                    score += 1800;
                    break;
                case"250":
                    score += 2200;
                    break;
                case"300":
                    score += 2700;
                    break;
                case"400":
                    score += 3000;
                    break;
                case"500":
                    score += 3500;
                    break;
                case"Railroads":
                    score += 2500;
                    break;
                case"Utilities":
                    score += 800;
                    break;
					
			}
		}
		return score;
	}

}
