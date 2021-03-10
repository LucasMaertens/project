package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 * @invar |getSquare()!=null
 * @invar| getNbLives()>=0
 */
public class PacMan {
	/**
	 * @invar | nblives>=0
	 * @invar | square!=null
	 */
	private int nblives;
	private Square square;
	
	/**
	 * 
	 * @basic
	 */
	public Square getSquare() { 
		return square;
	}
	/**
	 *@basic
	 */
	public int getNbLives() { return nblives; }
	/**
	 * 
	 * @throw IllegalArgumentException | nbLives<=0 
	 * @throw IllegalArgumentException| square==null
	 * @post | getNbLives()==nbLives
	 * @post | getSquare()==square
	 * 	 */

	public PacMan(int nbLives, Square square) {
		if (nbLives<=0)
			throw new IllegalArgumentException("nblives must be greater than zero");
		if (square==null)
			throw new IllegalArgumentException("square can't be null");
		this.nblives=nbLives;
		this.square=square;
	}
	/**
	 * 
	 * @throws IllegalArgumentException| square==null
	 * @post| getSquare()==square
	 * @post | getNbLives()==old(getNbLives())
	 * @mutates|this
	 * @inspects | square //NIET ZEKER
	 */
	public void setSquare(Square square) { 
		if(square==null)
			throw new IllegalArgumentException("Square is not allowed to be null.");
		this.square=square;
	}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @post | getNbLives()==old(getNbLives())-1
	 * @post| getSquare()==old(getSquare())
	 * @mutates|this
	 * @inspects|this
	 * @throws RuntimeException | getNbLives()==1  // LIJKT HIJ NIET TE PAKKEN WANT BLIJFT GRIJS?
	 * 
	 */
	public void die() {
		
		if(getNbLives()==0)  
			throw new RuntimeException("out of lives");
		else
			nblives--;
			
	}

}
