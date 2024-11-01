package com.cucumberbdd.automationFramework.utilsHelper;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.cucumberbdd.automationFramework.base.Base;


public class CommandLineUtilsHelper extends Base {

	/**
	 * This method is used to get the process ID by name
	 * @param processName
	 * @return
	 * @
	 */
	public static String getProcessIDByName(String processName) {
		String processID = "";
		
		try { 
			if (isWindows()) {
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "tasklist | findstr " + processName);
		        Process p = builder.start(); 
		        StringBuilder sb = new StringBuilder();
		        p.waitFor(); 
		        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line, st = null; 
		        
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 
		       
		        if (st != null) {
		        	st = st.replace(" ", ":");
			        
			        int firstColonPos = 0, firstDigitPos = 0, endProcessIDPos = 0;
					
					for (int index = 0; index < st.length(); index++) {
						char aChar = st.charAt(index);
						
						if ((String.valueOf(aChar).equalsIgnoreCase(":"))) {
							firstColonPos = index;
							break;
						}
					}
					
					for (int i = firstColonPos; i < st.length(); i++) {
						char aChar = st.charAt(i);
						
						if (!(String.valueOf(aChar).equalsIgnoreCase(":"))) {
							firstDigitPos = i;
							break;
						}
					}
					
					for (int i = firstDigitPos; i < st.length(); i++) {
						char aChar = st.charAt(i);
						
						if (String.valueOf(aChar).equalsIgnoreCase(":")) {
							endProcessIDPos = i;
							break;
						}
					}
					
					Log4j.info("Process name: " + st.split(":")[0]);
					processID = st.substring(firstDigitPos, endProcessIDPos);
					Log4j.info("Process ID: " + processID);
		        }
				
			} else if (isMAC()) {
				ArrayList<String> processList = new ArrayList<String>();
				String process;
				Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ps -ax | grep \"" + processName + "\"" });
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				while ((process = input.readLine()) != null) {
					processList.add(process);
				}
				input.close();

