package br.com.travel.function;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

public interface GetImageDrawable {

    @Nullable
    static Drawable execute(Context context, String nameOfImageDrawable) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(nameOfImageDrawable, "drawable", context.getPackageName());
        return ResourcesCompat.getDrawable(resources, drawableId, context.getTheme());
    }
}

