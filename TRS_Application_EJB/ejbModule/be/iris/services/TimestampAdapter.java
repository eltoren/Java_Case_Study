package be.iris.services;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter extends XmlAdapter<String, Timestamp>  {

	@Override
	public Timestamp unmarshal(String v) throws Exception {

		return Timestamp.valueOf(LocalDateTime.parse(v, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

	@Override
	public String marshal(Timestamp v) throws Exception {
		// TODO Auto-generated method stub
		return v.toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	
}
