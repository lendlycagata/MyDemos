package com.careercitydashboard.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careercitydashboard.Dao.SiteRepo;
import com.careercitydashboard.Model.Site;
import com.careercitydashboard.Service.SiteService;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {
	
	@Autowired
	private SiteRepo siteRepo;

	@Override
	public List<Site> getAllSiteList() {
		// TODO Auto-generated method stub
		return this.siteRepo.findAll();
	}

	@Override
	public void addSite(Site site) {
		// TODO Auto-generated method stub
		this.siteRepo.save(site);
	}

	@Override
	public void updateSite(Site site) {
		// TODO Auto-generated method stub
		this.siteRepo.save(site);
	}

	@Override
	public Site deleteSite(Integer SITE_ID) {
		// TODO Auto-generated method stub
		this.siteRepo.deleteById(SITE_ID);
		return null;
	}

}
