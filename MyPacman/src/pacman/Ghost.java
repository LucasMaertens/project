package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 * @invar | getSquare()!=null
 * @invar | getDirection()!=null
 */

public class Ghost {
	
	/**
	 * @invar | square!=null
	 * @invar | direction!=null
	 */
	private Square square;
	private Direction direction;
	
	/*
	 * Return the square where the ghost currently is
	 * @basic
	 */
	public Square getSquare() { return square; }
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 *@basic
	 */
	public Direction getDirection() { 
		
		return direction;
	}
	
	/**
	 * Initialises this ghost with the given square and direction
	 * @throws IllegalArgumentException| square==null||direction==null
	 * @post | getSquare()==square
	 * @post | getDirection()==direction
	 */
	public Ghost(Square square, Direction direction) { 
		if (square==null)
			throw new IllegalArgumentException("square can not be null");
		if (direction==null)
			throw new IllegalArgumentException("direction can not be null");
		
		this.square=square;
		this.direction=direction;
		
	}
	/**
	 * Sets the ghosts square to the given square
	 * @throws IllegalArgumentException| (square instanceof Square)==false
	 * @post| getSquare()==square
	 * @post | getDirection()==old(getDirection())
	 * @mutates|this
	 * @inspects | square //XXXXXXXXXXX niet zeker
	 */
	public void setSquare(Square square) {
		if (square instanceof Square)//Is dit wel nodig???
			
			this.square=square;
		else 
			throw new IllegalArgumentException("argument must be instance of Square");
	}
	
	/**
	 * Sets the ghosts direction to the given direction
	 * @throws IllegalArgumentException| (direction instanceof Direction)==false//XXXXXXX is dit nodig???
	 * @post | getDirection()==direction
	 * @post | getSquare()==old(getSquare())
	 * @mutates| this
	 * @inspects | direction//XXXXXXXXXXX niet zeker
	 */
	
	public void setDirection(Direction direction) { 
		if (direction instanceof Direction)
			
			this.direction=direction;
		else 
			throw new IllegalArgumentException("argument must be instance of Direction");
	}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
