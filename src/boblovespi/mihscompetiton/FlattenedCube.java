package boblovespi.mihscompetiton;

import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class FlattenedCube
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("cube.txt", true);
		int cases = s.nextInt();
		String[][] arr = new String[4][4];
		for (int p = 0; p < cases; p++)
		{
			s.nextLine();
			for (int i = 0; i < 4; i++)
			{
				String str = s.nextLine();
				for (int j = 0; j < 4; j++)
				{
					arr[i][j] = Character.toString(str.charAt(j));
				}
			}

			String face1 = s.next();
			int posX, posY;

			for (int i = 0; i < arr.length; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					if (arr[i][j].equals(face1))
					{
						posX = i;
						posY = j;
					}
				}
			}

			int oX, oY;

		}
	}
}
