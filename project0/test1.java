public class test1{
public static void main(String[] args){
	int maxPileSize = 20;
	PositionFactory<WythoffsNim> factory = new WythoffsNim.PositionBuilder(maxPileSize);
	Player<WythoffsNim> me = new WythoffsNimBetterPlayer();
	Player<WythoffsNim> random = new WythoffsNimPerfectPlayer();
	Referee<WythoffsNim> ref = new Referee<WythoffsNim>(random, me, factory);
	ref.call();
	ref.gauntlet(10000);

}
}