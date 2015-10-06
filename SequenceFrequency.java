import java.util.*; 

public class SequenceFrequency
{
	public static void main(String[] args)
	{
		/*
		Scanner scanner = new Scanner(new File("clean5UTR.csv"));
        HashMap<String, String> mapCSV = new HashMap<String, String>();
        while(scanner.hasNext()){
            String current = scanner.next();
            Scanner row = new Scanner(current);
            row.useDelimiter(",");
            mapCSV.put(row.next(), row.next());
            row.close();
        }
		*/

		String seq = "gcccagcccccaccagtccactgcacggccgtagtcattgtcctccagcacct";
		TreeMap<String,Integer> freqs = getFreqs(4,seq);

		for(Map.Entry<String,Integer> e: freqs.entrySet())
		{
			System.out.println(e.getKey() + " "+e.getValue());
		}
	}


	public static boolean similar(String a, String b)
	{
		for(int i = 0; i < a.length(); ++i)
		{
			if(a.charAt(i) != b.charAt(i) && b.charAt(i) != 'x')
			{
				return false;
			}
		}

		return true; 
	}

	public static ArrayList<String> generateMasks(String s)
	{
		return new ArrayList<String>();
	}

	public static TreeMap<String,Integer> getFreqs(int windowSize, String seq)
	{
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();

		int start = 0; 
		int end = windowSize; 

		while(end  < seq.length())
		{
			String sub = seq.substring(start,end);
			if(!map.containsKey(sub))
			{
				map.put(sub,freq(sub,seq));
			}
			start++;
			end++;
		}

		return map;
	}

	public static int freq(String subseq, String seq)
	{
		int start = 0;
		int end = subseq.length(); 
		int counter = 0; 
		while(end  < seq.length())
		{
			if(seq.substring(start,end).equals(subseq))
			{
				counter++;
			}
			start++;
			end++;
		}

		return counter; 
	}
}
