public class WythoffsNimPlayer extends Player<WythoffsNim>{

		
		public WythoffsNimPlayer(){
			//no state necessary
		}
	
		public String toString(){
			//returning name of my player
			return "TG";
		}
	
		public WythoffsNim getMove(WythoffsNim position, int playerId){
			Pair<Integer, Integer> piles = position.getPiles();
			if (piles.getFirst().equals(0) && piles.getSecond().equals(0)){
				throw new IllegalArgumentException("Given game has empty piles!");
			}
		
				//choosing a move code right here
		
			Integer firstPile = piles.getFirst();
			//declare the pair here so we can use it outside of the following conditional
			Pair<Integer, Integer> newPiles;
			Integer secondPile = piles.getSecond();
			if(firstPile > 0 && firstPile > secondPile && secondPile > 0 ){
				//take one from the first pile
				newPiles = new Pair <Integer, Integer>(firstPile - (secondPile - 1), secondPile - (secondPile - 1));
				
				//~failed~ newPiles = new Pair <Integer, Integer>(firstPile - (firstPile - 1), piles.getSecond());
				
			}else{

				//take one from the second pile
				//Integer secondPile = piles.getSecond();
				
				newPiles = new Pair<Integer, Integer>(firstPile, secondPile - 1);
				
				//~failed~newPiles = new Pair<Integer, Integer>(firstPile, secondPile - (secondPile - 1));
			}
			//Integer secondPile = piles.getSecond();
			//if(firstPile == 1 && secondPile == 1 ){
			
			if(firstPile == secondPile){
				newPiles = new Pair <Integer, Integer>(firstPile - firstPile, secondPile - secondPile);
			} else{
				if(firstPile == 0){
					newPiles = new Pair<Integer, Integer>(firstPile, secondPile - secondPile);
				}else{
					if(secondPile == 0){
							newPiles = new Pair<Integer, Integer>(firstPile - firstPile, secondPile);
					}else{
						/*
						if(firstPile != secondPile){
							newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile);
						}else{
							if (secondPile != firstPile)
								newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile);
						}
						*/
						/*
						
						else{
							if(secondPile < 2){
								newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 1), secondPile);
							}
							*/
							
							
							/*
													if(firstPile == 1 ){
							newPiles = new Pair<Integer, Integer>(firstPile, secondPile - (secondPile - 2));
						}else{
							if(secondPile == 1){
								newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 2), secondPile);
							}else{
								if(firstPile == 2){
									newPiles = new Pair<Integer, Integer>(firstPile, secondPile - (secondPile - 1));
								}
								else{
									if(secondPile == 2){
										newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 1), secondPile);
									}
								}else{
								if(firstPile > 1 || firstPile > 2)
								{
								newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile);	
								}
								else{
									if(secondPile > 1 || secondPile > 2){
									newPiles = new Pair<Integer, Integer>(firstPile, secondPile - 1);	
									
									*/
									if(firstPile == 1 && secondPile > 3){
										newPiles = new Pair<Integer, Integer>(firstPile, secondPile - (secondPile - 2));
									}else{ 
									if(firstPile == 2 && secondPile > 2){
										newPiles = new Pair<Integer, Integer>(firstPile, secondPile - (secondPile - 1));
									}
								else{
									if(secondPile == 1 && firstPile > 3){
										newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 2), secondPile);
									}else{
										if(secondPile == 2 && firstPile > 2){
											newPiles = new Pair<Integer, Integer>(firstPile - (firstPile - 1), secondPile);
										}else{
									if(firstPile % 2 == 0 && secondPile % 2 == 0){
										newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile - 1);
									}else{
										if(firstPile + 1 == secondPile && firstPile > 1){
											newPiles = new Pair<Integer, Integer>(firstPile - (secondPile - 2), secondPile - (firstPile + 1));
										}else{
											if (firstPile - 1 == secondPile && secondPile > 1){
												newPiles = new Pair<Integer, Integer>(firstPile - (secondPile + 1), secondPile - (firstPile - 2));
											}else{
										if(firstPile > 1 || firstPile > 2)
											{
											newPiles = new Pair<Integer, Integer>(firstPile - 1, secondPile);	
											}
												else{
													if(secondPile > 1 || secondPile > 2){
													newPiles = new Pair<Integer, Integer>(firstPile, secondPile - 1);		
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
			//Pair<Integer, Integer> newPiles = new Pair<Integer, Integer>(firstPile - 1, piles.getSecond());
			return new WythoffsNim(newPiles);
		}
		public static void main(String[] args){
	}
}