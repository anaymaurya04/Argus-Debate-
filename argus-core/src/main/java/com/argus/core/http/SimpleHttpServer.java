package com.argus.core.http;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/health", new HealthHandler());

        server.setExecutor(
                java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()
        );
        server.start();

        System.out.println("HTTP server started on port 8080");
    }

    static class HealthHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Thread t = Thread.currentThread();
            System.out.println(
                    "Handling request on thread: " + t +
                            ", isVirtual=" + t.isVirtual()
            );


            try {
                Thread.sleep(5000); // simulate slow processing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String response = "OK";

            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }

    }
}


