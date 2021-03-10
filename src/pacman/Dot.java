package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 * @immutable
 */
public class Dot {
	
	/**
	 * @invar square!= null
	 * 
	 */
	private Square square;
	/**
	 * 
	 * @basic
	 */
	public Square getSquare() {return square; }
	/**
	 * 
	 * @post | getSquare()==square
	 */
	
	public Dot(Square square) { 
		this.square = square; }

}
