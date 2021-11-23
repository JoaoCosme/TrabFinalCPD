package service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreTrie {
    private static final int R = 256;
    private Node root;

    private static class Node
    {
        private int val;
        private final Node[] next = new Node[R];
    }
    private Node get(Node x, String key, int d)
    {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void put(String key, int val)
    {  root = put(root, key, val, 0);  }

    private Node put(Node x, String key, int val, int d)
    {
        if (x == null) x = new Node();
        if (d == key.length()) {  x.val = val; return x; }
        char c = key.charAt(d);
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