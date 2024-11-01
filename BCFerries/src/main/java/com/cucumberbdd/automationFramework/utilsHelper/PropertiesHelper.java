package com.cucumberbdd.automationFramework.utilsHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;

import com.cucumberbdd.automationFramework.base.Base;

/**
 * This class handles all Properties file related operations
 */

public class PropertiesHelper extends Base {
	
	/**
	 * This method is used to return a property value based on the key
	 * @param key
	 * @return
	 */
	public static String readProperties(String key) {
		Properties prop = new Properties();
		
		try {
			
			File dir = new File(frameworkTestResourcesPath);
			File[] files = dir.listFiles();

			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().contains(".properties")) {
						File file = new File(files[i].getPath());
						FileInputStream fis = new FileInputStream(file);

						prop.load(fis);
					}
				}
			}
			
			File file = new File(frameworkConfigPropertiesPath);
			FileInputStream fis = new FileInputStream(file);

			prop.load(fis);

		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return prop.getProperty(key);
	}

	/**
	 * This method is used to write a value to a properties file based on the key
	 * @param key
	 * @param value
	 */
	public static void writeProperties(String key, String value) {
		try {
			FileInputStream in = new FileInputStream(frameworkConfigPropertiesPath);
			Properties prop = new Properties();
			prop.load(in);
			in.close();

			FileOutputStream output = null;
			output = new FileOutputStream(frameworkConfigPropertiesPath);

			// set the properties value
			prop.setProperty(key, value);

			// save properties to project root folder
			prop.store(output, null);
			output.close();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to instantiate a properties file and return a property value based on the key
	 * @param pageClassName
	 * @param key
	 * @return
	 */
	public static String instantiateProperties(String pageClassName, String key) {
        Properties prop = new Properties();
        try {
        	File file = new File(FileUtilityHelper.getClassLocatorPath(pageClassName));
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (Exception e) {
            Log4j.info(e.getMessage());
        }
        return prop.getProperty(key);
    }
	
	/**
	 * This method returns a value from the config.properties file based on the key
	 * @param key
	 * @return
	 */
	public static String getConfigPropertiesKeyValue(String key) {
		String propertyValue = "";

		try {
			Properties prop = new Properties();

			for (int i = 0; i < propertiesFilesList.size(); i++) {
				if (propertiesFilesList.get(i).getName().trim().toLowerCase().contains(".properties")) {
					File newFile = new File(propertiesFilesList.get(i).getPath());
					FileInputStream fis = new FileInputStream(newFile);
					prop.load(fis);

					if (FileUtilityHelper.readFile(newFile.getPath()).contains(key)) {
						if (isPropertiesKeywordFoundInAnyLineOfAFile(FileUtilityHelper.readFile(newFile.getPath()),
								key)) {
							propertyValue = prop.getProperty(key).trim();
							break;
						}
					}
				}
			}

			return propertyValue;

		} catch (Exception e) {
			Log4j.info("Failed to get the property value for the key '" + key + "'");
			Log4j.info(e.getMessage());
			return propertyValue;
		}
	}
	
	/**
	 * This method returns a value from the config.properties file based on the key
	 * @param fileName
	 * @param key
	 * @return
	 */
	public static String getPropertiesValue(String fileName, String key) {
		File file = new File(fileName);
		Properties prop = new Properties();
		
		try {
			if (file.getName().toLowerCase().contains("config.properties")) {
				File newFile = new File(file.getPath());
				FileInputStream fis = new FileInputStream(newFile);
				prop.load(fis);
				
				if (FileUtilityHelper.readFile(newFile.getPath()).contains(key)) {
					if (isPropertiesKeywordFoundInAnyLineOfAFile(FileUtilityHelper.readFile(newFile.getPath()), key)) {
						return prop.getProperty(key).trim();
					}
				}
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return "";
	}
	
	/**
	 * This method returns true if a file content has a property variable. This method checks line by line and looks for exact match
	 * @param fileName
	 * @param keyToFind
	 * @return boolean
	 */
	public static boolean isPropertiesKeywordFoundInAnyLineOfAFile(String fileContent, String keyToFind) {
		String[] contentLineByLine = fileContent.split("\n");
		boolean keyFound = false;
		
		for (int i = 0; i < contentLineByLine.length; i++) {
			keyFound = contentLineByLine[i].contains(keyToFind);
			if (keyFound) {
				if (contentLineByLine[i].split("=")[0].trim().equalsIgnoreCase(keyToFind)) {
					return keyFound;
				}
			}
		}
		return keyFound;
	}
	
	/**
	 * This method is used to get a list of all .properties files
	 * @param directoryName
	 * @return
	 */
	public static List<File> getAllFilesInFramework(String directoryName) {
		List<File> allFilesInFrameworkList = new ArrayList<File>();
		
		try {
			File directory = new File(directoryName);
			// get all the files from a directory
			File[] fList = directory.listFiles();
			allFilesInFrameworkList.addAll(Arrays.asList(fList));
			
			for (File file : fList) {
				if (file.isFile()) {
					if (file.getName().toLowerCase().contains(".properties")) {
						allFilesInFrameworkList.add(file);
					}
				} else if (file.isDirectory()) {
					allFilesInFrameworkList.addAll(getAllFilesInFramework(file.getAbsolutePath()));
				}
			}
			
			return allFilesInFrameworkList;

		} catch (Exception e) {
			Log4j.info("Failed to get the list of all files from the directory: " + directoryName);
			Log4j.info(e.getMessage());
			return allFilesInFrameworkList;
		}
	}
	
	/**
	 * This method is used to get a list of all .properties files
	 * @param directoryName
	 * @return
	 */
	public static List<File> getPropertiesFilesList() {
		List<File> propertiesFilesList = new ArrayList<File>();
		
		try {
			List<File> allFilesInFrameworkList = getAllFilesInFramework(frameworkTestResourcesPath);
			System.out.println("Framework test resources path " + frameworkTestResourcesPath);
			LinkedHashSet<File> hashSet = new LinkedHashSet<>(allFilesInFrameworkList);
			ArrayList<File> uniqueFilesList = new ArrayList<File>(hashSet);
			
			for (int fileIndex = 0; fileIndex < uniqueFilesList.size(); fileIndex++) {
				if (uniqueFilesList.get(fileIndex).getAbsolutePath().contains(".properties")) {
					propertiesFilesList.add(uniqueFilesList.get(fileIndex));
				}
			}
			
			return propertiesFilesList;

		} catch (Exception e) {
			Log4j.info("Failed to get the list of config files from the directory: " + frameworkTestResourcesPath);
			Log4j.info(e.getMessage());
			return propertiesFilesList;
		}
	}
	
}
