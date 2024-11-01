package com.cucumberbdd.automationFramework.utilsHelper;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.cucumberbdd.automationFramework.base.Base;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public class SetForegroundWindowUtil extends Base {
	public interface User32 extends StdCallLibrary {
		User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

		interface WNDENUMPROC extends StdCallCallback {
			boolean callback(Pointer hWnd, Pointer arg);
		}

		boolean EnumWindows(WNDENUMPROC lpEnumFunc, Pointer arg);

		int GetWindowTextA(Pointer hWnd, byte[] lpString, int nMaxCount);

		int SetForegroundWindow(Pointer hWnd);

		Pointer GetForegroundWindow();
	}

	public static boolean setForegroundWindowByName(final String windowName, final boolean starting) {
		final User32 user32 = User32.INSTANCE;
		return user32.EnumWindows(new User32.WNDENUMPROC() {

			@Override
			public boolean callback(Pointer hWnd, Pointer arg) {
				byte[] windowText = new byte[512];
				user32.GetWindowTextA(hWnd, windowText, 512);
				String wText = Native.toString(windowText);
				// if (wText.contains(WINDOW_TEXT_TO_FIND)) {
				if (starting) {
					if (wText.contains(windowName)) {
						user32.SetForegroundWindow(hWnd);
						return false;
					}
				} else {
					if (wText.contains(windowName)) {
						user32.SetForegroundWindow(hWnd);
						return false;
					}
				}
				return true;
			}
		}, null);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			
		} catch (Exception e) {
			Log4j.info("Something went wrong when opening the .bat file");
		}
	}

	/**
	 * This method is used to press the ALT key and TAB key on the keyboard @
	 */
	public static void keyboardKeysAlt_Tab() {
		try {
			Log4j.info("Press the keyboard ALT + TAB keys");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(2000);
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard ALT + TAB keys - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the Q key on the keyboard @
	 */
	public static void enterOptions() {
		try {
			Log4j.info("Press the keyboard ENTER key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_Q);
			robot.keyRelease(KeyEvent.VK_Q);
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard ENTER key - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the CTRL (in case of Windows and Command in case of Macbook) key and A key on the keyboard to select all the content on the window
	 */
	public static void keyboardKeysSelectAll() {
		try {
			Log4j.info("Press the keyboard CTRL + A keys");
			if (isWindows()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_A);
				robot.delay(2000);

			} else if (isMAC()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_META);
				robot.keyRelease(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.delay(2000);
			}
		} catch (Exception e) {
			Log4j.info("Failed to select all using keyboard CTRL + A keys - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the CTRL (in case of Windows and Command in case of Macbook) key and V key on the keyboard to paste the clipboard content on the window
	 */
	public static void keyboardKeysPaste() {
		try {
			Log4j.info("Press the keyboard CTRL + V keys");
			if (isWindows()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.delay(2000);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.delay(2000);

			} else if (isMAC()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_META);
				robot.keyRelease(KeyEvent.VK_V);
				robot.delay(2000);
			}
		} catch (Exception e) {
			Log4j.info("Failed to copy using keyboard CTRL + V keys - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the DELETE key on the keyboard
	 */
	public static void keyboardKeysDelete() {
		try {
			Log4j.info("Press the keyboard DELETE key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.keyRelease(KeyEvent.VK_DELETE);
			robot.delay(2000);
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard DELETE key - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the BACKSPACE key on the keyboard
	 */
	public static void keyboardKeysBackspace() {
		try {
			Log4j.info("Press the keyboard BACKSPACE key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			robot.delay(2000);
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard BACKSPACE key - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the CTRL (in case of Windows and Command in case of Macbook) key and C key on the keyboard to copy content to the clipboard on the window
	 */
	public static void keyboardKeysCopy() {
		try {
			Log4j.info("Press the keyboard CTRL + C keys");
			if (isWindows()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_C);
				robot.delay(2000);

			} else if (isMAC()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_META);
				robot.keyRelease(KeyEvent.VK_C);
				robot.delay(2000);
			}
		} catch (Exception e) {
			Log4j.info("Failed to copy using keyboard CTRL + C keys - " + e.getMessage());
		}
	}
		
	/**
	 * This method is used to press the CTRL (in case of Windows and Command in case of Macbook) key and T key on the keyboard to open a new window @
	 */
	public static void keyboardKeysNewTab() {
		try {
			Log4j.info("Press the keyboard CTRL + T keys");
			if (isWindows()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_T);
				robot.delay(2000);

			} else if (isMAC()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_META);
				robot.keyRelease(KeyEvent.VK_T);
				robot.delay(2000);
			}
		} catch (Exception e) {
			Log4j.info("Failed to open a new tab using keybard CTRL + T keys - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the CTRL (in case of Windows and Command in case of Macbook) key and W key on the keyboard to close current active window @
	 */
	public static void keyboardKeysCloseTab() {
		try {
			Log4j.info("Press the keyboard CTRL + W keys");
			if (isWindows()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_W);
				robot.delay(2000);

			} else if (isMAC()) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_META);
				robot.keyRelease(KeyEvent.VK_W);
				robot.delay(2000);
			}
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard CTRL key - " + e.getMessage());
		}
	}

	/**
	 * This method is used to press the CTRL (in case of Windows and Command in case of Macbook) key and TAB key on the keyboard @
	 */
	public static void keyboardKeysTab() {
		try {
			Log4j.info("Press the keyboard TAB key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(2000);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(2000);
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard TAB key - " + e.getMessage());
		}
	}
	
	/**
	 * This method is used to press the keyboard ESC key
	 */
	public static void keyboardKeysEscape() {
		try {
			Log4j.info("Press the keyboard ESC key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			robot.delay(2000);
			
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard ESC key");
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to press the keyboard ENTER key
	 */
	public static void keyboardKeysEnter() {
		try {
			Log4j.info("Press the keyboard ENTER key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(2000);
			
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard ENTER key");
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to press the keyboard F6 key
	 */
	public static void keyboardKeysF6() {
		try {
			Log4j.info("Press the keyboard ENTER key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F6);
			robot.delay(2000);
			robot.keyRelease(KeyEvent.VK_F6);
			robot.delay(2000);
			
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard F6 key");
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to press the keyboard RIGHT ARROW key
	 */
	public static void keyboardKeysRightArrow() {
		try {
			Log4j.info("Press the keyboard RIGHT ARROW key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.delay(2000);
			robot.keyRelease(KeyEvent.VK_RIGHT);
			robot.delay(2000);
			
		} catch (Exception e) {
			Log4j.info("Failed to press keyboard RIGHT ARROW key");
			Log4j.info(e.getMessage());
		}
	}
}
