package tcp.chat.multi;

import java.net.*;
class ServerExample4 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;  //서버 소켓 선언
        try {
            serverSocket = new ServerSocket(9002);		//서버소켓에 포트번호 9002 넣음.
            while (true) {
                Socket socket = serverSocket.accept();   //소켓 무한루프 돌리기.
                Thread thread = new PerClinetThread(socket);
                thread.start();  //스레드 시작
            }
        } 
        catch (Exception e) {  //예외처리. 오류발생시 메세지 띄움
            System.out.println(e.getMessage());
        }
    }
}
