import javax.swing.JOptionPane;
import java.util.Arrays;
public class Year1Sem2GroupProjectCS4092
{
  public static void main(String [] args)
  {
    int     choice;
    String  menuOption = "";  
    while ((menuOption != null) && (!(menuOption.equals("0"))))
    {  
      menuOption = getMenuOption();
      if (menuOption != null)
      {
	    choice = Integer.parseInt(menuOption);  
	    if (choice != 0)
        {
	      switch(choice)
	      {
	        case 1: analyseVowelContentOfWordPhrase(); break;
            case 2: analyseConsonantContent(); break;
            case 3: analyseCharacterContent(); break;
            case 4: determineKeyboardRows(); break;
            case 5: alternatingVowelsAndConsonants(); break;
            case 6: determineLongestAndShortestWords(); break;
            case 7: areWordsOrPhrasesAnagrams(); break;
            case 8: determineIfPalindromes(); break;
          }
        }
      }
    }  
  }
 
    
    
    
    
  public static String getMenuOption()
  {
    String menuOptions = "1. Analyse vowel content of word/phrase."+"\n2. Analyse consonant content of word/phrase."+"\n3. Analyse character content of word/phrase" +"\n4. Determine keyboard rows required for word/phrase"+"\n5. Determine if vowels and consonants are alternating in word/phrase."+"\n6. Display the shortest and longest words in a sentence."+"\n7. Are two words/phrases anagrams of each other?"+"\n8. Determine if word/phrase is palindrome."+"\n0. Exit.";
    String menuMessage = "Choose number of option you wish to have executed";
    String errorMessage =  "Invalid menu selection.\n\nValid options are 0 to 7 inclusive.";
       	   errorMessage += "\nSelect OK to retry.";
    String errorHeader = "Error in user input";
    boolean validInput = false;
    String selection = "", menuChoicePattern = "[0-8]{1}";
    
    while (!(validInput))
    {
      selection = JOptionPane.showInputDialog(null, menuOptions, menuMessage, 3);
      if (selection == null || selection.matches(menuChoicePattern))
       validInput = true;
      else
       JOptionPane.showMessageDialog(null, errorMessage, errorHeader, 2);
    }				   
    return selection;
  }	

    
    
    

