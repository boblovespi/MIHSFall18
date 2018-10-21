package boblovespi.mihscompetiton;

import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class Merchant
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("merchant.txt", false);
		int size = s.nextInt();
		for (int i = 0; i < size; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			double c = s.nextDouble();
			System.out.println(a*b*(1-c));
		}
	}
}
