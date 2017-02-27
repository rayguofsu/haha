 Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z. 

/*
    public class Node {
    boolean endsHere;
    Node[] child;
    Node(){
        endsHere = false;
        child = new Node[26];
    }
    }
    */ //remember can put this class outside or inside Trie class; either one should be OK.
public class Trie {
    public class Node {
    boolean endsHere;
    Node[] child;
    Node(){
        endsHere = false;
        child = new Node[26];
    }
    }
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++){
            int indx = word.charAt(i) - 'a';
            if (node.child[indx] == null){
                node.child[indx] = new Node();
            }
            node = node.child[indx];
        }
        node.endsHere = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++){
            int indx = word.charAt(i) - 'a';
            if (node.child[indx] == null){
                return false;
            }
            node = node.child[indx];
        }
        return node.endsHere == true;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++){
            int indx = prefix.charAt(i) - 'a';
            if (node.child[indx] == null){
                return false;
            }
            node = node.child[indx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
