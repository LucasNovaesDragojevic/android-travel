package br.com.travel.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.travel.R;
import br.com.travel.function.GetDaysInText;
import br.com.travel.function.GetImageDrawable;
import br.com.travel.function.GetPriceInMoney;
import br.com.travel.model.TravelPackage;

public class TravelPackageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_travel_package_details);
        TravelPackage travelPackage = new TravelPackage("São Paulo", "sao_paulo_sp", 2, new BigDecimal("199.99"));

        TextView localTextView = findViewById(R.id.activity_travel_package_details_local);
        localTextView.setText(travelPackage.getLocal());

        ImageView imageViewOfLocal = findViewById(R.id.activity_travel_package_details_image);
        Drawable image = GetImageDrawable.execute(this, travelPackage.getImage());
        imageViewOfLocal.setImageDrawable(image);

        TextView daysTextView = findViewById(R.id.activity_travel_package_details_days);
        String daysInText = GetDaysInText.execute(this, travelPackage.getDays());
        daysTextView.setText(daysInText);

        TextView priceTextView = findViewById(R.id.activity_travel_package_details_price);
        String priceInMoney = GetPriceInMoney.execute(travelPackage.getPrice());
        priceTextView.setText(priceInMoney);
    }
}