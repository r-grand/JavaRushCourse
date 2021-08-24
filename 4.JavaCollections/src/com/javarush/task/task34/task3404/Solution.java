package com.javarush.task.task34.task3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6
	}
	
	private double makeOperation(String s, double first, double second) {
		switch (s) {
			case "+": {
				return first + second;
			}
			case "=": {
				return 0.0 - second;
			}
			case "%": {
				return 0.0 - second;
			}
			case "-": {
				return first - second;
			}
			case "@": {
				return first - second;
			}
			case "*": {
				return first * second;
			}
			case "/": {
				return first / second;
			}
			case "^": {
				return Math.pow(first, second);
			}
			default:
				return -1;
		}
	}
	
	private double makeFunction(String s, double first) {
		switch (s) {
			case "s": {
				return Math.sin(Math.toRadians(first));
			}
			case "c": {
				return Math.cos(Math.toRadians(first));
			}
			case "t": {
				return Math.tan(Math.toRadians(first));
			}
			
			default:
				return -1;
		}
	}
	
	private int getPriority(String s) {
		switch (s) {
			case "+":
			case "-":
			case "=":
			case "%":
			case "@":
				return 1;
			case "*":
			case "/":
				return 2;
			case "^":
				return 3;
			case "c":
			case "s":
			case "t":
				return 4;
			default:
				return -1;
		}
	}
	
	private boolean isOperator(String c) {
		return c.equals("+") || c.equals("-") || c.equals("@") || c.equals("%") || c.equals("=") || c.equals("*") || c.equals("/") || c.equals("^");
	}
	
	private boolean isFunction(String c) {
		return c.equals("s") || c.equals("c") || c.equals("t");
	}
	
	private String doSomething(String expression) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
		numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);
		DecimalFormat df = (DecimalFormat) numberFormat;
		df.applyPattern("#.##");
		LinkedList<Double> doubles = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		String workWith = expression.replaceAll("(S|s)(I|i)(N|n)", "s");//Заменяем все функции на одиночный аналог
		workWith = workWith.replaceAll("[Cc][Oo][Ss]", "c");//Заменяем все функции на одиночный аналог
		workWith = workWith.replaceAll("[Tt][Aa][Nn]", "t");//Заменяем все функции на одиночный аналог
		//посчитаем количество операций
		workWith = workWith.replaceAll("^-", "=");
		for (int i = 0; i < 2; i++) {
			Pattern binaryMinus = Pattern.compile("(\\d+\\s?-\\s?\\d+)|([cst]\\s?-\\s?\\d)|(\\d\\s?-\\s?[cst])" +
					"|([cst]\\s?-\\s?[cst])|(\\)\\s?-\\s?\\()|(\\d+\\s?-\\s?\\()" +
					"|(\\)\\s?-\\s?\\d+)|([cst]\\s?-\\s?\\()|(\\)\\s?-\\s?[cst])");
			Matcher minusMatcher = binaryMinus.matcher(workWith);
			while (minusMatcher.find()) {
				String group = minusMatcher.group();
				String newString = group.replace('-', '@');
				workWith = workWith.replace(group, newString);
			}
		}
		Pattern strange = Pattern.compile("[^\\d)]\\s?\\-\\s?[\\dcst\\(]");
		Matcher mimi = strange.matcher(workWith);
		while (mimi.find()) {
			String lookfor = mimi.group();
			String replTo = lookfor.replace("-", "%");
			workWith = workWith.replace(lookfor, replTo);
		}
		int numberOfOperations = 0;
		if (numberOfOperations == 0) {
			Pattern operation = Pattern.compile("[sct\\+\\-\\*/\\^=%@]");
			Matcher matcher = operation.matcher(workWith);
			while (matcher.find()) {
				numberOfOperations++;
			}
		}
		//в следующем блоке заменяем все цифры символом D
		Pattern compareWithDecimals = Pattern.compile("-?((\\d*\\.\\d*([eE][\\+\\-]?\\d+)?)|\\d+)");
		Matcher m = compareWithDecimals.matcher(workWith);
		while (m.find()) {
			String ourDouble = m.group();
			doubles.add(new Double(ourDouble));
			workWith = workWith.replaceFirst(ourDouble, "D");
		}
		workWith = workWith.replaceAll(" ", "");
		String[] p = workWith.split("");
		LinkedList<String> operators = new LinkedList<>();
		LinkedList<Double> d = new LinkedList<>();
		for (int i = 0; i < p.length; i++) {
			if (p[i].equals("D")) {
				d.add(doubles.removeFirst());
			}
			if (isFunction(p[i]) || isOperator(p[i])) {
				if (operators.size() == 0) {
					operators.add(p[i]);
					continue;
				} else {
					String lastOper = operators.getLast();
					int lastOperPriority = getPriority(lastOper);
					int thisPriority = getPriority(p[i]);
					while (thisPriority <= lastOperPriority && operators.size() > 0) {
						if (thisPriority == 3 && lastOperPriority == thisPriority) {
							operators.add(p[i]);
							break;
						}
						Double res = 0.0;
						String operation = operators.removeLast();
						if (operation.equals("=") || operation.equals("%")) {
							Double d2 = d.removeLast();
							res = makeOperation(operation, 0.0, d2);
							res = new Double(df.format(res));
							d.add(res);
							if (operators.size() > 0) {
								lastOperPriority = getPriority(operators.getLast());
							} else {
								lastOperPriority = -1;
							}
							continue;
						}
						Double d2;
						Double d1 = 0.0;
						if (isOperator(operation)) {
							d2 = d.removeLast();
							if (d.size() > 0) {
								d1 = d.removeLast();
							}
							res = makeOperation(operation, d1, d2);
						}
						if (isFunction(operation)) {
							d2 = d.removeLast();
							res = makeFunction(operation, d2);
						}
						res = new Double(df.format(res));
						d.add(res);
						if (operators.size() > 0) {
							lastOperPriority = getPriority(operators.getLast());
						} else {
							lastOperPriority = -1;
						}
					}
				}
				operators.add(p[i]);
			}
			
			if (p[i].equals("(")) {
				operators.add(p[i]);
			}
			if (p[i].equals(")")) {
				String operation = "";
				while (!(operation = operators.removeLast()).equals("(")) {
					Double res = 0.0;
					Double d2;
					if (operation.equals("=") || operation.equals("%")) {
						d2 = d.removeLast();
						res = makeOperation(operation, 0.0, d2);
						res = new Double(df.format(res));
						d.add(res);
						continue;
					}
					Double d1 = 0.0;
					
					if (isOperator(operation)) {
						d2 = d.removeLast();
						if (d.size() > 0) {
							d1 = d.removeLast();
						}
						res = makeOperation(operation, d1, d2);
					}
					if (isFunction(operation)) {
						d2 = d.removeLast();
						res = makeFunction(operation, d2);
					}
					res = new Double(df.format(res));
					d.add(res);
				}
			}
		}
		String operation = "";
		while (operators.size() != 0) {
			operation = operators.removeLast();
			Double d2;
			Double res = 0.0;
			if (operation.equals("=") || operation.equals("%")) {
				d2 = d.removeLast();
				res = makeOperation(operation, 0.0, d2);
				res = new Double(df.format(res));
				d.add(res);
				continue;
			}
			Double d1 = 0.0;
			if (isOperator(operation)) {
				d2 = d.removeLast();
				if (d.size() > 0) {
					d1 = d.removeLast();
				}
				res = makeOperation(operation, d1, d2);
			}
			if (isFunction(operation)) {
				d2 = d.removeLast();
				res = makeFunction(operation, d2);
			}
			res = new Double(df.format(res));
			d.add(res);
		}
		sb = new StringBuilder();
		sb.append(d.get(0));
		for (int i = 0; i < numberOfOperations; i++) {
			sb.append("!");
		}
		sb.append(" ");
		sb.append(numberOfOperations);
		String result = sb.toString();
		return result;
	}
	
	public void recurse(final String expression, int countOperation) {
		String result = "";
		int count = countOperation;
		Pattern compareWithDecimalss = Pattern.compile("^-?((\\d*\\.\\d*([eE][\\+\\-]?\\d+)?)|\\d+)$");
		Matcher mmm = compareWithDecimalss.matcher(expression);
		if (mmm.matches()) {
			Double d = new Double(expression);
			NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
			numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);
			DecimalFormat df = (DecimalFormat) numberFormat;
			df.applyPattern("#.##");
			String stringWeNeed = df.format(d);
			System.out.println(stringWeNeed + " " + countOperation);
			return;
		}
		if (!expression.contains("!")) {
			String strinny = doSomething(expression);
			String[] ss = strinny.split(" ");
			result = ss[0];
			count = Integer.parseInt(ss[1].trim());
		} else {
			result = expression.replaceFirst("!", "");
		}
		recurse(result, count);
		
	}
	
	public Solution() {
		//don't delete
	}
}

