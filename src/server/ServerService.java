package server;


import static util.ContentType.JSON;
import static util.ContentType.TEXT;

public class ServerService {

    private static String sendHeader(int statusCode, String statusText, String type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 ").append(statusCode).append(" ").append(statusText);
        stringBuilder.append(" Content-Type: ").append(type);
        return stringBuilder.toString();
    }
    public static String createHttp(String type){
        if (type.equals(JSON)||type.equals(TEXT)){
            return sendHeader(200, "OK", type);

            } else {
                return sendHeader( 404, "Not Found", type);
            }

    }

}
