package exta;

// JDA Import
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


//Exception Import
import javax.security.auth.login.LoginException;


public class App extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder jd = new JDABuilder(AccountType.BOT);
        jd.setToken("NjQ4OTA5NDcwMjE4NTg0MDY1.Xd5Izg.waxoSnjZMch_UnvdxIQT2Y2fTz0");
        jd.addEventListeners(new App());
        jd.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent msg) {
        if (msg.getAuthor().isBot())
            return;

        String req = msg.getMessage().getContentRaw();
        if (req.equals("!help")) {
            msg.getChannel().sendMessage("Hey, my name is eXta a Manga notifier bot !").queue();
        } else if (req.contains("black clover")) {
            try {
                Document doc = Jsoup.connect("https://jaiminisbox.com/reader/series/black_clover").get();
                String link = doc.getElementsByAttributeValue("class", "element").first().child(2).toString();
                msg.getChannel().sendMessage(Message.getDateOfManga("Black Clover", link)).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (req.contains("peerless dad")) {
            try {
                Document doc = Jsoup.connect("https://jaiminisbox.com/reader/series/peerless-dad").get();
                String link = doc.getElementsByAttributeValue("class", "element").first().child(2).toString();
                msg.getChannel().sendMessage(Message.getDateOfManga("Peerless Dad", link)).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (req.contains("solo leveling")) {
            try {
                Document doc = Jsoup.connect("https://jaiminisbox.com/reader/series/solo-leveling").get();
                String link = doc.getElementsByAttributeValue("class", "element").first().child(2).toString();
                msg.getChannel().sendMessage(Message.getDateOfManga("Solo Leveling", link)).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
