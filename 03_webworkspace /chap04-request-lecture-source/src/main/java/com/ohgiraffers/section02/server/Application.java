package com.ohgiraffers.section02.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

	public static void main(String[] args) throws IOException {
		
		//header값을 출력하는 간단한 웹서버를 만들어보자
		
		/* 요청을 해보면 총 3번의 요청이 들어오게 된다.
		 * 그 이유는 브라우저들이 favicon요청을 위해 request를 다시 한번 보내기 떄문이다.
		 * */
		ServerSocket listener = new ServerSocket(8002);
		
		int count = 1;
		
		try {
			System.out.println("Http Server started at 8802 port");
		
			while(true) {
				Socket socket = listener.accept();
				
				try {
					System.out.printf("New Client Connect! Connected IP : %s, port %d\n"
							,socket.getInetAddress(), socket.getPort());
					
					count++;
					
				
					System.out.println(count);
					InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream();
					
					
					int value = 0;
					while((value = in.read()) != -1 && count == 3){
						System.out.print((char) value);
					}
					
					String responseText = "<h1>Hello World</h1>";
					
					String responseGeneralheader = "HTTP/1.1 200 OK \r\n";
					String contentType = "Content-type: text/html; charset=utf-8\r\n";
					String contentLength = "Content-Length: "+ responseText.length() + "\r\n";
					String whiteLine = "\r\n";
					
					out.write(responseGeneralheader.getBytes());
					out.write(contentType.getBytes());
					out.write(contentLength.getBytes());
					out.write(whiteLine.getBytes());
					
					out.write(responseText.getBytes());
					out.write(whiteLine.getBytes());
					
				}catch(Exception e){
					e.printStackTrace();

				} finally {
					socket.close();
				}
			}
			
			
					
		} catch(Exception e){
			e.printStackTrace();

		} finally {
			listener.close();
		}
	}
	
}
