package com.parbrigal.model;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.parbrigal.main.controller.ConnectionManager;
import com.parbrigal.main.controller.EmploymentTypeCodes;
import com.parbrigal.main.controller.Name;
import com.parbrigal.main.controller.PaymentTypeCodes;

public class GenEmployeeDetail {
	
	private static List<Name> allNames = new ArrayList<Name>();
	private static List<Name> femaleAANames = new ArrayList<Name>();
	private static List<Name> maleAANames = new ArrayList<Name>();
	private static List<Name> femaleNonAANames = new ArrayList<Name>();
	private static List<Name> maleNonAANames = new ArrayList<Name>();
	
	private static List<Name> allSurnames = new ArrayList<Name>();
	private static List<Name> eeSurnames = new ArrayList<Name>();
	private static List<Name> nonEeSurnames = new ArrayList<Name>();

	public static String getID(int minAge, int maxAge) 
	{
		int minYear = Calendar.getInstance().get(1) - minAge;
		int maxYear = Calendar.getInstance().get(1) - maxAge;

		int nextYear = minYear - maxYear;

		Random rand = new Random();
		int firstFour = rand.nextInt(nextYear) + maxYear;

		String firstTwo = String.valueOf(firstFour).substring(2, 4);

		int secondTwo = rand.nextInt(12) + 1;

		String secTwoDisp;

		if (secondTwo < 10) {
			secTwoDisp = "0" + secondTwo;
		} else {
			secTwoDisp = String.valueOf(secondTwo);
		}

		Calendar calendar = Calendar.getInstance();

		int year = firstFour;
		int date = 1;

		calendar.set(year, secondTwo - 1, date);
		int maxdays = calendar.getActualMaximum(5);
		int thirdTwo = rand.nextInt(maxdays) + 1;
		String thirdTwoDisp;
		if (thirdTwo < 10) {
			thirdTwoDisp = "0" + thirdTwo;
		} else {
			thirdTwoDisp = "" + thirdTwo;
		}

		int fourthDigit = rand.nextInt(9) + 1;
		int fifthDigit = rand.nextInt(9);
		int sixthDigit = rand.nextInt(9);
		int seventhDigit = rand.nextInt(9);
		int eightDigit = rand.nextInt(2);
		int ninthDigit = rand.nextInt(9);

		String allButLast = firstTwo + secTwoDisp + thirdTwoDisp + fourthDigit + fifthDigit + sixthDigit + seventhDigit
				+ eightDigit + ninthDigit;

		char[] convertedString = allButLast.toCharArray();

		int totalodd = Character.getNumericValue(convertedString[0]) + Character.getNumericValue(convertedString[2])
				+ Character.getNumericValue(convertedString[4]) + Character.getNumericValue(convertedString[6])
				+ Character.getNumericValue(convertedString[8]) + Character.getNumericValue(convertedString[10]);
		String evenField = "" + convertedString[1] + convertedString[3] + convertedString[5] + convertedString[7]
				+ convertedString[9] + convertedString[11];

		int evenFieldmulti = Integer.parseInt(evenField) * 2;

		String evenFieldmultiInt = Integer.toString(evenFieldmulti);
		int evenFieldmultiChar = evenFieldmultiInt.length();
		char[] convertedString2 = evenFieldmultiInt.toCharArray();

		int evenFieldadd = 0;
		int x = 0;
		do {
			evenFieldadd += Character.getNumericValue(convertedString2[x]);
			x++;
		} while (

		x < evenFieldmultiChar);

		int LuhnTotal = totalodd + evenFieldadd;

		String LuhnString = Integer.toString(LuhnTotal);
		char[] convertedString3 = LuhnString.toCharArray();
		int luhnAnswer;
		if (Character.getNumericValue(convertedString3[1]) == 0) {
			luhnAnswer = 0;
		} else {
			luhnAnswer = 10 - Character.getNumericValue(convertedString3[1]) % 10;
		}

		String Idnumber = allButLast + luhnAnswer;

		String gender = null;
		String citizen = null;

		if (fourthDigit <= 4) {
			gender = "Female";
		} else if (fourthDigit >= 5) {
			gender = "Male";
		}
		if (eightDigit == 0) {
			citizen = "SA";
		} else if (eightDigit == 1) {
			citizen = "Other";
		}

		Idnumber = allButLast + luhnAnswer;

		return Idnumber;
	}

