package br.com.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.travel.R;
import br.com.travel.dao.TravelPackageDao;
import br.com.travel.model.TravelPackage;
import br.com.travel.ui.adapter.ListTravelPackAdapter;

public class ListTravelPackActivity extends AppCompatActivity {

    private TravelPackageDao travelPackageDao= new TravelPackageDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_travel_pack);
        List<TravelPackage> travelPackageList = travelPackageDao.getAll();
        ListView travelPackListView = findViewById(R.id.activity_list_travel_pack_list);
        travelPackListView.setAdapter(new ListTravelPackAdapter(travelPackageList, this));
    }
}