package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.DisplaySetting;
import com.pickme.webapi.repo.mongo.DisplaySettingRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class DisplaySettingService {

	@Autowired DisplaySettingRepository displaySettingRepo;
	@Autowired LogRepository logRepo;
	public List<DisplaySetting> getAllDisplaySettings() {
		List<DisplaySetting> displaysettings = displaySettingRepo.findByDeleted(false); 
		return displaysettings;
	}
	
	public DisplaySetting getDisplaySettingById(String id) {
		Optional<DisplaySetting> displaysetting = displaySettingRepo.findById(id);
		return displaysetting.get();
	}
	public List<DisplaySetting> getDisplaySettingByAllowMapView(boolean allowMapView) {
		List<DisplaySetting> displaysettings = displaySettingRepo.findByAllowMapView(allowMapView);
		return displaysettings;
	}
	public List<DisplaySetting> getDisplaySettingByDisplayUnits(String displayUnits) {
		List<DisplaySetting> displaysettings = displaySettingRepo.findByDisplayUnits(displayUnits);
		return displaysettings;
	}
	public List<DisplaySetting>  getDisplaySettingByCreatedBy(String createdBy) {
		List<DisplaySetting> displaysettings =  displaySettingRepo.findByCreatedBy(createdBy);
		return displaysettings;
	}
	public List<DisplaySetting>  getDisplaySettingByUpdatedBy(String updatedBy) {
		List<DisplaySetting> displaysettings =  displaySettingRepo.findByUpdatedBy(updatedBy);
		return displaysettings;
	}
	public DisplaySetting addDisplaySetting(DisplaySetting displaysetting) {
		DisplaySetting newDisplaySetting = displaySettingRepo.insert(displaysetting);
		return newDisplaySetting;
	}
	public DisplaySetting updateDisplaySetting(DisplaySetting Owner) {
		DisplaySetting newDisplaySetting = displaySettingRepo.save(Owner);
		return newDisplaySetting;
	}
	public boolean deleteDisplaySetting(String id) {
		return displaySettingRepo.deleteDisplaySetting(id);
	}
}
