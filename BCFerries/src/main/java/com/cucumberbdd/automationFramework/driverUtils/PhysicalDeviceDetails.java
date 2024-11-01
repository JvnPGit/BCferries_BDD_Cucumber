package com.cucumberbdd.automationFramework.driverUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.cucumberbdd.automationFramework.base.Base;

public class PhysicalDeviceDetails extends Base {
	public static String udid;
	public static String deviceConnectDevice;
	
	/**
	 * This method returns the UDID of a mobile device (Android mobile/Android tablet/iPad/iPhone)
	 * @param deviceName
	 * @return
	 */
	public static String getUdid(String deviceName) {
		try {
			switch (deviceName) {
			
			//Lenovo Tablet
			case "Android01":
				udid = "3300b1b12843627d";
				//mobileMacId = "40:4e:36:22:48:f4";
				break;
				
			// HTC
			case "Android02":
				udid = "d791e28";
				mobileMacId = "40:4e:36:22:48:f4";
				break;
			
			//iPhone v7
			case "iPhone01":
				udid = "d4f096bd2e3adac528e7074deac42ec761d0c260";
				mobileMacId = "78:88:6d:72:e4:cb";
				break;
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the UDID of the device: '" + deviceName + "'");
		}
		
		return udid;
	}
	
	/**
	 * This method returns the client device current Wi-Fi MAC address
	 * @return
	 * @
	 */
	public static String getDeviceMACAddress() {
		try {
			if (deviceType.equalsIgnoreCase("Desktop")) {
				return "";
			} else if (!deviceType.equalsIgnoreCase("Desktop")) {
				return mobileMacId;
			}	
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the device MAC address");
		}
		
		return "";
	}
	
	/**
	 * This method returns the UDID of a mobile device (Android mobile/Android tablet/iPad/iPhone)
	 * @return
	 * @
	 */
	public static String getDeviceUDID()  {
		String udidValue = null;
		
		try { 
			if (isWindows()) {
				Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "adb devices"});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line, st = null; 
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 
		        String[] str = st.split("\n");
		        String[] udid = null;
		        for(int i = 0; i < str.length; i++) {
		        	if(str.length > 1) {
		        		udid = str[1].split("device");
		        	}
		    	}
		        
		        for (int j = 0; j < udid.length; j++) {
        			if(udid[j].trim() != "" || udid[j].trim() != null) {
        				udidValue = udid[j].trim();
        				break;
        			}
        		}
			} else if (isMAC()) {
				
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the device UDID");
		}
		return udidValue;
	}
	
	/**
	 * This method is used to verify if the client device is a Mobile device (Android mobile / iPhone)
	 * @return
	 */
	public static boolean isMobile() {
		return !(deviceType.equalsIgnoreCase("Desktop")) && (deviceName.contains("Android") || deviceName.contains("iPhone"));
	}
	
	/**
	 * This method is used to verify if the client device is a tablet device (Android tablet / iPad)
	 * @return
	 */
	public static boolean isTab() {
		return !(deviceType.equalsIgnoreCase("Desktop")) && (deviceName.contains("ATab") || deviceName.contains("iPad"));
	}
	
