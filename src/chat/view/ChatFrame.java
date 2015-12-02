package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;

/**
 * Creates the frame for the GUI project.
 * 
 * @author dbar0540
 * @version 0.x Nov 9, 2015 added a refrence to the GUIPanel and installed it as
 *          the content pane added the setupFrame helper method
 */

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	private JTextField textField;

	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController; // assign parameter to data
												// member.
		basePanel = new ChatPanel(baseController);
		SpringLayout springLayout = (SpringLayout) basePanel.getLayout();
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 135, SpringLayout.NORTH, basePanel);
		springLayout.putConstraint(SpringLayout.WEST, textField, 182, SpringLayout.WEST, basePanel);
		basePanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 71, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, textField);
		basePanel.add(btnNewButton);
		setupFrame();

	}

	/**
	 * Helper method to setp the Frame and its structure
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel); // Sets the panel in the GUIFrame this
										// is REQUIRED
		// this.setResizable(false); // usually a good idea, but not required.
		this.setTitle("my window app"); // sets title
		this.setSize(500, 500); // sets the size
		this.setVisible(true); // must be the last line of code in the
								// setupFrame method
	}
}
