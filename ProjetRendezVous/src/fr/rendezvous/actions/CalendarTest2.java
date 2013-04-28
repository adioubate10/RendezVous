package fr.rendezvous.actions;

import java.io.IOException;

import com.google.gdata.util.ServiceException;

public class CalendarTest2 {

    public static void main(String[] args) throws IOException, ServiceException {
      GRendezVous c= new GRendezVous();
      GCalendar ca= new GCalendar();
      /*
       c.afficher();
       c.creer();
       c.newQuery();
       c.afficher();
       */
    // c.afficher();
      System.out.println(ca.execute());
    }
}