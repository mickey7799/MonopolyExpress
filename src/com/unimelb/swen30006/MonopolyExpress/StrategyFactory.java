package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Strategy.EveryTurnsStrategy;
import com.unimelb.swen30006.MonopolyExpress.Strategy.IScoringStrategy;
import com.unimelb.swen30006.MonopolyExpress.Strategy.SecondTurnsStrategy;

public class StrategyFactory {
	public static StrategyFactory strategyFactory = new StrategyFactory();
	private IScoringStrategy scoringStrategy;
	
	static public StrategyFactory getInstance() {
		if(strategyFactory==null)
			strategyFactory = new StrategyFactory();
		return strategyFactory;
	}
	
	public IScoringStrategy getStrategy(int turns) {
		if(turns %2 !=0 && turns %3 !=0 )
			scoringStrategy = new EveryTurnsStrategy();
		else
			//scoringStrategy = new CompositeStrategy(turns);
		return scoringStrategy;
		
	}

}
