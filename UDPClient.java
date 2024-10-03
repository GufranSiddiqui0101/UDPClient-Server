import java.io.*;
import java.net.*;
class UDPClient{
	public static void main(String[]args){
		try{
			BufferedReader bri=new BufferedReader(new InputStreamReader(System.in));
			DatagramSocket clientSocket=new DatagramSocket();
			InetAddress ip=InetAddress.getByName("localhost");
			byte[] sendData=new byte[1024];
			byte[] receiveData=new byte[1024];
			String data=bri.readLine();
			sendData=data.getBytes();
			DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,ip,9876);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
			clientSocket.receive(receivePacket);
			System.out.println("Server says:"+new String(receivePacket.getData()));
			clientSocket.close();
		}catch(Exception e){
				e.printStackTrace();
		}
	}
}
