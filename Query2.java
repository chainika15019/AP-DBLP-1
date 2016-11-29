import java.util.*;

public class Query2 {

	private ArrayList <Authors> authors = PREPROCESS.getAuthors();
	private int count = 0;
	ArrayList <String> names = new ArrayList <String>();


	Query2(int minPub)
	{

		for(int i = 0 ; i < authors.size() ; i++)
		{
			if(authors.get(i).getNumPub() >= minPub)
			{
				names.add(authors.get(i).getNames().get(0));
			}
		}

	}
	
	public ArrayList <String> getNames()
	{
		return names;
	}

}
