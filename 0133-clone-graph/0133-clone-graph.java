/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node n, Map<Node, Node> map) {
        if (n == null)
            return null;
        if (map.containsKey(n))
            return map.get(n);
        Node copy = new Node(n.val);
        map.put(n, copy);
        for (Node curr : n.neighbors) {
            copy.neighbors.add(dfs(curr, map));
        }
        return copy;
    }

}