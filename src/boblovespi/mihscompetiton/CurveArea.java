package boblovespi.mihscompetiton;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class CurveArea
{
	public static void main(String[] args) throws Exception
	{
		Scanner sr = NotALibrary.readFromFile("area.txt", true);
		String next;
		int length = sr.nextInt();
		for (int i = 0; i < length; i++)
		{
			double a, b, c, A, B, d, p, q, r, s;
			a = sr.nextDouble();
			sr.next();
			next = sr.next();
			if (next.equals("+"))
				b = sr.nextDouble();
			else
				b = -sr.nextDouble();
			sr.next();
			sr.next();
			c = sr.nextDouble();
			A = sr.nextDouble();
			sr.next();
			next = sr.next();
			if (next.equals("+"))
				B = sr.nextDouble();
			else
				B = -sr.nextDouble();
			sr.next();
			sr.next();
			d = sr.nextDouble();

			p = (B * c - b * d) / (B * a - b * A);
			q = (A * c - a * d) / (A * b - a * B);
			r = Math.min(d(c, a), d(d, A));
			s = Math.min(d(c, b), d(d, B));

			double answer = 0.5 * (q * r + s * p);
			String str = answer + "";
			NumberFormat format = (NumberFormat) NumberFormat.getNumberInstance().clone();
			format.setMaximumFractionDigits(3);
			format.setMinimumFractionDigits(3);
			format.setRoundingMode(RoundingMode.HALF_UP);
			System.out.println(format.format(answer));
		}
	}

	public static double d(double a, double b)
	{
		if (b == 0)
			return 1000000000;
		if (a / b < 0)
			return 1000000000;
		return a / b;
	}
}
