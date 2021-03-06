import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
	
	public static void main(String[] args) {
		LOGGER.info("Начало работы программы!!!");
		
		try {
			LOGGER.warn("Внимание! Программа пытается разделить одно число на другое");
			System.out.println(12/0);
		} catch (ArithmeticException x) {
			LOGGER.error("Ошибка! Произошло деление на ноль!");
		}
	}
}