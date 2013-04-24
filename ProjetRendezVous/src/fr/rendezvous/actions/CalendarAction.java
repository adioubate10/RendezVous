package fr.rendezvous.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.google.gdata.client.GoogleService;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.client.http.AuthSubUtil;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.ColorProperty;
import com.google.gdata.data.calendar.HiddenProperty;
import com.google.gdata.data.calendar.TimeZoneProperty;
import com.google.gdata.data.extensions.Where;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CalendarAction{
	private CalendarService myService ;
	private String id;
	
	public String ajouter(String titre,String description,String lieu,String date,String couleur, String mail, String mdp)
	{	
		// Create the calendar
		 myService = new CalendarService("exampleCo-exampleApp-1.0");
		 try {
			myService.setUserCredentials(mail, mdp);
		} catch (AuthenticationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CalendarEntry calendar = new CalendarEntry();
		calendar.setTitle(new PlainTextConstruct(titre));
		calendar.setSummary(new PlainTextConstruct(description));
		calendar.setTimeZone(new TimeZoneProperty(date));
		calendar.setHidden(HiddenProperty.FALSE);
		calendar.setColor(new ColorProperty(couleur));
		calendar.addLocation(new Where("","",lieu));
		calendar.getHtmlLink();
		/*
		calendar.setTitle(new PlainTextConstruct("Prof"));
		calendar.setSummary(new PlainTextConstruct("This calendar contains the practice schedule and game times."));
		calendar.setTimeZone(new TimeZoneProperty("America/Los_Angeles"));
		calendar.setHidden(HiddenProperty.FALSE);
		calendar.setColor(new ColorProperty("#2952A3"));
		calendar.addLocation(new Where("","","Oakland"));
		calendar.getHtmlLink();
		*/
		// Insert the calendar
	
		URL postUrl = null;
		try {
			postUrl = new URL("https://www.google.com/calendar/feeds/default/owncalendars/full");
		
		
			CalendarEntry returnedCalendar = myService.insert(postUrl, calendar);
			System.out.println("\t" + returnedCalendar.getTitle().getPlainText());
		id = returnedCalendar.getId().substring(55);
		
			 System.out.println("\t" + returnedCalendar.getId().substring(55));
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

return id;
	}
	
}
