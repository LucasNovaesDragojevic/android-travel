package br.com.travel.ui.activity;

import static br.com.travel.constants.AppConstants.TRAVEL_PACKAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.travel.R;
import br.com.travel.function.GetPriceInMoney;
import br.com.travel.model.TravelPackage;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_payment);
        final TravelPackage travelPackage = this.getTravelPackage();
        if (travelPackage != null) {
            this.showFinalPrice(travelPackage);
            this.configPurchaseButton(travelPackage);
        }
    }

    private void configPurchaseButton(TravelPackage travelPackage) {
        final Button purchaseButton = super.findViewById(R.id.activity_payment_btn_purchase);
        purchaseButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, PurchaseDetailsActivity.class);
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

    private void showFinalPrice(final TravelPackage travelPackage) {
        final TextView finalPriceValueTextView = super.findViewById(R.id.activity_payment_final_price_value);
        final String finalPrice = GetPriceInMoney.execute(travelPackage.getPrice());
        finalPriceValueTextView.setText(finalPrice);
    }
}