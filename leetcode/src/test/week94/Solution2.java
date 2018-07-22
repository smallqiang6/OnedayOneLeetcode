package test.week94;


/*
https://leetcode-cn.com/contest/weekly-contest-94/problems/walking-robot-simulation/
	
	874. 行走机器人模拟
	用户通过次数 0
	用户尝试次数 0
	通过次数 0
	提交次数 0
	题目难度 Easy
	无限网格上的机器人从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

	-2：向左转 90 度
	-1：向右转 90 度
	1 <= x <= 9：向前移动 x 个单位长度
	有一些网格方块被视作障碍物。 

	第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])

	如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。

	返回从原点到机器人的最大欧式距离的平方。

	 

	示例 1：

	输入: commands = [4,-1,3], obstacles = []
	输出: 25
	解释: 机器人将会到达 (3, 4)
	示例 2：

	输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
	输出: 65
	解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
	 

	提示：

	0 <= commands.length <= 10000
	0 <= obstacles.length <= 10000
	-30000 <= obstacle[i][0] <= 30000
	-30000 <= obstacle[i][1] <= 30000
	答案保证小于 2 ^ 31
	*/
public class Solution2 {

	int maxdis = 0;
	int direction = 0;// 北0 东1 南2 西3
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
			//对每一个
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
