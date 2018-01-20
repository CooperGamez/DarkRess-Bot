//

package DarkRessDiscordBot.DRDB;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter {
    public static void main( String[] args ) throws LoginException, InterruptedException {
    	
    	JDA jdaBot = new JDABuilder(AccountType.BOT).setToken("NDA0MjU3Njc3MTk2Mzk0NTA4.DUTaQg.jPaIDpDag4Kt_KIdKO7AFObYY5Q").buildBlocking();
    	jdaBot.addEventListener(new App());
    	
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
    
    	Message objMsg = e.getMessage();
    	MessageChannel objChannel = e.getChannel();
    	User objUser = e.getAuthor();
    	
    	if (objMsg.getContentDisplay().charAt(0) == '!') {
    		String[] strArgs = objMsg.getContentDisplay().substring(1).split(" ");
    		//!roll
    		//!roll 100
    		
    		if(strArgs[0].equals("hello")) {
    			objChannel.sendMessage("Hello, " + objUser.getAsMention() +"!").queue();
    		} else if(strArgs[0].equals("roll")) {
    			int intSides = 6;
    			if (strArgs.length > 1) {
    				intSides = Integer.valueOf(strArgs[1]);
    			}
    			objChannel.sendMessage(objUser.getAsMention() + " rullet en " + (int)(Math.random() * intSides + 1)).queue();
    		}
    	}
    	
    } 
}
