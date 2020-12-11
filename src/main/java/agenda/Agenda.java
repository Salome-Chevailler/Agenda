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
        this.myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) throws Exception {
        if (this.myEvents.isEmpty()) {
            throw new Exception("Pas d'evenement dans cet Agenda");
        }

        List<Event> resultat = new LinkedList<>();

        for (Event e : myEvents) {
            if (e.isInDay(day)) {
                resultat.add(e);
            }
        }

        return resultat;

    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) throws Exception {
        if (this.myEvents.isEmpty()) {
            throw new Exception("Pas d'evenement dans cet Agenda");
        }
        List<Event> titreIdentique = new LinkedList<>();
        for (Event e : myEvents) {
            if (e.getTitle().equals(title)) {
                titreIdentique.add(e);
            }
        }
        return titreIdentique;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     *
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) throws Exception {
        if (this.myEvents.isEmpty()) {
            throw new Exception("Pas d'evenement dans cet Agenda");
        }
        boolean r = true;

        for (Event event : myEvents) {
            if (e.isInDay(event.getStart().toLocalDate())) {
                if (e.getStart().toLocalTime().isBefore(event.getStart().toLocalTime()) || e.getStart().toLocalTime().equals(event.getStart().toLocalTime())){
                    if (e.getStart().plus(e.getDuration()).toLocalTime().isAfter(event.getStart().toLocalTime()) || e.getStart().plus(e.getDuration()).toLocalTime().equals(event.getStart().toLocalTime())){
                        r = false;
                    }
                }
            }

        }
        return r;
    }
}
