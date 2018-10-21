package boblovespi.mihscompetiton;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class WordChoice
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("word.txt", false);
		int size = s.nextInt();
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < size; i++)
		{
			String s1 = s.next();
			String s2 = s.next();
			map.put(s1, s2);
			map.put(s2, s1);
		}
		size = s.nextInt();
		s.nextLine();
		for (int i = 0; i < size; i++)
		{
			String[] words = s.nextLine().split(" ");
			String res = "";
			for (String word : words)
			{
				String[] split = word.split("[^\\w]");
				String[] split2 = word.split("\\w+");
				word = split[0];

				if (map.containsKey(word))
				{
					if (split2.length <= 1)
						res += map.get(word) + " ";
					else
						res += map.get(word) + split2[1] + " ";
				} else
				{
					if (split2.length <= 1)
						res += word + " ";
					else
						res += word + split2[1] + " ";
				}
			}
			System.out.println(res);
		}
	}
}
