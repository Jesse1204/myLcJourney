import java.util.HashMap;

import jdk.nashorn.internal.ir.Node;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return clone(node, visited);
    }
    
    public Node clone(Node n, Map<Node, Node> v) {
        Node clone = new Node(n.val, new ArrayList<>());
        v.put(n, clone);
        for (Node neighbor : n.neighbors) {
            Node neighborClone = v.get(neighbor);
            if (neighborClone == null) {
                clone.neighbors.add(clone(neighbor, v));
            } else {
                clone.neighbors.add(neighborClone);
            }
        }
        return clone;
    }
}

