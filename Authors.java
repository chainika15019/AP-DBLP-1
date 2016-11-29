import java.util.*;

public class Authors {
	static private int mval = -1;
	// static Has
	private ArrayList <String> names ;
	private int mappedVal = -1;
	private int numPub = 0;
	private int Val=1;

	Authors()
	{
		mval++;
		names = new ArrayList<String>();
	}

	public int getVal()
	{
		return Val;
	}

	public void setVal(int val)
	{
		Val = val;
	}

	public int getNumPub()
	{
		return numPub;
	}

	public void addNumPub()
	{
		numPub++;
	}

	public void addAuthor(String name)
	{
		names.add(name);
	}

	public void setMappedVal()
	{
		mappedVal = mval;
	}

	public ArrayList <String> getNames()
	{
		return names;
	}

	public int getMappedVal()
	{
		return mappedVal;
	}

}
