package boblovespi.mihscompetiton;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class Patterns
{
	public static String patStr = "";
	public static int patSize = 1;
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("C:\\Users\\Willi\\Documents\\MIHSFall18\\pattern.txt");
		Scanner sc = new Scanner(fr);
		int len = sc.nextInt();
		sc.nextLine();
		patStr = "";
		patSize = 1;
		for (int i = 0; i < len; i++)
		{
			patSize = 1;
			patStr = "";
			String line = sc.nextLine();
			line = line.replaceAll("\\s+","");
			f(0, 1, "", line);
			for (int l = 0; l < patStr.length() - 1; l++){
				System.out.print(patStr.charAt(l) + " ");
			}
			System.out.println(patStr.charAt(patStr.length()));
			System.out.println(patSize);
		}
	}

	private static int f(int i, int size, String pat, String str)
	{
		if ((i >= str.length()) || (size*2 > str.length()))
		{
			return 1;
		}
		pat += str.charAt(i);
		for (int k = 0; k < pat.length(); k++){
			if (pat.charAt(k + i) != str.charAt(k + i)){
				return Math.max(f(i + 1, 1, "", str), f(i + 1, size + 1, pat, str));
			}
		}
		if (size > patSize){
			patStr = pat;
			patSize = size;
		}
		return Math.max(size, Math.max(f(i + 1, 1, "", str), f(i + 1, size + 1, pat, str)));
	}
}
