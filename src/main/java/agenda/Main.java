/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Lisa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime dt1 = LocalDateTime.of(2021, 01, 20, 10, 30);
        Duration du = Duration.ofHours(2);
        Duration allDay = Duration.ofDays(1);
        Event e = new Event ("dentiste",dt1,du);
        Event eToday = new Event ("carnaval",today,allDay);
        Event eToday2 = new Event ("Un autre évènement",today,allDay);
        Agenda monAgenda = new Agenda ();
  
        monAgenda.addEvent(e);
        monAgenda.addEvent(eToday);
        monAgenda.addEvent(eToday2);
        
        System.out.println(e.isInDay(LocalDate.now()));
        System.out.println(eToday.isInDay(LocalDate.now()));
        System.out.println(monAgenda.eventsInDay(LocalDate.now()));
        
        
    }
    
}
