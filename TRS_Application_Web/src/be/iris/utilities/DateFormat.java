package be.iris.utilities;
import java.time.format.DateTimeFormatter;
/**
 * DateTimeFormatter Class to have the rights format on the application
 */
public class DateFormat {

	public static DateTimeFormatter dtfDays = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static DateTimeFormatter dtfHours = DateTimeFormatter.ofPattern("kk:mm");

}
