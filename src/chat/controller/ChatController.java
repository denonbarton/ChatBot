package chat.controller;

import chat.model.ChatBot;
import chat.view.ChatView;
import chat.view.ChatFrame;

/**
 * Controller for the Chatbot project. Created a popup for the user name, and
 * displays the response.
 * 
 * @author Dbar0540
 * @version 1.3 10/24/15 Displays the Chatbot's user
 */
public class ChatController
{
	private ChatBot myBot;
	private ChatView myChatView;
	private ChatFrame chatFrame;

	public ChatController()
	{
		myChatView = new ChatView();
		String user = myChatView.getUserInput("What is your name?");
		myBot = new ChatBot(user);
		chatFrame = new ChatFrame(this);
	}

	public void start()
	{
		myChatView.displayResponse("Hi there " + myBot.getUserName());
		chat();
	}

	private void chat()
	{
		String textFromUser = myChatView.getUserInput("Talk to the chatbot.");
		while (myBot.lengthChecker(textFromUser))
		{

			textFromUser = myBot.processQuestion(textFromUser);
			textFromUser = myChatView.getUserInput(textFromUser);
		}

	}

	public String fromUserToChatbot(String textFromUser)
	{
		String botResponse = "";

		if (myBot.quitChecker(textFromUser))
		{
			shutDown();
		}

		botResponse = myBot.processQuestion(textFromUser);

		return botResponse;
	}

	private void shutDown()
	{
		myChatView.displayResponse("Goodbye, " + myBot.getUserName() + "hope to see you later");
		System.exit(0);
	}

}