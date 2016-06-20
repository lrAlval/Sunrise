package libs;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class Read {
	public static int toInt(HttpServletRequest request, String parameter) {
		try {
			return Integer.parseInt(request.getParameter(parameter));
		} catch (NumberFormatException ex) {
			return -1;
		}
	}

	public static int toInt(String parameter) {
		try {
			return Integer.parseInt(parameter);
		} catch (NumberFormatException ex) {
			return -1;
		}
	}

	public static double toDouble(HttpServletRequest request, String parameter) {
		try {
			return Double.parseDouble(request.getParameter(parameter));
		} catch (NumberFormatException ex) {
			return -1;
		}
	}

	public static double toDouble(String parameter) {
		try {
			return Double.parseDouble(parameter);
		} catch (NumberFormatException ex) {
			return -1;
		}
	}

	public static String toString(HttpServletRequest request, String parameter) {
		try {
			return request.getParameter(parameter);
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	
	public static String toString(int parameter) {
		try {
			return String.valueOf(parameter);
		} catch (NumberFormatException ex) {
			return null;
		}
	}

	public static Date toDate(HttpServletRequest request, String parameter) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(parameter);
		} catch (Exception ex) {
			return null;
		}
	}

	public static Date toDate(String parameter) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(parameter);
		} catch (ParseException ex) {
			return null;
		}
	}

	public static String fromDateToString(Date date) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").format(date);
		} catch (Exception ex) {
			return null;
		}
	}

	public static String fromCompleteDateInStringToTimeInString(String date) {
		try {
			Date f = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
			return new SimpleDateFormat("HH:mm").format(f);
		} catch (ParseException ex) {
			return null;
		}
	}

	public static Date toTime(String parameter) {
		try {
			return new SimpleDateFormat("HH:mm").parse(parameter);
		} catch (ParseException ex) {
			return null;
		}
	}

	public static String fromTimeToString(Date date) {
		try {
			return new SimpleDateFormat("HH:mm").format(date);
		} catch (Exception ex) {
			return null;
		}
	}

	public static File toFile(String path) {
		if (path == null)
			return null;
		return new File(path);
	}

	public static String getMoney(double cash) {
		Locale loc = new Locale("ES", "PE");
		NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
		return nf.format(cash);
	}

	public static boolean areDatesCorrect(String inicio, String fin) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date i = sdf.parse(inicio);
			Date f = sdf.parse(fin);
			if (f.after(i))
				return true;
		} catch (ParseException ex) {
			return false;
		}
		return false;
	}


}
