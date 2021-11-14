package service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreTrie {
    private static final int R = 256; // radix
    private Node root;          // root of trie

    private static class Node
    {
        private int val;
        private final Node[] next = new Node[R];
    }
    private Node get(Node x, String key, int d)
    {  // Return value associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    }

    public void put(String key, int val)
    {  root = put(root, key, val, 0);  }

    private Node put(Node x, String key, int val, int d)
    {  // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) {  x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
    public List<Integer> keysWithPrefix(String pre)
    {
        List<Integer> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }
    private void collect(Node x, String pre,
                         List<Integer> q)
    {

        if (x == null) return;
        if (x.val != 0) q.add(x.val);
        for (char c = 0; c < R; c++)
            collect(x.next[c], pre + c, q);
    }
}