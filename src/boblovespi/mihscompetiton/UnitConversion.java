package boblovespi.mihscompetiton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Willi on 10/20/2018.
 */
public class UnitConversion
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = NotALibrary.readFromFile("conversion.txt", false);
		int length = s.nextInt();
		for (int i = 0; i < length; i++)
		{
			HashMap<String, HashSet<ConversionFactor>> conversionFactors = new HashMap<>(length);

			int convL = s.nextInt();
			for (int j = 0; j < convL; j++)
			{
				double from = s.nextInt();
				String fromN = s.next();
				s.next();
				double to = s.nextInt();
				String into = s.next();

				if (!conversionFactors.containsKey(fromN))
					conversionFactors.put(fromN, new HashSet<ConversionFactor>()
					{{
						add(new ConversionFactor(from, to, into));
					}});
				else
					conversionFactors.get(fromN).add(new ConversionFactor(from, to, into));

				if (!conversionFactors.containsKey(into))
					conversionFactors.put(into, new HashSet<ConversionFactor>()
					{{
						add(new ConversionFactor(to, from, fromN));
					}});
				else
					conversionFactors.get(into).add(new ConversionFactor(to, from, fromN));
			}

			double from = s.nextInt();
			String fromName = s.next();
			s.next();
			String into = s.next();

			System.out.println(Math.round(traverse(conversionFactors, fromName, into, from, new HashSet<>(10))));
		}
	}

	private static double traverse(HashMap<String, HashSet<ConversionFactor>> conversionFactors, String fromName,
			String into, double from, HashSet<String> hasTraversed)
	{
		HashSet<ConversionFactor> conversions = conversionFactors.get(fromName);
		hasTraversed.add(fromName);
		for (ConversionFactor c : conversions)
		{
			if (c.into.equals(into))
				return from / c.from * c.to;
			if (hasTraversed.contains(c.into))
				continue;
			double v = traverse(conversionFactors, c.into, into, from / c.from * c.to, hasTraversed);
			if (v > 0)
				return v;
		}
		return -1;
	}

	public static class ConversionFactor
	{
		public double from;
		public double to;
		public String into;

		ConversionFactor(double from, double to, String into)
		{
			this.from = from;
			this.to = to;
			this.into = into;
		}
	}
}

