import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;


public class PREPROCESS1 extends DefaultHandler{
	private boolean isauthor = false;
	private int ct=0;
	private boolean toadd = true;
	private boolean iswww = false;
	private String tmptype;

	private ArrayList <Authors> authors = PREPROCESS.getAuthors();
	private HashMap hm = PREPROCESS.getHashing();	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(ch,start,length);
		if(isauthor && !iswww)
		{
			if(hm.containsKey(str))
				authors.get((Integer)hm.get(str)).addNumPub();
			else
			{
				System.out.println(str);				
			}
		}
		isauthor = false;
		
//		super.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		// System.out.println(publication.get(0).getTitle());
		// System.out.println(publication.get(1).getTitle());
		// System.out.println(publication.get(2).getTitle());
		System.out.println(hm.get("Semra Tunali"));
		System.out.println(authors.get((Integer)hm.get("Semra Tunali")).getNumPub());

		// System.out.println(ct);
		System.out.println("END");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(ct%100000 == 0)
		{
			System.out.println(ct);
		}
		ct++;

		if(qName.equals("www"))
		{
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
//		ct++;
		tmptype = qName;
		if(qName.equals("www"))
		{
			// System.out.println("HERE");
			for(int i=0;i < attributes.getLength(); i++)
			{
		// if(attributes.getName(i).equals("key"))
		// {
				if(attributes.getValue(i).contains("homepages/"))
				{
					iswww = true;
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
