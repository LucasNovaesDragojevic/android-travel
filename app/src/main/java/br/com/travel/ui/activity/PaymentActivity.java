package br.com.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        super.setTitle("Payment");
        final TravelPackage travelPackage = new TravelPackage("São Paulo", "sao_paulo_sp", 2, new BigDecimal("199.99"));
        this.showFinalPrice(travelPackage);
    }

    private void showFinalPrice(final TravelPackage travelPackage) {
        final TextView finalPriceValueTextView = super.findViewById(R.id.activity_payment_final_price_value);
        final String finalPrice = GetPriceInMoney.execute(travelPackage.getPrice());
        finalPriceValueTextView.setText(finalPrice);
    }
}