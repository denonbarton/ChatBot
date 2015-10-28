package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;

/**
 * Controller for ChatBot project
 * 
 * @author dbar0540
 * 1.3
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

	public void start() {
		display.displayText("Hello " + simpleBot());
		chat();
	}

	private void chat() 
	{
		String textFromUser = display.getUserInput("Talk to the chatbot");
		while (simpleBot.lengthChecker(textFromUser));
		{
			if (simpleBot.contentChecker(textFromUser))
			{
				display.displayResponse("Wow, I had no idea you loved " + simpleBot.getContent());
			}
			textFromUser = display.getUserInput("wow" + textFromUser);
		}
	}
	
	private void shutDown()
	{
		
	}

}
