package GameEngine;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * This class is an input listener for the keyboard.
 * 
 * This class allows the user to manually check the input at specific times, 
 * rather than having to set up action listeners for key pressed and manage which are pressed themselves.
 * @author Joshua DeMoss
 */
public class Input {

	private static ArrayList<Integer> Keys;	// Integer representing the Keyboard ID of a key
	private static ArrayList<Boolean> KeyPressed;	// true is down, false is up This is always current
	private static ArrayList<Boolean> KeyLastState;	// true is down, false is up This is what it last was when it was checked

	public static boolean IsKeyPressed(int Key) {	// This returns true if the key was pressed. Further calls will return false until the key is Released
		if (Keys.contains(Key)) {	// If the key is in the list
			int Pos = Keys.indexOf(Key);
			if (KeyPressed.get(Pos) && !KeyLastState.get(Pos)) {	// If the current state is Down, but it previously was Up, we know that it was Pressed
				KeyLastState.set(Pos, true);	//This updates the state, ensuring that its previous state is Down as well, preventing further calls from returning true
				return true;
			}
		}
		return false;	//If it was not in the list, or it was not just pressed, return false
	}

	public static boolean IsKeyReleased(int Key) {	//This returns true if the key was released. Further calls will return false until the key is Pressed
		if (Keys.contains(Key)) {
			int Pos = Keys.indexOf(Key);
			if (!KeyPressed.get(Pos) && KeyLastState.get(Pos)) {	// If the current state is Up, but it previously was Down, we know that it was Released
				KeyLastState.set(Pos, false);	//This updates the state, ensuring that its previous state is Up as well, preventing further calls from returning true
				return true;
			}
		}
		return false;	//If it was not in the list, or it was not just released, return false
	}

	public static boolean IsKeyDown(int Key) {	//This checks if the key is down at any moment. Always returns if the key is down, regardless of previous calls
		if (Keys.contains(Key)) {	// If the key is in the list, we just need to return the current state 
			return KeyPressed.get(Keys.indexOf(Key));
		} else {	// If the key is not in the list, add it
			Keys.add(Key);	//Add the entry
			KeyPressed.add(false);
			KeyLastState.add(false);
			return false;	//return false, as if it was ever pressed, it would be in the list
		}
	}

	private static void SetKey(int KeyCode, boolean Up) {	//Internal method to set the state of a key
		int Pos = Keys.indexOf(KeyCode);	// Get the index of the Key
		KeyLastState.set(Pos, KeyPressed.get(Pos));	// Set the previous state to the current one
		KeyPressed.set(Pos, Up);	// Update the current state
	}

	static {	// Static blocks are called when the program is run. This "constructs" the class resources
		Keys = new ArrayList<>(32);	//This sets up the ArrayLists with a default of 32 keys
		KeyPressed = new ArrayList<>(32);
		KeyLastState = new ArrayList<>(32);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {	//This sets up the listener, which captures all events and stores them in a more useful manner
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				switch (e.getID()) {	// Switch for if it was pressed or released
					case KeyEvent.KEY_PRESSED:	// This sets up the entry in the arrays for each key if it is pressed and not already in the array, if it is then it updates the state
						if (Keys.contains(e.getKeyCode())) {	// Updates current state
							SetKey(e.getKeyCode(), true);
						} else {	// Sets up entry
							Keys.add(e.getKeyCode());
							KeyPressed.add(true);
							KeyLastState.add(false);
						}
						break;
					case KeyEvent.KEY_RELEASED:	// If the key was released, this method already captures that it was pressed, so it is always set up
						SetKey(e.getKeyCode(), false);	// Updates current state
						break;
				}
				return false;
			}
		});
	}
}
