package com.cucumberbdd.automationFramework.utilsHelper;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.cucumberbdd.automationFramework.base.Base;

public class StringUtilsHelper extends Base{

	/**
	 * This method returns a random public URL
	 * @return
	 */
	public static String getRandomPublicURL() {
			ArrayList<String> websites = new ArrayList<String>();
			
			try {
				
				websites.add("http://www.ebay.com");
				websites.add("http://www.adobe.com");
				websites.add("http://www.bbc.com");
				websites.add("http://www.cnbc.com");
				websites.add("http://www.cnn.com");
				
				/*websites.add("http://www.live.com");
				websites.add("http://www.wordpress.com");
				websites.add("http://www.github.com");
				websites.add("http://www.wikipedia.com");
				websites.add("http://www.adobe.com");
				websites.add("https://www.uscis.gov/");
				websites.add("http://amasci.com/");
				websites.add("https://yarchive.net/");
				websites.add("https://hugotunius.se/");
				websites.add("https://www.seleniumhq.org/");*/
				
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return websites.get(getRandomNumber(websites));
	}

	/**
	 * This method returns a random number from an ArrayList
	 * @param listName
	 * @return
	 */
	public static int getRandomNumber(ArrayList<String> listName) {
		Random rand = new Random();
		return rand.nextInt(listName.size());
	}

	/**
	 * This method returns the Captive Portal existing user login credentials in QA environment
	 * @return
	 */
	public static String getAboveUserCredentials_QA() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("TAC103234:TACEmailSys123");
		return credentials.get(getRandomNumber(credentials));
	}

