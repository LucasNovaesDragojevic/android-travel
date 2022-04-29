package br.com.travel.ui.activity;

import static br.com.travel.constants.AppConstants.TRAVEL_PACKAGE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.travel.R;
import br.com.travel.function.GetDaysInText;
import br.com.travel.function.GetDurationInText;
import br.com.travel.function.GetImageDrawable;
import br.com.travel.function.GetPriceInMoney;
import br.com.travel.model.TravelPackage;

public class TravelPackageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_travel_package_details);
        final TravelPackage travelPackage = this.getTravelPackage();
        if (travelPackage != null) {
            this.showLocal(travelPackage);
            this.showImage(travelPackage);
            this.showDays(travelPackage);
            this.showPrice(travelPackage);
            this.showDate(travelPackage);
            this.configBuyButton(travelPackage);
        }
    }

    private void configBuyButton(TravelPackage travelPackage) {
        final Button buyButton = super.findViewById(R.id.activity_travel_package_details_btn_buy);
        buyButton.setOnClickListener(view -> {
            final Intent intent = new Intent(this, PaymentActivity.class);
            intent.putExtra(TRAVEL_PACKAGE, travelPackage);
            super.startActivity(intent);
        });
    }

    private TravelPackage getTravelPackage() {
        final Intent intent = super.getIntent();
        if (intent.hasExtra(TRAVEL_PACKAGE))
            return (TravelPackage) intent.getSerializableExtra(TRAVEL_PACKAGE);
        return null;
    }

    private void showDate(final TravelPackage travelPackage) {
        final TextView durationTextView = findViewById(R.id.activity_travel_package_details_duration);
        final String durationInText = GetDurationInText.execute(travelPackage.getDays());
        durationTextView.setText(durationInText);
    }

    private void showPrice(final TravelPackage travelPackage) {
        final TextView priceTextView = super.findViewById(R.id.activity_travel_package_details_price);
        final String priceInMoney = GetPriceInMoney.execute(travelPackage.getPrice());
        priceTextView.setText(priceInMoney);
    }

    private void showDays(final TravelPackage travelPackage) {
        final TextView daysTextView = super.findViewById(R.id.activity_travel_package_details_days);
        final String daysInText = GetDaysInText.execute(this, travelPackage.getDays());
        daysTextView.setText(daysInText);
    }

    private void showImage(final TravelPackage travelPackage) {
        final ImageView imageViewOfLocal = super.findViewById(R.id.activity_travel_package_details_image);
        final Drawable image = GetImageDrawable.execute(this, travelPackage.getImage());
        imageViewOfLocal.setImageDrawable(image);
    }

    private void showLocal(final TravelPackage travelPackage) {
        final TextView localTextView = super.findViewById(R.id.activity_travel_package_details_local);
        localTextView.setText(travelPackage.getLocal());
    }
}