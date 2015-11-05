package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Cody Henrichsen
 * @version 1.3 10/14/15 updated my lengthChecker method
 * repaired topic lists
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "CodeLizard";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("anti joke chicken");
		this.memesList.add("forever alone");
		this.memesList.add("malicious mallard");
		this.memesList.add("Stare dad");
		this.memesList.add("godfather baby");
		this.memesList.add("");
		this.memesList.add("");
		this.memesList.add("");
		
		/**
		 * 
		 */
		
		
	}
	
	private void buildPoliticalTopicsList()
	{
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput.length() >= 1)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public String politicalTopicChecker(String currentInput)
	{
		return userName;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme : memesList)
		{
			hasMeme = true;
		}
		
		return hasMeme;
	}
	
	public boolean quitChecker(String currentInput)
	{
		return false;
	}
	
	public String processConversation(String currentInput)
	
	{
		String nextConversation = "oh, what else would you ke to talk about?";
		int randomTopic = (int) (Math.random() * 5); 
		
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				nextConversation = "hey you talked about my special topic, neat! what else do you like?";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				nextConversation = "That is a popular meme this year! wow! what is your favorite food?";
			}
			break;
		case 2:
			if(politicalTopicChecker(currentInput) 
			{
				nextConversation = "comment and question";
			}
			break;
		case 3:
			if(currentInput.length() > 23)
			{
				nextConversation = "comment and question";
			}
			break;
		case 4:
			nextConversation = "comment and question";
			break;
		default:
			nextConversation = "comment and question";
			break;
		
		}
		
		
		
		
		return nextConversation;
		
	}
		
	public String getUserName()
	{
		return userName;
	}
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}
