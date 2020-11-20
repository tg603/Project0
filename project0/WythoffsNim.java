/**
 * Represents the game (ruleset) Wythoff's Nim.
 * 
 * @author Kyle Burke <paithanq@gmail.com>
 * 
 */
//package something;
 
import java.lang.*;
import java.io.*;
import java.util.*;

public class WythoffsNim extends CombinatorialGame {

    //instance variables
    
    private Pair<Integer, Integer> piles;
    
    //constants
    
    /** Constructors **/
    
    /**
     * Class Consstructor.
     *
     * @param pair  A pair of integers representing the sizes of the two piles.  Throws an exception if either of the elements of pair is null or negative.
     * @throws IllegalArgumentException  If either elements in the pair is null or negative.  Negative numbers are illegal pile sizes.
     */
    public WythoffsNim(Pair<Integer, Integer> piles) {
        if (piles == null || piles.getFirst() == null || piles.getFirst() < 0 || piles.getSecond() == null || piles.getSecond() < 0) {
            throw new IllegalArgumentException("Argument cannot be null or have null or negative values!");
        }
        //don't just use the parameter pair; we need a deep copy so it can't be modified from outside.
        this.piles = new Pair<Integer, Integer>(piles.getFirst(), piles.getSecond());
    }
    
    //public methods
    
    
    //@override
    public String toString() {
        return "Wythoff's Nim (" + this.piles.getFirst() + ", " + this.piles.getSecond() + ")";
    }
    
    //@override 
    public Collection<CombinatorialGame> getOptions(int player) {
        Collection<CombinatorialGame> options = new ArrayList<CombinatorialGame>();
        int first = this.piles.getFirst();
        int second = this.piles.getSecond();
        //Get the moves that take from the first pile
        for (int x = 0; x < first; x++) {
            options.add(new WythoffsNim(new Pair<Integer, Integer>(x, second)));
        }
        //Get the moves that take from the second pile
        for (int y = 0; y < second; y++) {
            options.add(new WythoffsNim(new Pair<Integer, Integer>(first, y)));
        }
        //Add the moves that take from both piles
        int min = Math.min(first, second);
        for (int both = 1; both <= min; both ++) {
            options.add(new WythoffsNim(new Pair<Integer, Integer>(first - both, second - both)));
        }
        
        return options;
    }
    
    /**
     * Returns the name of this game.
     * 
     * @return  The String "Wythoff's Nim".
     */
    public static String getName() {
        return "Wythoff's Nim";
    }
    
    /**
     * Returns the piles.
     *
     * @return  A pair of integers that is a deep copy of the piles here.
     */
    public Pair<Integer, Integer> getPiles() {
        return new Pair<Integer, Integer>(this.piles.getFirst(), this.piles.getSecond());
    }
    
    /**
     * Returns a deep clone of this.
     *
     * @return  A deep clone of this position.
     */
    public CombinatorialGame clone() {
        return new WythoffsNim(this.piles);
    }
    
    //@override
    public boolean equals(Object other) {
        try {
            WythoffsNim otherGame = (WythoffsNim) other;
            return this.equals(otherGame);
        } catch (ClassCastException cce) {
            return false;
        }
    }
    
    //@override
    public boolean equals(CombinatorialGame other) {
        try {
            WythoffsNim otherGame = (WythoffsNim) other;
            return this.equals(otherGame);
        } catch (ClassCastException cce) {
            return false;
        }
    }
    
    /**
     * Returns whether this equals another position.
     *
     * @param other     Another position.
     * @return          Whether this position equals the other.  This should compare identity, *NOT* equivalence.
     */
    public boolean equals(WythoffsNim other) {
        if (this.piles.equals(other.piles)) {
            return true;
        } else {
            return this.piles.equals(other.piles.getReverse());
        }
    }
    
    /**
     * Generator for Wythoff's Nim Games.
     */
    public static class PositionBuilder implements PositionFactory<WythoffsNim> {
        //maximum initial pile size
        private int maxPileSize;
        
        /**
         * Constructor
         * @param maxPileSize  The maximum size of a pile.
         */
        public PositionBuilder(int maxPileSize) {
            this.maxPileSize = maxPileSize;
        }
        
        /**
         * Generate a position!
         *
         * @return  A new WythoffsNim position.
         */
        public WythoffsNim getPosition() {
            Random random = new Random();
            int first = random.nextInt(this.maxPileSize + 1);
            int second = random.nextInt(this.maxPileSize + 1);
            return new WythoffsNim(new Pair<Integer, Integer>(first, second));
        }
    
    } //end of WythoffsNim.PositionBuilder
    
    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        WythoffsNim nim = new WythoffsNim(new Pair<Integer, Integer>(3, 5));
        System.out.println("nim: " + nim);
        System.out.println("Options for nim: " + nim.getOptions(CombinatorialGame.LEFT));
        
        //test out the Factory 
        PositionFactory<WythoffsNim> factory = new WythoffsNim.PositionBuilder(5);
        nim = factory.getPosition();
        System.out.println("Randomly generated position: " + nim);
        System.out.println("Another randomly generated position: " + factory.getPosition());
    }
   
   
} //end of WythoffsNim.java