	/**
	 * This method returns the Captive Portal existing user login credentials in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierUserCredentials_StageProd() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("WIFI578290:Testing123");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 *  This method returns the Captive Portal existing user login credentials in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierUserCredentialsBackUp_StageProd() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("WIFI578266:Testing123");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 *  This method returns the existing Android/iPhone user login credentials in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierUserCredentialsForMobile_StageProd() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("WIFI578282:Testing123");
		return credentials.get(getRandomNumber(credentials));
	}

    /**
     *  This method returns the Captive Portal existing below tier residential user login credentials in QA environment
	 * @return
	 */
	public static String getBelowTierResidentUserCredentials_QA() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("TAC8919100012391422:TACEmailSys123");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns the Captive Portal existing below tier residential user login credentials in Stage or Prod environment
	 * @return
	 */
	public static String getBelowTierResidentUserCredentials_StageProd() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("rfdn26:Comcast1");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns the Captive Portal existing below tier business user login credentials in QA environment
	 * @return
	 */
	public static String getBelowTierBusinessUserCredentials_QA() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("qatest125@malisettycorp.comcastbiz.net:Comcast1");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns the Captive Portal existing below tier residential user login credentials in PROD environment
	 * @return
	 */
	public static String getBelowTierUserResidentialCredentials_Prod() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("wodnm19421747:Comcast1");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns the Captive Portal existing below tier user login credentials in QA environment
	 * @return
	 */
	public static String getBelowTierUserCredentials_QA() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("wifitestqa53:Tester123$");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns the Captive Portal existing above tier business user login credentials in QA environment
	 * @return
	 */
	public static String getAboveTierBusinessUserCredentials_QA() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("sri@wifitest.comcastbiz.net:Comcast1");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns the Captive Portal existing above tier business user login credentials in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierBusinessUserCredentials_StageProd() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("NewStroller2@GracooBabee.comcastbiz.net:Comcast1");
		return credentials.get(getRandomNumber(credentials));
	}

	/**
	 * This method returns the Captive Portal existing user Username in QA environment
	 * @return
	 */
	public static String getAboveTierUsername_QA() {
		String[] username = getAboveUserCredentials_QA().split(":");
		return username[0];
	}

	/**
	 * This method returns the Captive Portal existing user Password in QA environment
	 * @return
	 */
	public static String getAboveTierPassword_QA() {
		String[] password = getAboveUserCredentials_QA().split(":");
		return password[1];
	}
	
	/**
	 * This method returns the Captive Portal existing below tier residential user login credentials in QA environment
	 * @return
	 */
	public static String getBelowTierResidentUsername_QA() {
		String[] username = getBelowTierResidentUserCredentials_QA().split(":");
		return username[0];
	}
	
	/**
	 * This method returns the Captive Portal existing below tier residential user Password credentials in QA environment
	 * @return
	 */
	public static String getBelowTierResidentPassword_QA() {
		String[] password = getBelowTierResidentUserCredentials_QA().split(":");
		return password[1];
	}
	
	/**
	 * This method returns the Captive Portal existing below tier residential user login credentials in QA environment
	 * @return
	 */
	public static String getBelowTierResidentUsername_StageProd() {
		String[] username = getBelowTierResidentUserCredentials_QA().split(":");
		return username[0];
	}
	
	/**
	 * This method returns the Captive Portal existing below tier residential user Password credentials in QA environment
	 * @return
	 */
	public static String getBelowTierResidentPassword_StageProd() {
		String[] password = getBelowTierResidentUserCredentials_QA().split(":");
		return password[1];
	}
	
	/**
	 * This method returns the below tier business user Username in QA environment
	 * @return
	 */
	public static String getBelowTierBusinessUsername_QA() {
		String[] username = getBelowTierBusinessUserCredentials_QA().split(":");
		return username[0];
	}
	
	/**
	 * This method returns the below tier business user Password in QA environment
	 * @return
	 */
	public static String getBelowTierBusinessPassword_QA() {
		String[] password = getBelowTierBusinessUserCredentials_QA().split(":");
		return password[1];
	}
	
	/**
	 * This method returns the above tier business user Username in QA environment
	 * @return
	 */
	public static String getAboveTierBusinessUsername_QA() {
		String[] username = getAboveTierBusinessUserCredentials_QA().split(":");
		userId = username[0];
		return username[0];
	}
	
	/**
	 * This method returns the above tier business user Password in QA environment
	 * @return
	 */
	public static String getAboveTierBusinessPassword_QA() {
		String[] password = getAboveTierBusinessUserCredentials_QA().split(":");
		return password[1];
	}

	/**
	 * This method returns the below tier business user Username in STAGE/PROD environment
	 * @return
	 */
	public static String getBelowTierUsername_StageProd() {
		String[] username = getBelowTierUserResidentialCredentials_Prod().split(":");
		return username[0];
	}
	
	/**
	 * This method returns the below tier business user Password in STAGE/PROD environment
	 * @return
	 */
	public static String getBelowTierPassword_StageProd() {
		String[] password = getBelowTierUserResidentialCredentials_Prod().split(":");
		return password[1];
	}
	
	/**
	 * This method returns the above tier business user Username in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierBusinessUsername_StageProd() {
		String[] username = getAboveTierBusinessUserCredentials_StageProd().split(":");
		userId = username[0];
		return username[0];
	}
	
	/**
	 * This method returns the above tier business user Password in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierBusinessPassword_StageProd() {
		String[] password = getAboveTierBusinessUserCredentials_StageProd().split(":");
		return password[1];
	}
	
	/**
	 * This method returns the existng user Username in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierUsername_StageProd() {
		String[] username = getAboveTierUserCredentials_StageProd().split(":");
		userId = username[0];
		return username[0];
	}

	/**
	 * This method returns the existing user Password in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierPassword_StageProd() {
		String[] password = getAboveTierUserCredentials_StageProd().split(":");
		return password[1];
	}
	
	/**
	 * This method returns the existng user Username in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierBackUpUsername_StageProd() {
		String[] username = getAboveTierUserCredentialsBackUp_StageProd().split(":");
		userId = username[0];
		return username[0].trim();
	}

	/**
	 * This method returns the existing user Password in STAGE/PROD environment
	 * @return
	 */
	public static String getAboveTierBackupPassword_StageProd() {
		String[] password = getAboveTierUserCredentialsBackUp_StageProd().split(":");
		return password[1].trim();
	}

	public static String getAboveTierUserName() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getAboveTierUsername_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getAboveTierUsername_StageProd();
		}
		return null;
	}
	
	public static String getAboveTierPassword() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getAboveTierPassword_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getAboveTierPassword_StageProd();
		}
		return null;
	}
	
	/*
	 * This method get the alternate username for captive portal
	 */
	public static String getAboveTierBackUpUserName() {
		if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getAboveTierBackUpUsername_StageProd();
		}
		return "";
	}
	
	/*
	 * This method get the alternate password for captive portal
	 */
	public static String getAboveTierBackUpPassword() {
		if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getAboveTierBackupPassword_StageProd();
		}
		return "";
	}
	public static String getBelowTierUserName() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getBelowTierResidentUsername_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getBelowTierUsername_StageProd();
		}
		return null;
	}
	
	public static String getBelowTierPassword() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getBelowTierResidentPassword_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getBelowTierPassword_StageProd();
		}
		return null;
	}
	
	/**
	 * This method returns user's Email address and Zip code
	 * @return
	 */
	public static String getUserEmailAndZipcode() {
		ArrayList<String> credentials = new ArrayList<String>();
		
		try {
			credentials.add("test@gmail.com:19103");
			credentials.add("wodnm01@gmail.com:19103");
			credentials.add("wodnm002@gmail.com:19103");
		} catch(Exception e) {
			Log4j.info(e.getMessage());
		}
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns the non-existing user Email address
	 * @return
	 */
	public static String getUserEmailAddress() {
		String[] email = getUserEmailAndZipcode().split(":");
		return email[0];
	}
	
	/**
	 * This method returns the non-existing user Zipcode
	 * @return
	 */
	public static String getUserZipcode() {
		String[] zipcode = getUserEmailAndZipcode().split(":");
		return zipcode[1];
	}
	
	/**
	 * This method is used to generate random names for further automation usage
	 * @return
	 */
	public static String getRandomNames() {
		ArrayList<String> names = new ArrayList<String>();
		
		try {
			names.add("Samual:Pai");
			names.add("Jonathan:Sweeney");
			names.add("Donovan:Tafolla");
			names.add("Victor:Melillo");
			names.add("Shaina:Motta");
			names.add("Margareta:Bennington");
			names.add("Roselia:Horan");
			names.add("Lilly:Heal");
			names.add("Patience:Gratz");
			names.add("Enid:Lover");
			names.add("Tamera:Knorr");
			names.add("Stephany:Arizmendi");
			names.add("Maximina:Centers");
			names.add("Edyth:Eggleston");
			names.add("Bong:Rossbach");
			names.add("Jenice:Cookingham");
			names.add("Mikaela:Mcgahee");
			names.add("Lore:Filkins");
			names.add("Brandy:Barish");
			names.add("Coleen:Martello");
			names.add("Coretta:Clay");
			names.add("Alise:Madison");
			names.add("Stepanie:Erskine");
			names.add("Celinda:Sharpless");
			names.add("Jill:Stiefel");
			names.add("Edythe:Luman");
			names.add("Marjory:Buda");
			names.add("Valery:Lindemann");
			names.add("Suk:Beckwith");
			names.add("Nona:Holdman");
			names.add("Amber:Guth");
			names.add("Vita:Block");
			names.add("Yoshie:Truelove");
			names.add("Buddy:Souza");
			names.add("Mariko:Slack");
			names.add("Claudia:Houseman");
			names.add("Versie:Fuselier");
			names.add("Will:Hendershott");
			names.add("Donn:Carrion");
			names.add("Carmela:Twyman");
			names.add("Isabelle:Stull");
			names.add("Rosella:Garbarino");
			names.add("Renetta:Wolpert");
			names.add("Bunny:Blass");
			names.add("Mirta:Kohan");
			names.add("Cindi:Surrett");
			names.add("Onita:Salmons");
			names.add("Hermine:Bilski");
			names.add("Jetta:Eastwood");
			names.add("Carlena:Cosme");
			names.add("Delta:Villegas");
			names.add("Cathey:Hovland");
			names.add("Ngoc:Willman");
			names.add("Jaleesa:Stackhouse");
			names.add("Loretta:Macintyre");
			names.add("Annice:Quandt");
			names.add("Angie:Dupree");
			names.add("Tamatha:Dilley");
			names.add("Shirleen:Esposito");
			names.add("Leia:Ciotti");
			names.add("Manuela:Schmitmeyer");
			names.add("Amberly:Parkinson");
			names.add("Gabriela:Shur");
			names.add("Kori:Bigler");
			names.add("Lurlene:Quesada");
			names.add("Consuelo:Camel");
			names.add("Hermine:Ammerman");
			names.add("Wanda:Zeolla");
			names.add("Hisako:Pacifico");
			names.add("Sharmaine:Grinnell");
			names.add("Jefferey:Eisenman");
			names.add("Gary:Scovil");
			names.add("Thad:Zacharias");
			names.add("Maricela:Giles");
			names.add("Sean:Studebaker");
			names.add("Randell:Condit");
			names.add("Jodee:Portugal");
			names.add("Williams:Cheslock");
			names.add("Lexie:Fortson");
			names.add("Rosendo:Berkley");
			names.add("Norman:Almaguer");
			names.add("Melonie:Pless");
			names.add("Caterina:Fergus");
			names.add("Madison:Rowser");
			names.add("Randy:Fabre");
			names.add("William:Welborn");
			names.add("Barbera:Pegg");
			names.add("Khadijah:Fells");
			names.add("Marybelle:Hecht");
			names.add("Gordon:Kohan");
			names.add("Karole:Sober");
			names.add("Denyse:Schuelke");
			names.add("Michelina:Dingus");
			names.add("Katina:Auten");
			names.add("Shanti:Shippy");
			names.add("Maryland:Ku");
			names.add("Yessenia:Sumrall");
			names.add("Marissa:Banning");
			names.add("Rosalba:Forbes");
			names.add("Darron:Soliman");
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		return names.get(getRandomNumber(names));
	}
	
	/**
	 * This method returns the first name of the user from getRandomNames() method
	 * @return
	 */
	public static String getFirstName() {
		String[] firstName = getRandomNames().split(":");
		return firstName[0];
	}
	
	/**
	 * This method returns the last name of the user from getRandomNames() method
	 * @return
	 */
	public static String getLastName() {
		String[] lastName = getRandomNames().split(":");
		return lastName[1];
	}
	
	/**
	 * This method is used to generate a random email for purchasing and registering Captive Portal passes
	 * @return
	 */
	public static String getRandomEmailAddress() {
		return "wodnm" + generateRandomNumeric(8) + "@gmail.com";
	}
	
	/**
	 * This method is used to generate random zipcodes for further automation usage
	 * @return
	 */
	public static String getRandomZipCodes() {
		ArrayList<String> zipcode = new ArrayList<String>();
		
		try {
			zipcode.add("19126");
			zipcode.add("19125");
			zipcode.add("19128");
			zipcode.add("19127");
			zipcode.add("19130");
			zipcode.add("19129");
			zipcode.add("19132");
			zipcode.add("19131");
			zipcode.add("19134");
			zipcode.add("19133");
			zipcode.add("19136");
			zipcode.add("19135");
			zipcode.add("19138");
			zipcode.add("19137");
			zipcode.add("19140");
			zipcode.add("19139");
			zipcode.add("19142");
			zipcode.add("19141");
			zipcode.add("19144");
			zipcode.add("19143");
			zipcode.add("19146");
			zipcode.add("19145");
			zipcode.add("19148");
			zipcode.add("19147");
			zipcode.add("19150");
			zipcode.add("19149");
			zipcode.add("19152");
			zipcode.add("19151");
			zipcode.add("19154");
			zipcode.add("19153");
			zipcode.add("19155");
			zipcode.add("19170");
			zipcode.add("19173");
			zipcode.add("19019");
			zipcode.add("19176");
			zipcode.add("19187");
			zipcode.add("19192");
			zipcode.add("19101");
			zipcode.add("19099");
			zipcode.add("19103");
			zipcode.add("19102");
			zipcode.add("19105");
			zipcode.add("19104");
			zipcode.add("19107");
			zipcode.add("19106");
			zipcode.add("19109");
			zipcode.add("19111");
			zipcode.add("19112");
			zipcode.add("19115");
			zipcode.add("19114");
			zipcode.add("19118");
			zipcode.add("19116");
			zipcode.add("19120");
			zipcode.add("19119");
			zipcode.add("19122");
			zipcode.add("19121");
			zipcode.add("19124");
			zipcode.add("19123");
		
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return zipcode.get(getRandomNumber(zipcode));
	}
	
	/**
	 * This method is used to generate a random String of Alphabet for a given length
	 * @param length
	 * @return
	 */
	public static String generateRandomStrAlphabetic(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	/**
	 * This method genrates a random String of integers for a give length
	 * @param length
	 * @return
	 */
	public static String generateRandomNumeric(int length) {
		return RandomStringUtils.randomNumeric(length);
	}
	
	/**
	 * This method is used to generate a random String of Alpha-Numeric characters for a given length
	 * @param length
	 * @return
	 */
	public static String generateRandomStrAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
	/**
	 * This method is used to generate a random integer for a given length/maximum numbers
	 * @param maxNumber
	 * @return
	 */
	public static int generateRandomInt(int maxNumber) {
		return new Random().nextInt(maxNumber);
	}
	
	/**
	 * This method is used to generate a random integer range for a given lower bound and upper bound
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public static int generateRandomIntInRange(int lowerBound, int upperBound) {
		return ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
	}
	
	/**
	 * This method returns the first N characters of a string based on the number of required characters
	 * @param str
	 * @param n
	 * @return
	 */
	public static String getFirstNCharacters(String str, int n) {
		return str.substring(0, Math.min(str.length(), n));
	}
	
	/**
	 * This method is used to remove the last character of a given string
	 * @param str
	 * @return
	 */
	public static String removeLastCharacter(String str) {
		if (str != null && str.length() > 0 && Character.isLetter(str.charAt(str.length()-1)) ) {
			str = str.substring(0, str.length() - 1);
		} else if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	/**
	 * This method is used to remove the last n characters of a given string
	 * @param str
	 * @return
	 */
	public static String removeLastNCharacters(String str, int lastNCharacterCount) {
		if (str != null && str.length() > 0 && Character.isLetter(str.charAt(str.length()-1)) ) {
			str = str.substring(0, str.length() - lastNCharacterCount);
		} else if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - lastNCharacterCount);
		}
		return str;
	}
	
	/**
	 * This method is used to remove the last character of a given string
	 * @param str
	 * @return
	 */
	public static String removeFirstCharacter(String str) {
		if (str != null && str.length() > 0 ) {
			str = str.substring(1, str.length());
		} 
		return str.trim();
	}
	
	/**
	 * This method is used to generate a random UUID on a Windows laptop which is used to create a Wireless interface name
	 * @return
	 */
	public static String generateRandomUUID() {
		UUID uuid = UUID.randomUUID();
	    return uuid.toString();
	}
	
	/**
	 * This method is used to get a text without decimals for a given String
	 * @param sampleText
	 * @return
	 */
	public static String getTextWithOutDecimals(String sampleText) {
		if (sampleText.contains(".0")) {
			sampleText = sampleText.substring(0, (sampleText.length() - 2));
		} else if (sampleText.contains(".00")) {
			sampleText = sampleText.substring(0, (sampleText.length() - 3));
		}
		return sampleText;
	}
	
	
	/**
	 * This method is used to replace the old string with a new string for a given string
	 * @param str
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	public static String replaceCharacterInAString(String str, String oldStr, String newStr) {
		return str.replace(oldStr, newStr);
	}
	
	/**
	 * This method is used to copy a String to Clipboard
	 * @param strToCopy
	 */
	public static void copyStringToClipboard(String strToCopy) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(strToCopy);
		clipboard.setContents(strSel, null);
	}
	
	/**
	 * This method is used to convert Clipboard content to String
	 * @return
	 * @throws Exception
	 */
	public static String getClipboardContentToString() throws Exception {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		
		return result;
	}
	
	/**
	 * This method converts a HEX-STRING input to a STRING output format
	 * @param hex
	 * @return
	 */
	public static String convertHexToString(String hex) {
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		  
		try {
			//49204c6f7665204a617661 split into two characters 49, 20, 4c...
			  for( int i = 0; i < hex.length() - 1; i += 2 ){
				  
			      //grab the hex in pairs
			      String output = hex.substring(i, (i + 2));
			      //convert hex to decimal
			      int decimal = Integer.parseInt(output, 16);
			      //convert the decimal to character
			      sb.append((char)decimal);
				  
			      temp.append(decimal);
			  }
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to convert Hex to String");
		}
		  
		return temp.toString().trim();
	  }
	
	/**
	 * This method returns the 1st occurrence of a character in a string
	 * @param str
	 * @param c
	 * @return
	 */
	public static int findInStr (String str, String c) {
		for (int i = 0; i < str.length(); i++) {
		    if (String.valueOf(str.charAt(i)).equalsIgnoreCase(c)) 
		        return i;
		}
		return -1;
	}
	
	
	/**
	 * This method is used to format an unformatted XML file into pretty format
	 * @param xml
	 * @return
	 */
	public static String prettyFormatXML(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            final Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));

            System.setProperty(DOMImplementationRegistry.PROPERTY,"com.sun.org.apache.xerces.internal.dom.DOMImplementationSourceImpl");

            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
            writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set this to true if the declaration is needed to be in the output.

            return writer.writeToString(document);
        } catch (Exception e) {
        	Log4j.info("Failed to format XML");
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * This method is used to format an unformatted XML file into pretty format
	 * @param unformattedXml
	 * @return
	 *//*
	public static String format(String unformattedXml) {
	    try {
	        final Document document = parseXmlFile(unformattedXml);
	
	        OutputFormat format = new OutputFormat(document);
	        format.setLineWidth(65);
	        format.setIndenting(true);
	        format.setIndent(2);
	        Writer out = new StringWriter();
	        XMLSerializer serializer = new XMLSerializer(out, format);
	        serializer.serialize(document);
	
	        return out.toString();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}*/
	
	/**
	 * This method is used to parse an XML file
	 * @param unformattedXml
	 * @return
	 */
	public static Document parseXmlFile(String unformattedXml) {
	    try {
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        InputSource is = new InputSource(new StringReader(unformattedXml));
	        return db.parse(is);
	    } catch (ParserConfigurationException e) {
	        throw new RuntimeException(e);
	    } catch (SAXException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	/** This method returns the position number of a substring in a string
	 * @param text
	 * @param matchText
	 * @return positionNumber
	 */
	public static int getPositionOfSubString(String text, String matchText) {
		return text.indexOf(matchText);
	}

	/** This method adds a character for every n characters and returns a string
	 * @param text
	 * @param insert
	 * @return period
	 */
	public static String insertACharacterPeriodically(String text, String insert, int period) {
		StringBuilder builder = new StringBuilder(text.length() + insert.length() * (text.length() / period) + 1);
		try {
			int index = 0;
			String prefix = "";
			while (index < text.length()) {
				// Don't put the insert in the very first iteration.
				// This is easier than appending it *after* each substring
				builder.append(prefix);
				prefix = insert;
				builder.append(text.substring(index, Math.min(index + period, text.length())));
				index += period;
			}
			return builder.toString();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return builder.toString();
	}
	
	/** This method returns the percentage of two numbers in int
	 * @param score
	 * @param total score
	 * @return int
	 */
	public static int getPercentageOfAnyTwoNumbers(float score, float totalScore) {
		float percent = (score * 100.0f) / totalScore;
		return (int) percent;
	}
	
	/** This method is used to get last n character(s) of a given string
	 * @param str
	 * @return
	 */
	public static String getLastNCharacters(String str, int n) {
		if (str != null && str.length() > 0 ) {
			str = str.substring(str.length() - n, str.length());
		} 
		return str;
	}
  
	/** This method is used to insert a delimiter in a String in between characters
	 * @param text
	 * @param insert
	 * @param period
	 * @return
	 */
	public static String insertDelimiterInAString(String text, String insert, int period) {
	    Pattern p = Pattern.compile("(.{" + period + "})", Pattern.DOTALL);
	    Matcher m = p.matcher(text);
	    return m.replaceAll("$1" + insert);
	}
	
	/**
	 * This method is used to format a MAC address in the format: 00:00:00:00:00:00
	 * @param macAddress
	 * @return
	 */
	public static String formatMACAddress(String macAddress) {
		try {
			if (macAddress.contains(":")) {
				Log4j.info("MAC address is already formatted");
			
			} else {
				macAddress = StringUtilsHelper.removeLastCharacter(insertDelimiterInAString(macAddress, ":", 2));
			}
			
			return macAddress;
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			return macAddress;
		}
	}
	
	/**
	 * This method is get only numerics of an other string
	 * @param actual String
	 * @return numeric only string
	 */
	public static String getNumericsOnlyFromAString(String actualString) {
		String numericString = "";
	    for (char c : actualString.toCharArray()) {
	        if (Character.isDigit(c)) {
	        		numericString = numericString + c;
	        } 
	    }
		return numericString;
	}
	
  /** This method converts Hexa decimal value to ASCII value.
	 * @param hexValue
	 * @return ASCII value
	 */
	public static String getASCIIValueForHexaValue(String hexValue) {
	 
		StringBuilder asciiValue = new StringBuilder();
	    
		for (int i = 0; i < hexValue.length(); i+=2) {
	        String str = hexValue.substring(i, i+2);
	        asciiValue.append((char)Integer.parseInt(str, 16));
	    }
	    
	    return asciiValue.toString();
	}
	
	/**
	 * This method converts HEX to Decimal format
	 * @param hex
	 * @return
	 */
	public static String convertHexToDecimal(String hex) {
		String finalStr = "";
		
		try {
			String[] split =  hex.split(" ");
		
			for (int i = 0; i < split.length; i++) {
				int decimal = Integer.parseInt(split[i].trim(),16);  
				finalStr = finalStr + decimal + ".";
			}
			finalStr = StringUtilsHelper.removeLastCharacter(finalStr.trim());
			return finalStr;
			
		} catch (Exception e) {
			Log4j.info("Failed to convert HEX string to Decimal - " + e.getMessage());
			return finalStr;
		}
	}
	
	/**
	 * This method is used to copy existing page content to String using Keyboard keys CTRL+C CTRL+V
	 * @
	 */
	public static String getExistingPageContentAsStringUsingKeyboardKeys()  {
		try {
			Log4j.info("Getting the existing page content to String format");
			
		//	String currentWindow = driver.getWindowHandle();
			SetForegroundWindowUtil.keyboardKeysSelectAll();
		//	driver.switchTo().window(currentWindow);
			SetForegroundWindowUtil.keyboardKeysSelectAll();
			SetForegroundWindowUtil.keyboardKeysCopy();
			
			return StringUtilsHelper.getClipboardContentToString();

		} catch (Exception e) {
			Log4j.info("Failed to copy the existing page content to String using keyboard keys - " + e.getMessage());
			return "";
		}
	}
	
	/**
	 * This method is used to get the first occurrence of a character/string in a main string
	 * @param mainStr
	 * @param subStr
	 * @return
	 */
	public static int getFirstOccurenceOfACharacter(String mainStr, String subStr){
	    return mainStr.indexOf(subStr);
	}
	
	/**
	 * This  method is used to get the total number of times a character is occurring in a string
	 * @param str
	 * @param charToCheck
	 * @return
	 */
	public static int getOccuringCharCount(String str, String charToCheck)  { 
		int occurenceCount = 0;
		
		try {
			occurenceCount = StringUtils.countMatches(str, charToCheck);
			
			Log4j.info("The number of times the character '" + charToCheck + "' is found in the input string '" + str + "' is: " + occurenceCount);
			return occurenceCount;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the number of occurences of the character");
			Log4j.info(e.getMessage());
			return occurenceCount;
		}
    }
	
	/**
	 * This method is used to get the last index of a character in a given string
	 * @param str
	 * @param charToSearch
	 * @return
	 */
	public static int getLastIndexOfCharacter(String str, String charToSearch) {
		int lastIndex = 0;
		
		try {
			lastIndex = str.lastIndexOf(charToSearch);
			Log4j.info("The last index of the character '" + charToSearch + "' in the string '" + str + "' is: " + lastIndex);
			return lastIndex;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the last index of the character '" + charToSearch + "' in the string '" + str + "' \n" + e.getMessage());
			return lastIndex;
		}
	}
	
	/**
	 * This method is used to check if the index position for a given input string is an Integer or not
	 * @param index
	 * @return
	 */
	public static boolean isInputStringAnInteger(String inputStr, int index) {
		boolean isInteger = false;
		
		try {
			isInteger = Character.isDigit(inputStr.charAt(index));
			Log4j.info("Is input string an Integer: " + isInteger);
			return isInteger;
			
		} catch (Exception e) {
			Log4j.info("Failed to check if the index position for a given input string is an Integer or not");
			Log4j.info(e.getMessage());
			return isInteger;
		}
	}
	
	/**
	 * This method is used to check if the index position for a given input string is an Letter or not
	 * @param index
	 * @return
	 */
	public static boolean isInputStringALetter(String inputStr, int index) {
		boolean isLetter = false;
		
		try {
			isLetter = Character.isLetter(inputStr.charAt(index));
			Log4j.info("Is input string a Letter: " + isLetter);
			return isLetter;
			
		} catch (Exception e) {
			Log4j.info("Failed to check if the index position for a given input string is a Letter or not");
			Log4j.info(e.getMessage());
			return isLetter;
		}
	}
	
	/**
	 * This method is used to generate a random number of given length with a prefix
	 * @param nunberLength
	 * @param prefix
	 * @return
	 */
	public static String generateRandomNumberWithPrefix(String nunberLength) {
		String number = "";
		
		try {
			Random rand = new Random();
	        long x = (long)(rand.nextDouble()*100000000000000L);
	        int prefix = getRandomIntegerBetweenRange(1, 9);
	        number = String.valueOf(prefix) + String.format("%0" + nunberLength + "d", x);
	        
	        Log4j.info("The '" + number + "' digit number starting with prefix '" + prefix + "' is: " + number);
			return number;
			
		} catch (Exception e) {
			Log4j.info("Failed to generate a random number of given length with a prefix");
			Log4j.info(e.getMessage());
			return number;
		}
    }
	
	/**
	 * This method is used to to generate a random number in between a given minimum and maximum number 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandomIntegerBetweenRange(double min, double max) {
		int number = 0;
		
		try {
			double x = (int)(Math.random()*((max-min)+1)) + min;
		    number = (int) x;
			
		    Log4j.info("The random number generated in between the minmum number (" + min + ") and the maximum number (" + max + ") is: " + number);
			return number;
			
		} catch (Exception e) {
			Log4j.info("Failed to generate a random number in between the minmum number (" + min + ") and the maximum number (" + max + ")");
			Log4j.info(e.getMessage());
			return number;
		}
	}
	
	/**
	 * This method is used to generate a random number with a given length input
	 */
	public static int generateRandomNumber(int length) {
		int number = 0;
		
		try {
			Random random = new Random();
		    char[] digits = new char[length];
		    digits[0] = (char) (random.nextInt(9) + '1');
		    for (int i = 1; i < length; i++) {
		        digits[i] = (char) (random.nextInt(10) + '0');
		    }
		    long output = Long.parseLong(new String(digits));
		    number = (int)output;
		    
		    return number;
		} catch (Exception e) {
			Log4j.info("Failed to generate a random nunber of length '" + length + "' digits");
			Log4j.info(e.getMessage());
			return number;
		}
	}
	
	/**
	 * This method is used to get the URL status from the Captive Portal page
	 * @param currentURL
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static int getURLStatus(String currentURL) throws MalformedURLException, IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(currentURL).openConnection();
		return connection.getResponseCode();
	}
	
	/**
	 * This method returns Internet Essentials username
	 * @return Internet Essentials username
	 */
	public static String getInternetEssentialsUserName() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getInternetEssentialsUsername_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getInternetEssentialsUsername_StageProd();
		}
		return null;
	}
	
	/**
	 * This method returns Internet Essentials password
	 * @return Internet Essentials password
	 */
	public static String getInternetEssentialsPassword() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getInternetEssentialsPassword_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getInternetEssentialsPassword_StageProd();
		}
		return null;
	}
	
	/**
	 * This method returns Internet Essentials user login credentials in QA environment
	 * @return
	 */
	public static String getInternetEssentialsUsername_QA() {
		String[] username = getInternetEssentialsUserCredentials_QA().split(":");
		return username[0];
	}
	
	/**
	 * This method returns Internet Essentials user Password credentials in QA environment
	 * @return
	 */
	public static String getInternetEssentialsPassword_QA() {
		String[] password = getInternetEssentialsUserCredentials_QA().split(":");
		return password[1];
	}
	
	/**
	 * This method returns Internet Essentials user Username in STAGE/PROD environment
	 * @return
	 */
	public static String getInternetEssentialsUsername_StageProd() {
		String[] username = getInternetEssentialsUserCredentials_StageProd().split(":");
		return username[0];
	}
	
	/**
	 * This method returns Internet Essentials user Password in STAGE/PROD environment
	 * @return
	 */
	public static String getInternetEssentialsPassword_StageProd() {
		String[] password = getInternetEssentialsUserCredentials_StageProd().split(":");
		return password[1];
	}
	
	/**
	 * This method returns Internet Essentials user login credentials in QA environment
	 * @return
	 */
	public static String getInternetEssentialsUserCredentials_QA() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("ARCADIA100060:ARCADIA100060");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns Internet Essentials user login credentials in Stage or Prod environment
	 * @return
	 */
	public static String getInternetEssentialsUserCredentials_StageProd() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("ARCADIA100037:Testing123");
		return credentials.get(getRandomNumber(credentials));
	}
	

	/**
	 * This method returns Performance Starter username
	 * @return Performance Starter username
	 */
	public static String getPerformanceStarterUserName() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getPerformanceStarterUsername_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getPerformanceStarterUsername_StageProd();
		}
		return null;
	}
	
	/**
	 * This method returns Performance Starter password
	 * @return Performance Starter password
	 */
	public static String getPerformanceStarterPassword() {
		if (environmentName.toLowerCase().equals("qa")) {
			return getPerformanceStarterPassword_QA();
		} else if (environmentName.toLowerCase().equals("stage") || environmentName.toLowerCase().equals("prod")) {
			return getPerformanceStarterPassword_StageProd();
		}
		return null;
	}
	
	/**
	 * This method returns Performance Starter user login credentials in QA environment
	 * @return
	 */
	public static String getPerformanceStarterUsername_QA() {
		String[] username = getPerformanceStarterUserCredentials_QA().split(":");
		return username[0];
	}
	
	/**
	 * This method returns Performance Starter user Password credentials in QA environment
	 * @return
	 */
	public static String getPerformanceStarterPassword_QA() {
		String[] password = getPerformanceStarterUserCredentials_QA().split(":");
		return password[1];
	}
	
	/**
	 * This method returns Performance Starter user Username in STAGE/PROD environment
	 * @return
	 */
	public static String getPerformanceStarterUsername_StageProd() {
		String[] username = getPerformanceStarterUserCredentials_StageProd().split(":");
		return username[0];
	}
	
	/**
	 * This method returns Performance Starter user Password in STAGE/PROD environment
	 * @return
	 */
	public static String getPerformanceStarterPassword_StageProd() {
		String[] password = getPerformanceStarterUserCredentials_StageProd().split(":");
		return password[1];
	}
	
	/**
	 * This method returns Performance Starter user login credentials in QA environment
	 * @return
	 */
	public static String getPerformanceStarterUserCredentials_QA() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("WIFI12631700:Testing123");
		return credentials.get(getRandomNumber(credentials));
	}
	
	/**
	 * This method returns Performance Starter user login credentials in Stage or Prod environment
	 * @return
	 */
	public static String getPerformanceStarterUserCredentials_StageProd() {
		ArrayList<String> credentials = new ArrayList<String>();
		credentials.add("WIFI12631700:Testing123");
		return credentials.get(getRandomNumber(credentials));
	}
}
