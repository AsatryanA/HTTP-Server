package client;

import java.io.*;
import java.net.Socket;

public class Request extends Thread {
    private String fileFormat;

    public Request(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream())
             )) {
            socket.setSoTimeout(10000);
            System.out.println("Connected to server"+Thread.currentThread().getName());
            writer.write(ClientService.createHttp(fileFormat));
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Response : " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
