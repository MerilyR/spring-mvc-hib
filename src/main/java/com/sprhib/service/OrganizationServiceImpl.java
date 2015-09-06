package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.OrganizationDAO;
import com.sprhib.model.Organization;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDAO organizationDAO;

	public void addOrganization(Organization organization) {
		organizationDAO.addOrganization(organization);
	}

	public void updateOrganization(Organization organization) {
		organizationDAO.updateOrganization(organization);
	}

	public Organization getOrganization(int id) {
		return organizationDAO.getOrganization(id);
	}

	public void deleteOrganization(int id) {
		organizationDAO.deleteOrganization(id);
	}

	public List<Organization> getOrganizations() {
		return organizationDAO.getOrganizations();
	}

}
