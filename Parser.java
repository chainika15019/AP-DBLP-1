import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;


public class Parser extends DefaultHandler{
	private boolean isauthor = false;
	private boolean istitle = false;
	private boolean ispages = false;
	private boolean isjournal = false;
	private boolean isurl = false;
	private boolean isee = false;
	private boolean isvolume = false;
	private boolean isyear = false;
	private int ct=0;
	private boolean toadd = true;

	ArrayList<Publication> publication = new ArrayList<Publication>(); 
	Publication tmp = new Publication();

	private String searchBy;
	private String nameOrTitle;
	private ArrayList <String> words = new ArrayList <String>();
	private int year = -1;
	private int rangeYearStart = -1;
	private int rangeYearEnd = Integer.MAX_VALUE;

	Parser(String sby,String not, String yr, String rys, String rye)
	{

		searchBy = sby;
		nameOrTitle = not;
		String s = "";
		for(int i = 0 ; i < nameOrTitle.size() ; i++)
		{
			if(nameOrTitle.get(i) == " ")
			{
				words.add(s);
				s = new String();
			}
			s += nameOrTitle.get(i);
		}
		if(yr.equals("") == false)
			year = Integer.parseInt(yr);
		if(rys.equals("") == false)
			rangeYearStart = Integer.parseInt(rys);
		if(rye.equals("") == false)
			rangeYearEnd = Integer.parseInt(rye);

	}

	
	
	private boolean Check()
	{

		if(year != -1)
		{
			if(tmp.year != year)
				return false;
		}
		if(tmp.year > rangeYearStart || tmp.year < rangeYearEnd)
			return false;

		if(searchBy.equals("Author"))
		{
			boolean tmp = false;
			for(int i=0; i < tmp.getNames.size(); i++)
			{
				if(tmp.getNames().get(i).contains(nameOrTitle))
			}
		}



		return true	;

	}


	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(ch,start,length);
		if(isauthor)
		{
			tmp.addAuthor(str);
			isauthor = false;
		}
		else if(istitle)
		{
			tmp.setTitle(str);
			istitle = false;
		}
		else if(ispages)
		{
			tmp.setPages(str);
			ispages = false;
		}
		else if(isjournal)
		{
			tmp.setJournal(str);
			isjournal = false;
		}
		else if(isurl)
		{
			tmp.setURL(str);
			isurl = false;
		}
		else if(isee)
		{
			tmp.setEE(str);
			isee = false;
		}
		else if(isvolume)
		{
			tmp.setVolume(str);
			isvolume = false;
		}
		else if(isyear)
		{
			tmp.setYear(Integer.parseInt(str));
			isyear = false;
		}
		
//		super.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
//		System.out.println(publication.get(0).getTitle());
//		System.out.println(publication.get(1).getTitle());
//		System.out.println(publication.get(2).getTitle());
		
		System.out.println(ct);
		System.out.println("END");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(Check())
		{
			publication.add(tmp);
			tmp = new tmp();
		}

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("START");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(tmp.getVal() == 0)
		{
			
			if(qName.equals("article"))
				tmp.setVal(1);
			else if(qName.equals("inproceedings"))
				tmp.setVal(2);
			else if(qName.equals("proceedings"))
				tmp.setVal(3);
			else if(qName.equals("book"))
				tmp.setVal(4);
			else if(qName.equals("incollection"))
				tmp.setVal(5);
			else if(qName.equals("phdthesis"))
				tmp.setVal(6);
			else if(qName.equals("masterthesis"))
				tmp.setVal(7);
			else if(qName.equals("www"))
				tmp.setVal(8);
		}
		else
		{
			if(qName.equals("author"))
				isauthor = true;
			else if(qName.equals("title"))
				istitle = true;
			else if(qName.equals("pages"))
				ispages = true;
			else if(qName.equals("journal"))
				isjournal = true;
			else if(qName.equals("url"))
				isurl = true;
			else if(qName.equals("ee"))
				isee = true;
			else if(qName.equals("volume"))
				isvolume = true;
			else if(qName.equals("year"))
				isyear = true;
			
		}
		
		// TODO Auto-generated method stub
		
	} 
	
}
