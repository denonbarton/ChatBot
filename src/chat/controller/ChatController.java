package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;

/**
 * Controller for ChatBot project
 * 
 * @author dbar0540 1.3
 */

public class ChatController

{
	private Chatbot simpleBot;
	private ChatView display;

	public ChatController()

	{
		display = new ChatView();
		String user = display.getUserInput("What is your name?");
		simpleBot = new Chatbot(user);
	}

	public void start()
	{
		display.displayResponse("Hello " + simpleBot.getUserName());
		chat();
	}

	private void chat()
	{
		String textFromUser = display.getUserInput("Talk to the chatbot");
		while (simpleBot.lengthChecker(textFromUser))
		{
			if (simpleBot.contentChecker(textFromUser))
			{
				display.displayResponse("Wow, I had no idea you loved " + simpleBot.getContent());
			}
			else if (simpleBot.memeChecker(textFromUser))
			{
				display.displayResponse("OMG Y U NO memes!");

			}
			textFromUser = display.getUserInput("wow" + textFromUser);
		}

	}

	private void shutDown()
	{

	}

}
