package chat.controller;

import  java.util.ArrayList;

import twitter4j.TwitterException;
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
		display.displayResponse(errorMessage);
	}
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.getUserInput("What is your name");
		chatBotDenon = new Chatbot(user);
		setBaseFrame(new ChatFrame(this));
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
		String userAnalysis = "The Twiter user " + userName + "has...";
		try
		{
			myTwitter.loadTweet(userName);
		}
		catch (TwitterException error)
		{
			handleErrors(error.getErrorMessage());
		}
		return userAnalysis;	
	}
		
	private void shutDown()
	{
		display.displayResponse("Goodbye, " + chatBotDenon.getUserName() + "hope to see you later");
		System.exit(0);
	}
	
	private void sendTweet(String tweetText)
	{
		myTwitter.sendTweet(tweetText);
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

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}

	public ChatController getBaseController()
	{
		return baseController;
	}

	public void setBaseController(ChatController baseController)
	{
		this.baseController = baseController;
	}

public Chatbot getChatbot()
{
	return chatBotDenon;
}

public ChatView getChatView()
{
	return display;
}
}