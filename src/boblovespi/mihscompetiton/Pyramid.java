package boblovespi.mihscompetiton;

import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class Pyramid
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("pyramid.txt", false);

		int length = s.nextInt();

		for (int i = 0; i < length; i++)
		{
			System.out.println(sumSquares(s.nextInt()));
		}
		// System.out.println(sumSquares(100000000));
	}

	public static long sumSquares(long n)
	{
		long sum = 0;
		for (long i = 0; i <= n; i++)
		{
			sum += i * i;
		}
		return sum;
	}
}
