package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    private LocalDate terminationInclusive;
    private long numberOfOccurrences;

    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.terminationInclusive = terminationInclusive;

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive
     * event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.numberOfOccurrences = numberOfOccurrences;
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        // TODO : implémenter cette méthode
        return this.terminationInclusive;
    }

    public long getNumberOfOccurrences() {
        // TODO : implémenter cette méthode
        return this.numberOfOccurrences;
    }

    public void addExecption(LocalDate date) {
        lesExceptions.add(date);
    }

    public boolean isInDay(LocalDate aDay) {
        LocalDateTime myStart = this.getStart();
        Duration myDuration = this.getDuration();
        LocalDateTime myEnd = myStart.plus(myDuration);

        boolean r = false;

        for (LocalDate d : lesExceptions) {
            if (d.isEqual(aDay)) {
                return false;
            }

            if (myStart.toLocalDate().isEqual(aDay)) {
                return true;
            }

            if (this.terminationInclusive != null) {
                if ((myStart.plus(numberOfOccurrences)).LocalDate().isAfter(aDay) || (myStart.plus(numberOfOccurrences)).LocalDate().isEqual(aDay)) {

                    while (myStart.toLocalDate().isBefore(aDay)) {
                        myEnd = myStart.plus(myDuration);
                        if (myStart.toLocalDate().isBefore(aDay) || myStart.toLocalDate().isEqual(aDay)) {
                            if (myEnd.toLocalDate().isAfter(aDay) || myEnd.toLocalDate().isEqual(aDay)) {
                                return true;
                            }

                        }
                        myStart = myStart.plus(1, frequency);
                    }
                }
            } else {
                if (myStart.plus(this.numberOfOccurrences, this.frequency).toLocalDate().isAfter(aDay) || myStart.plus(this.numberOfOccurrences, this.frequency).toLocalDate().isEqual(aDay));
                while (myStart.toLocalDate().isBefore(aDay) || myStart.toLocalDate().isEqual(aDay)) {
                    if (myStart.toLocalDate().isBefore(aDay) || myStart.toLocalDate().isEqual(aDay)) {
                        if (myEnd.toLocalDate().isAfter(aDay) || myEnd.toLocalDate().isEqual(aDay)) {
                            return true;
                        }
                    }
                }

                return r;

            }
        }
