package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.DisplaySetting;
import com.pickme.webapi.repo.mongo.custom.DisplaySettingCustomRepository;

public interface DisplaySettingRepository extends MongoRepository<DisplaySetting, String>, DisplaySettingCustomRepository {
	public List<DisplaySetting> findByAllowMapView(boolean allowMapView);
	public List<DisplaySetting> findByDisplayUnits(String displayUnits);
	public List<DisplaySetting> findByCreatedBy(String createdBy);
	public List<DisplaySetting> findByUpdatedBy(String updatedBy);
	public List<DisplaySetting> findByDeleted(boolean deleted);
	Page<DisplaySetting> findByDeleted(boolean deleted, Pageable pageable);

}