				for (int i = 0; i < processList.size(); i++) {
					if ((processList.get(i).contains(processName)) && (!(processList.get(i).contains("grep")))) {
						Log4j.info("Process info: " + processList.get(i));
						String firstValue = processList.get(i).split(" ")[0].trim();
						String secondValue = processList.get(i).split(" ")[1].trim();
						
						if ((!firstValue.contains(" ") || !firstValue.contains("?") || !firstValue.isEmpty()) && firstValue.length() > 1) {
							processID = firstValue.trim();
							break;
							
						} else if ((!secondValue.contains(" ") || !secondValue.contains("?") || !secondValue.isEmpty()) && secondValue.length() > 1) {
							processID = secondValue.trim();
							break;
						}
					}
				}
			}
			
			return processID;
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the process ID by process name");
			return "";
		}
	}
	
	/**
	 * This method is used to kill a process by Process ID
	 * @param processName
	 * @return
	 * @
	 */
	public static boolean killProcessByProcessID(String processName) {
		boolean isProcessKilled = false;
		
		try {
			String processID = getProcessIDByName(processName);
			Log4j.info("Process ID to kill : " + processID);
			String line, st = null; 
			
			if (isWindows()) {
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "taskkill /PID " + Integer.valueOf(processID) + " /F");
		        Process p = builder.start(); 
		        StringBuilder sb = new StringBuilder();
		        p.waitFor(); 
		        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 
		        isProcessKilled = st.contains("SUCCESS: The process with PID");
				
			} else if (isMAC()) {
				String [] cmd = {"bash", "-c", "kill -9 " + processID};
				Process p = Runtime.getRuntime().exec(cmd);
				p.waitFor();
		        StringBuilder sb = new StringBuilder();
		        
		        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		       
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        }
		        
		        if (st != null) {
		        	isProcessKilled = st.trim().contains("Killed: 9");
		        
		        } else {
		        	processID = getProcessIDByName(processName);
		        	isProcessKilled = !(processID.length() > 0);
		        }
			}
			
			if (isProcessKilled) {
	        	logHelper.info("Process '" + processName + "' is killed succesfully with process id: " + processID);
	        	
	        } else {
	        	logHelper.info("Failed to kill the process '" + processName + "' with process id: " + processID);
	        }
			
			return isProcessKilled;
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to kill the process '" + processName + "'");
			return isProcessKilled;
		}
	}
	
	/**
	 * This method is used to kill a process by Process Name
	 * @param processName
	 * @return
	 * @
	 */
	public static boolean killProcessByProcessName(String processName) {
		boolean output = false;
		
		try {
			if (isWindows()) {
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "taskkill /f /IM " + processName + "");
		        Process p = builder.start(); 
		        StringBuilder sb = new StringBuilder();
		        p.waitFor(); 
		        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		        String line, st = null; 
		        
		        while((line = reader.readLine()) != null) { 
		        	sb = sb.append(line).append("\n");
		        	st = sb.toString();
		        } 
		        output = st.contains("SUCCESS: The process");
				
			} else if (isMAC()) {
				
			}
			
			return output;
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to kill the process by process ID");
			return output;
		}
	}
	
	/**
	 * This method is used to execute a command through command line and get the output as a String
	 * @param cmd
	 * @return
	 * @
	 */
	public static String executeCmdAndGetResult(String cmd) {
		String output = "";
		Process pr = null;
		BufferedReader br = null;
		
		try { 
			if (isMAC()) {
				pr = Runtime.getRuntime().exec(cmd);
			} else if (isWindows() && !cmd.contains("curl")) {
				pr = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});
			} else if (isWindows() && cmd.contains("curl")) {
				Log4j.info("Just in case, if Jenkins API is not working, then first check if curl is installed and curl path is setup in the node where the script is running");
				pr = Runtime.getRuntime().exec(cmd);
			}
			
			br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			
			while ((line = br.readLine()) != null) {
				sb = sb.append(line).append("\n");
	        	output = sb.toString().trim();
			} 
			
			Log4j.info("Output after executing the command is: \n" + cmd);
			
			if (output.contains("is not recognized as an internal or external command") || output.equalsIgnoreCase("") || output.equalsIgnoreCase(null)) {
				Log4j.info("Please install Net-SNMP software if using a Windows machine or use a Macbook to execute OG1600 commands!!");
	        }
		} catch (Exception e) {
			Log4j.info("Failed to execute the command and get result from command prompt");
			Log4j.info(e.getMessage());
		
		} finally {
			Log4j.info("Closing the buffered reader");
			try {
				br.close();
			} catch (Exception e) {
				Log4j.info("Failed to close the Buffered Reader - " + e.getMessage());
			}
		}
		
		return output;
	}
	
	/**
	 * This method is used to check if ping command to a device successful through command line
	 * @param accessPointIPAddress
	 * @return
	 * @
	 */
	public static boolean isPingToDeviceSuccessful(String accessPointIPAddress)  {
		boolean isPingToDeviceSuccessful = false;
		String output = "";
		String pingPrefixStr = "ping ";
		try {
			if(isMAC() && environmentName.equalsIgnoreCase("prod") && accessPointIPAddress.contains("udp6")) {
				pingPrefixStr = "ping6 ";
			} 
			
			if (environmentName.equalsIgnoreCase("prod") && accessPointIPAddress.contains("udp6")) {
				accessPointIPAddress = StringUtilsHelper.replaceCharacterInAString(StringUtilsHelper.replaceCharacterInAString(accessPointIPAddress.split("udp6:")[1], "]", ""), "[", "");
			}
			
			output = pingAndGetPingResponse(pingPrefixStr + accessPointIPAddress);
			if (output.contains("timeout")) {
				Log4j.info("Ping response text from command prompt says 'Timeout', Acutal message from ping response is - " + output);
			}
			isPingToDeviceSuccessful = (output.contains("from") && (output.contains("time") || output.contains("byte")));
			Log4j.info("Ping response text from command prompt: " + output);
			Log4j.info("Is ping successful: " + isPingToDeviceSuccessful);
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		
		return isPingToDeviceSuccessful;
	}
	
	/**
	 * This method will try to ping any IP and return true only if ping is unsuccessful.
	 * @param ip
	 * @return
	 */
	public static boolean isPingToBenuClientUnsuccessful(String ip) {
		boolean isPingUnsuccesful = false;
		try {
			String output = pingAndGetPingResponse("ping " + ip);
			if (output.contains("timeout")) {
				Log4j.info("Ping response text from command prompt says 'Timeout', Acutal message from ping response is - " + output);
			}
			isPingUnsuccesful = ! (output.contains("from") && (output.contains("time") || output.contains("byte")));
			Log4j.info("Ping response text from command prompt: " + output);
			Log4j.info("Is ping unsuccessful: " + isPingUnsuccesful);
		} catch (Exception e) {
			Log4j.info("Inside isPingToBenuClientUnsuccessful exception " + e.getMessage());
		}
		return isPingUnsuccesful;
	}
	
	/**
	 * This method is used to ping to an IP to check whether the IP is reachable or not
	 * @param cmd
	 * @return
	 * @
	 */
	public static String pingAndGetPingResponse(String cmd)  {
		int waitTime = 0;
		StringBuilder sb = new StringBuilder();
		String line = "", output = "";
		Process pr = null;
		
		try { 
			Log4j.info("Pinging the device with command - " + cmd);
			if (isMAC()) {
				pr = Runtime.getRuntime().exec(cmd);
			} else if (isWindows()) {
				pr = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});
			}
			
			//pr.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			
			for (waitTime = 0; waitTime < 10; waitTime++) {
				if ((line=buf.readLine()) == null) {
					Thread.sleep(waitTime + 500);
				} else {
					break;
				}
			}
			
			while ((line=buf.readLine())!=null) {
				if ((line.contains("from") && (line.contains("time") || line.contains("byte"))) || line.contains("Request timeout")) {
					sb = sb.append(line).append("\n");
			        	output = sb.toString().trim();
			        	break;
				}
			} 
			if (output.contains("is not recognized as an internal or external command") || output.equalsIgnoreCase("") || output.equalsIgnoreCase(null)) {
				Log4j.info("Please install Net-SNMP software if using a Windows machine or use a Macbook!!");
	        }
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		return output;
	}
	
	/**
	 * this method will run the commands in a batch/command scripts
	 * @param command
	 * @param jobName
	 */
	public static File getExecutableFileAfterRunningAnyCommandAsExecutableOnMacWithNoWait(String command, String jobName) {
		File file = null;
		try {
			if (isMAC()) {
				file = new File(System.getProperty("user.dir") + "/trigger.command");
				Log4j.info("Trigger command/batch File obsolute path - " + file.getPath());
				FileUtilityHelper.writeDataToTextFile(file.getPath(), command);
				
				Log4j.info("Triggering the Command/Batch Execution");
				Runtime.getRuntime().exec("chmod 777 " + file.getPath());
				Runtime.getRuntime().exec("chmod 775 " + file.getPath());
				Runtime.getRuntime().exec("chmod a+x " + file.getPath());
				waitFor(1);
				
				//Below comments may be required for future debugging
//				Log4j.info("Printing with actual command ---- ");
//				FileUtilityHelper.printFileContent(file.getPath());
				Desktop.getDesktop().open(file);
				Log4j.info("Waiting for 30 seconds for the job to start running on jenkins");
				waitFor(30);
				Log4j.info("Job name to verify that we are checking for the right job, if its running or not -- " + jobName);
				//JenkinsJobConfigUtils.waitUntilJenkinsJobComplete(jobName);
			} else {
				Log4j.info("OS is not MAC OS, please check your run configurations and trigger this method on a mac machine");
			}
		} catch (Exception e) {
			Log4j.info("Failed to invoke Jenkins job with build with dynamic parameters" + e.getMessage());
		}
		return file;
	}
	
	/**
	 * This method closes the command file thats already executed using command.
	 * @param file
	 */
	public static void closeTheExecutableFileBeingExecutedAsCommand(File file) {
		try {
			FileUtilityHelper.writeDataToTextFile(file.getAbsolutePath(), "\nosascript -e 'tell application \"Terminal\" to close (every window whose name contains \"trigger.command\")' & Close");
			Runtime.getRuntime().exec("chmod 777 " + file.getPath());
			Runtime.getRuntime().exec("chmod 775 " + file.getPath());
			Runtime.getRuntime().exec("chmod a+x " + file.getPath());
			
			//Below comments may be required for future debugging
//			Log4j.info("Printing with actual command ---- ");
//			FileUtilityHelper.printFileContent(file.getPath());
			waitFor(1);
			Desktop.getDesktop().open(file);
			waitFor(1);
			
			file.deleteOnExit();
			Log4j.info("Dynamic job Execution Complete --- ");
		} catch (Exception e) {
			Log4j.info("Failed to invoke Jenkins job with build with dynamic parameters" + e.getMessage());
		}
	}
	
	/**
	 * This method is used to get the list of all open Terminal Title Names for MacOS
	 * @return
	 */
	public static ArrayList<String> getAllOpenTerminalWindowTitleNamesList() {
		ArrayList<String> terminalWindowTitlesList = new ArrayList<String>();
		
		try {
			if (isMAC()) {
				String cmd = "osascript -e 'tell application \"Terminal\" to get the name of every window'";
				File getTerminalTitleName = File.createTempFile("GetTerminalTitle", ".command");
				Log4j.info("Changing the permissions to read/write/execute for the file '" + getTerminalTitleName.getAbsolutePath() + "'");
				Runtime.getRuntime().exec("chmod 777 " + getTerminalTitleName.getPath());
				Runtime.getRuntime().exec("chmod 775 " + getTerminalTitleName.getPath());
				Runtime.getRuntime().exec("chmod a+x " + getTerminalTitleName.getPath());
				waitFor(2);
				
				FileUtilityHelper.writeDataToTextFile(getTerminalTitleName.getAbsolutePath(), cmd);
				Process pr = Runtime.getRuntime().exec(getTerminalTitleName.getAbsolutePath());
				waitFor(2);
				
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				String line = "", output = "";
				StringBuilder sb = new StringBuilder();
				
				while ((line=buf.readLine()) != null) {
					sb = sb.append(line).append("\n");
					output = sb.toString().trim();
				}
			
				String[] titlesList = output.split(",");
				
				for (int i = 0; i < titlesList.length; i++) {
					terminalWindowTitlesList.add(titlesList[i].trim());
				}
				
				Log4j.info("List of all open Terminal Windows are");
				for (String st : terminalWindowTitlesList) {
					Log4j.info(st.trim());
				}
				
				Log4j.info("Delete the temporary file GetTerminalTitle.command");
				getTerminalTitleName.deleteOnExit();
			}
			
			return terminalWindowTitlesList;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the list of all open Terminal window titles in MacOS");
			Log4j.info(e.getMessage());
			return terminalWindowTitlesList;
		}
	}
	
	/**
	 * This method is used to get the contents of the Terminal Window
	 */
	public static String getContentsOfTerminalWindow(String terminalWindowToSearch) {
		String output = "";
		
		try {
			File terminalFileContents = File.createTempFile("TerminalFileContents", ".scpt");
			File tempTextFile = File.createTempFile("TempTerminalTextFile", ".txt");
			Runtime.getRuntime().exec("chmod 777 " + tempTextFile.getPath());
			Runtime.getRuntime().exec("chmod 775 " + tempTextFile.getPath());
			
			String textFilePath = frameworkTestResourcesPath + "automationFrameworkTestData" + File.separator + "GetTerminalWindowContent.text";
			String appleScript = FileUtilityHelper.readFile(textFilePath);
			FileUtilityHelper.writeDataToTextFile(tempTextFile.getAbsolutePath(), appleScript);
			
			FileUtilityHelper.searchAndReplaceFileContent(tempTextFile.getAbsolutePath(), "fileToReplace", tempTextFile.getAbsolutePath());
			FileUtilityHelper.searchAndReplaceFileContent(tempTextFile.getAbsolutePath(), "terminalWindowToSearch", terminalWindowToSearch);
			
			String command = FileUtilityHelper.readFile(tempTextFile.getAbsolutePath());
			
			Log4j.info("Changing the permissions to read/write/execute for the file '" + terminalFileContents.getAbsolutePath() + "'");
			Runtime.getRuntime().exec("chmod 777 " + terminalFileContents.getPath());
			Runtime.getRuntime().exec("chmod 775 " + terminalFileContents.getPath());
			Runtime.getRuntime().exec("chmod a+x " + terminalFileContents.getPath());
			waitFor(2);
			
			FileUtilityHelper.writeDataToTextFile(terminalFileContents.getAbsolutePath(), command);
			FileUtilityHelper.clearFileContents(tempTextFile);
			Runtime.getRuntime().exec("osascript " + terminalFileContents.getAbsolutePath());
			waitFor(2);
			
			output = FileUtilityHelper.readFile(tempTextFile.getAbsolutePath());
			Log4j.info("Terminal output is: \n" + output);
			
			tempTextFile.deleteOnExit();
			terminalFileContents.deleteOnExit();
			
			return output;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the contents of the terminal window");
			Log4j.info(e.getMessage());
			return output;
		}
	}
	
	/**
	 * This method is used to get the process ID from the list of all active applications using powershell
	 * @param expectedText
	 * @return
	 */
	public static HashMap<String, String> getActiveApplicationsProcessIDAndProcessNameFromPowershell() {
		HashMap<String, String> processMap = new HashMap<String, String>();
		
		try {
			if (isWindows()) {
				ArrayList<String> output = new ArrayList<String>();
				String command = "powershell.exe  gps | ? {$_.mainwindowtitle} | select id, mainwindowtitle | ft -AutoSize";
				// Executing the command
				Process powerShellProcess = Runtime.getRuntime().exec(command);
				// Getting the results
				powerShellProcess.getOutputStream().close();
				String line;
				BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

				while ((line = stdout.readLine()) != null) {
					output.add(line);
				}
				stdout.close();

				String processIDFilePath = "C:\\ProcessIDList.txt";
				FileUtilityHelper.writeDataToTextFile(processIDFilePath, output.toString());

				if (output.size() > 0) {
					String str = FileUtilityHelper.readFile(processIDFilePath);
					String[] splitStr = str.split(",");

					for (int i = 0; i < splitStr.length; i++) {
						String st = splitStr[i].trim().replace(" ", "#");
						st = st.trim();
						if (!st.contains("--#---------------") && (!st.contains("Id#MainWindowTitle")) && (st.length() > 0) && !(st.contains("[")) && !(st.contains("]"))) {
							
							int index = StringUtilsHelper.getFirstOccurenceOfACharacter(st, "#");
							String key = st.substring(0, index).trim();
							String value = st.substring(index, st.length());
							value = value.replace("#", " ").trim();
							processMap.put(key, value);
						}
					}
				}
			}
			return processMap;

		} catch (Exception e) {
			Log4j.info("Failed to execute command in powershell to get PID");
			Log4j.info(e.getMessage());
			return processMap;
		}
		
	}
	
	/**
	 * This method is used to bring the application to focus using process ID
	 * @param processID
	 */
	public static void bringApllicationToFocusUsingPID(String processID) {
		try {
			if (isWindows()) {
				Runtime.getRuntime().exec("wscript C:\\Focus.vbs " + processID);
				waitFor(5);
			}
			
		} catch (Exception e) {
			Log4j.info("Failed to bring the application to focus using process ID");
			Log4j.info(e.getMessage());
		}
	}
}
