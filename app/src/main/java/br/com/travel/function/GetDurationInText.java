package br.com.travel.function;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public interface GetDurationInText {

    @NonNull
    static String execute(final Integer days) {
        final Calendar departureDate = Calendar.getInstance();
        final Calendar returnDate = Calendar.getInstance();
        returnDate.add(Calendar.DATE, days);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        final String departureDateFormatted = simpleDateFormat.format(departureDate.getTime());
        final String returnDateFormatted = simpleDateFormat.format(returnDate.getTime());
        return departureDateFormatted + " - " + returnDateFormatted;
    }
}
