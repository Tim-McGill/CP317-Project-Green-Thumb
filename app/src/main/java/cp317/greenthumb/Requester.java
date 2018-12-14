package cp317.greenthumb;
import android.graphics.Bitmap;
import android.util.Base64;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Random;

/*
public interface RequesterCalls{
        //public default void createUse
        public void getBGPhoto();
        public void getPhotoReports();
        public void getPlantByImage();
        public void getPlantByQuery();
        public void getUser();
        public void handlePhotoReport();
        public void reportPhoto();
        public void uploadPhoto();
        public void votePhoto();
}
*/
public class Requester {
    //
    static String apiBaseUrl="http://04456f4e.ngrok.io/";
    //HttpClient client = HttpClients.createDefault();


    // calls
    public static void createUser(int userId) throws IOException {
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/user/add").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        String output ="{ userId:"+userId+" }";
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();

        os.write(outputBytes);
        os.close();
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);
        FEUser user = new FEUser(userId,0);


        //Map<String,Object> map = user.readValue(json, Map.class);


        in.close();
        httpcon.disconnect();
    }
    public String getBGPhoto() throws IOException {
        Random rand = new Random();
        int photoId = rand.nextInt(5)+1;
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/photo/byId").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        String output ="{ photoId:"+photoId+" }";
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();
        os.write(outputBytes);
        os.close();
        //get photo info
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        httpcon.disconnect();
        String url=response.toString();
        return url;
    }
    // this isn't used in the andriod one
    public void getPhotoReports(int adminId) throws IOException{
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/photoReports/get").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        String output ="{ adminId:"+adminId+" }";
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();
        os.write(outputBytes);
        os.close();
        //get photo report info
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        // convert to jason and build objects


        //
        httpcon.disconnect();
    }
    //Send image to backend to be processed
    public void getPlantByImage(String imageName)throws IOException{
        int imageWidth=0,imageHeight=0;
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/plants/byImage").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        //get bitmap
        //Bitmap image=(Bitmap) intent.getParcelableExtra(imageName);//need to fix
        //base 64 enocde
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String output ="{B64image:{ image:+image+,width:"+imageWidth+",height:"+imageHeight+"}}";
        //send output
        byte[] outputBytes = output.getBytes("UTF-8");
        OutputStream os = httpcon.getOutputStream();
        os.write(outputBytes);
        os.close();
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        // convert to jason and build objects
        httpcon.disconnect();
    }
    public void getPlantByQuery(String query) throws IOException {
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/plants/byQuery").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        String output ="{query:"+query+"}";
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();
        os.write(outputBytes);
        os.close();
        //get photo report info
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        // convert to jason and build objects


        //
        httpcon.disconnect();
    }
    public void getUser(int userId)throws IOException{
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/user/byId").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        //need to fix format of this
        String output ="{userId:"+userId+"}";
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();

        os.write(outputBytes);
        os.close();
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        httpcon.disconnect();
    }
    public void handlePhotoReport(int adminId,int photoreportId, AdminAction adminAction )throws IOException{
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/photoReports/handle").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        //need to fix format of this
        String output = "{ adminAction:"+adminAction+", adminId:"+adminId+", photoReportId:"+photoreportId+" }";
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();

        os.write(outputBytes);
        os.close();
        //no responce
        httpcon.disconnect();
    }
    public void reportPhoto(int userId,int photoId, String reportText)throws IOException{
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/photoReports/add").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        //need to fix format of this
        String output ="{ photoId:"+photoId+", reportText:"+reportText+", userId:"+userId+"}";
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();

        os.write(outputBytes);
        os.close();
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        httpcon.disconnect();
    }
    //Need to fix photo catch retrievle
    public void uploadPhoto(int userId,int photoId,int plantId)throws IOException{
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/photo/add").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        //need to fix format of this
        //format"".getBytes("UTF-8");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
        String output ="{ image:"+encoded+", plantId:"+plantId+", userId:"+userId+"}";
        //send output
        byte[] outputBytes = output.getBytes("UTF-8");
        OutputStream os = httpcon.getOutputStream();
        os.write(outputBytes);
        os.close();
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        // convert to jason and build objects
        httpcon.disconnect();
    }
    //no known endoint for this
    public void votePhoto(int userId, int photoId, Boolean up)throws IOException{
        //open http connection
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiBaseUrl+"/photos/vote").openConnection()));
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        /*
         * Output user credentials over HTTP Output Stream
         */
        //need to fix format of this
        String output ="{ userId:"+userId+", plantId:"+photoId+", Boolean:"+up+"}";
        //send output
        byte[] outputBytes = output.getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();

        os.write(outputBytes);
        os.close();
        //get responce
        InputStream is= httpcon.getInputStream();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();
        httpcon.disconnect();
    }
}
