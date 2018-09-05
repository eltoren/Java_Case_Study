package be.iris.converter;

import java.time.LocalTime;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import be.iris.utilities.DateFormat;

@FacesConverter(forClass=LocalTime.class)
public class LocalTimeConverter implements Converter{

	@Override
	public LocalTime getAsObject(FacesContext arg0, UIComponent arg1, String value) throws ConverterException {
		String[] time = value.split(":");
		int hours = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		
		return LocalTime.of(hours, minutes);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) throws ConverterException {
		LocalTime time = (LocalTime) object;
		
		return time.format(DateFormat.dtfHours);
	}

}
