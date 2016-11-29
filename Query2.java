import java.util.*;

public class Query2 {

	private ArrayList <Authors> authors = PREPROCESS.getAuthors();
	private int count = 0;


	Query2(int minPub)
	{
		int max = authors.get(0).getNumPub();
		int j = 0;
		for(int i = 0 ; i < authors.size() ; i++)
		{
			if(authors.get(i).getNumPub() > max)
			{
				max = authors.get(i).getNumPub();
				j = i;
				// System.out.println(authors.get(i).getNames().get(0));
				count ++;
			}
		}
		System.out.println(max);
		System.out.println(authors.get(j).getNames().get(0));
	}

}
