package br.com.travel.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.travel.R;
import br.com.travel.model.TravelPackage;

public class ListTravelPackAdapter extends BaseAdapter {

    private final List<TravelPackage> travelPackageList;
    private final Context context;

    public ListTravelPackAdapter(List<TravelPackage> travelPackageList, Context context) {
        this.travelPackageList = travelPackageList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return travelPackageList.size();
    }

    @Override
    public TravelPackage getItem(int position) {
        return travelPackageList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View viewCreated = LayoutInflater.from(context).inflate(R.layout.item_travel_pack, parent, false);
        TravelPackage travelPackage = travelPackageList.get(position);

        TextView travelPackageLocalTextView = viewCreated.findViewById(R.id.item_travel_pack_text_local);
        travelPackageLocalTextView.setText(travelPackage.getLocal());

        ImageView travelPackageImageView = viewCreated.findViewById(R.id.item_travel_pack_image);
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(travelPackage.getImage(), "drawable", context.getPackageName());
        Drawable travelPackageImageDrawable = resources.getDrawable(drawableId);
        travelPackageImageView.setImageDrawable(travelPackageImageDrawable);

        TextView travelPackageDaysTextView = viewCreated.findViewById(R.id.item_travel_pack_text_days);
        travelPackageDaysTextView.setText(travelPackage.getDays() + " days");

        TextView travelPackagePriceTextView = viewCreated.findViewById(R.id.item_travel_pack_text_price);
        travelPackagePriceTextView.setText(travelPackage.getPrice().toPlainString());

        return viewCreated;
    }
}
