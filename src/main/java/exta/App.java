package exta;

// JDA Import
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

//Exception Import
import javax.security.auth.login.LoginException;

public class App extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder jd = new JDABuilder(AccountType.BOT);
        jd.setToken("NjQ4OTA5NDcwMjE4NTg0MDY1.Xd1Mrw.Pm3vyB7olqKdlZIainXeCOJCByk");
        jd.addEventListeners(new App());
        jd.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent msg) {
        if (msg.getAuthor().isBot())
            return ;
        System.out.println("Received a message from : " +
                msg.getAuthor().getName() + " : " +
                msg.getMessage().getContentDisplay());

        if (msg.getMessage().getContentRaw().equals("!ping")) {
            msg.getChannel().sendMessage("pong!").queue();
        }
    }
}
