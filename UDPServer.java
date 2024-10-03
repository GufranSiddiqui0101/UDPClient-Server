import java.io.*;
import java.net.*;
class UDPServer{
	public static void main(String[]args){
		try{
			DatagramSocket serverSocket=new DatagramSocket(9876);
			byte[] receiveData=new byte[1024];
			byte[] sendData=new byte[1024];
			while(true){
				DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
				serverSocket.receive(receivePacket);
				String data=new String(receivePacket.getData());
				InetAddress ip=receivePacket.getAddress();
				int port=receivePacket.getPort();
				sendData=data.toUpperCase().getBytes();
				DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,ip,port);
				serverSocket.send(sendPacket);
			}
		}catch(Exception e){
				e.printStackTrace();
		}
	}
}
