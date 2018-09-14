package be.iris.dao;

import java.util.List;

import javax.ejb.Local;

import be.iris.entities.Tutcompany;

@Local
public interface CompanyDao {
	
	public void insertCompany(Tutcompany company);
	
	public void updateCompany(Tutcompany oldCompany, Tutcompany newCompany);
	
	public void deleteCompany(Tutcompany company);
	
	public Tutcompany geCompany(Tutcompany company);
	
	public List<Tutcompany> listAllCompanies();
		
	public List<Tutcompany> listComapniesInCountry(String country);
	
	public List<Tutcompany> listCompaniesInTownByName(String town);
	
	public List<Tutcompany> listCompaniesInTownByZipCode(String zipcode);

}