	/**
	 * This method is used to get the desktop serial number (Windows/Macbook)
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static String getDesktopSerialNumber() throws Exception {
		String serial = "";
		
		try {
			if (isWindows()) {
				Process process = Runtime.getRuntime().exec(new String[] {"wmic", "bios", "get", "serialnumber"});
				process.getOutputStream().close();
				Scanner sc = new Scanner(process.getInputStream());
				String property = sc.next();
				serial = sc.next();
				Log4j.info("Windows Desktop " + property + ": " + serial);
				
				return serial;
			} else if (isMAC()) {
				String st = null;
				
				String cmd = "system_profiler SPHardwareDataType | awk '/Serial/ {print $4}'";
				StringBuilder sb = new StringBuilder();
				
				Runtime run = Runtime.getRuntime();
				Process pr = run.exec(cmd);
				pr.waitFor();
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				String line = "";
				
				while ((line=buf.readLine())!=null) {
					sb = sb.append(line).append("\n");
		        	st = sb.toString();
					
				}
				serial = st;
				serial = serial.substring(serial.indexOf("Serial Number (system):") + 1);
				serial = serial.substring(0,  serial.indexOf("Hardware"));
				serial = serial.substring(serial.indexOf(":") + 1).trim();
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the desktop serial number");
		}
		
		return serial;
	}
	
	/**
	 * This method returns the desktop device name for further automation usage
	 * @return
	 */
	public static String getDesktopDeviceName() {
		String serial;
		String deviceName = "";
		
		try {
			serial = getDesktopSerialNumber();
			
			switch (serial) {
				case "5CD62848DR":
					deviceName = "Win02";
					break;
				
				case "5CD6290CJM":
					deviceName = "Win03";
					break;
					
				case "5CD643381V":
					deviceName = "Win05";
					break;
					
				case "LR0AFJGY":
					deviceName = "Win06";
					break;
					
				case "FWHG5M2":
					deviceName = "Win17";
					break;
					
				case "C02SG0LFFVH8":
					deviceName = "Mac09";
					break;
					
				case "C02Q60BMG8WL":
					deviceName = "Mac10";
					break;
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get desktop device name");
		}
		return deviceName;
	}
	
	/**
	 * This method returns the suffix to be added to the og1600 ssid names
	 * @param deviceSerialNumber
	 * @return
	 * @
	 */
	public static String getOG1600DevicePrefixId(String deviceSerialNumber) {
		try {
			switch (deviceSerialNumber) {
			
			case "82C2UG888711544"://Automation Prod device is P1
				return "P1"; 
				
			case "G75BUG665600317":
				return "P2";
				
			case "G75BUG665600327":
				return "P3";
				
			case "8CL2UG888750802":
				return "P4";
				
			case "8CL2UG888750804":
				return "P5";
				
			case "8912UG888731731":
				return "P6";
			
			case "G92BUG776700594"://Automation Prod device is Q1
				return "Q1";
				
			case "8152UG888707056":
				return "Q2";
				
			case "G75BUG665600332":
				return "Q3";
			
			default:
				return "NoMatch";
			}

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get OG1600 device prefix ID");
			return "";
		}
	}
	
	/**
	 * This method returns the suffix to be added to the cpe ssid names
	 * @param deviceSerialNumber
	 * @return
	 */
	public static String getCPEDevicePrefixId(String deviceSerialNumber) {
		try {
			switch (deviceSerialNumber) {
			
			case "275169011"://BWG
				return "P1"; 
				
			case "DBDBU4EC9552237"://Arris XB2
				return "P2";
				
			case "F19BUE686602188"://Arris XB3  
				return "P3";
	
			case "276650704"://BWGNative
				return "P4";
				
			case "G46BUK577B24410"://Arris XB3  
				return "P5";
				
			case "G46BUK577B22729": //Arris XB3
				return "P6";
				
			case "276250667": //CISCO XB3
				return "P7";
				
			case "277354053": //CISCO XB3
				return "P8";
				
			case "265235711": //CISCO XB3
				return "P9";
				
			case "8542C5776D01126": //ARRIS XB6
				return "P10";
				
			case "276350968": //Cisco 3941T
				return "P11";
				
			case "152930007123100032": //Cisco CGA4130COM
				return "P12";
				
			case "8BL2C5798D46250": //ARRIS XB6
				return "P13";
				
			case "286601469":
				return "P14"; // CBR - CGA4131COM
				
			case "8BL2C5798D47061": //Arris XB6
				return "P15";
				
			case "276297702": //CISCO XB3 DPC3941T
				return "P16";
			
			case "PAV800038601": //Arris X5001
				return "P17";
				
			case "152930068436100858": //CGM4140COM ARRIS XB6-T 
				return "P18";
				
			case "263674619": //CISCO XB3 DPC3939
				return "P19";
				
			case "8BL2C5798D43075":
				return "P20"; //Arris XB6 - TG3482G
				
			case "G46BUK577B24369": //Arris XB3 TG1682g
				return "Q1";
				
			case "FAILED":
				return "F1";
				
			case "null":
				return "N1";
				
			case "NULL":
				return "N2";
				
			default:
				return "T1";//Temp name - Until we add all other devices.. T1 indicates Test devices 1
			}

		} catch (Exception e) {
			Log4j.info("Failed to get CPE device prefix ID: " + e.getMessage());
			return "T1";
		}
	}
	
	/**
	 * This method returns the password based on device serial number
	 * @return
	 * @
	 */
	public static String getSystemPasswordBasedOnDeviceSerialNumber() {
		try {
			switch (getDesktopSerialNumber()) {
			
			case "C02L86XWF6T6":
				return "wifitest"; 
			
			case "C02P53SKG5RP":
				return "wifitest";
				
			case "C02V24UHHTDD":
				return "XwifiAutomation2018"; 
				
			case "C02RX1RPG8WL":
				return "XwifiAutomation2018"; 
			
			default:
				return "NoMatch";
			}

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get system password based on device serial number");
			return "";
		}
	}
	
}