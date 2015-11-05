package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 *  this class provides popups for input and output
 * @author dbar0540
 * @version 1.2 11/5/15 added icon to the input window.
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "This message brought to you by the chatbot! :D";
		chatIcon = new ImageIcon(getClass().getResource("images/heart.png"));
	}
	/**
	 * Provides a GUI popup for collecting user text with the supplied String
	 * returns the user response as a String.
	 * @param input The supplied question for the Popup.
	 * @return he user's answer to the supplied question.
	 */
	public String getUserInput(String input)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, input, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here please!").toString();
		
		return answer;
	}
	/**
	 * Displays a String to the user with a standard popup
	 * @param input input the text to be diplayed
	 */
	
	public void displayResponse(String input)
	{
		JOptionPane.showMessageDialog(null, input, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
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
