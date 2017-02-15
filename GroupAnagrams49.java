Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //remember map.keySet() map.values() containsKey(Object key) containsValue(Object value)
        //from char[] to String: String a = new String(char[]) or String a = String.valueOf(char[]);
        //From intger to string, can also use String.valueOf(int);
        //map key can be char[] not charactor[]
        //remember do not use Map<char[] List<String> here , as for two "" "" they are not groupped together for some reason.
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s =  String.valueOf(c); //somehow using new String(c) here hit time limit
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(strs[i]);
            map.put(s, list);  //remember not sure why this is needed
        }
        for (String key: map.keySet()){
            //System.out.println(" key is " + key[0]);
            res.add(map.get(key));
        }
        return res;
    }
}
