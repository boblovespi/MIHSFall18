package boblovespi.mihscompetiton;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class OddsEvens
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("oae.txt", false);

		int length = s.nextInt();
		s.nextLine();

		for (int ai = 0; ai < length; ai++)
		{
			String[] numsS = s.nextLine().split(" ");
			Integer[] nums = new Integer[numsS.length];

			for (int i = 0; i < numsS.length; i++)
			{
				nums[i] = Integer.parseInt(numsS[i]);
			}

			Arrays.sort(nums, new OddEvenComparator());
			for (Integer num : nums)
			{
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static class OddEvenComparator implements Comparator<Integer>
	{
		@Override
		public int compare(Integer a, Integer b)
		{
			if (a % 2 == 1)
			{
				if (b % 2 == 0)
					return -1;
				return a - b;
			}
			if (b % 2 == 0)
				return a - b;
			return 1;
		}
	}

}
