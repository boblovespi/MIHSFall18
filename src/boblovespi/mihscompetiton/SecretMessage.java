package boblovespi.mihscompetiton;

import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class SecretMessage
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("message.txt", false);
		int size = s.nextInt();
		s.nextLine();
		for (int i = 0; i < size; i++)
		{
			String s1 = s.nextLine();
			String s2 = s.nextLine();
			String str = "";
			for (int j = 0; j < s1.length() && j < s2.length(); j++)
			{
				if (!(s1.charAt(j) == (s2.charAt(j))))
				{
					str += s2.charAt(j);
				}
			}
			if (str.equals("")){
				System.out.println("No change");
			}
			else
			{
				System.out.println(str);
			}
		}
	}
}
