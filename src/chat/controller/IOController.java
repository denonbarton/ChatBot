package chat.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class IOController
{

	
	public static String saveFile(String TextToSave)
	{
		String fileName = "Saved Chat File - ";
		
		try
		{
	
		}
		catch (IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());			
		}
		return fileName;
	}
	
	public static String readTextFromFile(String fileName)
	{
		String text = "";
		File chatTextFile = new File(fileName);
		Scanner chatScanner;
		try
		{
			chatScanner = new Scanner (chatTextFile);
			while(chatScanner.hasNext())
			{
				
			}
		}
	}
}
