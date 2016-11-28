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
		// TODO Auto-generated method stub
//		if(toadd)
//		{
//		System.out.println(ct++);
			if(qName.equals("article"))
			{
//				System.out.println(ct);
				publication.add(ct,tmp);
				if(ct%50000 == 0)
				{
					
					System.out.println(ct);
				}
				
				tmp = null;
				tmp = new Publication();
				toadd = false;	
				ct++;
//				System.out.println("yo");
			}
			else if(qName.equals("inproceedings"))
			{
				publication.add(ct,tmp);
				tmp = null;
				tmp = new Publication();
				toadd = false;
				ct++;
			}
			else if(qName.equals("proceedings"))
			{
				publication.add(ct,tmp);
				tmp = null;
				tmp = new Publication();
				toadd = false;
				ct++;
			}
			else if(qName.equals("book"))
			{
				publication.add(ct,tmp);
				tmp = null;
				tmp = new Publication();
				toadd = false;
				ct++;
			}
			else if(qName.equals("incollection"))
			{
				publication.add(ct,tmp);
				tmp = null;
				tmp = new Publication();
				ct++;
				toadd = false;
			}
			else if(qName.equals("phdthesis"))
			{
				publication.add(ct,tmp);
				tmp = null;
				tmp = new Publication();
				ct++;
				toadd = false;
			}
			else if(qName.equals("mastherthesis"))
			{
				publication.add(ct,tmp);
				tmp = null;
				tmp = new Publication();
				ct++;
				toadd = false;
			}
			else if(qName.equals("phdthesis"))
			{
				publication.add(ct,tmp);
				tmp = null;
				tmp = new Publication();
				ct++;
				toadd = false;
			}
			
//		}
//		super.endElement(uri, localName, qName);
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("START");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		ct++;
		String str = new String();
		for(int i=0;i<qName.length();i++)
		{
			if(qName.charAt(i) != ' ')
			{
				str += Character.toString(qName.charAt(i));
			}
			else
			{
				break;
			}
		}
		
		if(tmp.getVal() == 0)
		{
			
			if(str.equals("article"))
			{
				tmp.setVal(1);
			}
			
			else if(str.equals("inproceedings"))
			{
				tmp.setVal(2);
			}
			
			else if(str.equals("proceedings"))
			{
				tmp.setVal(3);
			}
			
			else if(str.equals("book"))
			{
				tmp.setVal(4);
			}
			
			else if(str.equals("incollection"))
			{
				tmp.setVal(5);
			}
			
			else if(str.equals("phdthesis"))
			{
				tmp.setVal(6);
			}
			
			else if(str.equals("masterthesis"))
			{
				tmp.setVal(7);
			}
			
			else if(str.equals("www"))
			{
				tmp.setVal(8);
			}
		}
		else
		{
			if(str.equals("author"))
			{
				isauthor = true;
			}
			else if(str.equals("title"))
			{
				istitle = true;
			}
			else if(str.equals("pages"))
			{
				ispages = true;
			}
			else if(str.equals("journal"))
			{
				isjournal = true;
			}
			else if(str.equals("url"))
			{
				isurl = true;
			}
//			private boolean istitle = false;
//			private boolean ispages = false;
//			private boolean isjournal = false;
//			private boolean isurl = false;
//			private boolean isee = false;
//			private boolean isvolume = false;
//			private boolean isyear = false;

			else if(str.equals("ee"))
			{
				isee = true;
			}
			else if(str.equals("volume"))
			{
				isvolume = true;
			}
			else if(str.equals("year"))
			{
				isyear = true;
			}
			
		}
		
		// TODO Auto-generated method stub
		
	} 
	
}
