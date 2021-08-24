package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static Map<String, String> countries = new HashMap<>();
	
	static {
		countries.put("UA", "Ukraine");
		countries.put("RU", "Russia");
		countries.put("CA", "Canada");
	}
	
	public static void main(String[] args) {
		IncomeData incomeData = new IncomeData() {
			@Override
			public String getCountryCode() {
				return "UA";
			}

			@Override
			public String getCompany() {
				return "JavaRush Ltd.";
			}

			@Override
			public String getContactFirstName() {
				return "Ivan";
			}

			@Override
			public String getContactLastName() {
				return "Ivanov";
			}

			@Override
			public int getCountryPhoneCode() {
				return 38;
			}

			@Override
			public int getPhoneNumber() {
				return 501234567;
			}
		};

		IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);

		System.out.println(incomeDataAdapter.getCompanyName());
		System.out.println(incomeDataAdapter.getCountryName());
		System.out.println(incomeDataAdapter.getName());
		System.out.println(incomeDataAdapter.getPhoneNumber());
	}
	
	public static class IncomeDataAdapter implements Contact, Customer {
		private final IncomeData data;
		
		public IncomeDataAdapter(IncomeData data) {
			this.data = data;
		}
		
		@Override
		public String getCompanyName() {
			return data.getCompany();
		}
		
		@Override
		public String getCountryName() {
			return countries.get(data.getCountryCode());
		}
		
		@Override
		public String getName() {
			return data.getContactLastName() + ", " + data.getContactFirstName();
		}
		
		@Override
		public String getPhoneNumber() {
			char[] phoneNumber = (String.valueOf(data.getPhoneNumber())).toCharArray();
			int[] frameNumber = new int[10];
			int ext = frameNumber.length - phoneNumber.length;
			for (int i = ext; i < frameNumber.length; i++) {
				frameNumber[i] = Integer.parseInt(String.valueOf(phoneNumber[i - ext]));
			}
			String readyNumber = "+" + data.getCountryPhoneCode() +
					"(" + frameNumber[0] + frameNumber[1] + frameNumber[2] + ")" +
					frameNumber[3] + frameNumber[4] + frameNumber[5] + "-" +
					frameNumber[6] + frameNumber[7] + "-" +
					frameNumber[8] + frameNumber[9];
			return readyNumber;
		}
	}
	
	
	public interface IncomeData {
		String getCountryCode();        //For example: UA
		
		String getCompany();            //For example: JavaRush Ltd.
		
		String getContactFirstName();   //For example: Ivan
		
		String getContactLastName();    //For example: Ivanov
		
		int getCountryPhoneCode();      //For example: 38
		
		int getPhoneNumber();           //For example: 501234567
	}
	
	public interface Customer {
		String getCompanyName();        //For example: JavaRush Ltd.
		
		String getCountryName();        //For example: Ukraine
	}
	
	public interface Contact {
		String getName();               //For example: Ivanov, Ivan
		
		String getPhoneNumber();        //For example: +38(050)123-45-67
	}
}