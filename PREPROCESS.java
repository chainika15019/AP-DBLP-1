import java.lang.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;


public class PREPROCESS extends DefaultHandler{
	private boolean isauthor = false;
	private boolean iswww = false;
	static private ArrayList <Authors> authors = new ArrayList <Authors>();
	private Authors tmp_auth ;
	private int ct = 0;
	static private HashMap hm = new HashMap();
	// private Charsequence shit = "homepages/";

	static public ArrayList <Authors> getAuthors()
	{
		return authors;
	}

	static public HashMap getHashing()
	{
		return hm;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(ch,start,length);

		if(isauthor && iswww)
		{
			tmp_auth.addAuthor(str);
			// if(tmp_auth.getNames().size() == 2)
			// {
			// 	System.out.println("here");
			// }
			if(tmp_auth.getMappedVal() == -1)
			{
				tmp_auth.setMappedVal();
			}

			hm.put(str,tmp_auth.getMappedVal());	
		}
		
		isauthor = false;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
//		System.out.println(publication.get(0).getTitle());
//		System.out.println(publication.get(1).getTitle());
//		System.out.println(publication.get(2).getTitle());
		
		System.out.println((authors.get(0).getNames()).get(0));
		System.out.println((authors.get(1).getNames()).get(0));
		System.out.println((authors.get(2).getNames()).get(0));
		System.out.println((authors.get(2).getMappedVal()));
		System.out.println(hm.get("Patrick A. V. Hall"));

		// System.out.println(ct);
		System.out.println("END");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("www") && iswww)
		{
			authors.add(tmp_auth);
			// if(authors.get(100000).getNames().size())
			// {
			// 	System.out.println(authors.get(0).getNames().get(0));
			// }
			iswww = false;
		}

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("START");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		ct++;
		if(ct%100000 == 0)
			System.out.println(authors.size() + "  " + ct);
		// if(attributes.contains("homepages/"))
		// 	System.out.println(ct);


		if(qName.equals("www"))
		{
			// System.out.println("HERE");
			for(int i=0;i < attributes.getLength(); i++)
			{
		// if(attributes.getName(i).equals("key"))
		// {
				if(attributes.getValue(i).contains("homepages/"))
				{
		tmp_auth = new Authors();
					iswww = true;
					break;
					// System.out.println("YES");
				}
			// }
			}
		}
		else
		{
			if(qName.equals("author"))
			{
				isauthor = true;
			}
		}
		
		// TODO Auto-generated method stub
		
	} 
	
}
