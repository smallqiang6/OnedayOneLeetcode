package test.week97;
//
//889. �������� III
//�û�ͨ������ 66
//�û����Դ��� 76
//ͨ������ 66
//�ύ���� 125
//��Ŀ�Ѷ� Medium
//�� R �� C �еľ����ϣ����Ǵ� (r0, c0) �泯���濪ʼ
//
//��������������λ�ڵ�һ�е�һ�У�����Ķ��Ͻ�λ�����һ�����һ�С�
//
//���ڣ�������˳ʱ�밴����״���ߣ����ʴ������е�ÿ��λ�á�
//
//ÿ�������ƶ�������ı߽�֮��ʱ�����ǻ����������֮�����ߣ����Ժ���ܻ᷵�ص�����߽磩��
//
//���գ����ǵ������������ R * C ���ռ䡣
//
//���շ���˳�򷵻ر�ʾ����λ�õ������б�
//
// 
//
//ʾ�� 1��
//
//���룺R = 1, C = 4, r0 = 0, c0 = 0
//�����[[0,0],[0,1],[0,2],[0,3]]
//
//
// 
//
//ʾ�� 2��
//
//���룺R = 5, C = 6, r0 = 1, c0 = 4
//�����[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
//
//
//
// 
//
//��ʾ��
//
//1 <= R <= 100
//1 <= C <= 100
//0 <= r0 < R
//0 <= c0 < C
public class Solution2 {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int dir = 0; // east
		int total = 0;
		int len = 1;

		int r = r0;
		int c = c0;

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int[][] res = new int[R * C][2];
		res[0] = new int[] { r0, c0 };
		total++;
		while (total < R * C) {
			for (int i = 0; i < len; i++) {
				r = r + dx[dir];
				c = c + dy[dir];
				if (r >= 0 && r < R && c >= 0 && c < C) {
					res[total++] = new int[] { r, c };
					// System.out.println("r = " + r + " c = " + c);
				}
			}

			dir = (dir + 1) % 4;

			for (int i = 0; i < len; i++) {
				r = r + dx[dir];
				c = c + dy[dir];
				if (r >= 0 && r < R && c >= 0 && c < C) {
					res[total++] = new int[] { r, c };
					// System.out.println("r = " + r + " c = " + c);
				}
			}

			dir = (dir + 1) % 4;
			len++;

		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
