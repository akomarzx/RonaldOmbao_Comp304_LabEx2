package com.example.excercise1.data

import com.example.excercise1.R

object HomeDataSource {
    fun getHouses() : List<HouseInformation> {
        val houseType = arrayListOf(
            HouseInformation(1, "554 Manchester Ave. Orleans, ON K1E 2M4", "$350000", R.drawable.logo, HouseType.Apartment),
            HouseInformation(2, "314 Shipley Drive Nackawic, NB E6G 5J8", "$400000",  R.drawable.logo, HouseType.Apartment),
            HouseInformation(3, "468 Bridle Street Woodstock, NB E7M 0R7", "$130000", R.drawable.logo, HouseType.Apartment),
            HouseInformation(4, "607 Westminster Court Bois-Francs-Sud, QC J0H 3G6", "$550000", R.drawable.logo, HouseType.Detached),
            HouseInformation(5, "476 Depot Street Highlands, BC V9B 6A6", "$4002200", R.drawable.logo, HouseType.Detached),
            HouseInformation(6, "949 Hillcrest St. Charny, QC G6X 3X5", "$430000", R.drawable.logo, HouseType.Detached),
            HouseInformation(7, "17 Charles St. Powell River, BC V8A 2V2", "$620000", R.drawable.logo, HouseType.SemiDetached),
            HouseInformation(8,"280 Lyme Lane Coaticook, QC J1A 3S9", "$240000", R.drawable.logo, HouseType.SemiDetached),
            HouseInformation(9, "430 North Bay Road Delhi, ON N4B 7T3", "$624000", R.drawable.logo, HouseType.SemiDetached),
            HouseInformation(10, "7592 E. Cherry Ave. Mount Pearl, LB A1N 3T3", "$324000", R.drawable.logo, HouseType.Condo),
            HouseInformation(11, "979 Cottage Drive Grand Falls, LB A2A 5Y0", "$522000", R.drawable.logo, HouseType.Condo),
            HouseInformation(12, "7 Temple Court Gloucester, ON K1B 4E3", "$253000", R.drawable.logo, HouseType.Condo),
            HouseInformation(13, "7172 Mulberry Dr. Enfield, NS B2T 6Y5", "$450000", R.drawable.logo, HouseType.Townhouse),
            HouseInformation(14,"8901 Oklahoma St. L'Île-Dorval, QC H9S 2K4", "$120000", R.drawable.logo, HouseType.Townhouse),
            HouseInformation(15, "8689 Valley St. Wellington, ON N0B 2M5", "$750000", R.drawable.logo, HouseType.Townhouse),
        )

        return houseType
    }

    fun getHouseByType(type: HouseType?) : List<HouseInformation> {
        return getHouses().filter { it.houseType == type }
    }
}