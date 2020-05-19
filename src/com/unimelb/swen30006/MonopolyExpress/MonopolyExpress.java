/**
 * This class is for Workshop's exercises for SWEN30006 Software Design and Modelling subject at the University of Melbourne
 * @author 	Patanamon Thongtanunam
 * @version 1.0
 * @since 	2019-04
 * 
 */

package com.unimelb.swen30006.MonopolyExpress;
import java.util.ArrayList;
import java.util.Scanner;

import com.unimelb.swen30006.MonopolyExpress.Board.BoardGame;
import com.unimelb.swen30006.MonopolyExpress.Strategy.IScoringStrategy;



public class MonopolyExpress {

	public static void main(String[] args) {
		
		BoardGame board = new BoardGame();
		ArrayList<Player> players = new ArrayList<Player>();
		DiceList dices = DiceList.getInstance();
		IScoringStrategy scoringStrategy;
		
		players.add(new Player("A"));
		players.add(new Player("B"));
		
		Scanner in = new Scanner(System.in);
		
		boolean hasWinner = false;
		
		while(!hasWinner) {
			dices.initialDices();			
			Player currentPlayer = players.remove(0);
			currentPlayer.newTurn();
			System.out.println("====== Turn "+currentPlayer.getTurn()+" ====");
			System.out.println("====== "+currentPlayer.getName()+"'s turn ====");
			
			boolean turnEnds = false;
			do {
				//Roll the dice and show the faces				
				dices.rollDice();
				int i =0;
				while(i < dices.getunPlacedDices().size()) {
					//System.out.println("Dice "+ (i+1) + " face name is : " + dices.getunPlacedDices().get(i).getCurrentFaceName());
					//Check PoliceDice and place on the board
					if(dices.getunPlacedDices().get(i).getCurrentFaceName().equals("Police")) {
						board.placeDie(dices.getunPlacedDices().get(i));
						dices.placeDice(dices.getunPlacedDices().get(i));
					}else {
						i++;
					}
				}
				
				System.out.println(board.show());
				
				if(board.isAllFilled("Police")) {
					turnEnds = true;
					System.out.println("You got 3 police on the board, your turn ends!");
				}else {
					//Ask the player to pick the number dice
					int index = 0;
					int remainingDice = 0;
					
					
					do {
						System.out.println("------ Remaining Dice ----");
						//show dice faces
						for (i =0; i<dices.getunPlacedDices().size(); i++) {
							System.out.println("Dice " + (i+1) + " face name is : " + dices.getunPlacedDices().get(i).getCurrentFaceName());
						}
						remainingDice = dices.getunPlacedDices().size();
						
						System.out.print("["+currentPlayer.getName()+"]Pick a number die (1-"+remainingDice+") or -1 (no pick):");
						index = in.nextInt();
						boolean valid = false; 
						while(!valid){
							if(index<=0 && index != -1|| index>remainingDice) {
								System.out.print("Please pick a number die (1-"+remainingDice+") or -1 (no pick):");
								index = in.nextInt();
							}
															
							if(index <= remainingDice && index>0) {
								board.placeDie(dices.getunPlacedDices().get(index-1));
								dices.placeDice(dices.getunPlacedDices().get(index-1));
								System.out.println(board.show());
								valid = true; 
							}
							if(index == -1)
								valid = true;
						};
						
						
					}while(index != -1 && remainingDice != 0);
					
					
					System.out.print("["+currentPlayer.getName()+"] Keep rolling? (y/n):");
					String answer = in.next();
					if(answer.toLowerCase().equals("n") || remainingDice == 0) {
						turnEnds = true;
						//calculate score
						scoringStrategy = StrategyFactory.getInstance().getStrategy(currentPlayer.getTurn());
						currentPlayer.addScore(scoringStrategy.calculateScoring(board, dices));
					}
				}	
	
			}while(!turnEnds);
			System.out.println("Turn ends");
			
			//Calculate score
			if(currentPlayer.getScore()>=15000) {
				System.out.println(currentPlayer.getName() + " is the winner! The score is "+ currentPlayer.getScore());
				hasWinner = true;
			}else {
				System.out.println("The score of "+currentPlayer.getName() + " is "+ currentPlayer.getScore());
			}
			
			
			players.add(currentPlayer);
			board.reset();
		}
		
		in.close();
		
	}

	
	
}
