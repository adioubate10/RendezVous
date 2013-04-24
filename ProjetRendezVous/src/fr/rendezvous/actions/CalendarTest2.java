package fr.rendezvous.actions;

import java.io.IOException;

import com.google.gdata.util.ServiceException;

public class CalendarTest2 {

    public static void main(String[] args) throws IOException, ServiceException {
      Calendar c= new Calendar();
      CalendarAction ca= new CalendarAction();
      /*
       c.afficher();
       c.creer();
       c.newQuery();
       c.afficher();
       */
     c.afficher();
      //ca.execute();
    }
}