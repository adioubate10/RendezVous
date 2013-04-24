package fr.rendezvous.actions;

import com.google.gdata.client.*;
import com.google.gdata.client.calendar.*;
import com.google.gdata.data.*;
import com.google.gdata.data.acl.*;
import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.data.calendar.*;
import com.google.gdata.data.extensions.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;
public class CalendarTest {

    private static final int DAY_OF_WEEK = 0;
	private static final int MONDAY = 0;
	private static final int HOUR_OF_DAY = 0;
	private static final int MINUTE = 0;
	private static final int SECOND = 0;
	private static final int MILLISECOND = 0;
	private static final BatchOperationType INSERT = null;
	static CalendarFeed resultFeed = null;
	 static URL feedUrl = null;
	 static CalendarService myService;
	public static void main(String[] args) {
		affichageEvent();
		CalendarEventEntry creationEvent = creationEvent();
		System.out.println(creationEvent);
		affichageEvent();
		//suprimerEvent(creationEvent);
	} 
	// Create the calendar
	public static void creationCal(){
	CalendarEntry calendar = new CalendarEntry();
	calendar.setTitle(new PlainTextConstruct("Little League Schedule"));
	calendar.setSummary(new PlainTextConstruct("This calendar contains the practice schedule and game times."));
	calendar.setTimeZone(new TimeZoneProperty("America/Los_Angeles"));
	calendar.setHidden(HiddenProperty.FALSE);
	calendar.setColor(new ColorProperty("#2952A3"));
	calendar.addLocation(new Where("","","Oakland"));

	// Insert the calendar
	URL postUrl = null;
	try {
		postUrl = new URL("https://www.google.com/calendar/feeds/default/owncalendars/full");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		CalendarEntry returnedCalendar = myService.insert(postUrl, calendar);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}	
	public static void affichageEvent(){
        myService = new CalendarService("exampleCo-exampleApp-1.0");
        try {
			myService.setUserCredentials("diopref@gmail.com", "diop2011");
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
		try {
			feedUrl = new URL("https://www.google.com/calendar/feeds/diopref@gmail.com/private/full");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		try {
			resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Your calendars:");
        
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
            CalendarEntry entry = resultFeed.getEntries().get(i);
            System.out.println("\t" + entry.getTitle().getPlainText());
            System.out.println("\t" + entry.getAuthors());
          }
        System.out.println("fin des evenement");
	}
       public static CalendarEventEntry creationEvent(){
    	   CalendarEventEntry ceven = null;
        
        CalendarEventEntry entry = new CalendarEventEntry();
        entry.setTitle(new PlainTextConstruct("signature de la convention de stage "));
        entry.setContent(new PlainTextConstruct("Jeudi 17"));
        entry.setQuickAdd(false);

        Calendar calendar = Calendar.getInstance();

        // Début de l'événement : heure courante
        DateTime start = new DateTime(calendar.getTime(), TimeZone.getDefault());

        // Durée de l'événement : 30 minutes
        calendar.add(Calendar.MINUTE, 10);
        DateTime end = new DateTime(calendar.getTime(), TimeZone.getDefault());

        When times = new When();
        times.setStartTime(start);
        times.setEndTime(end);
        entry.addTime(times);

        // Valider l'événement
        try {
        	ceven= myService.insert(feedUrl, entry);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ceven;
	}
	public static void suprimerEvent(CalendarEventEntry eventEntry){
		// Supprimer un événement existant
		URL delete = null;
		try {
			delete = new URL(eventEntry.getEditLink().getHref());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			myService.delete(delete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}