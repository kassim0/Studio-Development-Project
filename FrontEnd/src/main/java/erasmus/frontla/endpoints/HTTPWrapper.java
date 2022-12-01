package erasmus.frontla.endpoints;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class HTTPWrapper {
    //"http://localhost:8081/Preguntas/Correspondencia"

    // typeRequest --> POST GET PUT DELETE
    public static String SetRequestWithBody(String link, String typeRequest, String body) throws IOException {

        String responseBack = "";

        URL url = new URL (link);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod(typeRequest);
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = body.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            responseBack = response.toString();
        }

        return responseBack;
    }

    // typeRequest --> POST GET PUT DELETE
    public static String SetRequest(String link, String typeRequest) throws IOException {

        String responseBack = "";

        URL url = new URL (link);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod(typeRequest);
        con.connect();
        System.out.println("OEEEK");

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("ODSFK");
            responseBack = response.toString();
        }

        return responseBack;
    }

}
