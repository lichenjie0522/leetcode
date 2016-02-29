package medium;

import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * This problem is equivalent to finding if a cycle exists in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be
 * impossible to take all courses.
 * 
 * @author lichenjie0522
 *
 */
public class No207_CourseSchedule {

	boolean hasCycle = false;
	Stack<Integer> reversePost = new Stack<Integer>();  //store topological ordering vertex
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length < 2) {
			return true;
		}
		boolean[] visited = new boolean[numCourses];
		boolean[] trace = new boolean[numCourses];
		
		for (int v = 0;v < numCourses; ++v) {
			if (hasCycle) {
				return false;
			}
			if (!visited[v]) {
				dfs(v, prerequisites, visited, trace);
			}
		}
		return true;
	}

	private void dfs(int v, int[][] prerequisites, boolean[] visited, boolean[] trace) {
		trace[v] = true;
		visited[v] = true;
		for (int[] edge : prerequisites) {
			if (edge[1] == v) {
				if (!visited[edge[0]]) {
					dfs(edge[0], prerequisites, visited, trace);
				} else {
					if (trace[edge[0]]) {
						hasCycle = true;
					}
				}
			}
		}
		trace[v] = false;
		reversePost.push(v);
	}
}
