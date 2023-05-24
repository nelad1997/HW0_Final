/**
 * represents a single action in the game
 */
public class Action {
    private Tile tile;//the tile that we can move
    private Direction direction;// in each direction we can move it

    /**
     * the action's constructor
     * @param tile //the tile that we can move
     * @param direction // in each direction we can move it
     */
    public Action(Tile tile, Direction direction) {
        this.tile = tile;
        this.direction = direction;
    }

    /**
     * get the action's tile
     * @return the tile
     */

    public Tile getTile() {
        return tile;
    }

    /**
     *  get the action's direction
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * a string that represents the action
     * @return the string
     */
    public String toString() {
        return "Move " + tile.getValue() + " " + direction;
    }
}
