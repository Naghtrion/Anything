Um amigo me passou esta classe... ela verifica a similaridade entre palavras...  
Uso: StringSimilarity.similaridade("asd", "asd");


```java
public class StringSimilarity 
{
	public static double similaridade(String s1, String s2) 
	{
		try 
		{
			return similaridade1(s1, s2) * 100;
		} catch (Exception e) 
		{
			return 0;
		}
	}

	private static double similaridade1(String s1, String s2) 
	{
		String longer = s1, shorter = s2;
		if (s1.length() < s2.length()) 
		{
			longer = s2;
			shorter = s1;
		}
		int longerLength = longer.length();
		if (longerLength == 0)
			return 1.0;
		return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
	}

	private static int editDistance(String s1, String s2) 
	{
		int i, j, newValue;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] costs = new int[s2.length() + 1];
		for (i = 0; i <= s1.length(); i += 1) 
		{
			int lastValue = i;
			for (j = 0; j <= s2.length(); j += 1) 
			{
				if (i == 0)
					costs[j] = j;
				else 
					if (j > 0) 
					{
						newValue = costs[j - 1];
						if (s1.charAt(i - 1) != s2.charAt(j - 1))
							newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
			}
			if (i > 0)
				costs[s2.length()] = lastValue;
		}
		return costs[s2.length()];
	}
}
```
