package spel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Main {

	public static void main(String[] args) {

		Date today = new GregorianCalendar(2014, Calendar.OCTOBER, 20).getTime();
		Date xmas = new GregorianCalendar(2014, Calendar.DECEMBER, 25).getTime();

		String expression = "#Today < #DueDate";
		
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("Today", today);
		context.setVariable("DueDate", xmas);
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(expression);
		boolean result = exp.getValue(Boolean.class);
		
		System.out.println("result= " + result);
	}

}
