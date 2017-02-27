
 There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]

There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
            List<Integer> list = map.getOrDefault(prerequisites[i][0], new ArrayList<Integer>());
            list.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], list);
        }
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            if (!dfs(map, i, visited, res)) return new int[0];
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
    private boolean dfs(Map<Integer, List<Integer>> map, int id, int[] visited, List<Integer> res){
        if (visited[id] == 2) return true;
        if (visited[id] == 1) return false;
        visited[id] = 1;
        List<Integer> list = map.get(id);
        if (list != null){
            for (int i = 0; i < list.size(); i++){
                if (!dfs(map, list.get(i), visited, res)){
                return false;
                }
            }
        }
        visited[id] = 2;
        res.add(id);
        return true;
    }
    

}
