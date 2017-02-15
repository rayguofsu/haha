Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want. 
public class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};//remember
        char[] c = digits.toCharArray();
        if (c.length == 0) return new ArrayList<String>();
        return helper(map, c, c.length - 1);
    }
    private List<String> helper(char[][] map, char[] c, int index){
        List<String> res = new ArrayList<String>();
        int num = c[index] - '0';
        if (index == 0){
            for (int i = 0; i < map[num].length; i++){
                res.add(map[num][i] + "");
            }
            return res;
        }
        
        List<String> prev = helper(map, c, index - 1);
        char[] row = map[num];
        for (int i = 0; i < row.length; i++){
            for (int j = 0; j < prev.size(); j++){
                res.add(prev.get(j) + row[i]);
            }
        }
        return res;
    }
}
