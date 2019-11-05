package unit;
import java.io.*;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Word2Vec extends UnitSimMeasure
{
    private String compOne;
    private String compTwo;
    private static Socket socket;
    public Word2Vec()
    {
    	name="Word2Vec";
    }
    public double getSim(String st1, String st2){
		double ret = 0.000001;

		try
        {
            String host = "localhost";
            int port = 10004;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
 
            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
 
            String sendMessage = st1 + "," + st2;
            bw.write(sendMessage);
            bw.flush();

            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

			BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            //System.out.println("Message received from the server : " +message);
			
			ret = Double.parseDouble(message);
			//System.out.println(ret);
        }
        catch (Exception exception)
        {
			System.out.println("Word2Vec server is not started");
			System.exit(1);
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
		return ret;
	}
    public double getSimilarity(String compOne, String compTwo)
    {   
		return getSim(compOne,compTwo);
    }
}
