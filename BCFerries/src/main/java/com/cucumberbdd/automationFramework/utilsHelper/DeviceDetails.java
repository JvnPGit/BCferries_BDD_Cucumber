package com.cucumberbdd.automationFramework.utilsHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.driverUtils.AndroidADBUtilsHelper;

public class DeviceDetails extends Base {
	private static Logger Log = Logger.getLogger(DeviceDetails.class.getName());

	/**
	 * This method returns the System user info on the client device (Windows/Macbook)
	 * @return
	 */
	public static String getSystemUser() {
		String sysUserName = System.getProperty("user.name");
		return sysUserName;
	}

	/**
	 * This method returns the OS name on the client device (Windows/Macbook)
	 * @return
	 */
	public static String getOSName() {
		String osName = System.getProperty("os.name");
		return osName;
	}

	/**
	 * This method returns the OS version on the client device (Windows/Macbook)
	 * @return
	 * @
	 */
	public static String getOSVersion()  {
		String osVersion = "";
		try {
			if (deviceType.equalsIgnoreCase("Desktop")) {
				osVersion = System.getProperty("os.version");
				return osVersion;
			} else if (deviceType.equalsIgnoreCase("Android")) {
				osVersion = AndroidADBUtilsHelper.getAndroidDeviceOSVersion();
			} else if (deviceType.equalsIgnoreCase("iOS")) { 
				osVersion = iOSPlatformVersion;
			}	
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the OS version!!");
		}
		
		return osVersion;
	}

	/**
	 * This method returns the Wi-Fi SSID name from the list of saved networks on the client device (Windows/Macbook)
	 * @return
	 * @
	 */
	public static String getWiFiSSIDInfo()  {
		StringBuffer buf = new StringBuffer();
		Document document;
		String osName = System.getProperty("os.name");
		String ssidName = null;
		
		try {
			if (osName.contains("Windows")) {
				File interfacesPath = new File("C:" + File.separator + "ProgramData" + File.separator + "Microsoft" + File.separator + "Wlansvc" + File.separator + "Profiles" + File.separator + "Interfaces" + File.separator);
				String[] names = interfacesPath.list();
				String file = null, xmlFile = null;
				
				for(String name : names) {
				   file = name;
				}
				
				File guidPath = new File(interfacesPath + File.separator + file);
				String[] xmlFilesList = guidPath.list();
				
				if(xmlFilesList.length > 0) {
					for(String xml : xmlFilesList) {
						xmlFile = xml;
					}
					
				    File fXmlFile = new File(guidPath + File.separator + xmlFile);
			        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			        document = documentBuilder.parse(fXmlFile);
			        NodeList nl = document.getElementsByTagName("name");
			        Node node = (Node) nl.item(0);
			        NodeList children = node.getChildNodes();
			        
			        for (int i = 0; i < children.getLength(); i++) {
			            Node textChild = children.item(i);
			            if (textChild.getNodeType() != Node.TEXT_NODE) {
			                System.err.println("Mixed content! Skipping child element " + textChild.getNodeName());
			                continue;
			            }
			            buf.append(textChild.getNodeValue());
			            ssidName = buf.toString();
			        }
				} else {
					logHelper.info("There is no WLAN Profile exists!!");
				}
			} else if (osName.contains("Mac")) {
				ssidName = getCurrentSSIDNameMacOS();
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the Wi-Fi SSID name!!");
		}
		return ssidName;
	}
	
	/**
	 * This method returns the SSID name ONLY for Macbook from command line
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String getCurrentSSIDNameMacOS() throws IOException, InterruptedException {
        String line = null;
        String cmd = "/System/Library/PrivateFrameworks/Apple80211.framework/Versions/Current/Resources/airport -I | awk '/ SSID/ {print substr($0, index($0, $2))}'";
        BufferedReader input=null;
        String[] ssid = null ;
 
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (line.trim().startsWith("SSID")) {
					ssid = line.split(":");
					return ssid[1].trim();
				}
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the current SSID name on MacBook!!");
		} finally {
			if (input != null) {
				try {
					Log4j.info("Closing the BufferedReader in getCurrentSSIDNameMacOS()");
					input.close();
				} catch (Exception e) {
					Log4j.info("Failed to close the BufferedReader in getCurrentSSIDNameMacOS()");
				}
			}
		}
		return ssid[1];
    }
	
	/**
	 * This method returns the MAC address of a Windows laptop from command line
	 * @return
	 */
	public static String getDeviceMACAddress() {
		byte[] mac = null;
		InetAddress ip;
		StringBuilder sb = null;

		try {
			ip = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			mac = network.getHardwareAddress();
			sb = new StringBuilder();
			if (mac != null) {
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
				}
				return sb.toString();
			}
			else {
				Log.info("WiFi is not connected!");
				Log.info("Execution Terminated!!");
			}

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the device MAC address!!");
		} 
		return null;
	}
	
	/**
	 * This method returns the Wi-Fi MAC address of a Macbook on command line
	 * @return
	 * @throws Exception
	 */
	public static String getMacbookWiFiMacAddress() throws Exception {
		String var = ""; 
		String[] arr;
		int i = 0;
		
		try { 
				if (isMAC()) {
					String line = "";
					
					Runtime run = Runtime.getRuntime();
					Process pr = run.exec("networksetup -listallhardwareports | grep -A2 \"Hardware Port.*Wi-Fi\"");
					pr.waitFor();
					BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
					
					while ((line=buf.readLine())!=null) {
						if (line != "" || line != " " || line != null) {
							if (line.contains("en0") || i == 1) {
								i++;
								var = line; 
							}
							
							if (var.contains("Ethernet Address:")) {
								arr = var.split(" ");
								return arr[2];
							}
						}
					}
				} 
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the Wi-Fi MAC address on MacBook!!");
		}
		
		return "";
	}
	
	/**
	 * This method returns the Wi-Fi interface name of a Macbook on command line
	 * @return
	 * @throws Exception
	 */
	public static String getMacbookWiFiInterfaceName() throws Exception {
		String interfaceName = ""; 
		ArrayList<String> output = new ArrayList<String>();
		
		try { 
				if (isMAC()) {
					String line = "";
					
					Runtime run = Runtime.getRuntime();
					Process pr = run.exec("networksetup -listallhardwareports | grep -A2 \"Hardware Port: Wi-Fi\"");
					pr.waitFor();
					BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
					
					while ((line = buf.readLine()) != null) {
						if (line != "" || line != " " || line != null) {
							output.add(line);
						}
					}
					
					for (int i = 0; i < output.size(); i++) {
						if (output.get(i).contains("Hardware Port: Wi-Fi")) {
							interfaceName = output.get(i+1).substring(8, 11).trim();
							break;
						}
					}

					Log4j.info("Wi-Fi interface name for the MacBook is: " + interfaceName);
				}
				
				return interfaceName;
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the Wi-Fi interface name on MacBook!!");
			return interfaceName;
		}
	}
}
