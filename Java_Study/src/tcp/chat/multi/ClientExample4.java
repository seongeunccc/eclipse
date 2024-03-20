package tcp.chat.multi;

import java.net.*;
class ClientExample4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(		//args 에 데이터가 없다면 내용 출력
                "Usage: java ClientExample4 <user-name>");
            return;
        }
        try {
	    // 서버와 연결
            Socket socket = new Socket("192.168.0.92", 9002);  //여기 적어놓은 건 한일섭 과장님 ip / 접속할 ip만들면 됨.

             // 메시지 송신 쓰레드와 수신 쓰레드 생성해서 시작
            Thread thread1 = new SenderThread(socket, args[0]); //송신 쓰레드
            Thread thread2 = new ReceiverThread(socket);  //수신 쓰레드

            thread1.start();		//송수신 쓰레드 호출하고 start 하기
            thread2.start();		
        }
        catch (Exception e) {		//쓰레드 사용하기 위한 예외처리 구문
            System.out.println(e.getMessage());
        }
    }
}
