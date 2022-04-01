package br.com.travel.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import br.com.travel.R;
import br.com.travel.function.GetDaysInText;
import br.com.travel.function.GetImageDrawable;
import br.com.travel.function.GetPriceInMoney;
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
        configTravelPackageLocalTextView(viewCreated, travelPackage);
        configTravelPackageImageView(viewCreated, travelPackage);
        configTravelPackageDaysTextView(viewCreated, travelPackage);
        configTravelPackagePriceTextView(viewCreated, travelPackage);
        return viewCreated;
    }

    private void configTravelPackageLocalTextView(View viewCreated, TravelPackage travelPackage) {
        TextView travelPackageLocalTextView = viewCreated.findViewById(R.id.item_travel_pack_text_local);
        travelPackageLocalTextView.setText(travelPackage.getLocal());
    }

    private void configTravelPackageImageView(View viewCreated, TravelPackage travelPackage) {
        ImageView travelPackageImageView = viewCreated.findViewById(R.id.item_travel_pack_image);
        Drawable travelPackageImageDrawable = GetImageDrawable.execute(context, travelPackage.getImage());
        travelPackageImageView.setImageDrawable(travelPackageImageDrawable);
    }

    private void configTravelPackageDaysTextView(View viewCreated, TravelPackage travelPackage) {
        TextView travelPackageDaysTextView = viewCreated.findViewById(R.id.item_travel_pack_text_days);
        Integer days = travelPackage.getDays();
        String daysInText = GetDaysInText.execute(context, days);
        travelPackageDaysTextView.setText(daysInText);
    }

    private void configTravelPackagePriceTextView(View viewCreated, TravelPackage travelPackage) {
        TextView travelPackagePriceTextView = viewCreated.findViewById(R.id.item_travel_pack_text_price);
        String priceFormatted = GetPriceInMoney.execute(travelPackage.getPrice());
        travelPackagePriceTextView.setText(priceFormatted);
    }
}
