import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;


public class Parser1 extends DefaultHandler{
	private boolean isauthor = false;
	private boolean isyear = false;
	private int ct=0;
	private boolean toadd = true;
	private String authorName;
	private int mappedVal ;

	ArrayList<Publication> publication = new ArrayList<Publication>(); 
	Publication tmp = new Publication();

	private boolean authfound = false;

	HashMap hm = PREPROCESS.getHashing();

	private int[] pubyears = new int[85];

	public int[] getPubYears()
	{
		return pubyears;
	}

	Parser1(String authName)
	{
		if(authName != null)
		{
			authorName = authName;
			if(hm.containsKey(authorName))
			{
				mappedVal = (Integer)hm.get(authorName);
			}
		}
		for(int i=0; i<85;i++)
			pubyears[i] = 0;
	}

	public ArrayList <Publication> getPublication() {
		return publication;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(ch,start,length);
		if(isauthor)
		{
			tmp.addAuthor(str);
			if(hm.containsKey(str))
			{
				if(mappedVal == (Integer)hm.get(str))
					authfound = true;
			}
			isauthor = false;
		}
		else if(isyear)	{
			tmp.setYear(Integer.parseInt(str));
			isyear = false;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println(ct);
		System.out.println("END");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("article") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
		}
		else if(qName.equals("inproceedings") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
		}
		else if(qName.equals("proceedings") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
		}
		else if(qName.equals("book") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
		}
		else if(qName.equals("incollection") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
		}
		else if(qName.equals("phdthesis") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
		}
		else if(qName.equals("masterthesis") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
		}
		else if(qName.equals("www") && authfound)	{
			if(tmp.getYear() >= 1936)
				pubyears[tmp.getYear() - 1936] ++;
			authfound = false;
			}
		}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("START asdsdsd PalundsadrrrrRtstrdgbdgbrser");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(ct%100000 == 0)
			System.out.println(ct);
		ct++;
		if(qName.equals("article"))
			tmp = new Publication();
		else if(qName.equals("inproceedings"))
			tmp = new Publication();
		else if(qName.equals("proceedings"))
			tmp = new Publication();
		else if(qName.equals("book"))
			tmp = new Publication();
		else if(qName.equals("incollection"))
			tmp = new Publication();
		else if(qName.equals("phdthesis"))
			tmp = new Publication();
		else if(qName.equals("masterthesis"))
			tmp = new Publication();
		else if(qName.equals("www"))
			tmp = new Publication();
		else	{
			if(qName.equals("author"))
				isauthor = true;
			else if(qName.equals("year"))
				isyear = true;
		}
	} 
}
