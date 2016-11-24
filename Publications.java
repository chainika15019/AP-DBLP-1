class Main {
	private ArrayList <String> authors;
	private String title;
	private String pages;
	private int volume;
	private String journal;
	private String ee;
	private String url;

	public ArrayList <String> getAuthor()
	{
		return authors;
	}

	public String getTitle()
	{
		return title;
	}
	
	public String getPages()
	{
		return pages;
	}
	
	public int getVolume()
	{
		return volume;
	}
	
	public String getJournal()
	{
		return journal;
	}
	
	public String getEE()
	{
		return ee;
	}
	
	public String getURL()
	{
		return url;
	}
	
	public void setAuthor(ArrayList <String> authors_input)
	{
		authors = authors_input;
	}
	
	public void setTitle(String title_input)
	{
		title = title_input;
	}
	
	public void setPages(String pages_input)
	{
		pages = pages_input;
	}
	
	public void setVolume(int volume_input)
	{
		volume = volume_input;
	}
	
	public void setJournal(String journal_input)
	{
		journal = journal_input;
	}
	
	public void setEE(String ee_input)
	{
		ee = ee_input;
	}
	
	public void setURL(String url_input)
	{
		url = url_input;
	}

}
