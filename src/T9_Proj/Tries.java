package T9_Proj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tries {

    private final Node root;
    HashMap search_list;

    public Tries() {
        root = new Node(false);
    }

    String previous;

    private void search_all(String word, Node crawl) {
        //TODO ищет листья до конца слов
        if (!crawl.children.isEmpty()) { // пока есть уровень с буквами ниже
            Set<Map.Entry<Character, Node>> set = crawl.children.entrySet();
            for (Map.Entry<Character, Node> entry : set) {
                if (entry.getValue().end == true) {
                    search_list.put(entry.getValue().word + entry.getKey(), entry.getValue().ch);
                } else {
                    word += entry.getKey();
                    search_all(word, entry.getValue());
                }
            }
        }
    }

    public HashMap search(String word) {
        //TODO выделяет нужную ветку (введенное слово)
        Node crawl = root;
        search_list = new HashMap<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (crawl.children.get(ch) == null) {
                return search_list; // empty
            } else {
                crawl = crawl.children.get(ch);
                if (i == n - 1) {
                    if (crawl.end == true) {
                        search_list.put(word, crawl.ch);
                    }
                    search_all(word, crawl);
                }
            }
        }
        return search_list;//full;
    }

    public void add(String word, int number) {
        Node crawl = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (crawl.children.containsKey(ch)) {
                crawl = crawl.children.get(ch);
            } else {
                final Node temp = new Node(false);
                temp.word = word.substring(0, i);
                crawl.children.put(ch, temp);
                crawl = temp;
            }
            if (i == n - 1) {
                crawl.end = true;
                crawl.ch += 1;
                if (number != 0) {
                    crawl.ch = number;
                }
            }
        }
    }
}
