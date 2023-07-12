package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import View.EmployeePN;
public class Server {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients = new ArrayList<>();
    private String name;
    EmployeePN empp = new EmployeePN();
    public static void main(String[] args) {
        Server server = new Server();
        server.initServer();
    }

    public void initServer() {
        try {
        	empp.setVisible(false);
        	
            serverSocket = new ServerSocket(1234);
            System.out.println("Server started...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected...");

                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        try {
            for (ClientHandler client : clients) {
                if (client != sender) {
                	
                	sender.setName(empp.getTfusernamemain().getText());
                    client.getWriter().write(sender.getName() + ": " + message);
                    client.getWriter().newLine();
                    client.getWriter().flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                name = reader.readLine();
                System.out.println(name + " has joined the chat.");

                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//                writer.write("Welcome to the chat, " + name + "!");
                writer.newLine();
                writer.flush();

                String message;
                while ((message = reader.readLine()) != null) {
                    broadcastMessage(message, this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                clients.remove(this);
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(name + " has left the chat.");
            }
        }

//        public String getName() {
//            return name;
//        }

        public BufferedWriter getWriter() {
            return writer;
        }
    }
}