package br.com.travel.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.travel.model.TravelPackage;

public class TravelPackageDao {

    private static final List<TravelPackage> travelPackageList;

    static {
        travelPackageList = new ArrayList<>();
        travelPackageList.add(new TravelPackage("São Paulo", "sao_paulo_sp", 2, new BigDecimal("100")));
        travelPackageList.add(new TravelPackage("Belo Horizonte", "belo_horizonte_mg", 2, new BigDecimal("250.99")));
        travelPackageList.add(new TravelPackage("Recife", "recife_pe", 2, new BigDecimal("310")));
        travelPackageList.add(new TravelPackage("Rio de Janerio", "rio_de_janeiro_rj", 2, new BigDecimal("150")));
        travelPackageList.add(new TravelPackage("Salvador", "salvador_ba", 2, new BigDecimal("550")));
        travelPackageList.add(new TravelPackage("Foz do Iguaçu", "foz_do_iguacu_pr", 1, new BigDecimal("399.99")));
    }

    public List<TravelPackage> getAll() {
        return Collections.unmodifiableList(travelPackageList);
    }
}
