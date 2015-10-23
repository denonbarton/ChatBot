package chat.view;

import javax.swing.JOptionPane;
/**
 *  this class provides popups for input and output
 * @author dbar0540
 * @version 1.1 10/21/15 completed
 */
public class ChatView
{
	/**
	 * Provides a GUI popup for collecting user text with the supplied String
	 * returns the user response as a String.
	 * @param input The supplied question for the Popup.
	 * @return he user's answer to the supplied question.
	 */
	public String getUserInput(String input)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, input);
		
		return answer;
	}
	/**
	 * Displays a String to the user with a standard popup
	 * @param input input the text to be diplayed
	 */
	
	public void displayResponse(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
	
	private void buildPoliticalTopicsList()
	{
		
	}
	
	public boolean lengthChecker(String currentInput)
	{
		boolean haslength = false;
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				haslength = true;
			}
		}
		
		if(currentInput != null && currentInput.length() > 0)
		{
			haslength = true;
		}
		
		return haslength;
	}
}
