package be.iris.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>  {

	@Override
	public Date unmarshal(String v) throws Exception {
		
		return Date.valueOf(LocalDate.parse(v, DateTimeFormatter.ISO_LOCAL_DATE));
	}

	@Override
	public String marshal(Date v) throws Exception {
		return v.toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

}
