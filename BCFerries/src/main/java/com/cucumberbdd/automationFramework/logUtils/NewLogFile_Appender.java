package com.cucumberbdd.automationFramework.logUtils;

import org.apache.log4j.FileAppender;

public class NewLogFile_Appender  extends FileAppender {

	/**
	 * This method is a constructor
	 */
	public NewLogFile_Appender() {
    }
    
	/**
	 * This method is used to set the log file
	 */
	@Override
    public void setFile(String file) {
        super.setFile(prependDate(file));
    }

	/**
	 * This method is used to prefix the Date in the log file
	 * @param filename
	 * @return
	 */
    private static String prependDate(String filename) {
        return System.currentTimeMillis() + "_" + filename;
    }
}