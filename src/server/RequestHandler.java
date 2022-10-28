package server;


import java.io.*;
import java.net.Socket;

public class RequestHandler extends Thread {

    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream())
             )) {
            String request = reader.readLine();
            System.out.println("request " + request);
            String fileFormat = request.substring(4, request.indexOf(" HTTP"));
            String response= "Server answer " + ServerService.createHttp(fileFormat);



            writer.write(response);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
