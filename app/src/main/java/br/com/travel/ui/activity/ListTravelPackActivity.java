package br.com.travel.ui.activity;

import static br.com.travel.constants.AppConstants.TRAVEL_PACKAGE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.travel.R;
import br.com.travel.dao.TravelPackageDao;
import br.com.travel.model.TravelPackage;
import br.com.travel.ui.adapter.ListTravelPackAdapter;

public class ListTravelPackActivity extends AppCompatActivity {

    private final TravelPackageDao travelPackageDao = new TravelPackageDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_list_travel_pack);
        final List<TravelPackage> travelPackageList = travelPackageDao.getAll();
        final ListView travelPackListView = findViewById(R.id.travel_package_list);
        travelPackListView.setAdapter(new ListTravelPackAdapter(travelPackageList, this));
        travelPackListView.setOnItemClickListener((adapterView, view, position, id) -> {
            final TravelPackage travelPackage = travelPackageList.get(position);
            final Intent intent = new Intent(this, TravelPackageDetailsActivity.class);
            intent.putExtra(TRAVEL_PACKAGE, travelPackage);
            super.startActivity(intent);
        });
    }
}