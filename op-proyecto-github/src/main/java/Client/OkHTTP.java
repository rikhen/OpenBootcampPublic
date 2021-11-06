package Client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;

public class OkHTTP {

    // ATTRIBUTES
    private Request request;
    private Response response;
    private String mediatype;
    private String url;

    private Authentication auth = new Authentication();

    // CONSTRUCTORS
    public OkHTTP() {};

    // METHODS
    /**
     * Método que envía una petición con los parámetros GitHub dados
     * @return Request objeto de la petición
     */
    public Request sendRequest() throws IOException, InterruptedException {
        try {
            request = new Request.Builder()
                    .header("Authorization", auth.authenticate())
                    .header("accept", getMediatype())
                    .url(getUrl())
                    .build();
        } catch (Exception e) {
            System.out.println(request.body());
            e.printStackTrace();
        }
        return request;
    }

    /**
     * Método que lee la respuesta del cliente
     * @param request objeto de la petición
     * @return mensaje recibido de la petición
     */
    public String getResponse(Request request) throws IOException {
        OkHttpClient client = new OkHttpClient();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println(response.body());
            e.printStackTrace();
        }
        return response.body().string();
    }

    // GETTER & SETTER
    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
