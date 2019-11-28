package de.uniwue.gdp.labyrinth.model;

import de.uniwue.gdp.labyrinth.examples.Examples;

public interface Maze {

    final class Direction {
    	public static final int LEFT = 0;
    	public static final int AHEAD = 1;
    	public static final int RIGHT = 2;
    	public static final int BACK = 3;
    }

    /*
public int getWidth(){
        return this.
}

    public static void main(String[] args) {


        /**
         * @return the total width of this maze.
*/
        int width();
  /*      Examples.EXAMPLES


    }
    /**
     * @return the total height of this maze.
     */
    int height();
    String Hashtags();
    /**
     * Checks whether there is a wall in the given direction or not.
     * @param direction the direction to check.
     * @return true if and only if there is a wall in the given direction.
     */
    boolean isWall(int direction);

    /**
     * Marks this field of the maze in the given direction. Every field can have multiple marks in arbitrary directions.
     * @param direction the direction to mark.
     */
    void mark(int direction);

    /**
     * Gets the number of marks on the current field in the given direction.
     * @param direction the direction the marks are oriented.
     * @return the number of marks.
     */
    int marks(int direction);

    /**
     * Walks in the given direction.
     * @param direction the direction to walk.
     */
    void walk(int direction);
}
