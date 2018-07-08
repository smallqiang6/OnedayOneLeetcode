package test.week92;

public class Solution1 {

	public int[][] transpose(int[][] A) {

		int a[][] = new int[A[0].length][A.length];

		for (int i = 0; i < A[0].length; i++) {

			for (int j = 0; j < A.length; j++)

			{

				a[i][j] = A[j][i];

			}

		}

		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] in = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] out = new Solution1().transpose(in);
		
		for (int i = 0; i < in[0].length; i++) {

			for (int j = 0; j < in.length; j++) {
				System.out.print(in[j][i]);
			}
			System.out.println();
			// [[1,4],[2,5],[3,6]}
		}
		System.out.println("----------");
		
		for (int i = 0; i < out[0].length; i++) {

			for (int j = 0; j < out.length; j++) {
				System.out.print(out[j][i]);
			}
			System.out.println();
			// [[1,4],[2,5],[3,6]}
		}
	}
}
