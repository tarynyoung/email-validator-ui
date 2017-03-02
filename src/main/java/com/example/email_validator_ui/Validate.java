package com.example.email_validator_ui;

public class Validate {
	
	private static int rulesPassed, atChar, dotChar, hashtagChar, ampChar;

	public static String Validate(String email){
		//counter for @ symbol
		atChar = 0;
		//counter for . symbol
		dotChar = 0;
		//counter for # of rules passed
		rulesPassed = 0;
		
		
		//custom rule 1
		//email addresses must not contain the # symbol
		hashtagChar = 0;
		
		//custom rule 2
		//email addresses must not contain & symbol
		ampChar = 0;
		
		char c;
		
		//check each character in the string, count the @ and .
		for(int i =0; i < email.length(); i++){
			c = email.charAt(i);
			//check if c is equal to @, ., #, or &
			if(c==64){
				atChar++;
			}
			if(c==46){
				dotChar++;
			}
			if(c==35){
				hashtagChar++;
			}
			if(c==38){
				ampChar++;
			}
		}
		
		//if there is exactly one @ then it passes the rule, so increment rulesPassed count
		if(atChar==1){
			rulesPassed++;
		}
		//if there is at least one . then it passes the rule, so increment the count
		if(dotChar>0){
			rulesPassed++;
		}
		//if there are none, it passes
		if(hashtagChar==0){
			rulesPassed++;
		}
		//if there are none, it passes
		if(ampChar==0){
			rulesPassed++;
		}
		
		System.out.println("This email passes "+rulesPassed+" rules");
		
		if(rulesPassed==4){
			return "This is a valid email";
		}
		else{
			return "This is not a valid email";
		}
		
	}
	
	//get methods for the counters
	//useful for tests
	public static int getAtChar(){
		return atChar;
	}
	
	public static int getDotChar(){
		return dotChar;
	}
	
	public static int HashtagChar(){
		return hashtagChar;
	}
	public static int getAmpChar(){
		return ampChar;
	}
	
	//returns # of rules passed
	//return value of 4 means everything passes
	public static int getRulesPassed(){
		return rulesPassed;
	}
	
	//prints # of rules passed as a string
	public String toString(){
		return "This email passes "+rulesPassed+" rules";
	}


}
