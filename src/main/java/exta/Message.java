package exta;

public class Message {
    public static String getDateOfManga(String mangaName, String content) {
        String date = content.substring(content.lastIndexOf(",") + 2, content.lastIndexOf("<"));
        return new String("The last chapter of " + mangaName + " was released : " + date);
    }

}
