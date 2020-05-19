package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Strategy.CompositeStrategy;
import com.unimelb.swen30006.MonopolyExpress.Strategy.EveryTurnsStrategy;
import com.unimelb.swen30006.MonopolyExpress.Strategy.IScoringStrategy;
import com.unimelb.swen30006.MonopolyExpress.Strategy.SecondTurnsStrategy;
import com.unimelb.swen30006.MonopolyExpress.Strategy.ThirdTurnsStrategy;

public class StrategyFactory {
	public static StrategyFactory strategyFactory = new StrategyFactory();
	private IScoringStrategy scoringStrategy = null;
	
	static public StrategyFactory getInstance() {
		if(strategyFactory==null)
			strategyFactory = new StrategyFactory();
		return strategyFactory;
	}
	
	public IScoringStrategy getStrategy(int turns) {
		if(turns %2 !=0 && turns %3 !=0 )
			scoringStrategy = new EveryTurnsStrategy();
		else {
			//IScoringStrategy everyTurnsStrategy = new EveryTurnsStrategy();
			//IScoringStrategy secondTurnsStrategy = new SecondTurnsStrategy();
			//IScoringStrategy thirdTurnsStrategy = new ThirdTurnsStrategy();
			CompositeStrategy compositeStrategy = new CompositeStrategy();
			
			compositeStrategy.add(new EveryTurnsStrategy());
			compositeStrategy.add(new SecondTurnsStrategy());
			compositeStrategy.add(new ThirdTurnsStrategy());
			
			scoringStrategy = (IScoringStrategy) compositeStrategy;
		}
			
		return scoringStrategy;
		
	}

}
