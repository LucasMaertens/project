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
		boolean[] passable= {true,true,false,false,true,true};
		MazeMap mazemap=new MazeMap(3,2,passable);
		Square vierkantx=Square.of(mazemap, 0, 0);
		Square vierkant =Square.of(mazemap, 0, 0);
		Square vierkant2=Square.of(mazemap, 0, 1);
		Square vierkant3=Square.of(mazemap, 0, 2);
		Square vierkant4=Square.of(mazemap, 1, 0);
		Square vierkant5=Square.of(mazemap, 1, 1);
		Square vierkant6=Square.of(mazemap, 1, 2);
		
		//Square vierkantfout=Square.of(mazemap, -1, 0);
		//Square vierkantfout2=Square.of(mazemap, 1, 4);
		//Square vierkantfout3=Square.of(null, 1, 0);
		PacMan pacman=new PacMan(5,vierkant);
		assertEquals(true,mazemap.isPassable(0, 0));
		assertEquals(true,mazemap.isPassable(1, 2));
		assertEquals(2,mazemap.getHeight());
		assertEquals(3,mazemap.getWidth());
		assertEquals(5,pacman.getNbLives());
		pacman.die();
		
		
		assertEquals(4,pacman.getNbLives());
		pacman.die();
		pacman.die();
		pacman.die();
		
		
		
	
		//testen van square
		
		
		
		
		
		assertEquals(new Square().of(mazemap, 0, 0).getMazeMap(),mazemap);
		assertEquals(new Square().of(mazemap, 1, 0).getRowIndex(),1);
		assertEquals(new Square().of(mazemap, 0, 1).getRowIndex(),0);
		assertEquals(new Square().of(mazemap, 1, 1).getColumnIndex(),1);
		assertEquals(new Square().of(mazemap, 1, 0).getColumnIndex(),0);
		assertEquals(new Square().of(mazemap, 1, 1).isPassable(),true);
		assertEquals(vierkant6.isPassable(),true);
		assertEquals(vierkant3.isPassable(),false);
		assertEquals(new Square().of(mazemap, 0, 0).equals(new Square().of(mazemap, 0, 0)),true);
		Direction[] lijstje =new Direction [2];
		
		assertEquals(vierkant.getNeighbor(Direction.LEFT).equals(vierkant3),true);
		assertEquals(vierkant4.getNeighbor(Direction.UP).equals(vierkant),true);
		assertEquals(vierkant3.getNeighbor(Direction.RIGHT).equals(vierkant),true);
		lijstje[0]=Direction.RIGHT;
		lijstje[1]=Direction.UP;
		assertEquals(vierkant5.canMove(Direction.RIGHT),true);
		assertEquals(vierkant5.canMove(Direction.UP),true);
		assertEquals(vierkant5.canMove(Direction.DOWN),true);
		
		assertEquals(vierkant2.canMove(Direction.LEFT),true);
		assertEquals(Direction.values()[0],Direction.RIGHT);
		assertEquals(Direction.UP,vierkant5.getPassableDirectionsExcept(Direction.RIGHT)[0]);
		assertEquals(3,vierkant5.getPassableDirectionsExcept(Direction.LEFT).length);
		assertEquals(0,vierkant6.getPassableDirectionsExcept(Direction.LEFT).length);
		
		assertEquals(vierkant.canMove(Direction.RIGHT),true);
		assertEquals(vierkant2.canMove(Direction.LEFT),true);
		assertEquals(vierkant6.canMove(Direction.DOWN),false);
		//+testen va ghost
		Ghost ghost=  new Ghost(vierkant,Direction.DOWN);
		Ghost ghost2=new Ghost(vierkant2,Direction.LEFT);
		Ghost ghost3= new Ghost(vierkant3,Direction.DOWN);
		ghost3=null;
		assertEquals(null,ghost3);
		
		//getdirection
		assertEquals(ghost.getDirection(),Direction.DOWN);
		
		//getsquare
		assertEquals(ghost.getSquare().equals(new Square().of(mazemap, 0, 0)),new Square().of(mazemap, 0, 0).equals(ghost.getSquare()));
		assertEquals(ghost2.getSquare().equals(new Square().of(mazemap, 0, 1)),true);
		//setsquare
		ghost.setSquare(vierkant2);
		assertEquals(ghost.getSquare().equals(ghost2.getSquare()),true);
		//setdirection
		ghost.setDirection(Direction.LEFT);
		assertEquals(ghost.getDirection(),Direction.LEFT);
		;
		
		
		
		// eerst terug beginnen met de Square class af te werken vooraleer door te gaan.
		
		
	}

}
