package fr.rendezvous.actions;

import java.io.IOException;

import java.net.URL;


import com.google.gdata.client.Query;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.*;
import com.google.gdata.data.extensions.When;

import com.google.gdata.util.ServiceException;

public class Calendar {
	private static CalendarService myService ;
	private static URL postURL;
	public void afficher()throws IOException, ServiceException {
	 myService = new CalendarService("exampleCo-exampleApp-1.0");
    myService.setUserCredentials("diopref@gmail.com", "diop2011");

    URL feedUrl = new URL("https://www.google.com/calendar/feeds/default/owncalendars/full");
    CalendarFeed resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);

    System.out.println("Your calendars:");
    System.out.println();

   
    for (int i = 0; i < resultFeed.getEntries().size(); i++) {
    	CalendarEntry entry = resultFeed.getEntries().get(i);
        System.out.println("\t" + entry.getTitle().getPlainText());
        System.out.println("\t" + entry.getAuthors());
        System.out.println("\t" + entry.getId());
        System.out.println("\t" + entry.getId().substring(55));
    }
	}
	
	public static String getId() throws IOException, ServiceException{
		 myService = new CalendarService("exampleCo-exampleApp-1.0");
		    myService.setUserCredentials("diopref@gmail.com", "diop2011");

		    URL feedUrl = new URL("https://www.google.com/calendar/feeds/default/owncalendars/full");
		    CalendarFeed resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);

		    System.out.println("Your calendars:");
		    System.out.println();

		   
		  
		    	CalendarEntry entry = resultFeed.getEntries().get(0);
		       
		      //  System.out.println("\t" + entry.getId().substring(58));
		   
		return entry.getId().substring(55);
	}
	public CalendarEventEntry creer() throws IOException, ServiceException{
		postURL = new URL("http://www.google.com/calendar/feeds/diopref@gmail.com/private/full");
		CalendarEventEntry myEvent = new CalendarEventEntry();

		//Set the title and description
		myEvent.setTitle(new PlainTextConstruct("Pi Day Party"));
		myEvent.setContent(new PlainTextConstruct("I am throwing a Pi Day Party!"));

		//Create DateTime events and create a When object to hold them, then add
		//the When event to the event
		DateTime startTime = DateTime.parseDateTime("2013-04-18T15:00:00-08:00");
		DateTime endTime = DateTime.parseDateTime("2013-04-18T17:00:00-08:00");
		When eventTimes = new When();
		eventTimes.setStartTime(startTime);
		eventTimes.setEndTime(endTime);
		myEvent.addTime(eventTimes);

		// POST the request and receive the response:
		CalendarEventEntry insertedEntry = myService.insert(postURL, myEvent);
		return insertedEntry;
	}
	public void newQuery() throws IOException, ServiceException{
		postURL = new URL("http://www.google.com/calendar/feeds/diopref@gmail.com/private/full");
		Query myQuery = new Query(postURL);
		myQuery.setFullTextQuery("Pi");

		//Send the request with the built query URL
		CalendarEventFeed myResultsFeed = myService.query(myQuery, CalendarEventFeed.class);

		//Take the first match and print the title
		if (myResultsFeed.getEntries().size() > 0) {
		    CalendarEventEntry firstMatchEntry = new CalendarEventEntry();
		    myResultsFeed.getEntries().get(0);
		    System.out.println(firstMatchEntry.getTitle().getPlainText());
		}
	}
}
