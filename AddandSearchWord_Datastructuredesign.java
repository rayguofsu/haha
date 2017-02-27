 Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z. 

class TrieNode{
    boolean endsHere;
    TrieNode[] child;
    TrieNode(){
        endsHere = false;
        child = new TrieNode[26];
    }
}
public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null){
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.endsHere = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, root, 0);
    }
    private boolean helper(String word, TrieNode node, int start){
        //base case
        if (node == null) return false;
        if (start == word.length()){
            return node.endsHere;
        }
        
        char c = word.charAt(start);
        if (c == '.'){  
            for (int j = 0; j < 26; j++){
                boolean res = helper(word, node.child[j], start+1);
                if (res) return true;
            }
            return false;
        }
        else{
            int index = c - 'a';
            if (node.child[index] == null) return false;
            return helper(word, node.child[index], start+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