  public static void analyseVowelContentOfWordPhrase()
    {
			String input = "", msg1, msg2, msg3, msg4, msg5, msg6, result = "",error;
			error = "Invalid input";
			int a ,e, i , o , u, x=0;
			char letter;
            msg1 = "Please enter a word or sentence:";
			while(input  !=  null)
			{
			a = 0; e = 0; i = 0; o = 0; u = 0;
			result = "";
            input = JOptionPane.showInputDialog(null, msg1, "Find vowel content", 3);
			
			if(input == null)
			{return;}
				else
				{
						input = input.toLowerCase();
						int posA,posE,posI,posO,posU;
						posA = input.indexOf('a');
						posE = input.indexOf('e');
						posI = input.indexOf('i');
						posO = input.indexOf('o');
						posU = input.indexOf('u');
						msg2 = "There are no vowels present";
						msg3 = "This input contains all the vowels";
						msg4 = "This input contains all the vowels in alphabetical order";
						msg5 = "This input contains all the vowels in reverse alphabetical order";
						if(posA == -1 && posE == -1 && posI == -1 && posO == -1 && posU == -1)			//If no vowels present
						{
							result += msg2;
						}
						else
						{
							if(posA != -1 && posE != -1 && posI != -1 && posO != -1 && posU != -1)		//If all vowels present
							{
								if(posA < posE && posE < posI && posI < posO && posO < posU)			//If all present in alphabetical order
								{
								result += msg4;
								}
								else if(posA > posE && posE > posI && posI > posO && posO > posU)		//If all present in reverse alphabetical order
								{
									result += msg5;
								
								}
								else	
									result += msg3;	
							}
							for(x = 0; x< input.length(); x++)
							{
								letter = input.charAt(x);
								if(letter=='a')
									a++;
								else if(letter=='e')
									e++;
								else if(letter=='i')
									i++;
								else if(letter=='o')
									o++;
								else if(letter=='u')
									u++;
							}
							if(a > 0)
								result += "\n The frequency of 'a' is:  " + a;
							if(e > 0)
								result += "\n The frequency of 'e' is:  " + e;
							if(i > 0)
								result += "\n The frequency of 'i'  is:  " + i;
							if(o > 0)
								result += "\n The frequency of 'o' is:  " + o;
							if(u > 0)
								result += "\n The frequency of 'u' is:  " + u;
						}
						JOptionPane.showMessageDialog(null, result, "Results", 1);
				}
			
			}
		}		

    
    
    
    
   
  public static void analyseConsonantContent()    
    {
		boolean validInput = false;
		String result = "";
        while(!validInput)
		{
			String errorMsg = "Please enter a valid word/phrase,\nContaining only letters of the English alphabet";
			String userInput = JOptionPane.showInputDialog(null,"Please Enter The Word Or Phrase to check for consonants","Consonant Content",3);
			if(userInput==null)return;
			    
            result+="Original Word/Phrase= "+userInput+"\n";                     //prints original string
            userInput  = userInput.toLowerCase();                                       //converts to lower case
            userInput  = userInput.replaceAll("[\\saeiou]", "");                        //delete white spaces & vowels
            userInput  = userInput.replaceAll("[^a-zA-Z]","");                          //gets rid of everything else
					
            if(userInput.equals(""))
				JOptionPane.showMessageDialog(null,errorMsg,"Error",2);					//empty string wont be accepted
            else
            {
				validInput=true;
				result+="New String (Containing only Consonants)= "+userInput+"\n";  //prints without vowels
				char letters [] = userInput.toCharArray();                                  //puts consonants into char array
				Arrays.sort(letters);                                                       //sorts the array alphabetically
				result+="Total Amount of Consonants= "+letters.length+"\n";         //prints total amount of Consonants
				
				int  count = 0;																//sets consonant counter to 0
				char lastConsonant=letters[0];												//initialises consonant position indicator

				for(int i=0;i<letters.length;i++)  
				{
					if(letters[i]!=lastConsonant)  											//if it doesnt match next cons, it'll stop the matching process
					{
						result+=lastConsonant+" occurred "+count+" times\n";
						count=0;                                                       		// prepare for next grouping
						lastConsonant=letters[i];											//makes last cons the next char in the sorted array
					}
					count++;																//sets the counter back to one(if a new char exists it must be at least 1)
					if(i==(letters.length-1))  												//print statement in case the last char is unique
					{
						result+=lastConsonant+" occurred "+count+" times";
					}
				}
					
			}
		}
        JOptionPane.showMessageDialog(null,result);
  }
  
    
    
    
    
  public static void analyseCharacterContent()
  {
        String userInput, minusAlphabet, minusNumbers, minusSymbols, result1, result2="";
        int num1, num2, num3;
        int freq=0;
        char character;
        boolean flag;
        do
        {
            userInput = JOptionPane.showInputDialog(null, "Enter word, phrases, or sentence.","Alphabetic, numeric, and symbolic character analysis", 3);
            if (userInput == null) return;
            if(userInput.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid word/sentence/phrase.");
                flag=false;
            }
            else
                flag=true;
        } while(!flag);
        for (character = (char)32; character<=126; character++)
        {
            freq=0;
            for(int i=0; i<userInput.length(); i++)
            {
                if(character == userInput.charAt(i))
                    freq++;
            }
            if(freq>0)
            {
                result2 += (character+" occurs "+freq+"\n");
            }        
        }
        minusAlphabet=userInput.replaceAll("[a-zA-Z]","");
        minusNumbers=userInput.replaceAll("[0-9]", "");
        minusSymbols=userInput.replaceAll("[^a-zA-Z0-9]","");
        num1=userInput.length()-minusAlphabet.length();
        num2=userInput.length()-minusNumbers.length();
        num3=userInput.length()-minusSymbols.length();
        result1="There are "+num1+" alphabetical characters.\nThere are "+num2+" numerical characters.\nThere are "+num3+" symbolic characters.\n";
        JOptionPane.showMessageDialog(null, result1+result2, "Results", 3);
  }
  
    
    
    
    
