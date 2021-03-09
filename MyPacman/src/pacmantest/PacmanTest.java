package pacmantest;

import static org.junit.jupiter.api.Assertions.*;
import pacman.MazeMap;
import pacman.PacMan;
import pacman.Square;
import pacman.Direction;
import pacman.Ghost;

import org.junit.jupiter.api.Test;

class PacmanTest {

	@Test
	void test() {
		boolean[] passable= {true,true,false,false};
		MazeMap mazemap=new MazeMap(2,2,passable);
		Square vierkant =Square.of(mazemap, 0, 0);
		
		PacMan pacman=new PacMan(5,vierkant);
		assertEquals(true,mazemap.isPassable(0, 0));
		assertEquals(false,mazemap.isPassable(1, 1));
		assertEquals(2,mazemap.getHeight());
		assertEquals(2,mazemap.getWidth());
		assertEquals(5,pacman.getNbLives());
		pacman.die();
		
		
		assertEquals(4,pacman.getNbLives());
		pacman.die();
		pacman.die();
		pacman.die();
		
		
		
	
		//testen van square
		
		
		
		
		//best nog square getNeighbor testen, ik vertrouw die % niet helemaal, is dit niet gewoon de rest bij deling?
		assertEquals(new Square().of(mazemap, 0, 0).getMazeMap(),mazemap);
		assertEquals(new Square().of(mazemap, 1, 0).getRowIndex(),1);
		assertEquals(new Square().of(mazemap, 0, 1).getRowIndex(),0);
		assertEquals(new Square().of(mazemap, 1, 1).getColumnIndex(),1);
		assertEquals(new Square().of(mazemap, 1, 0).getColumnIndex(),0);
		assertEquals(new Square().of(mazemap, 0, 0).isPassable(),true);
		assertEquals(new Square().of(mazemap, 0, 0).equals(new Square().of(mazemap, 0, 0)),true);
		Direction[] lijstje =new Direction [1];
		
		
		lijstje[0]=Direction.LEFT;
		assertEquals(vierkant.canMove(Direction.LEFT),true);
		assertEquals(vierkant.canMove(Direction.UP),false);
		assertEquals(vierkant.canMove(Direction.DOWN),false);
		
		assertEquals(new Square().of(mazemap, 0, 0).canMove(Direction.LEFT),true);
		assertEquals(Direction.values()[0],Direction.RIGHT);
		assertEquals(lijstje[0],vierkant.getPassableDirectionsExcept(Direction.RIGHT)[0]);
		
		//+testen va ghost
		Ghost ghost=  new Ghost(vierkant,Direction.DOWN);
		//getdirection
		assertEquals(ghost.getDirection(),Direction.DOWN);
		//getsquare
		assertEquals(ghost.getSquare().equals(new Square().of(mazemap, 0, 0)),new Square().of(mazemap, 0, 0).equals(ghost.getSquare()));
		//setsquare
		//ghost.setSquare(new Square().of(mazemap, 1, 0));
		//assertEquals(ghost.getSquare().equals(new Square().of(mazemap, 1, 0)),true);
		//setdirection
		//ghost.setDirection(Direction.LEFT);
		
		
		// eerst terug beginnen met de Square class af te werken vooraleer door te gaan.
		
		
	}

}
