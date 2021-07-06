package jdbc_4;

import java.util.*;

/*
 * Encapsulates a Sudoku grid to be solved.
 * CS108 Stanford.
 */
public class Sudoku {
	// Provided grid data for main/testing
	// The instance variable strategy is up to you.
	
	// Provided easy 1 6 grid
	// (can paste this text into the GUI too)
	public  int[][] yong;
	public String[] jiefa=new String[100];
	public static int count=0;
	public long run_time=0;
	public static final int[][] easyGrid = Sudoku.stringsToGrid(
	"1 6 4 0 0 0 0 0 2",
	"2 0 0 4 0 3 9 1 0",
	"0 0 5 0 8 0 4 0 7",
	"0 9 0 0 0 6 5 0 0",
	"5 0 0 1 0 2 0 0 8",
	"0 0 8 9 0 0 0 3 0",
	"8 0 9 0 4 0 2 0 0",
	"0 7 3 5 0 9 0 0 1",
	"4 0 0 0 0 0 6 7 9");
	
	
	// Provided medium 5 3 grid
	public static final int[][] mediumGrid = Sudoku.stringsToGrid(
	 "530070000",
	 "600195000",
	 "098000060",
	 "800060003",
	 "400803001",
	 "700020006",
	 "060000280",
	 "000419005",
	 "000080079");
	
	// Provided hard 3 7 grid
	// 1 solution this way, 6 solutions if the 7 is changed to 0
	public static final int[][] hardGrid = Sudoku.stringsToGrid(
	"3 7 0 0 0 0 0 8 0",
	"0 0 1 0 9 3 0 0 0",
	"0 4 0 7 8 0 0 0 3",
	"0 9 3 8 0 0 0 1 2",
	"0 0 0 0 4 0 0 0 0",
	"5 2 0 0 0 6 7 9 0",
	"6 0 0 0 2 1 0 4 0",
	"0 0 0 5 3 0 9 0 0",
	"0 3 0 0 0 0 0 5 1");
	
	public static final int[][] ff = Sudoku.stringsToGrid(
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0",
	"0 0 0 0 0 0 0 0 0");
	
	
	public static final int SIZE = 9;  // size of the whole 9x9 puzzle
	public static final int PART = 3;  // size of each 3x3 part
	public static final int MAX_SOLUTIONS = 100;
	
	
	// Provided various static utility methods to
	// convert data formats to int[][] grid.
	
