package dynamic_programming.maximalRectangle;

import java.util.Stack;

/*
 * 
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 * 
 * 
 * ¿¿Æ×²Î¿¼£ºhttps://blog.csdn.net/doc_sgl/article/details/11805519
 * ÊäÈë: [2,1,5,6,2,3]
 * Êä³ö: 10
 */

public class Solution2 {

	public int largestRectangleArea_bianli(int[] heights) {
		int end = heights.length;  
        int begin = 0;  
        int largestarea = 0;  
        for(int i = begin; i < end; ++i)  
        {  
            int area;  
            int high = heights[i];  
            for(int j = i; j < end; ++j){  
                if(heights[j] < high) high = heights[j];  
                area = (j - i + 1)*high;  
                if(area > largestarea) largestarea = area;  
            }  
        }  
        return largestarea;  
 
    }
	public int largestRectangleArea(int[] heights) {
        int res=0;
        
        int myheights[] = new int[heights.length + 1];
        System.arraycopy(heights, 0, myheights, 0, heights.length);
        myheights[heights.length] = 0;
        
        Stack<Integer> stk=new Stack<Integer>();
        
        int i = 0;  
        int maxArea = 0;  
        while(i < myheights.length){  
            if(stk.empty() || myheights[stk.peek()] <= myheights[i]){  
                stk.push(i++);  
            }else {  
                int t = stk.peek();  
                stk.pop();  
                maxArea = Math.max(maxArea, myheights[t] * (stk.empty() ? i : i - stk.peek() - 1));  
            }  
        }  
        return maxArea;  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data1 [] = {2,1,5,6,2,3};
		if(10 == new Solution2().largestRectangleArea(data1))
		{
			System.out.println("testcase1 pass");
		}

	}

}
