package chat.view;

import javax.swing.*;

import chat.controller.ChatController;

import java.awt.Color;
import java.awt.event.*;
import java.awt.TextArea;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JButton submitButton;
	private JTextField chatTextField;
	private SpringLayout chatLayout;
	private JTextArea chatTextArea;
	private JScrollPane chatPane;
	private JButton analyzeTwitterButton;
	private JButton tweetButton;

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		chatLayout = new SpringLayout();
		submitButton = new JButton("");
		chatButton = new JButton("Press this!!");
		chatTextField = new JTextField(30);
		
		chatTextArea = new JTextArea(10, 30);
		analyzeTwitterButton = new JButton("analyze");
		
		tweetButton = new JButton ("tweet");
		

		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupChatPane()
	{
		chatTextArea.setLineWrap(true);
		chatTextArea.setWrapStyleWord(true);
		chatTextArea.setEnabled(false);
		chatTextArea.setEditable(false);
		chatPane = new JScrollPane(chatTextArea);
		chatPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

	}

	private void setupPanel()
	{
		this.setLayout(chatLayout);
		this.add(chatPane);
		this.setBackground(Color.CYAN);
		// this.add(chatTextArea);
		this.add(chatButton);
		this.add(chatTextField);
		this.add(submitButton);
		this.add(analyzeTwitterButton);
		this.add(tweetButton);

		chatTextField.setToolTipText("Chat Bot is listening");
		chatTextArea.setEnabled(false);

	}

	private void setupLayout()
	{
		chatLayout.putConstraint(SpringLayout.SOUTH, submitButton, -21, SpringLayout.SOUTH, this);
		chatLayout.putConstraint(SpringLayout.WEST, chatButton, 69, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, submitButton);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -30, SpringLayout.NORTH, chatButton);
		chatLayout.putConstraint(SpringLayout.NORTH, chatTextField, 5, SpringLayout.SOUTH, chatTextArea);
		chatLayout.putConstraint(SpringLayout.NORTH, chatTextArea, 25, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -113, SpringLayout.SOUTH, this);
		chatLayout.putConstraint(SpringLayout.EAST, chatTextArea, -21, SpringLayout.EAST, this);
		chatLayout.putConstraint(SpringLayout.EAST, submitButton, 0, SpringLayout.EAST, chatTextArea);
		chatLayout.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 220, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, -44, SpringLayout.WEST, submitButton);
		chatLayout.putConstraint(SpringLayout.WEST, chatTextField, -20, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.EAST, chatTextField, 360, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, chatButton);
		chatLayout.putConstraint(SpringLayout.EAST, tweetButton, -44, SpringLayout.WEST, submitButton);
		

	}

	public JTextField getTextField()
	{
		return chatTextField;
	}

	private void setupListeners()
	{
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("");
			}
		});
		
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				setBackground(new Color(red, blue, green));
				chatTextField.setText("Press ");
			}
		});

		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = chatTextField.getText(); // Grab user from
															// text
				String response = baseController.fromUserToChatbot(userText);
				// Send// the// text// to// the// controller// gives// text//
				// to// chatbot// to// process,// gets// chatbot// answer.
				chatTextArea.append("\nUser: " + userText); // displays user
															// text
				chatTextArea.append("\nChatbot: " + response); // displays
																// answer
				chatTextField.setText(""); // clears the user field
			}
		});

		analyzeTwitterButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				String user = chatTextField.getText();
				String results = baseController.analyze(user);
				chatTextArea.setText(results);
			}
			
			
		});
	}

}