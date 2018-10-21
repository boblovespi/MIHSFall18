package boblovespi.mihscompetiton;

import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class EscapeRoom
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("escape.txt", true);
		int cases = s.nextInt();
		for (int k = 0; k < cases; k++)
		{
			int rows = s.nextInt();
			int col = s.nextInt();
			s.nextLine();
			char[][] arr = new char[rows][col];
			for (int i = 0; i < arr.length; i++)
			{
				String line = s.nextLine();
				for (int j = 0; j < arr[0].length; j++)
				{
					arr[i][j] = line.charAt(j);
				}
			}
			int starti = 0;
			int startj = 0;
			for (int i = 0; i < arr.length; i++)
			{
				for (int j = 0; j < arr[0].length; j++)
				{
					if (arr[i][j] == 'O')
					{
						arr[i][j] = arr[i][j - 1];
					} else if (arr[i][j] == 'S')
					{
						starti = i;
						startj = j;
					}
				}
			}
			System.out.println(r(arr, starti, startj, starti, startj, 0));
		}
	}

	public static int r(char[][] arr, int i, int j, int previ, int prevj, int time)
	{
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length)
		{
			return Integer.MAX_VALUE;
		}
		char c = arr[i][j];
		arr[previ][prevj] = 'N';
		if (c == 'N')
		{
			return Integer.MAX_VALUE;
		}
		if (c == 'X')
		{
			return time;
		}
		if (c == 'A')
		{
			return Math.min(
					r(arr, i + 1, j, i, j, time + 10), Math.min(
							r(arr, i - 1, j, i, j, time + 10),
							Math.min(r(arr, i, j + 1, i, j, time + 10), r(arr, i, j - 1, i, j, time + 10))));
		}
		if (c == 'F')
		{
			return Math.min(
					r(arr, i + 1, j, i, j, time + 20), Math.min(
							r(arr, i - 1, j, i, j, time + 20),
							Math.min(r(arr, i, j + 1, i, j, time + 20), r(arr, i, j - 1, i, j, time + 20))));
		}
		if (c == 'G')
		{
			return r(arr, i, j - 1, i, j, time + 10);
		}
		if (c == 'L')
		{
			if (i != previ)
			{
				if (previ > i)
				{
					return r(arr, i - 1, j, i, j, time);
				}
				return r(arr, i + 1, j, i, j, time);
			} else if (j != prevj)
			{
				if (prevj > j)
				{
					return r(arr, i, j - 1, i, j, time);
				}
				return r(arr, i, j + 1, i, j, time);
			} else
			{
				System.out.println("ERROR ON 70");
			}
		}
		return Math.min(
				r(arr, i + 1, j, i, j, time), Math.min(
						r(arr, i - 1, j, i, j, time),
						Math.min(r(arr, i, j + 1, i, j, time), r(arr, i, j - 1, i, j, time))));

	}
}
