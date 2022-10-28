package client;


import static util.ContentType.*;

public class Client {
    public static void main(String[] args) {
        new Request(JSON).start();
        new Request(TEXT).start();
        new Request(JPG).start();

    }
}
