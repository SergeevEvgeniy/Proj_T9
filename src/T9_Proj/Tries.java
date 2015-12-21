package T9_Proj;

import java.util.HashMap;

public class Tries {

    private final Node root;

    public Tries() {
        root = new Node(false);
    }

    public void search_all(String word, Node some) {
        //TODO for list<>
        Node crawl = some;
        char ch = 1;//
        while (!crawl.children.isEmpty()) { // пока есть куда ползти
            //keyset or values or entrySet
            }
    }

    HashMap search_list = new HashMap<>();

    public boolean search(String word) {
        //TODO already use
        Node crawl = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (crawl.children.get(ch) == null) {
                return false;
            } else {
                crawl = crawl.children.get(ch);
                if (i == n - 1) { //&& crawl.end == true) {
                    if (crawl.end == true) {
                        search_list.put(word, crawl.ch);
                    }
                    search_all(word, crawl);
                }
            }
        }
        return false;
    }

    public void add(String word) {
        Node crawl = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (crawl.children.containsKey(ch)) {
                crawl = crawl.children.get(ch);
            } else {
                final Node temp = new Node(false);
                crawl.children.put(ch, temp);
                crawl = temp;
            }
            if (i == n - 1) {
                crawl.end = true;
                crawl.ch += 1;
            }
            System.out.println(ch + " " + crawl.end + " " + crawl.ch);
        }
    }
}
