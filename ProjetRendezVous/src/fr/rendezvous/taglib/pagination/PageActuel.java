package fr.rendezvous.taglib.pagination;

@SuppressWarnings("serial")
public class PageActuel extends Pager 
{		
	@Override
	protected String getString() 
	{		
		return String.valueOf(pageActuel);
	}
}