/*
package com.javarush.task.task34.task3404;

import java.util.*;

*/
/*
Рекурсия для мат. выражения
*//*


public class Solution {
	*/
/*------------------------------------------------------------------
	 * PARSER RULES
	 *------------------------------------------------------------------*//*


//    expr : plusminus* EOF ;
//
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//
//    multdiv : factor ( ( '*' | '/' ) factor )* ;
//
//    factor : func | unary | NUMBER | '(' expr ')' ;
//
//    unary : '-' factor ;
//
//    func : NAME factor ;
	
	public Solution() {
		//don't delete
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6
		solution.recurse("sin(45)", 0); // Expected output: 0.5 6
		solution.recurse("122 - 34 - 3* (55 + 5* (3 - 2)) * 2", 0);
	}
	
	public void recurse(final String expression, int countOperation) {
		//implement
		List<Lexeme> lexemes = lexAnalyze(expression);
		LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
		System.out.println(expr(lexemeBuffer));
	}
	
	public enum LexemeType {
		LEFT_BRACKET, RIGHT_BRACKET,
		OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
		NUMBER, NAME, DOT,
		EOF;
		
	}
	
	public interface Function {
		double apply(double operand);
	}
	
	public static Map<String, Function> getFunctionMap() {
		Map<String, Function> functionMap = new HashMap<>();
		functionMap.put("sin", Math::sin);
		functionMap.put("cos", Math::cos);
		functionMap.put("tan", Math::tan);
		functionMap.put("^", operand -> Math.pow(operand, operand));
		return functionMap;
	}
	
	public static class Lexeme {
		LexemeType type;
		
		String value;
		
		public Lexeme(LexemeType type, String value) {
			this.type = type;
			this.value = value;
		}
		
		public Lexeme(LexemeType type, Character value) {
			this.type = type;
			this.value = value.toString();
		}
		
		@Override
		public String toString() {
			return "Lexeme{" +
					"type=" + type +
					", value='" + value + '\'' +
					'}';
		}
		
	}
	
	public static class LexemeBuffer {
		
		private int pos;
		
		public List<Lexeme> lexemes;
		
		public LexemeBuffer(List<Lexeme> lexemes) {
			this.lexemes = lexemes;
		}
		
		public Lexeme next() {
			return lexemes.get(pos++);
		}
		
		public void back() {
			pos--;
		}
		
		public int getPos() {
			return pos;
		}
		
	}
	
	public static List<Lexeme> lexAnalyze(String expText) {
		ArrayList<Lexeme> lexemes = new ArrayList<>();
		int pos = 0;
		while (pos < expText.length()) {
			char c = expText.charAt(pos);
			switch (c) {
				case '(':
					lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
					pos++;
					continue;
				case ')':
					lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
					pos++;
					continue;
				case '+':
					lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
					pos++;
					continue;
				case '-':
					lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
					pos++;
					continue;
				case '*':
					lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
					pos++;
					continue;
				case '/':
					lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
					pos++;
					continue;
				case '.':
					lexemes.add(new Lexeme(LexemeType.DOT, c));
					pos++;
					continue;
				default:
					if (c <= '9' && c >= '0') {
						StringBuilder sb = new StringBuilder();
						do {
							sb.append(c);
							pos++;
							if (pos >= expText.length()) {
								break;
							}
							c = expText.charAt(pos);
						} while (c <= '9' && c >= '0');
						lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
					} else {
						if (c != ' ') {
							if (c >= 'a' && c <= 'z'
									|| c >= 'A' && c <= 'Z') {
								StringBuilder sb = new StringBuilder();
								do {
									sb.append(c);
									pos++;
									if (pos >= expText.length()) {
										break;
									}
									c = expText.charAt(pos);
								} while (c >= 'a' && c <= 'z'
										|| c >= 'A' && c <= 'Z');
								
								if (getFunctionMap().containsKey(sb.toString())) {
									lexemes.add(new Lexeme(LexemeType.NAME, sb.toString()));
								} else {
									throw new RuntimeException("Unexpected character: " + c);
								}
							}
						} else {
							pos++;
						}
					}
			}
		}
		lexemes.add(new Lexeme(LexemeType.EOF, ""));
		return lexemes;
	}
	
	public static double expr(LexemeBuffer lexemes) {
		Lexeme lexeme = lexemes.next();
		if (lexeme.type == LexemeType.EOF) {
			return 0;
		} else {
			lexemes.back();
			return plusminus(lexemes);
		}
	}
	
	public static double plusminus(LexemeBuffer lexemes) {
		double value = multdiv(lexemes);
		while (true) {
			Lexeme lexeme = lexemes.next();
			switch (lexeme.type) {
				case OP_PLUS:
					value += multdiv(lexemes);
					break;
				case OP_MINUS:
					value -= multdiv(lexemes);
					break;
				case EOF:
				case RIGHT_BRACKET:
					lexemes.back();
					return value;
				default:
					throw new RuntimeException("Unexpected token: " + lexeme.value
							+ " at position: " + lexemes.getPos());
			}
		}
	}
	
	public static double multdiv(LexemeBuffer lexemes) {
		double value = factor(lexemes);
		while (true) {
			Lexeme lexeme = lexemes.next();
			switch (lexeme.type) {
				case OP_MUL:
					value *= factor(lexemes);
					break;
				case OP_DIV:
					value /= factor(lexemes);
					break;
				case EOF:
				case RIGHT_BRACKET:
				case OP_PLUS:
				case OP_MINUS:
					lexemes.back();
					return value;
				default:
					throw new RuntimeException("Unexpected token: " + lexeme.value
							+ " at position: " + lexemes.getPos());
			}
		}
	}
	
	public static double factor(LexemeBuffer lexemes) {
		Lexeme lexeme = lexemes.next();
		double value;
		switch (lexeme.type) {
			case NAME:
				lexemes.back();
				return func(lexemes);
			case OP_MINUS:
				value = factor(lexemes);
				return -value;
			case NUMBER:
				return Integer.parseInt(lexeme.value);
			case LEFT_BRACKET:
				value = plusminus(lexemes);
				lexeme = lexemes.next();
				if (lexeme.type != LexemeType.RIGHT_BRACKET) {
					throw new RuntimeException("Unexpected token: " + lexeme.value
							+ " at position: " + lexemes.getPos());
				}
				return value;
			default:
				throw new RuntimeException("Unexpected token: " + lexeme.value
						+ " at position: " + lexemes.getPos());
		}
	}
	
	public static double func(LexemeBuffer lexemeBuffer) {
		String name = lexemeBuffer.next().value;
		Lexeme lexeme = lexemeBuffer.next();
		
		if (lexeme.type != LexemeType.LEFT_BRACKET) {
			throw new RuntimeException("Wrong function call syntax at " + lexeme.value);
		}
		
		double operand = 0;
		
		lexeme = lexemeBuffer.next();
		if (lexeme.type != LexemeType.RIGHT_BRACKET) {
			lexemeBuffer.back();
			operand = expr(lexemeBuffer);
		}
		return getFunctionMap().get(name).apply(operand);
	}
}*/