  public static void determineKeyboardRows()
  {
		String input, newInput, aCharacter;
		String Line1 = "qwertyuiop", Line2 = "asdfghjkl", Line3 = "zxcvbnm", result = "The Keyboard Lines Used In This Word/Sentence/Phrase Are: \n";
		boolean L1 = false, L2 = false, L3 = false, isCorrectFormat = false ;
		int i;
		
		while(isCorrectFormat != true)
		{
			input = JOptionPane.showInputDialog(null, "Please enter a word, phrase or sentence: ","Keyboard Line Check", 3);
			if(input == null)return;
			
			newInput = input.replaceAll("[^a-zA-Z]", "");
			newInput = newInput.toLowerCase();
			
				if(newInput.equals(""))
				   JOptionPane.showMessageDialog(null,"Please enter a valid word/sentence/phrase.");      //Error Message 
			   
				else 
				{
					for(i = 0; i < Line1.length() && !L1; i++)
					{
					   aCharacter = Line1.substring(i, i + 1);   //Stores a character from keyboard line 1 into aCharacter
					   if (input.indexOf(aCharacter) == -1)      //Checks for the index of a character in the user input
					   L1 = false;
					   else L1 = true;
					}
				
					for(i = 0; i < Line2.length() && !L2; i++)
					{
					   aCharacter = Line2.substring(i, i + 1);
					   if (input.indexOf(aCharacter) == -1)
					   L2 = false;
					   else L2 = true;
					}
					
					for(i = 0; i < Line3.length() && !L3; i++)
					{
					   aCharacter = Line3.substring(i, i + 1);
					   if (input.indexOf(aCharacter) == -1)
					   L3 = false;
					   else L3 = true;
					}
					
					if(L1)
						result += "Line 1 (QWERTYUIOP)\n";
					if(L2)
						result += "Line 2 (ASDFGHJKL) \n";
					if(L3)
						result += "Line 3 (ZXCVBNM) \n";
					
					JOptionPane.showMessageDialog(null,result);
					isCorrectFormat = true;                //Allows user out of the while loop
				}
		}
  }   
  
   
    
    
      
  public static void alternatingVowelsAndConsonants()    
  {
        boolean alternating;
		String result = "", error;
		error = "Invalid input";
		String input = "", msg1;
		String vowels = "aeiou";
		String consonants = "bcdfghjklmnpqrstvwxyz";
		boolean validInput;
		while(input  !=  null)
			{
		validInput = false;	
		alternating = true;
		input = "";
		result = "";
		msg1 = "Please enter a word or sentence";
		input = JOptionPane.showInputDialog(null, msg1, "Alternaing vowels and consonants", 3);
		
		if(input == null)
		{return;}
		else
			{
				input = input.replace(" ","");
				String pattern = "([a-zA-Z]+)|((([a-zA-Z]+\\s)+)[a-zA-Z]+)";
				if(input.matches(pattern))
				validInput = true;
				
					if((validInput == true) && (input != null))
					{
						for(int i = 0; i < input.length() -1 && alternating; i++)
						{
							if(vowels.contains(input.substring(i, i + 1)))					//Checks if character is a vowel
							{
								if(consonants.contains(input.substring(i + 1, i + 2)))		//Checks if next character is a consonant
									alternating = true;
								else alternating = false;
							}
							else if(consonants.contains(input.substring(i, i + 1)))			// Checks if character is a consonant
							{
								if(vowels.contains(input.substring(i + 1, i + 2)))			//Checks if character is a vowel
									alternating = true;
								else alternating = false;
							}
							else alternating = false;
						}
					}
				else
				{
				alternating = false;
				}
				if(alternating)
				result += "This contains alternating vowels and consonants";
			else if(!alternating)
				result += "This does not contain alternating vowels and consonants";
		
			JOptionPane.showMessageDialog(null, result, "Results", 1);
			
			
			}
	
		
		}
  }
  
    
    
    
    
