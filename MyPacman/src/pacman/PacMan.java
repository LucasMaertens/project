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
	 * Returns the square where the pacman currently is
	 * @basic
	 */
	public Square getSquare() { 
		return square;
	}
	/*
	 * Returns the number of lives the pacman has left
	 * @basic
	 */
	public int getNbLives() { return nblives; }
	
	
	/**
	 * Initialises this pacman with the given nbLives and square
	 * @throw IllegalArgumentException | nbLives<=0 || square==null
	 * @post | getNbLives()==nbLives
	 * @post | getSquare()==square
	 */
	public PacMan(int nbLives, Square square) {
		if (nbLives<=0)
			throw new IllegalArgumentException("nblives must be greater than zero");
		if (square==null)
			throw new IllegalArgumentException("square can't be null");
		this.nblives=nbLives;
		this.square=square;
	}
	/**
	 * sets the square of the pacman to the given square
	 * @throws IllegalArgumentException| square==null
	 * @post| getSquare()==square
	 * @post | getNbLives()==old(getNbLives())
	 * @mutates|this
	 * @inspects | square//XXXXXXXXXXX niet zeker
	 */
	public void setSquare(Square square) { 
		if(square==null)
			throw new IllegalArgumentException("Square is not allowed to be null.");
		this.square=square;
	}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @post | getNbLives()==old(getNbLives())-1
	 * @post | getSquare()==old(getSquare())
	 * @throws RuntimeException | getNbLives()==1
	 * @mutates | this
	 * @inspects | this
	 */
	public void die() {
		if (this.nblives==1)
			throw new RuntimeException("Game Over");
		else
			nblives--;
	}

}
