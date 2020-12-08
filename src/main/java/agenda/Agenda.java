package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    private final HashSet<Event> myEvents = new HashSet<>();
    
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO : implémenter cette méthode
        List<Event> resultat = new ArrayList<>();
        
        myEvents.forEach((e) -> {
           if (e.isInDay(day)){
               resultat.add(e);   
           } 
           
        });
        return resultat;
        
    }
}
    