	public static String getTax() {
		List<Integer> list = new ArrayList();

		list.add(Integer.valueOf(0));
		list.add(Integer.valueOf(1));
		list.add(Integer.valueOf(2));
		list.add(Integer.valueOf(3));
		list.add(Integer.valueOf(9));

		int index = new Random().nextInt(list.size());

		int tDig1 = ((Integer) list.get(index)).intValue();

		Random randT = new Random();
		int tDig2 = randT.nextInt(9);
		int tDig3 = randT.nextInt(9);
		int tDig4 = randT.nextInt(9);
		int tDig5 = randT.nextInt(9);
		int tDig6 = randT.nextInt(9);
		int tDig7 = randT.nextInt(9);
		int tDig8 = randT.nextInt(9);
		int tDig9 = randT.nextInt(9);

		int tDig10 = 0;

		int lineItem1 = tDig1 * 2;
		int finalLineItem1;
		if (lineItem1 > 9) {
			String lineItem1Str = Integer.toString(lineItem1);
			char[] lI1 = lineItem1Str.toCharArray();
			finalLineItem1 = Character.getNumericValue(lI1[0]) + Character.getNumericValue(lI1[1]);
		} else {
			finalLineItem1 = lineItem1;
		}

		int lineItem2 = tDig3 * 2;
		int finalLineItem2;
		if (lineItem2 > 9) {
			String lineItem2Str = Integer.toString(lineItem2);
			char[] lI2 = lineItem2Str.toCharArray();
			finalLineItem2 = Character.getNumericValue(lI2[0]) + Character.getNumericValue(lI2[1]);
		} else {
			finalLineItem2 = lineItem2;
		}

		int lineItem3 = tDig5 * 2;
		int finalLineItem3;
		if (lineItem3 > 9) {
			String lineItem3Str = Integer.toString(lineItem3);
			char[] lI3 = lineItem3Str.toCharArray();
			finalLineItem3 = Character.getNumericValue(lI3[0]) + Character.getNumericValue(lI3[1]);
		} else {
			finalLineItem3 = lineItem3;
		}

		int lineItem4 = tDig7 * 2;
		int finalLineItem4;
		if (lineItem4 > 9) {
			String lineItem4Str = Integer.toString(lineItem4);
			char[] lI4 = lineItem4Str.toCharArray();
			finalLineItem4 = Character.getNumericValue(lI4[0]) + Character.getNumericValue(lI4[1]);
		} else {
			finalLineItem4 = lineItem4;
		}

		int lineItem5 = tDig9 * 2;
		int finalLineItem5;
		if (lineItem5 > 9) {
			String lineItem5Str = Integer.toString(lineItem5);
			char[] lI5 = lineItem5Str.toCharArray();
			finalLineItem5 = Character.getNumericValue(lI5[0]) + Character.getNumericValue(lI5[1]);
		} else {
			finalLineItem5 = lineItem5;
		}

		int taxTotal = finalLineItem1 + finalLineItem2 + finalLineItem3 + finalLineItem4 + finalLineItem5;

		String taxTotalString = Integer.toString(taxTotal);
		char[] convertedString4 = taxTotalString.toCharArray();

		int taxlastDigit = Character.getNumericValue(convertedString4[(taxTotalString.length() - 1)]);

		if (taxlastDigit == 0) {
			tDig10 = 0;
		} else {
			tDig10 = 10 - taxlastDigit;
		}
		String Taxno = "" + tDig1 + tDig2 + tDig3 + tDig4 + tDig5 + tDig6 + tDig7 + tDig8 + tDig9 + tDig10;

		return Taxno;
	}

