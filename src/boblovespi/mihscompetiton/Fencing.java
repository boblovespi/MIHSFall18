package boblovespi.mihscompetiton;

import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class Fencing
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("fence.txt", false);
		int size = s.nextInt();
		for (int i = 0; i < size; i++){
			int rows = s.nextInt();
			int cols = s.nextInt();
			int topi = rows;
			int boti = 0;
			int lefti = cols;
			int righti = 0;
			for (int row = 0; row <= rows; row++){
				String line = s.nextLine();
				for (int k = 0; k < line.length(); k++){
					if (line.charAt(k) == 'x' || line.charAt(k) == 'X'){
						topi = Math.min(topi, row);
						boti = Math.max(boti, row);
						lefti = Math.min(lefti, k);
						righti = Math.max(righti, k);
					}
				}
			}
			System.out.println((boti - topi + 1) + " " + (righti - lefti + 1));
		}
	}
}
