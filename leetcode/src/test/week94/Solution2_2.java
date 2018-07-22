package test.week94;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2_2 {

	int[] dx = { 0, 1, 0, -1 };
	int[] dy = { 1, 0, -1, 0 };
	int k = 0;

	public int robotSim(int[] commands, int[][] obstacles) {
		Set<List<Integer>> noway = new HashSet<>();
		for (int[] obstacle : obstacles) {
			noway.add(Arrays.asList(obstacle[0], obstacle[1]));
		}

		int ans = 0, x = 0, y = 0, k = 0;
		for (int command : commands) {
			// System.out.println(x + " " + y + " " + k);
			if (command == -2) {
				k = (k + 3) % 4;
			} else if (command == -1) {
				k = (k + 1) % 4;
			} else {
				for (int t = 0; t < command; t++) {
					int xx = x + dx[k];
					int yy = y + dy[k];
					if (noway.contains(Arrays.asList(xx, yy))) {
						break;
					} else {
						x = xx;
						y = yy;
						ans = Math.max(ans, x * x + y * y);
					}
				}
			}
		}

		return (int) ans;
	}

	public static void main(String[] args) {
		Solution2_2 sol = new Solution2_2();
		System.out.println(sol.robotSim(new int[] { 4, -1, 3 }, new int[][] {}));
		System.out.println(sol.robotSim(new int[] { 4, -1, 4, -2, 4 }, new int[][] { { 2, 4 } }));

	}

}