	/**
	 * Returns a 2-d grid parsed from strings, one string per row.
	 * The "..." is a Java 5 feature that essentially
	 * makes "rows" a String[] array.
	 * (provided utility)
	 * @param rows array of row strings
	 * @return grid
	 */
	public static int[][] stringsToGrid(String... rows) {
		int[][] result = new int[rows.length][];
		for (int row = 0; row<rows.length; row++) {
			result[row] = stringToInts(rows[row]);
		}
		return result;
	}
	
	
	/**
	 * Given a single string containing 81 numbers, returns a 9x9 grid.
	 * Skips all the non-numbers in the text.
	 * (provided utility)
	 * @param text string of 81 numbers
	 * @return grid
	 */
	public static boolean cha(int x,int y,int result[][])
	{
		for (int row = 0; row<SIZE; row++) 
		{
			
		
			if(result[row][y]==result[x][y])
			{
				if(row==x)
					continue;
				return false;
			}
		}
		for (int col = 0; col<SIZE; col++) 
		{
			
		
			if(result[x][col]==result[x][y])
			{
				if(col==y)
					continue;
				return false;
			}
		}
		int i,j;
		
		if(x>=0&&x<3 && y>=0&&y<3)//第一个正方形
    	{
    		for(i=0;i<3;i++)
    		{
    			for(j=0;j<3;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    				
    	    		
    			}
    		}
    	}
    	
    	if(x>=3&&x<6 && y>=0&&y<3)//第二个正方形
    	{
    		for(i=3;i<6;i++)
    		{
    			for(j=0;j<3;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
    	
    	if(x>=6&&x<9 && y>=0&&y<3)//第三个正方形
    	{
    		for(i=6;i<9;i++)
    		{
    			for(j=0;j<3;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
    	
    	if(x>=0&&x<3 && y>=3&&y<6)//第四个正方形
    	{
    		for(i=0;i<3;i++)
    		{
    			for(j=3;j<6;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
    	
    	if(x>=3&&x<6 && y>=3&&y<6)//第五个正方形
    	{
    		for(i=3;i<6;i++)
    		{
    			for(j=3;j<6;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
    	
    	if(x>=6&&x<9 && y>=3&&y<6)//第六个正方形
    	{
    		for(i=6;i<9;i++)
    		{
    			for(j=3;j<6;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
    	
    	if(x>=0&&x<3 && y>=6&&y<9)//第七个正方形
    	{
    		for(i=0;i<3;i++)
    		{
    			for(j=6;j<9;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
    	
    	if(x>=3&&x<6 && y>=6&&y<9)//第八个正方形
    	{
    		for(i=3;i<6;i++)
    		{
    			for(j=6;j<9;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
    	
    	if(x>=6&&x<9 && y>=6&&y<9)//第九个正方形
    	{
    		for(i=6;i<9;i++)
    		{
    			for(j=6;j<9;j++)
    			{
    				if(i==x&&j==y)
    					continue;
    				if(result[i][j]==result[x][y])
    					return false;
    			}
    		}
    	}
		return true;
		
	}
	
	public static int[][] textToGrid(String text) {
		int[] nums = stringToInts(text);
		
		if (nums.length != SIZE*SIZE) {
			throw new RuntimeException("Needed 81 numbers, but got:" + nums.length);
		}
		
		int[][] result = new int[SIZE][SIZE];
		int count = 0;
		for (int row = 0; row<SIZE; row++) {
			for (int col=0; col<SIZE; col++) {
				result[row][col] = nums[count];
				count++;
			}
		}
		for (int row = 0; row<SIZE; row++) 
		{
			
		
			for (int col=0; col<SIZE; col++) 
			{
				if(result[row][col]==0)
					continue;
				else if(cha(row,col,result))
				{
					continue;
				}
				else
				{
					throw new RuntimeException("inlegal num: in " + row+","+col);
				}
			}
		}
		return result;
	}
	
	public static String InttoString(int n[][])
	{
		String ge="	    ";
		String str="";
		for (int row = 0; row<SIZE; row++) 
		{
			str+=ge;
			for (int col=0; col<SIZE; col++) 
			{
				str=str+n[row][col];
				str+=" ";
			}
			str+="\n";
		}
			
		return str;
		
	}
	
	
	/**
	 * Given a string containing digits, like "1 23 4",
	 * returns an int[] of those digits {1 2 3 4}.
	 * (provided utility)
	 * @param string string containing ints
	 * @return array of ints
	 */
	public static int[] stringToInts(String string) {
		int[] a = new int[string.length()];
		int found = 0;
		for (int i=0; i<string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				a[found] = Integer.parseInt(string.substring(i, i+1));
				found++;
			}
		}
		int[] result = new int[found];
		System.arraycopy(a, 0, result, 0, found);
		return result;
	}


	
	// Provided -- the deliverable main().
	// You can edit to do easier cases, but turn in
	// solving hardGrid.
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		
		Sudoku sudoku;
		sudoku = new Sudoku();
		sudoku.set_yong(sudoku.hardGrid);
		
		System.out.println(sudoku); // print the raw problem
	 sudoku.solve(0);
	 long end = System.currentTimeMillis();
	 sudoku.run_time=end-start;
		System.out.println("elapsed:：" + (end - start) + "ms");
		
		
		
	}
	
	
	

	/**
	 * Sets up based on the given ints.
	 */
	@SuppressWarnings("static-access")
	public Sudoku() {
		this.count=0;
		
	}
	
	
	
	/**
	 * Solves the puzzle, invoking the underlying recursive search.
	 */
    @SuppressWarnings("static-access")
    public void set_yong(int n[][])
    {
    	this.yong=n;
    	
    }
    public void show()
    {
    	
    	
    	int i,j;
    	for(i=0;i<9;i++)
    	{
    		for(j=0;j<9;j++)
    		{
    			System.out.print(this.yong[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    	
    }
	@SuppressWarnings("static-access")
	public ArrayList<Integer>panduan(int x,int y)
    {
		
    	ArrayList<Integer> n=new ArrayList<Integer>();;
    	int i,j;
    	for(i=1;i<=9;i++)
    	{
    		n.add(i);
    	}
    	
    	
    	for(i=0;i<9;i++)//横排
    	{
    		if(this.yong[x][i]==0)
    			continue;
    		if(i==y)
    			continue;
    		if(n.contains(this.yong[x][i]))
    		{
    			int o=0;
    			for(int u:n)
    			{
    				if(u==this.yong[x][i])
    				{
    					n.remove(o);
    					break;
    				}
    				o++;
    			}
    			
    			
    			
    		}
    	}
    	
    	
    	for(j=0;j<9;j++)//竖排
    	{
    		if(this.yong[j][y]==0)
    			continue;
    		if(j==x)
    			continue;
    		if(n.contains(this.yong[j][y]))
    		{
    			int o=0;
    			for(int u:n)
    				
    			{
    				if(u==this.yong[j][y])
    				{
    					n.remove(o);
    					break;
    				}
    				o++;
    			}
    		}
    	}
    	
    	//下面是正方形内的判定
    	if(x>=0&&x<3 && y>=0&&y<3)//第一个正方形
    	{
    		for(i=0;i<3;i++)
    		{
    			for(j=0;j<3;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=3&&x<6 && y>=0&&y<3)//第二个正方形
    	{
    		for(i=3;i<6;i++)
    		{
    			for(j=0;j<3;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=6&&x<9 && y>=0&&y<3)//第三个正方形
    	{
    		for(i=6;i<9;i++)
    		{
    			for(j=0;j<3;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    				
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=0&&x<3 && y>=3&&y<6)//第四个正方形
    	{
    		for(i=0;i<3;i++)
    		{
    			for(j=3;j<6;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=3&&x<6 && y>=3&&y<6)//第五个正方形
    	{
    		for(i=3;i<6;i++)
    		{
    			for(j=3;j<6;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=6&&x<9 && y>=3&&y<6)//第六个正方形
    	{
    		for(i=6;i<9;i++)
    		{
    			for(j=3;j<6;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=0&&x<3 && y>=6&&y<9)//第七个正方形
    	{
    		for(i=0;i<3;i++)
    		{
    			for(j=6;j<9;j++)
    			{
    				if(this.yong[j][y]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=3&&x<6 && y>=6&&y<9)//第八个正方形
    	{
    		for(i=3;i<6;i++)
    		{
    			for(j=6;j<9;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	if(x>=6&&x<9 && y>=6&&y<9)//第九个正方形
    	{
    		for(i=6;i<9;i++)
    		{
    			for(j=6;j<9;j++)
    			{
    				if(this.yong[i][j]==0)
    	    			continue;
    				if(i==x&&j==y)
    					continue;
    	    		if(n.contains(this.yong[i][j]))
    	    		{
    	    			int o=0;
    	    			for(int u:n)
    	    			{
    	    				if(u==this.yong[i][j])
    	    				{
    	    					n.remove(o);
    	    					break;
    	    				}
    	    				o++;
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	return n;
    	
    }
	@SuppressWarnings("static-access")
	public void solve(int n) {
		
		  
	           if (n == 81)
	           {//是否已经是最后一个格子
	               //show();
	             
	               this.jiefa[count]=this.InttoString(this.yong);
	              
	               count++;
	              // System.out.println("这是第"+count+"种解法");
	               
	               return;
	           }
	           if(count>=100)
	        	   return;
	         

	            int i = n / 9, j = n % 9;

	           if (this.yong[i][j] != 0) 
	           {//如果当前格子不需要填数字，就跳到下一个格子
	        	   solve(n + 1);
	        	   return;
	           }

	           
	               if (panduan(i, j).size()!=0)
	               {
	            	  for(int kk:panduan(i,j))
	            	  {
	            		//  System.out.println(panduan(i,j));
	            		 // System.out.println("成功，这里是："+i+","+j+"填了"+kk);
	            		  this.yong[i][j]=kk;
	            		  solve(n + 1);//验证通过，就继续下一个
	            		 
	            		 
	            	  }
	               }
	           

	           this.yong[i][j] = 0;  //如果上面的单元无解，就回溯
			
			
	       
		
		 // YOUR CODE HERE
	}
	
	

}

