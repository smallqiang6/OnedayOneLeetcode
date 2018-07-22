package test.week94;


/*
https://leetcode-cn.com/contest/weekly-contest-94/problems/walking-robot-simulation/
	
	874. ���߻�����ģ��
	�û�ͨ������ 0
	�û����Դ��� 0
	ͨ������ 0
	�ύ���� 0
	��Ŀ�Ѷ� Easy
	���������ϵĻ����˴ӵ� (0, 0) ����ʼ���������򱱷����û����˿��Խ��������������͵����

	-2������ת 90 ��
	-1������ת 90 ��
	1 <= x <= 9����ǰ�ƶ� x ����λ����
	��һЩ���񷽿鱻�����ϰ�� 

	�� i ���ϰ���λ�������  (obstacles[i][0], obstacles[i][1])

	�����������ͼ�ߵ��ϰ����Ϸ�����ô����ͣ�����ϰ����ǰһ�����񷽿��ϣ�����Ȼ���Լ�����·�ߵ����ಿ�֡�

	���ش�ԭ�㵽�����˵����ŷʽ�����ƽ����

	 

	ʾ�� 1��

	����: commands = [4,-1,3], obstacles = []
	���: 25
	����: �����˽��ᵽ�� (3, 4)
	ʾ�� 2��

	����: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
	���: 65
	����: ����������ת�ߵ� (1, 8) ֮ǰ�������� (1, 4) ��
	 

	��ʾ��

	0 <= commands.length <= 10000
	0 <= obstacles.length <= 10000
	-30000 <= obstacle[i][0] <= 30000
	-30000 <= obstacle[i][1] <= 30000
	�𰸱�֤С�� 2 ^ 31
	*/
public class Solution2 {

	int maxdis = 0;
	int direction = 0;// ��0 ��1 ��2 ��3
	int x = 0;
	int y = 0;
	void turnAndMove(int command,int[][] obstacles) {
		System.out.println("before:x,y,d,cmd" +x+" "+y+" "+ direction +" "+command );
		if(command > 0) {//move
			switch (direction) {
			case 0:
				for(int i = 0; i < obstacles.length;i++) {
					if(obstacles[i][0] == x) {
						if(y+command >= obstacles[i][1] && y <obstacles[i][1])
						{
							y = obstacles[i][1]-1;
							return;
						}
					}
				}
				y = y+command;
				break;
			case 1:
				for(int i = 0; i < obstacles.length;i++) {
					if(obstacles[i][1] == y) {
						if(x+command >= obstacles[i][0] && x < obstacles[i][0])
						{
							x = obstacles[i][0]-1;
							return;
						}
					}
				}
				x = x+command;
				break;
			case 2:
				for(int i = 0; i < obstacles.length;i++) {
					if(obstacles[i][0] == x) {
						if(y-command <= obstacles[i][1] && y > obstacles[i][1])
						{
							y = obstacles[i][1]+1;
							return;
						}
					}
				}
				y = y-command;
				break;
			case 3:
				for(int i = 0; i < obstacles.length;i++) {
					if(obstacles[i][1] == y) {
						if(x-command <= obstacles[i][0] && x > obstacles[i][0] )
						{
							x = obstacles[i][0]+1;
							return;
						}
					}
				}
				x = x-command;
				break;

			default:
				break;
			}
		}
		if(command < 0) {
			if(command == -1) {
				direction = (direction+1)%4;
			}
			if(command == -2) {
				direction = (direction+4-1)%4;
			}
		}
		//System.out.println("before:x,y,d,cmd" +x+" "+y+" "+ direction +" "+command );
	}
	public int robotSim(int[] commands, int[][] obstacles) {
		
		for(int i = 0;i < commands.length; i++) {
			int command = commands[i];
			//��ÿһ��
			turnAndMove(command,obstacles);
			maxdis = Math.max(maxdis, x*x+y*y);	
			System.out.println(maxdis);
		}	
		
		return maxdis;
    }

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] obstacles = {{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
		int[] cmds = {-2,8,3,7,-1};
		System.out.println(new Solution2().robotSim(cmds, obstacles));
	}

}
