package br.com.travel.ui.activity;

import static br.com.travel.constants.AppConstants.TRAVEL_PACKAGE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.travel.R;
import br.com.travel.function.GetDurationInText;
import br.com.travel.function.GetImageDrawable;
import br.com.travel.function.GetPriceInMoney;
import br.com.travel.model.TravelPackage;

public class PurchaseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_purchase_details);
        final TravelPackage travelPackage = this.getTravelPackage();
        if (travelPackage != null) {
            this.showImage(travelPackage);
            this.showLocal(travelPackage);
            this.showDuration(travelPackage);
            this.showPrice(travelPackage);
        }
    }

    private TravelPackage getTravelPackage() {
        final Intent intent = super.getIntent();
        if (intent.hasExtra(TRAVEL_PACKAGE))
            return (TravelPackage) intent.getSerializableExtra(TRAVEL_PACKAGE);
        return null;
    }

    private void showPrice(TravelPackage travelPackage) {
        final TextView travelPackagePriceTextView = super.findViewById(R.id.activity_purchase_details_travel_package_price);
        final String priceInText = GetPriceInMoney.execute(travelPackage.getPrice());
        travelPackagePriceTextView.setText(priceInText);
    }

    private void showDuration(TravelPackage travelPackage) {
        final TextView travelPackageDurationTextView = super.findViewById(R.id.activity_purchase_details_travel_package_duration);
        final String durationInText = GetDurationInText.execute(travelPackage.getDays());
        travelPackageDurationTextView.setText(durationInText);
    }

    private void showLocal(TravelPackage travelPackage) {
        final TextView travelPackageLocalTextView = super.findViewById(R.id.activity_purchase_details_travel_package_local);
        travelPackageLocalTextView.setText(travelPackage.getLocal());
    }

    private void showImage(TravelPackage travelPackage) {
        final ImageView travelPackageImageView = super.findViewById(R.id.activity_purchase_details_travel_package_image);
        final Drawable imageOfTravelPackage = GetImageDrawable.execute(this, travelPackage.getImage());
        travelPackageImageView.setImageDrawable(imageOfTravelPackage);
    }
}