	public static CountryCodes getPassPortCountryCode() {
		Random rand = new Random();

		List<CountryCodes> passCodes = Arrays.asList(CountryCodes.values());

		CountryCodes countryCode = (CountryCodes) passCodes.get(rand.nextInt(passCodes.size() - 1) + 1);

		return countryCode;
	}

	public static String getPassportNo() {
		StringBuilder sb = new StringBuilder();

		Random rand = new Random();

		String passDigits = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int i = 0; i < 9; i++) {

			sb.append(passDigits.charAt(rand.nextInt(passDigits.length())));
		}

		String code = sb.toString();
		return code;
	}

	public static String getPassportCountry(CountryCodes code) {
		return code.getDisplay();
	}

	public static String passPortIssueDate() {
		StringBuilder sb = new StringBuilder();

		Random rand = new Random();

		int firstTwo = rand.nextInt(1) + 14;

		int secondTwo = rand.nextInt(12) + 1;

		String firstTwoDisp;

		if (firstTwo < 10) {
			firstTwoDisp = "200" + firstTwo;
		} else {
			firstTwoDisp = "20" + firstTwo;
		}

		String secTwoDisp;
		if (secondTwo < 10) {
			secTwoDisp = "0" + secondTwo;
		} else {
			secTwoDisp = String.valueOf(secondTwo);
		}

		Calendar calendar = Calendar.getInstance();

		int year = Integer.parseInt("20" + firstTwo);
		int date = 1;

		calendar.set(year, secondTwo - 1, date);
		int maxdays = calendar.getActualMaximum(5);
		int thirdTwo = rand.nextInt(maxdays) + 1;
		String thirdTwoDisp;
		if (thirdTwo < 10) {
			thirdTwoDisp = "0" + thirdTwo;
		} else {
			thirdTwoDisp = String.valueOf(thirdTwo);
		}

		sb.append(firstTwoDisp);
		sb.append(secTwoDisp);
		sb.append(thirdTwoDisp);

		return sb.toString();
	}

	public static String passPortExpirydate(String passPortIssueDate) 
	{
		int year = Integer.parseInt(passPortIssueDate.substring(0, 4)) + 5;

		String passPortExpiryDate = passPortIssueDate.replaceFirst(".{4}",String.valueOf(year));

		return passPortExpiryDate;
	}
	

	public static String ReadInitial(String name) {
		char[] np = name.toCharArray();

		char init = np[0];

		String initial = String.valueOf(init);

		return initial;
	}

	public static int getlastNumber(String Empin) {
		String str = Empin;
		char[] convertedString = str.toCharArray();
		int myNumber = Character.getNumericValue(convertedString[(str.length() - 1)]);

		return myNumber;
	}

	public static String removeLastNumber(String Empin) {
		StringBuilder myNumber = new StringBuilder();
		String str = Empin;

		for (int i = 0; i < str.length() - 1; i++) {
			myNumber.append(str.charAt(i));
		}

		return myNumber.toString();
	}

	public static String getGender(String useID) {
		char[] convertedString = useID.toCharArray();

		String genderCode = null;

		if (Character.getNumericValue(convertedString[6]) <= 4) {
			genderCode = "Female";
		} else if (Character.getNumericValue(convertedString[6]) >= 5) {
			genderCode = "Male";
		}

		return genderCode;
	}

	public static String getTitle(String gender) {
		String titleCode = null;

		if (gender.equals("Male")) {
			List<String> list = new ArrayList();

			for (int i = 0; i < 30; i++) {
				list.add("Mr");
			}
			list.add("Prof");
			list.add("Hon");
			list.add("Dr");

			int index = new Random().nextInt(list.size());
			titleCode = (String) list.get(index);

		} else if (gender.equals("Female")) {
			List<String> list = new ArrayList();

			for (int i = 0; i < 20; i++) {
				list.add("Mrs");
			}
			for (int i = 0; i < 10; i++) {
				list.add("Ms");
			}
			for (int i = 0; i < 10; i++) {
				list.add("Miss");
			}
			list.add("Dr");

			int index = new Random().nextInt(list.size());
			titleCode = (String) list.get(index);
		}
		return titleCode;
	}

	public static String getAffirm() {
		Random makeRace = new Random();
		int raceCode = makeRace.nextInt(2) + 1;
		String Affirm = null;

		if (raceCode == 1) {
			Affirm = "Y";
		} else if (raceCode == 2) {
			Affirm = "N";
		}

		return Affirm;
	}

	public static int getEmploymentStatus(EmploymentTypeCodes code) 
	{	
		switch(code)
		{
			case ALL_PERMANENT : return 1;
			case ALL_CASUALS : return 5;
			case ALL_TEMPS : return 2;
			case ALL_RANDOM : 
			{
				Random randomStatus = new Random();
				int status = randomStatus.nextInt(12) + 1;
				return status;
				
			}
			case MOSTLY_PERMANENT :
			{
				int [] odds = {1,2,3,4,5,6,7,8,9,10,11,12,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
				Random randomStatus = new Random();
				int status = randomStatus.nextInt(odds.length-1) + 1;
				return odds[status];
			}
			default :
				return 0;
		}
	}

	public static int getPaymentRate(PaymentTypeCodes code) 
	{
		switch(code)
		{
			case MONTHLY : return 4;
			case DAILY : return 2;
			case HOURLY : return 1;
			default : return 0;
		}
	}

	public static String getDOB(String useID) 
	{
		String dob = "19" + useID.substring(0, 6);

		return dob;
	}

	public static int getAge(String dob) 
	{
		int thisYear = Calendar.getInstance().get(1);
		String dateOfBirthYear = dob.substring(0, 4);
		int dateOfBirth = Integer.parseInt(dateOfBirthYear);

		int age = thisYear - dateOfBirth;

		return age;
	}

	public static int getMaritalStatus() {
		Random makeStatus = new Random();
		int marstatus = makeStatus.nextInt(4) + 1;

		return marstatus;
	}

	public static int getEthnicPersuasion(String raceCode) {
		int ethnic = 0;

		if (raceCode == "N") {
			ethnic = 4;

		} else if (raceCode == "Y") {
			Random rand = new Random();
			ethnic = rand.nextInt(3) + 1;
		}

		return ethnic;
	}

	public static int getRateOfPay(boolean include, int minValue, int maxValue) {
		if (include) {
			Random payRateRandom = new Random();
			if (minValue == 0) {
				minValue = 5000;
			}
			if (maxValue == 0) {
				maxValue = 20000;
			}
			int payRate = payRateRandom.nextInt(maxValue - minValue) + minValue;

			return payRate;
		}

		return 0;
	}

	public static int getDigIncrement(String Empin) {
		String str = Empin;

		String myComplete = null;
		StringBuilder myNumbers = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				myNumbers.append(str.charAt(i));
			}
		}
		myComplete = myNumbers.toString();
		int myint = Integer.parseInt(myComplete);
		return myint;
	}

	public static String getAlphIncrement(String Empin) {
		String str = Empin;
		StringBuilder myAlpha = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(str.charAt(i))) {
				myAlpha.append(str.charAt(i));
			}
		}
		return myAlpha.toString();
	}

	public static String getNationality(String passIDnumber) {
		char[] IDcharacters = passIDnumber.toCharArray();

		String citizencode = Character.toString(IDcharacters[10]);

		String natCode = null;

		if (citizencode != "1") {
			natCode = "Y";
		} else if (citizencode == "0") {
			natCode = "N";
		}

		return natCode;
	}
	
	public static void populateNames() throws ClassNotFoundException, IOException, SQLException
	{
		allNames = ConnectionManager.getNames();
		allSurnames = ConnectionManager.getSurnames();
		
		for (Name name : allNames)
		{
			if (name.getEeStatus().equals("AA") && name.getGender().equals("F"))
			{
				femaleAANames.add(name);
			}
		}
		for (Name name : allNames)
		{
			if (name.getEeStatus().equals("AA") && name.getGender().equals("M"))
			{
				maleAANames.add(name);
			}
		}
		for (Name name : allNames)
		{
			if (name.getEeStatus().equals("Non-AA") && name.getGender().equals("F"))
			{
				femaleNonAANames.add(name);
			}
		}
		for (Name name : allNames)
		{
			if (name.getEeStatus().equals("Non-AA") && name.getGender().equals("M"))
			{
				maleNonAANames.add(name);
			}
		}
		for (Name name : allSurnames)
		{
			if (name.getEeStatus().equals("Non-AA"))
			{
				nonEeSurnames.add(name);
			}
		}
		for (Name name : allSurnames)
		{
			if (name.getEeStatus().equals("AA"))
			{
				eeSurnames.add(name);
			}
		}
	}
	
	public static String readRandomName(String eeStatus, String gender)
	{
		String name = null;
		if ((eeStatus.equals("N") & gender.equals("Male"))) 
	    {
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(maleNonAANames.size() - 1);

			Name nameObj = maleNonAANames.get(nameSelect);
			name = nameObj.getName();
	    }
		if (((eeStatus.equals("N") & gender.equals("Female"))))
		{
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(femaleNonAANames.size() - 1);

			Name nameObj = femaleNonAANames.get(nameSelect);
			name = nameObj.getName();
		}
		if ((eeStatus.equals("Y") & gender.equals("Female")))
		{
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(femaleAANames.size() - 1);

			Name nameObj = femaleAANames.get(nameSelect);
			name = nameObj.getName();
		}
		if ((eeStatus.equals("Y") & gender.equals("Male")))
		{
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(maleAANames.size() - 1);

			Name nameObj = maleAANames.get(nameSelect);
			name = nameObj.getName();
		}

		return name;
	}
	
	public static String getRandomDate(Date startDate,Date endDate)
	{
		//Random Date will randomly select between the day of the start date / 1st of the month or 15th of the month up to the end date selected
		LocalDate start = startDate.toLocalDate();
		LocalDate end = endDate.toLocalDate();
	 
		LocalDate randomDate = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(start.toEpochDay(), end.toEpochDay()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return randomDate.format(formatter);
	}	
	
	public static String readRandomSurname(String eeStatus)
	{
		String name = null;
		if (eeStatus.equals("N")) 
	    {
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(nonEeSurnames.size() - 1);

			Name nameObj = nonEeSurnames.get(nameSelect);
			name = nameObj.getName();
	    }

		if (eeStatus.equals("Y"))
		{
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(eeSurnames.size() - 1);

			Name nameObj = eeSurnames.get(nameSelect);
			name = nameObj.getName();
		}

		return name;
	}
	
	public static String readRandomSurname(String eeStatus, String gender)
	{
		String name = null;
		if ((eeStatus.equals("N") & gender.equals("Male"))) 
	    {
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(maleNonAANames.size() - 1);

			Name nameObj = maleNonAANames.get(nameSelect);
			name = nameObj.getName();
	    }
		if (((eeStatus.equals("N") & gender.equals("Female"))))
		{
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(femaleNonAANames.size() - 1);

			Name nameObj = femaleNonAANames.get(nameSelect);
			name = nameObj.getName();
		}
		if ((eeStatus.equals("Y") & gender.equals("Female")))
		{
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(femaleAANames.size() - 1);

			Name nameObj = femaleAANames.get(nameSelect);
			name = nameObj.getName();
		}
		if ((eeStatus.equals("Y") & gender.equals("Male")))
		{
			Random namerand = new Random();
			int nameSelect = namerand.nextInt(maleAANames.size() - 1);

			Name nameObj = maleAANames.get(nameSelect);
			name = nameObj.getName();
		}

		return name;
	}
	

	public static List<Name> getFemaleAANames() {
		return femaleAANames;
	}

	public static List<Name> getMaleAANames() {
		return maleAANames;
	}

	public static List<Name> getFemaleNonAANames() {
		return femaleNonAANames;
	}

	public static List<Name> getMaleNonAANames() {
		return maleNonAANames;
	}

}
