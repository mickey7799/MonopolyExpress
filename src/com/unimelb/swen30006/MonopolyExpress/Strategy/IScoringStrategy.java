package com.unimelb.swen30006.MonopolyExpress.Strategy;

import com.unimelb.swen30006.MonopolyExpress.DiceList;
import com.unimelb.swen30006.MonopolyExpress.Board.BoardGame;

public interface IScoringStrategy {
	public int calculateScoring(BoardGame board, DiceList dices);
}
