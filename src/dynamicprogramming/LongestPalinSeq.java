package dynamicprogramming;

public class LongestPalinSeq
{
	public static void main(String[] arg)
	{
		longestPalinSeq("DERRQEZD");
	}// DERRED

	public static void longestPalinSeq(String str)
	{
		int n = str.length();
		StringBuffer buf = new StringBuffer();
		int memo[][] = new int[n][n];
		char palin[][] = new char[n][n];

		for (int i = 0; i < n; i++)
		{
			memo[i][i] = 1;
			palin[i][i] = str.charAt(i);
		}

		for (int i = 0; i < n - 1; i++)
		{
			if (str.charAt(i) == str.charAt(i + 1))
			{
				memo[i][i + 1] = 2;
			} else
			{
				memo[i][i + 1] = 1;
			}
		}

		for (int len = 3; len <= n; len++)
		{
			for (int i = 0; i < n - len + 1; i++)
			{
				int j = i + len - 1;
				if (str.charAt(i) == str.charAt(j))
				{
					memo[i][j] = 2 + memo[i + 1][j - 1];
				} else
				{
					memo[i][j] = Math.max(memo[i][j - 1], memo[i + 1][j]);
				}
			}

		}
		System.out.println(memo[0][n - 1]);
		System.out.println("number of insertions " + (str.length() - memo[0][n - 1]));
		printMatrix(memo);
	}

	public static void printMatrix(int[][] palin)
	{
		int n = palin.length;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(palin[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	/*
	 * Method commented below is to print longest palindrome subsequence
	 */

	/*
	 * public static void printLongestPalin(int[][] mem) { int n = mem.length;
	 * int i = 0; int j = n - 1; int pos = mem[i][j]; boolean flag = false;
	 * 
	 * while(pos>=0){
	 * 
	 * if(mem[i][j-1] == mem[i+1][j]){
	 * 
	 * res += s[j];
	 * 
	 * i++; j--; } else{
	 * 
	 * j--; }
	 * 
	 * pos = mem[i][j];
	 * 
	 * if(pos == 1){ flag = true; }
	 * 
	 * }
	 * 
	 * 
	 * reverse(res.begin(),res.end()); string sub;
	 * 
	 * 
	 * 
	 * if(flag){
	 * 
	 * sub = res.substr(1); reverse(sub.begin(),sub.end()); res = sub + res; }
	 * else{
	 * 
	 * sub = res.substr(0); reverse(sub.begin(),sub.end()); res = sub + res; }
	 * cout<<res<<endl; }
	 */

}
