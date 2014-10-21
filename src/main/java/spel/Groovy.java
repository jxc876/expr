package spel;

import groovy.lang.GroovyShell;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Groovy {

	public static void main(String[] args) {

		GroovyShell shell = new GroovyShell();

		String expression = "(@Today - 1) < @DueDate".replace("@", "");
		
		shell.setVariable("Today", new Date());
		Date xmas = new GregorianCalendar(2014, Calendar.DECEMBER, 25).getTime();
		shell.setVariable("DueDate", xmas);
		
		Object o = shell.evaluate(expression);
		System.out.println("o = " + o);
	}

}
