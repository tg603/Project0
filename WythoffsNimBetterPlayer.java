/**
* Runs Player 'TG' in WythoffsNim
*
* @author Zach T-Good
*/
public class WythoffsNimBetterPlayer extends Player<WythoffsNim>{
/**
* Class variables.
*
* @param dist1First Found distance of firstPileto zero, when firstPile < secondPile.
* @param dist1Sec Found distance of secondPile to zero, when firstPile > secondPile.
* @param dist2First Found distance of firstPile to zero, when firstPile < secondPile
* @param dist2Sec Found distance of secondPile to zero, when firstPile < secondPile.
* @param equals Found when both piles were equal.
*/
private int dist1First;
private int dist1Sec;
private int dist2First;
private int dist2Sec;
private int equals;


/**
* Calls the method to use.
*
* @param Method call to be referenced in test1.java.
* 
*/
	public WythoffsNimBetterPlayer(){
		//no state necessary
	}

/**
*Gives my player a name.
*
* @param Returns a String value to be put in for my player's name.
*
*/
	public String toString(){
		//returning name of my player
		return "TG";
	}
	
/**
* Default Constructor to initialize variables.
*
* @param Constructor setting up the Integer variables.
*
*
*/

	//Constructor for variables of distance
	public void Dist(int dist1First, int dist1Sec, int dist2First, int dist2Sec, int equals){
		this.dist1First = dist1First;
		this.dist1Sec = dist1Sec;
		this.dist2First = dist2First;
		this.dist2Sec = dist2Sec;
		this.equals = equals;
	}


/**
* Failed testing of methods/method calls.
*
*@param Testing with methods to add into the if/else statements.
*
*
*/

/*

//Distance to (2,1) if firstPile is greater than secondPile
public int set2Distance(WythoffsNim position, int dist2First, int dist1Sec){
Pair<Integer, Integer> piles = position.getPiles();
Integer firstPile = piles.getFirst();
Integer secondPile = piles.getSecond();
dist2First = (firstPile - (firstPile - 2));
dist1Sec = (secondPile - (secondPile - 1));
return dist2First;
return dist1Sec;
}

//Distance to (1,2) if secondPile is greater than firstPile
public int set1Distance(WythoffsNim position, int dist1First, int dist2Sec){
Pair<Integer, Integer> piles = position.getPiles();
Integer firstPile = piles.getFirst();
Integer secondPile = piles.getSecond();
dist1First = (firstPile - (firstPile - 1));
dist2Sec = (secondPile - (secondPile - 2));
return dist1First;
return dist2Sec;			
}

//Distance when both firstPile and secondPile are equal
public int equalDistance(WythoffsNim position, int equals){
Pair<Integer, Integer> piles = position.getPiles();
Integer firstPile = piles.getFirst();
Integer secondPile = piles.getSecond();
equals = (firstPile - (firstPile - 3));
}
*/

/**
* Initializes the getMove() method for my player to create a move.
* Takes the WythoffsNim position (current pair), and my playerId number.
* This allows for my player's board to be updated everytime and allows me to make any sort of move on the board.
*
*
* @param Method call for WythoffsNim getMove() for player 'TG' to create a move.
*
* 
*/
	public WythoffsNim getMove(WythoffsNim position, int playerId){
		Pair<Integer, Integer> piles = position.getPiles();	
			if (piles.getFirst().equals(0) && piles.getSecond().equals(0)){
				throw new IllegalArgumentException("Given game has empty piles!");
			}

/**
* Initializes Integer pile varaibles and updates the current positions.
*
* @param Variable calls to update pile locations/integer values.
* @param Setting up for a new Pair to be made within the newPiles variable.
*
*/

	Integer firstPile = piles.getFirst();
	Integer secondPile = piles.getSecond();
	Pair<Integer, Integer> newPiles;
	
	/**
	* Multiple if/else checking possible win scenarios/forfeiting cases
	*@param If/else statements checking for winning scenarios/forfeiting.
	*@param Calls implicatations of varaibles instituted above. Ex. line 144 dist2First is called and used in line 145 successfully.
	*@return Breaks out of the if/else and returns the newPile created from the condition.
	* Side note: Attempted to clean up code with method calls which didn't end up successful.
	*
	* Side note: Cases would be the best option here; but, I ran out of time to implement them into this code. 
	*
	* Side note: This codes successfully beats the WythoffsNimPerfectPlayer() over 50% of the time. 
	*
	*/
	
		//Check Killshots right away
		if(firstPile == 0){
			newPiles = new Pair<Integer, Integer>(firstPile, secondPile - secondPile);
			return new WythoffsNim(newPiles);
		}
			else{		
				if(firstPile == 3 && secondPile > 5){
					dist2First = secondPile - 5; 
					newPiles = new Pair<Integer, Integer>(firstPile, secondPile - dist2First);
				}
				else{
					if(secondPile == 0){
							newPiles = new Pair<Integer, Integer>(firstPile - firstPile, secondPile);
							return new WythoffsNim(newPiles);
					}
						else{
							if(firstPile == 1 && secondPile > 3){
								dist2Sec = (secondPile - (secondPile - 2));
								newPiles = new Pair<Integer, Integer>(firstPile, dist2Sec);
								return new WythoffsNim(newPiles);
							}
								else{ 
									if(firstPile == 2 && secondPile > 2){
										dist2Sec = (secondPile - (secondPile - 1));
										newPiles = new Pair<Integer, Integer>(firstPile, dist1Sec);
										return new WythoffsNim(newPiles);
									}
									else{
										if(secondPile == 1 && firstPile > 3){
											dist2First = (firstPile - (firstPile - 2));
											newPiles = new Pair<Integer, Integer>(dist2First, secondPile);
											return new WythoffsNim(newPiles);
										}
										else{
											if(secondPile == 2 && firstPile > 1){
												dist1First = (firstPile - (firstPile - 1));
												newPiles = new Pair<Integer, Integer>(dist1First, secondPile);
												return new WythoffsNim(newPiles);
											}
											else{
												//Check to see if firstPile == secondPile 
												if(firstPile == secondPile && firstPile >= 4){
													//equals = (firstPile - (firstPile - 3));
													newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile - 1);
													return new WythoffsNim(newPiles);
												} 
												else{
												//Check to see if firstPile == secondPile + 1
													if(firstPile == secondPile + 1 && secondPile > 1){
														newPiles = new Pair<Integer, Integer>(firstPile - (secondPile - 1), secondPile - (secondPile - 1));
														return new WythoffsNim(newPiles);
													}
													else{
													//Check to see if firstPile + 1 == secondPile
														if (firstPile + 1 == secondPile && firstPile > 1){
															newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 1), secondPile - (firstPile - 1));
															return new WythoffsNim(newPiles);
														}
														else{
															if(firstPile > 10 && secondPile > 6){
																newPiles = new Pair<Integer, Integer>(firstPile , secondPile - (secondPile - 6));
																return new WythoffsNim(newPiles);
																}
															else{
																if(secondPile > 10 && firstPile > 6){
																	newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 6), secondPile);
																	return new WythoffsNim(newPiles);
																}
																else{
																	if( secondPile == 7 && firstPile > 3){
																		newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 3), secondPile);
																		return new WythoffsNim(newPiles);
																	}
																	else{
																		if(firstPile == 7 && secondPile > 3 ){
																			newPiles = new Pair<Integer, Integer>(firstPile, secondPile - (secondPile - 3));
																			return new WythoffsNim(newPiles);
																		}
																		else{
																			if(firstPile == 10 ){
																				newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile);
																				return new WythoffsNim(newPiles);
																			}
																			else{
																				if(secondPile == 10){
																					newPiles = new Pair<Integer, Integer>(firstPile, secondPile - 1);
																					return new WythoffsNim(newPiles);
																				}
					
																				else{
																					if(3 > firstPile  && 3 > secondPile || firstPile > 0 && secondPile > 0 ){
																						newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile - 1);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
/**
* Return statement for the getMove() method call.
*@return returns the newPile created from the if/else statement conditions.
*/
						newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile - 1);
						return new WythoffsNim(newPiles);
		}
/**
*Main method call.
*@param Main method.
*
*/
		public static void main(String[] args){
	}
}
								
		

	
