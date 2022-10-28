package client;

import java.util.HashMap;
import java.util.Map;

public class ClientService {

    private static String createHeader( int statusCode, String statusText, String type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" HTTP/1.1 ").append(statusCode).append(" ").append(statusText);
        stringBuilder.append(" Content-Type: ").append(type);

        return stringBuilder.toString();
    }
    public static String createHttp(String type){
        return "GET/"+ type+createHeader(200, "OK", type);
    }
}
