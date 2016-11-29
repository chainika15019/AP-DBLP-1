import java.util.*;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;



public class Query3 {

	private double ans[] = new double[5];
	private int s = -1;
	private String[][] to_be_returned = new String[5][2];
	private String[] arr = new String[5];

	void Func(int[] py, int year)
	{
		s++;
		double slope;
		double last;
		double sum = 0;
		double avg;
		for(int i = year; i > year-5 && i >= 0 ; i--)
		{
			sum += py[i];
		}
		avg = sum / (Math.min(5,year-5));
		slope = ( py[year] - py[Math.max(year-5,0)] ) / Math.min(5,year-5);
		ans[s] = ( (py[year] + slope) + avg) / 2;
		// System.out.println(ans[s]);
	}


	Query3(String auth1, int year1 , String auth2, int year2, String auth3, int year3, String auth4, int year4, String auth5, int year5)  throws IOException, SAXException
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		arr[0] = auth1;
		arr[1] = auth2;
		arr[2] = auth3;
		arr[3] = auth4;
		arr[4] = auth5;
		Parser1 obj1 = new Parser1(auth1);
		Parser1 obj2 = new Parser1(auth2);
		Parser1 obj3 = new Parser1(auth3);
		Parser1 obj4 = new Parser1(auth4);
		Parser1 obj5 = new Parser1(auth5);
		year1 -= 1936;
		year2 -= 1936;
		year3 -= 1936;
		year4 -= 1936;
		year5 -= 1936;
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
		Func(py, year1);

		py = obj2.getPubYears();
		Func(py, year2);
		
		py = obj3.getPubYears();
		Func(py, year3);
		
		py = obj4.getPubYears();
		Func(py, year4);
		
		py = obj5.getPubYears();
		Func(py, year5);

		setEV();
	}

	public void setEV()
	{
		for( int i =0 ;i < 5; i++)
		{
			to_be_returned[i][0] = arr[i];
			to_be_returned[i][1] = Double.toString(ans[i]);
			System.out.println(to_be_returned[i][0] + " " + to_be_returned[i][1]);
		}
	}

	public String[][] getExpectedValue()
	{
		return to_be_returned;
	}


}
