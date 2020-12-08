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
    private List<Event> myEvents = new LinkedList<>();
    
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        this.myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) throws Exception {
        // TODO : implémenter cette méthode
        if(this.myEvents.isEmpty()){
            throw new Exception("Pas d'evenement dans cet Agenda");
        }
        
        List<Event> resultat = new LinkedList<>();
        
        for ( Event e : myEvents){
            if (e.isInDay(day)){
                resultat.add(e);
            }
        }
        return resultat;
        
    }
}
    
