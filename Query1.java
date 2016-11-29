public class Query1 {

	Query1()
	{

		XMLReader p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(new Parser());
		p.parse("dblp.xml");


	}

}