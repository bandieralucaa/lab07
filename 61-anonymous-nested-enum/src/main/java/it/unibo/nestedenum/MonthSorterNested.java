package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final Comparator<String> BY_DAYS = new SortByDays();
    private static final Comparator<String> BY_ORDER = new SortByMonthOrder();

    @Override
    public Comparator<String> sortByDays() {
        return BY_DAYS;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return BY_ORDER;
    }

    private enum Month{
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int days;

        Month(int days){
            this.days = days;
        }

        public static Month fromString(String name){
            Objects.requireNonNull(name);
            try{
                return valueOf(name);
            }catch (IllegalArgumentException e){
                Month month = null;
                for (final Month m : values()){
                    if(m.toString().toLowerCase(Locale.ROOT).startsWith(name.toLowerCase(Locale.ROOT))){
                        if(month != null){
                            throw new IllegalArgumentException("Ambiguous month name");
                        }
                        month = m;
                    }
                }
                if(month == null){
                    throw new IllegalArgumentException("Unknown month name");
                }
                return month;
            }
        }
    }

    private static final class SortByDays implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            final var m1 = Month.fromString(o1);
            final var m2 = Month.fromString(o2);
            return Integer.compare(m1.days, m2.days);
        }
    }

    private static final class SortByMonthOrder implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return Month.fromString(o1).compareTo(Month.fromString(o2));
        }
    }


    

   
}
