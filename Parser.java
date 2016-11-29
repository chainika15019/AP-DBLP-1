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

	HashMap hm = PREPROCESS.getHashing();

	private String searchBy;
	private String nameOrTitle;
	private ArrayList <String> wordsTitle = new ArrayList <String>();
	private int year = -1;
	private int rangeYearStart = -1;
	private int rangeYearEnd = Integer.MAX_VALUE;

	Parser(String sby,String not, String yr, String rys, String rye)
	{

		searchBy = sby;
		nameOrTitle = not;
		String s = "";
		for(int i = 0 ; i < nameOrTitle.length() ; i++)
		{
			if(nameOrTitle.charAt(i) == ' ')
			{
				wordsTitle.add(s);
				s = new String();
			}
			else
				s += nameOrTitle.charAt(i);
		}
		if(yr.equals("") == false)
			year = Integer.parseInt(yr);
		if(rys.equals("") == false)
			rangeYearStart = Integer.parseInt(rys);
		if(rye.equals("") == false)
			rangeYearEnd = Integer.parseInt(rye);

		System.out.println(searchBy + "	" + nameOrTitle + "	" + year + "	" + rangeYearStart + "	" + rangeYearEnd);

	}
	
	private boolean Check()
	{

		if(year != -1)
		{
			if(tmp.getYear() != year)
				return false;
		}
		if(tmp.getYear() < rangeYearStart || tmp.getYear() > rangeYearEnd)
			return false;

		if(searchBy.equals("Author"))
		{
			boolean x = false;
			for(int i=0; i < tmp.getAuthor().size(); i++)
			{
				if(hm.get(tmp.getAuthor().get(i)) == hm.get(nameOrTitle))
					x = true;
			}
			if(!x)
				return false;
			// System.out.println("HERE");
		}
		else if(searchBy.equals("Title"))
		{
			boolean x = false;
			String tmpstr = new String();
			String str = tmp.getTitle();
			for(int i=0; i < str.length(); i++)
			{
				if(x)
					break;
				if(str.charAt(i) != ' ')
				{
					tmpstr += str.charAt(i);
				}
				else
				{
					for(int j = 0 ; j < wordsTitle.size(); j++)
					{
						if(tmpstr.equals(wordsTitle.get(j)))
						{
							x = true;
							break;							
						}
					}
					tmpstr = new String();
				}
			}
			if(!x)
				return false;
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
		 	System.out.println("HGFHGFHGFH");
		 	publication.add(tmp);
		 	tmp = new Publication();
		 }

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("START Parser");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(ct%1000 == 0)
			System.out.println(ct);
		ct++;


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
