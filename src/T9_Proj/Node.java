package T9_Proj;

import java.util.HashMap;

class Node {

    HashMap<Character, Node> children;
    boolean end;
    int ch;
    String word;

    public Node(boolean b) {
        children = new HashMap<>();
        end = false;
        ch = 0;
    }
}