  public static void determineLongestAndShortestWords()
  {
     boolean isCorrectFormat = false, flag =true;
     String shortWord = "", longWord = "", input="", words[];
     int s=0, l=0;
      
     while(isCorrectFormat != true)
	 {
		 do
         {
         input = JOptionPane.showInputDialog(null, "Please enter a word, phrase or sentence:", "Longest Word/Shortest Word", 3);
		 if(input==null)return;
		 input = input.replaceAll("[^A-Za-z0-9\\s]","");  
		 s = input.length(); //l = 0;    // Variables used for comparisson to find the longest and shortest words
		 words = input.split(" "); // Splits the user input into an array of strings
	 
	 
         if (input.equals(""))
            {
             JOptionPane.showMessageDialog(null, "Please input a valid word/sentence/phrase.");
             flag=false;
            }
        else
            flag=true;
         }while(!flag);
		if(words.length < 2)
		 {
			 JOptionPane.showMessageDialog(null, "You have only entered one word , It is the longest and shortest word."); 
		     isCorrectFormat = true;
		 }
		 
		else
		{    	 
			for(int i = 0; i < words.length ; i++)
			{
				if(words[i].length() > l)
						l = words[i].length(); //Finds length of the longest word

				if(words[i].length() < s)   
						s = words[i].length(); //Finds length of the shortest word
			}
         
         
         
			for(int q = 0 ; q < words.length; q++)
		    {
					for(int j = q + 1; j < words.length; j++) 
					{
						if (words[q].equals(words[j]))  //Checks for duplicate words
						words[j] = "";                  //If duplicate is found it is set to an empty string
					}
		    }
            
           for(int m = 0; m < words.length; m++)
           {
				if(words[m].length() == l)
					longWord += words[m] + " ";      //Adds words with same length as the longest word to a String
            
				if(words[m].length() == s)
					shortWord += words[m] + " ";     //Adds words with same length as the shortest word to a String
           }
			isCorrectFormat = true;
        
		   JOptionPane.showMessageDialog(null,"Length of longest word(s): " + l + "\nLongest word(s): \t" + longWord +"\nLength of shortest word(s)" + s +"\nShortest word(s): \t" + shortWord);
		}
     }
  } 
  
    
    
    
    
  public static void areWordsOrPhrasesAnagrams()
  {
        boolean validInput = false;
        while(!validInput)
		{
			
			String orig1 = JOptionPane.showInputDialog(null,"Please Enter the first word, phrase or sentence\nNumbers and characters will be ignored");	//takes first string
			if(orig1==null)return;																														//cancel->return to main
			String orig2 = JOptionPane.showInputDialog(null,"Please Enter the second word, phrase or sentence\nNumbers and characters will be ignored");	//takes second string
			if(orig2==null)return;																														//cancel->return to main
			String input1= orig1.replaceAll("[^a-zA-Z]","");																							//replaces everything but vowels
			String input2= orig2.replaceAll("[^a-zA-Z]","");																							//replaces everything but vowels
			input1 = input1.toLowerCase();																												//converts to lower
			input2 = input2.toLowerCase();																												//converts to lower
			
			char [] chars1 = (input1.toCharArray());																									//puts chars into array
			char [] chars2 = (input2.toCharArray());																									//puts chars into array
			
			if(input1.equals("")||input2.equals(""))																									//error for empty string
				JOptionPane.showMessageDialog(null,"Please Enter A valid word/phrase, containing only letters in the English Alphabet","Error",3);
            else																																		//continues if valid
			{
				Arrays.sort(chars1);																													//sorts array
				Arrays.sort(chars2);
				
				if(Arrays.equals(chars1, chars2))																										//equal arrays(prints true)		
					{
						JOptionPane.showMessageDialog(null,orig1 + " Is an anagram of " + orig2);
						validInput=true;
					}
				else																																	//non equal prints false
					{
						JOptionPane.showMessageDialog(null,orig1 + " Is not an anagram of " + orig2);
						validInput=true;
					}
			}
		}
  }  

    
    
    
    
  public static void determineIfPalindromes()
  {
    boolean flag1 = true, flag2 = true, format=true;
    int n=0, i;
    String userInput, editUserInput, input[];
    String compare = "", compare2 = "";
    do
    {
        userInput = JOptionPane.showInputDialog(null, "Enter word, phrases, or sentence.", "Is the word/phrase/sentence a palindrome?", 3);
        if (userInput == null) return;
            userInput = userInput.replaceAll("[^a-zA-Z\\s]", "");
            if(userInput.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid word/sentence/phrase.");
                format=false;
            }
            else
                format=true;
    } while(!format);
    input = userInput.split(" ");
    n = input.length;
    if (input.length>1)
    {
        for(i = 0; (i< n/2) && (flag1); i++)
        {   
            compare = input[i];
            compare2 = input[n-i-1];
        if (!(compare.equalsIgnoreCase(compare2))) flag1 = false;
        }
    }
    else flag1 = false;
	editUserInput = userInput.replaceAll("[^a-zA-Z]", "");
	n = editUserInput.length();
	for(i = 0; (i < n/2) && (flag2 = true); i++)
	if (editUserInput.charAt(i) != editUserInput.charAt(n-i-1)) flag2 = false;
	if(flag1 || flag2) JOptionPane.showMessageDialog(null, userInput+" is a palindrome.","Result",3);
    else JOptionPane.showMessageDialog(null, userInput+" is not a palindrome.","Result",3);
  }	  
} 