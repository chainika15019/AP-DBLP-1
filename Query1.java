import java.util.*;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;



public class Query1 {

	Query1() throws IOException, SAXException
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");


		XMLReader p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(new Parser("Author","Sanjeev Saxena","","",""));
		p.parse("dblp.xml");


	}

}
