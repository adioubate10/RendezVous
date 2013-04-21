package fr.rendezvous.taglib.pagination;

@SuppressWarnings("serial")
public class TotalElement extends Pager 
{	
	@Override
	protected String getString() 
	{
		return String.valueOf(totalElement);
	}
}
