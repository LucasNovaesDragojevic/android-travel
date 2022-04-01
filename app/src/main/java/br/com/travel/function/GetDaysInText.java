package br.com.travel.function;

import android.content.Context;

import br.com.travel.R;

public interface GetDaysInText {

    static String execute(Context context, Integer days) {
        return context.getResources().getQuantityString(R.plurals.plural_day, days, days);
    }
}
