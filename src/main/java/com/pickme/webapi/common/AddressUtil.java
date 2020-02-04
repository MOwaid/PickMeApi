package com.pickme.webapi.common;

import java.util.ArrayList;
import java.util.List;

import com.pickme.webapi.document.Address;
import com.pickme.webapi.model.AddressSearchModel;

public class AddressUtil {

	public static List<AddressSearchModel> createAddressSearchModel(List<Address> addresses) {
		
		List<AddressSearchModel> addressSearchModelList = new ArrayList<AddressSearchModel>();
		
		for(Address address : addresses) {
			String addressString = "";
			if(address.getBuildingNumber() != null && address.getBuildingNumber() != "" ) {
				addressString+=" "+address.getBuildingNumber();
			}
			if(address.getBuildingName() != null && address.getBuildingName() != "") {
				addressString+=" "+address.getBuildingName();
			}
			if(address.getArea() != null && address.getArea() != "" ) {
				addressString+=" "+address.getArea();
			}
			if(address.getState() != null && address.getState() != "") {
				addressString+=" "+address.getState();
			}
			if(address.getPostCode() != null && address.getPostCode() != "") {
				addressString+=" "+address.getPostCode();
			}
			if(address.getCounty() != null && address.getCounty() != "") {
				addressString+=" "+address.getCounty();
			}
			addressString = addressString.toUpperCase();
			addressString = addressString.trim();
			AddressSearchModel model = new AddressSearchModel();
			model.setAddressId(address.getId());
			model.setAddressString(addressString);
			addressSearchModelList.add(model);
		}
		return addressSearchModelList;
	}
}
