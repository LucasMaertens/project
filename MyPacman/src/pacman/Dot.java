package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 * @immutable
 */
public class Dot {
	
	/**
	 * @invar square!= null
	 */
	private Square square;
	
	/**
	 * Returns the square of this Dot
	 * @basic
	 */
	public Square getSquare() {return square; }
	
	/**
	 * Initializes this dot with the given square
	 * @post the dot's square equals the given square
	 * 	| getSquare()==square
	 */
	public Dot(Square square) { 
		this.square = square; }

}
