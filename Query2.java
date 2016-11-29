import java.util.*;

public class Query2 {

	private ArrayList <Authors> authors = PREPROCESS.getAuthors();
	private int count = 0;


	Query2(int minPub)
	{

		for(int i = 0 ; i < authors.size() ; i++)
		{
			if(authors.get(i).getNumPub() >= minPub)
			{
				System.out.println(authors.get(i).getNames().get(0));
				count ++;
			}
		}
		System.out.println(count);

	}

}