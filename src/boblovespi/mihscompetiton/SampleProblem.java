package boblovespi.mihscompetiton;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class SampleProblem
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner s = NotALibrary.readFromFile("practice.txt", true);

		int size = s.nextInt();
		s.nextLine();

		for (int i = 0; i < size; i++)
		{
			String string = s.nextLine();
			int sum = 0;
			String[] nums = string.split(" ");
			for (String num : nums)
			{
				sum += Integer.parseInt(num);
			}
			System.out.println(sum);
		}
		Scanner sr = NotALibrary.readFromFile("rubiks.txt", true);
		while (sr.hasNext())
		{
			String next = sr.next();
			String[] chars = next.split("");
			for (String char1 : chars)
			{
				System.out.println((int) char1.charAt(0));
			}
		}
	}
}