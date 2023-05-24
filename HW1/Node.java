
public class Node {
    private State curr_State;// the node's current state
    private Action former_Action;// the action that has lead to the current state
    private Node parent;// the former node that this node is his expansion

    /**
     * the node's constructor
     * @param curr_State the node's current state
     * @param former_Action the action that has lead to the current state
     * @param parent the former node that this node is his expansion
     */
    public Node(State curr_State, Action former_Action, Node parent) {
        this.curr_State = curr_State;
        this.former_Action = former_Action;
        this.parent = parent;
    }

    /**
     * The root's node constructor(has no former action and parent)
     * @param curr_State the node's current state
     */
    public Node(State curr_State) {
        this(curr_State, null, null);
    }

    /**
     * get the node's current state
      * @return current state
     */

    public State getState() {
        return curr_State;
    }

    /**
     * get the node's former action that has lead to this state
     * @return former action
     */
    public Action getAction() {
        return former_Action;
    }

    /**
     * get the node's parent
     * @return node's parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * this function creates an array of the node's children by the possible actions array
     * @return the children array
     */
    public Node[] expand() {
        Action[] actions = curr_State.actions();
        int len_Act = actions.length;
        Node[] children = new Node[len_Act];
        for (int i = 0; i < len_Act; i++) {
            children[i] = new Node(curr_State.result(actions[i]), actions[i], this);
        }
        return children;
    }

    /**
     * the algorithm that improves the search for the solution of the puzzle- it calculate the total distances of each tile from the goal state.
     * it calculates the distance of the current tile from the place it should be.
     * @return a non-negative number that represents the distance from the goal state.
     */
    public int heuristicValue() {
       Tile[][] curr_Board = curr_State.getBoard().getTiles();
       int n = curr_Board.length;
       int m = curr_Board[0].length;
       int sum = 0;
       for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (curr_Board[i][j] != null) {
               int curr_Value = curr_Board[i][j].getValue();
               int target_Row = (curr_Value - 1) / m;//calculate where it should be using "/" operator
               int target_Col = (curr_Value - 1) % m;//calculate where it should be using "%" operator
               int diff_Row = i - target_Row;
               int diff_Col = j - target_Col;
               if(diff_Col<0)// if the distance is negative
                   diff_Col=-diff_Col;
               if(diff_Row<0)//// if the distance is negative
                   diff_Row=-diff_Row;
               int diff=diff_Col+diff_Row;
               sum += diff;
            }
          }
       }
       return sum;
    }
}