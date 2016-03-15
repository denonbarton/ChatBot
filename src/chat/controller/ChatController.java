package chat.controller;

import  java.util.ArrayList;

import chat.model.CTECTwitter;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatPanel;
import chat.view.ChatView;




/**
 * Controller for the Chatbot project. Created a popup for the user name, and
 * displays the response.
 * 
 * @author Dbar0540
 * @version 1.3 10/24/15 Displays the Chatbot's user
 */

public class ChatController
{
	private Chatbot chatBotDenon;
	private ChatView display;
	private ChatFrame baseFrame;
	private CTECTwitter myTwitter;
	private ChatController baseController;
	

	public void handleErrors(String errorMessage)
	{
		display.displayText(errorMessage);
	}
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.getUserInput("What is your name");
		chatBotDenon = new Chatbot(user);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.displayResponse("Hi there " + chatBotDenon.getUserName());
		chat();
	}

	private void chat()
	{
		String textFromUser = display.getUserInput("Talk to the chatbot.");
		while (chatBotDenon.lengthChecker(textFromUser))
		{

			textFromUser = chatBotDenon.processQuestion(textFromUser);
			textFromUser = display.getUserInput(textFromUser);
		}

	}

	public String analyze(String userName)
	{
		String userAnalysis = "The Twiter user " + username + "has...";
	return userAnalysis;	
	}
	
	private void shutDown()
	{
		display.displayResponse("Goodbye, " + chatBotDenon.getUserName() + "hope to see you later");
		System.exit(0);
	}
	
    public String fromUserToChatbot(String textFromUser)
	{
		String botResponse = "";

		if (chatBotDenon.quitChecker(textFromUser))
		{
			shutDown();
		}

		botResponse = chatBotDenon.processQuestion(textFromUser);

		return botResponse;
	}



}