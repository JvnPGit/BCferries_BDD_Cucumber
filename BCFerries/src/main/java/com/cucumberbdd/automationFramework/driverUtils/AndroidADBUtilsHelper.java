package com.cucumberbdd.automationFramework.driverUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.cucumberbdd.automationFramework.base.Base;

public class AndroidADBUtilsHelper extends Base {
	
	/**
	 * This  method is used to get the output after executing ADB commands
	 * @param cmd
	 * @return
	 */
	public static String getADBCommandOutput(String cmd) {
		String output = "";
		
		try {
			if (isWindows()) {
				Log4j.info("The ADB command executed is: 'adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd + "'");
				Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line; 
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	output = sb.toString();
		        } 
				
			} else if (isMAC()) {
				
				StringBuilder sb = new StringBuilder();
				String line = "", currentUser = "", str = "";
				
				Runtime run = Runtime.getRuntime();
				Process pr = run.exec("whoami");
				pr.waitFor();
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				
				while ((line=buf.readLine())!=null) {
					sb = sb.append(line).append("\n");
					currentUser = sb.toString();
				}
				
				currentUser = currentUser.trim();
				Log4j.info("Current logged in user (result after executing 'whoami' command on terminal): " + currentUser);
				str = File.separator + "Users" + File.separator + currentUser + File.separator + "Library" + File.separator + "Android" + File.separator + "sdk" /*+ File.separator*/;
				buf.close();
				
				Log4j.info("The ADB command executed is: 'adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd + "'");
				Process p = Runtime.getRuntime().exec(str + File.separator + "platform-tools" + File.separator + "adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd);
				
				StringBuilder sbr = new StringBuilder();
				String line2 = "";
				p.waitFor();
				
				BufferedReader buf2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				while ((line2 = buf2.readLine())!= null) {
					sbr = sbr.append(line2).append("\n");
		        	output = sbr.toString();
				}
				
				output = output.trim();
				Log4j.info("Output after executing ADB command is: " + output);
			}
			
			return output;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the output after executing the ADB command: '" + cmd + "'");
			return output;
		}
	}
	
	/**
	 * This method returns the Android device product brand of an Android device from command line
	 * @return
	 * @
	 */
	public static String getAndroidDeviceProductBrand() {
		String output = "";
		
		try { 
			output = getADBCommandOutput(" shell getprop ro.product.brand");
			return output.trim();
			
		} catch (Exception e) {
			Log4j.info("Failed to get Android device product brand " + e.getMessage());
			return output;
		}
	}
	
	/**
	 * This method returns the OS version on an Android device from command line
	 * @return
	 * @
	 */
	public static String getAndroidDeviceOSVersion() {
		String output = "";
		
		try { 
			output = getADBCommandOutput(" shell getprop ro.build.version.release");

		} catch (Exception e) {
			Log4j.info("Failed to get Android device OS version " + e.getMessage());
		}
		
		if (output.contains(".")) {
			output = output.split("\\.")[0];
		}
		
		return output.trim();
	}
	
	/**
	 * This method is used to uninstall the Appium settings on an Android device on command line)
	 * @param udid
	 * @return
	 */
	public static boolean uninstallAppiumSettings(String udid) {
		String st = null;
		boolean result = false;
		
		try { 
			if (isWindows()) {
				Process p = Runtime.getRuntime().exec(new String[]{adbUninstallSettingsBat, udid});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line; 
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 
		        if (st != null) {
		        	result = st.trim().toLowerCase().contains("success");
		        	if (result) {
		        		Log4j.info("ADB uninstall settings status: 'Success'");
		        	} else {
		        		Log4j.info("Failed to uninstall adb settings");
			        }
		        } else {
		        	Log4j.info("Failed to uninstall adb settings");
		        }
			} else if (isMAC()) {
				StringBuilder sb = new StringBuilder();
				String line = "";
				String str = null;
				
				Runtime run = Runtime.getRuntime();
				Process pr = run.exec("whoami");
				pr.waitFor();
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				
				while ((line=buf.readLine())!=null) {
					sb = sb.append(line).append("\n");
		        	str = sb.toString();
				}
				
				str = str.trim();
				str = File.separator + "Users" + File.separator + str + File.separator + "Library" + File.separator + "Android" + File.separator + "sdk" + File.separator;
				buf.close();
				
				Process p = Runtime.getRuntime().exec(str + File.separator + "platform-tools" + File.separator + "adb -s " + udid + " uninstall io.appium.settings");
				
				StringBuilder sbr = new StringBuilder();
				String line2 = "";
				p.waitFor();
				
				BufferedReader buf2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				while ((line2=buf2.readLine())!=null) {
					sbr = sbr.append(line2).append("\n");
		        	st = sbr.toString();
				}
				
				st = st.trim();
			}
			
				if (st != null) {
		        	result = st.trim().toLowerCase().contains("success");
		        	if (result) {
		        		Log4j.info("ADB uninstall settings status: 'Success'");
		        	} else {
		        		Log4j.info("Failed to uninstall adb settings");
			        }
		        } else {
		        	Log4j.info("Failed to uninstall adb settings");
		        }
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to uninstall appium settings");
		}
		return result;
	}
	
	/**
	 * This method is used to uinstall the Appium Unlock on an Android device on command line
	 * @param udid
	 * @return
	 */
	public static boolean uninstallAppiumUnlock(String udid) {
		String st = null;
		boolean result = false;
		
		try { 
			if (isWindows()) {
				Process p = Runtime.getRuntime().exec(new String[]{adbUninstallUnlockBat, udid});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line; 
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 

			}  else if (isMAC()) {
				StringBuilder sb = new StringBuilder();
				String line = "";
				String str = null;
				
				Runtime run = Runtime.getRuntime();
				Process pr = run.exec("whoami");
				pr.waitFor();
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				
				while ((line=buf.readLine())!=null) {
					sb = sb.append(line).append("\n");
		        	str = sb.toString();
				}
				
				str = str.trim();
				str = File.separator + "Users" + File.separator + str + File.separator + "Library" + File.separator + "Android" + File.separator + "sdk" + File.separator;
				buf.close();
				
				Process p = Runtime.getRuntime().exec(str + File.separator + "platform-tools" + File.separator + "adb -s " + udid + " uninstall io.appium.unlock");
				
				StringBuilder sbr = new StringBuilder();
				String line2 = "";
				p.waitFor();
				
				BufferedReader buf2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				while ((line2=buf2.readLine())!=null) {
					sbr = sbr.append(line2).append("\n");
		        	st = sbr.toString();
				}
				
				st = st.trim();
			}
				
				if (st != null) {
		        	result = st.trim().toLowerCase().contains("success");
		        	if (result) {
		        		Log4j.info("ADB uninstall unlock status: 'Success'");
		        	} else {
		        		Log4j.info("Failed to uninstall adb unlock!!");
			        }
		        } else {
		        	Log4j.info("Failed to uninstall adb unlock!!");
		        }
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to uninstall appium unlock");
		}
		return result;
	}
	
	/**
	 * This method is used to reset the Android device settings
	 * @param udid
	 * @return
	 */
	public static boolean resetAndroidDeviceSettings(String udid) {
		boolean result = false;
		try {
			if (uninstallAppiumSettings(udid)) {
				waitFor(3);
				if (uninstallAppiumUnlock(udid)) {
					result = true;
					Log4j.info("Successfully finished resetting Android device!!");
				}
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to reset Android device appium settings");
		}
		return result;
	}
	
	/**
	 * This method returns the Serial number of an Android deivce from command line
	 * @return
	 * @
	 */
	public static String getAndroidSerialNumber()  {
		String serialNumber = "";
		
		try { 
			serialNumber = getADBCommandOutput(" shell getprop | grep ro.boot.serialno");
			serialNumber = serialNumber.split(":")[1];
			serialNumber = serialNumber.trim();
			serialNumber = serialNumber.substring(1, serialNumber.length()-1);
			
			return serialNumber.trim();
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the Android serial number");
			return serialNumber.trim();
		}
	}
	
	/**
	 * This method returns the Wi-Fi MAC address of an Android device form command line
	 * @return
	 * @
	 */
	public static String getAndroidWiFiMACAddress()  {
		String wifiMACAddress = null;
		
		try { 
			if (isWindows()) {
				Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " shell ip addr show wlan0"});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line, st = null; 
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 
		        String[] str = st.split("\n");
		        String[] macAddress = null;
		        for(int i = 0; i < str.length; i++) {
		        	if(str[i].contains("ether")) {
		        		macAddress = str[i].split("ether");
		        		break;
		        	}
		    	}
		        
		        for (int j = 0; j < macAddress.length; j++) {
        			if ((macAddress[j].trim() != "" || macAddress[j].trim() != null) && (macAddress[j].length() > 0)) {
        				if(macAddress[j].trim().contains("ff:ff:ff:ff:ff:ff")) {
        					wifiMACAddress = macAddress[j].trim().substring(0, Math.min(macAddress[j].trim().length(), 17));
        				}
        			}
        		}
			} else if (isMAC()) {
				Process p = Runtime.getRuntime().exec(new String[]{"adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " shell ip addr show wlan0  | grep 'link/ether '| cut -d' ' -f6"});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line, st = null; 
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 
		        //String[] str = st.split("\n");
		        Log4j.info(st);
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the device UDID");
		}
		return wifiMACAddress;
	}
	
	/**
	 * This method is used to check if the currently connected Android device is a Samsung mobile/tablet 
	 * @return
	 */
	public static boolean isSamsung() {
		boolean isSamsung = false;
		
		try {
			String androidDeviceBrand = getAndroidDeviceProductBrand().trim();
			Log4j.info("Currently connected Android device brand is: " + androidDeviceBrand);
			isSamsung = androidDeviceBrand.equalsIgnoreCase("samsung");
			return isSamsung;
			
		} catch (Exception e) {
			Log4j.info("Failed to check if the currently connected Android device is a Samsung mobile/tablet - " + e.getMessage());
			return isSamsung;
		}
	}
	
	/**
	 * This method is used to check if the currently connected Android device is a Google mobile/tablet 
	 * @return
	 */
	public static boolean isGoogle() {
		boolean isGoogle = false;
		
		try {
			String androidDeviceBrand = getAndroidDeviceProductBrand().trim();
			Log4j.info("Currently connected Android device brand is: " + androidDeviceBrand);
			isGoogle = androidDeviceBrand.equalsIgnoreCase("google");
			return isGoogle;
			
		} catch (Exception e) {
			Log4j.info("Failed to check if the currently connected Android device is a Google mobile/tablet - " + e.getMessage());
			return isGoogle;
		}
	}
	
	/**
	 * This  method is used to get the output after executing ADB commands
	 * @param cmd
	 * @return
	 */
	public static ArrayList<String> getADBCommandOutputAsArray(String cmd) {
		ArrayList<String> output = new ArrayList<String>();
		
		try {
			if (isWindows()) {
				Log4j.info("The ADB command executed is: 'adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd + "'");
				Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line; 
		        
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	output.add(sb.toString());
		        } 
				
			} else if (isMAC()) {
				
				StringBuilder sb = new StringBuilder();
				String line = "", currentUser = "", str = "";
				
				Runtime run = Runtime.getRuntime();
				Process pr = run.exec("whoami");
				pr.waitFor();
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				
				while ((line=buf.readLine())!=null) {
					sb = sb.append(line).append("\n");
					currentUser = sb.toString();
				}
				
				currentUser = currentUser.trim();
				Log4j.info("Current logged in user (result after executing 'whoami' command on terminal): " + currentUser);
				str = File.separator + "Users" + File.separator + currentUser + File.separator + "Library" + File.separator + "Android" + File.separator + "sdk";
				buf.close();
				
				Log4j.info("The ADB command executed is: 'adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd + "'");
				Process p = Runtime.getRuntime().exec(str + File.separator + "platform-tools" + File.separator + "adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " " + cmd);
				
				StringBuilder sbr = new StringBuilder();
				String line2 = "";
				p.waitFor();
				
				BufferedReader buf2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				while ((line2 = buf2.readLine())!= null) {
					sbr = sbr.append(line2).append("\n");
					output.add(sb.toString().trim());
				}
				
				Log4j.info("Output after executing ADB command is: ");
				for (int i = 0; i < output.size(); i++) {
					Log4j.info(output.get(i).trim());
				}
			}
			
			return output;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the output after executing the ADB command: '" + cmd + "'");
			return output;
		}
	}
	
	/**
	 * This method is used to turn off auto-rotate Android screen
	 */
	public static void turnOffScreenRotation() {
		try {
			Log4j.info("Disabling auto-rotate Android screen");
			getADBCommandOutput(" shell settings put system accelerometer_rotation 0");
			
		} catch (Exception e) {
			Log4j.info("Failed to turn off the Android Screen Rotation on '" + deviceName + "' - " + e.getMessage());
		}
	}
	
	/**
	 * This method is used to set the Android screen in Portrait mode
	 * 
	 * 	user_rotation Values:
	 *	0  # Protrait 
	 *	1  # Landscape
	 *	2  # Protrait Reversed
	 *	3  # Landscape Reversed
	 * 
	 */
	public static void setAndroidScreenInPortraitMode() {
		try {
			turnOffScreenRotation();
			
			Log4j.info("Setting the Android screen in Portrait mode");
			getADBCommandOutput(" shell settings put system user_rotation 0");
			
		} catch (Exception e) {
			Log4j.info("Failed to set the Android screen in Portrait mode on '" + deviceName + "' - " + e.getMessage());
		}
	}
	
	/**
	 * This method is used to get the Android Wi-Fi IP Address
	 * @return
	 */
	public static String getAndroidDeviceWiFiIpAddress() {
		String ipAddress = "";
		
		try {
			String cmd = "";
			
			if (isMAC()) {
				StringBuilder sb = new StringBuilder();
				String line = "", currentUser = "", str = "";
				
				Runtime run = Runtime.getRuntime();
				Process pr = run.exec("whoami");
				pr.waitFor();
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				
				while ((line=buf.readLine())!=null) {
					sb = sb.append(line).append("\n");
					currentUser = sb.toString();
				}
				
				currentUser = currentUser.trim();
				Log4j.info("Current logged in user (result after executing 'whoami' command on terminal): " + currentUser);
				str = File.separator + "Users" + File.separator + currentUser + File.separator + "Library" + File.separator + "Android" + File.separator + "sdk" /*+ File.separator*/;
				buf.close();
				
				cmd = "adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " shell ip addr show wlan0 | grep inet | grep wlan0";
				Log4j.info("The ADB command executed is: '" + cmd + "'");
				
				Process p = Runtime.getRuntime().exec(str + File.separator + "platform-tools" + File.separator + cmd);
				StringBuilder sbr = new StringBuilder();
				String line2 = "";
				p.waitFor();
				
				BufferedReader buf2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				while ((line2 = buf2.readLine())!= null) {
					sbr = sbr.append(line2).append("\n");
					ipAddress = sbr.toString();
				}
				
				ipAddress = ipAddress.trim();
				
			} else if (isWindows()) {
				cmd = "adb -s " + PhysicalDeviceDetails.getUdid(deviceName) + " shell ip addr show wlan0 | findstr inet | findstr wlan0";
				Log4j.info("The ADB command executed is: '" + cmd + "'");
				
				Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});
				StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line; 
		        
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	ipAddress = sb.toString();
		        } 
		        
		        ipAddress = ipAddress.trim();
			}

			if (ipAddress.contains("inet")) {
				ipAddress = ipAddress.split("brd")[0].split("inet")[1].trim().split("/")[0].trim();
			}
			Log4j.info("The Android device Wi-Fi address is: " + ipAddress);
			return ipAddress;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the Android device Wi-Fi IP Address");
			Log4j.info(e.getMessage());
			return ipAddress;
		}
	}
}
