package boblovespi.mihscompetiton;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class NotALibrary
{
	public static final String USER_PATH = "C:\\Users\\willi\\Desktop\\SampleFiles\\";
	public static final String JUDGE_PATH = "D:\\JudgeFiles\\";

	public static Scanner readFromFile(String fileName, boolean isSampleFile) throws FileNotFoundException
	{
		String path = isSampleFile ? USER_PATH : JUDGE_PATH;
		return new Scanner(new FileReader(path + fileName));
	}

	public static int add(int a, int b, int c, int... d)
	{
		return a + b + c;
	}
}