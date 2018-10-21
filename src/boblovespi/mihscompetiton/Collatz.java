package boblovespi.mihscompetiton;

import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class Collatz
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("collatz.txt", false);

		int length = s.nextInt();

		for (int i = 0; i < length; i++)
		{
			System.out.println(collatz(s.nextInt()));
		}
	}

	public static int collatz(int n)
	{
		if (n == 1)
			return 0;
		if (n % 2 == 1)
			return collatz(3 * n + 1) + 1;
		return collatz(n / 2) + 1;
	}
}
