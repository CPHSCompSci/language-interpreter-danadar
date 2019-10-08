package app;

public class Main {

  public static void main(String[] args) {
    Lexicon lex = new Lexicon();

    String newWord = lex.translate("thingy");
    System.out.println(newWord);
    System.out.println(decodeMessage(lex.getSample(1)));
    System.out.println(decodeMessage(lex.getSample(3)));
    System.out.println(decodeMessage(lex.getSample(5)));
    System.out.println(decodeMessage(lex.getSample(7)));
    System.out.println(decodeMessage(lex.getSample(15)));
  }

  /**
   * This method decodes a single word.
   * 
   * @param word The single word to be decoded.
   */
  public static String decode(String word) {
	  //removes the "ingy" added in language
	  String newWord = word;
	  if(word.length() >= 4 && (word.substring(word.length() - 4, word.length())).equals("ingy"))
	  {
		  newWord = word.substring(0, word.length() - 4);
	  }
	  else if(word.length() >= 5 && (word.substring(word.length() - 5, word.length() - 1)).equals("ingy"))
	  {
		  newWord = word.substring(0, word.length() - 5) + word.substring(word.length() - 1);
	  }
	  //removes the "ent" added in language
	  int index = newWord.indexOf("ent");
	  if(index != -1)
	  {
		  char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		  
		  for(char v : vowels)
		  {
			  if(newWord.charAt(index - 1) == v)
			  {
				  if(index + 3 < newWord.length())
				  {
					  return newWord.substring(0, index) + newWord.substring(index + 3);
				  }
				  else
				  {
					  return newWord.substring(0, index);
				  }
			  }
		  }
	  }
	  
	  return newWord;
  }
  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
  public static String decodeMessage(String message) {
	  String newMessage = "";
	  String currentWord;
	  String tempMessage = message;
	  
	  for(int currentIndex = 0; currentIndex <= message.length() - 1;)
	  {
		  if(tempMessage.indexOf(" ") != -1)
			  currentWord = tempMessage.substring(0, tempMessage.indexOf(" "));
		  else
			  currentWord = tempMessage.substring(0);
		  
		  newMessage += decode(currentWord) + " ";
		  currentIndex = newMessage.length();
		  
		  if(tempMessage.indexOf(" ") != -1)
			  tempMessage = tempMessage.substring(tempMessage.indexOf(" ") + 1);
		  else
			  return newMessage;
	  }
	  return newMessage;
  }

  /**
   * This method uses the decode(String) and a Scanner to decode a word specified
   * by the user.
   */
  public static String decodeInput() {
    return "";
  }
  
  /**
   * This method uses the Lexicon translate(String) and a Scanner to encode a word specified
   * by the user.
   */
  public static String encodeInput() {
    return "";
  }
}