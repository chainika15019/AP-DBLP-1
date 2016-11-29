import java.util.*;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;



public class Query3 {


	Query3(String auth1, int year1 , String auth2, int year2, String auth3, int year3, String auth4, int year4, String auth5, int year5)  throws IOException, SAXException
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");

		Parser1 obj1 = new Parser1(auth1);
		Parser1 obj2 = new Parser1(auth2);
		Parser1 obj3 = new Parser1(auth3);
		Parser1 obj4 = new Parser1(auth4);
		Parser1 obj5 = new Parser1(auth5);

		XMLReader p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(obj1);
		p.parse("dblp.xml");

		p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(obj2);
		p.parse("dblp.xml");

		p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(obj3);
		p.parse("dblp.xml");

		p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(obj4);
		p.parse("dblp.xml");

		p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(obj5);
		p.parse("dblp.xml");

		int[] py = obj1.getPubYears();


	}

}