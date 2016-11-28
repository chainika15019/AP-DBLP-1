import java.lang.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;


public class PREPROCESS extends DefaultHandler{
	private boolean isauthor = false;
	private boolean iswww = false;
	private ArrayList <Authors> authors = new ArrayList <Authors>();
	private Authors tmp_auth = new Authors();
	private int ct = 0;
	private HashMap hm = new HashMap();
	// private Charsequence shit = "homepages/";

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(ch,start,length);

		if(isauthor && iswww)
		{
			// System.out.println("SA");
			tmp_auth.addAuthor(str);
			// if(tmp_auth.getNames().size() == 2)
			// 	System.out.println(tmp_auth.getNames().size());

			isauthor = false;
			// iswww = false;
			if(tmp_auth.getMappedVal() == -1)
			{
				tmp_auth.setMappedVal();
			}
			// hm.put(str,tmp_auth.getMappedVal());
			// tmp_auth = new Authors();
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
//		System.out.println(publication.get(0).getTitle());
//		System.out.println(publication.get(1).getTitle());
//		System.out.println(publication.get(2).getTitle());
		
		System.out.println((authors.get(0).getNames()).size());
		System.out.println((authors.get(1).getNames()).size());
		System.out.println((authors.get(2).getNames()).size());
		System.out.println((authors.get(2).getMappedVal()));
		// System.out.println(hm.get("Patrick A. V. Hall"));

		// System.out.println(ct);
		System.out.println("END");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("www"))
		{
			authors.add(tmp_auth);
			tmp_auth = new Authors();
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

		boolean p = false;
		// int len =
			// System.out.println(attributes.getValue(1));

		if(qName.equals("www"))
		{
			// System.out.println("HERE");
			for(int i=0;i < attributes.getLength(); i++)
			{
		// if(attributes.getName(i).equals("key"))
		// {
				if(attributes.getValue(i).contains("homepages/"))
				{
					p = true;
					// System.out.println("YES");					
				}
			// }
			}
			if(p)
			{
				tmp_auth = new Authors();
				iswww = true;
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