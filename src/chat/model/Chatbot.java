package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Denon Barton
 * @version 1.4 11/3/15 made a switch case. 
 */
public class ChatBot
{
    private ArrayList<String> memesList;
    private ArrayList<String> politicalTopicList;
    private ArrayList<String> quitApp;
    private String userName;
    private String content;
    
    /**
     * Creates an instance of the Chatbot with the supplied username.
     * @param userName The username for the chatbot.
     */
    public ChatBot(String userName)
    {
        this.memesList = new ArrayList<String>();
        this.politicalTopicList = new ArrayList<String>(); 
        this.userName = userName;
        this.content = "sugar";
        
        buildMemesList();
        buildPoliticalTopicsList();        
    }
    
    /**
     * Builds an array list of memes.
     * 
     */
    private void buildMemesList()
    {
        
        this.memesList.add("Doge");
        this.memesList.add("GodFather Baby");
        this.memesList.add("Stare Dad");
        this.memesList.add("Grandma Finds the internet");
        this.memesList.add("Challenge Accepted");
        this.memesList.add("Expectation vs reality");
        this.memesList.add("cute animals");
        this.memesList.add("Anti-joke chicken");
        this.memesList.add("forever alone");
        this.memesList.add("One does not simply");
    }
    
    private void buildPoliticalTopicsList()
    {
        this.politicalTopicList.add("Trump");
        this.politicalTopicList.add("2020");
        this.politicalTopicList.add("republican");
        this.politicalTopicList.add("liberal");
        this.politicalTopicList.add("conservative");
        this.politicalTopicList.add("Biden");
        this.politicalTopicList.add("Clinton");
        this.politicalTopicList.add("democrat");
        this.politicalTopicList.add("Carson");
        this.politicalTopicList.add("burn");
        this.politicalTopicList.add("Fiorina");
        this.politicalTopicList.add("Sanders");
        this.politicalTopicList.add("vote");
        this.politicalTopicList.add("11/8/2016");
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
        if(currentInput != null)
        {
            if(currentInput.length() > 0)
            {
                hasLength = true;
            }
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
    public boolean politicalTopicChecker(String currentInput)
    {
        boolean hasTopics = false;
        
        for(String topics : politicalTopicList)
        {
            if(currentInput.toLowerCase().contains(topics.toLowerCase()));
            {
                hasTopics = true;
            }
        }
        
        return hasTopics;
    }
    
    
    /**
     * Checks to see that the supplied String value is in the current memesList variable.
     * @param currentInput The supplied String to be checked.
     * @return Whether the supplied String is a recognized meme.
     */
    public boolean memeChecker(String currentInput)

    {
        boolean hasMemes = false;
        
        for(String meme : memesList)
        {
            if(currentInput.toLowerCase().contains(meme.toLowerCase()));
            {
                hasMemes = true;
            }
        }
        
        return hasMemes;
    }
    
    public boolean quitChecker(String currentInput)
    
    {
        boolean hasQuit = false;
        
        for(String quit : quitApp)
        {
            if(currentInput.toLowerCase().contains(quit.toLowerCase()));
            {
                hasQuit = true;
            }
        }
        
        return hasQuit;
    }
    
    //public String keyboardMashChecker(String currentInput)
    {
        String keyboardMash;
        int randomMessage = (int) (Math.random() * 7);
        
        switch (randomMessage)
        {
        case 0:keyboardMash = "Mash not detected.";
            break;
        case 1:keyboardMash = "Mash not detected.";
            break;
        case 2:keyboardMash = "Mash not detected.";
            break;
        case 3:keyboardMash = "Mash not detected.";
            break;
        case 4:keyboardMash = "Mash not detected.";
            break;
        case 5:
            keyboardMash = "Mash not detected.";
            break;
        case 6: 
            keyboardMash = "Mash not detected.";
            break;
        default:
            keyboardMash = ""
            		+ " oh no... ";
            break;
            
        }
        
        //return keyboardMash;
    }
    
    public boolean keyboardMashChecker(String currentInput)
    {
        boolean isMash = false;
        
        return isMash;
    }
    public String processQuestion(String currentInput)
    {
        String talkBack = "you make no sense";
        int randomTopic = (int) (Math.random() * 5); //Generates a random number between 1 and 4.
        
        if(keyboardMashChecker(currentInput))
        {
            return "Stop mashing the keyboard!!";
        }
        
        switch (randomTopic)
        {
        case 0:
            if(contentChecker(currentInput))
            {
                talkBack = " ?";
            }
            break;
        case 1:
            if(memeChecker(currentInput))
            {
                talkBack = "I like dat meme. I'm interested. Tell me more of the things.";
            }
            break;
        case 2:
            if(politicalTopicChecker(currentInput))
            {
                talkBack = "comment and question.";
            }
            break;
        case 3:
            if(currentInput.length() > 25)
            {
                talkBack = "Congrats. You like lengthy responses! If that's the case, do you take AP Classes? If so which ones?";
            }
            break;
        case 4:
            talkBack = "Swell. Real swell. Turtle or snake?";
            break;
        default:
            talkBack = "Meow meow. How about kangaroos?";
            break;
            
            
        }
        
        return talkBack;
    }
    
    
    /**
     * Returns the username of this Chatbot instance.
     * @return The username of the Chatbot.
     */
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