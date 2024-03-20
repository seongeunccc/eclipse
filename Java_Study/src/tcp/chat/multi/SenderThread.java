package tcp.chat.multi;

import java.net.*;
import java.io.*;
class SenderThread extends Thread {
    Socket socket;
    String name;
    SenderThread(Socket socket, String name) { //생성자함수 : 소켓 번호 + 쓰레드 이름(여기서 입력받은건 args)
        this.socket = socket;		// 외부에서 받은 값 여기에 넣어줌.
        this.name = name;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //입력 버퍼 : InputStreamReader 를 BufferedReader 에 담음
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            //출력 버퍼 : getOutputStream 를 PrintWriter 에 담음.
            
            
	    // 제일 먼저 서버로 대화명 송신한다.
	    writer.println(name);
            writer.flush(); //내 이름 송신 후 버퍼 초기화 ?
           
	   // 키보드로 입력된 메시지를 서버로 송신 
	    while (true) {
                String str = reader.readLine(); 
                if (str.equals("bye")) // 바이 입력하면 종료하기
                    break;
                writer.println(str); // 바이가 아니라면 키보드로 입력한 값을 출력\
                writer.flush(); //송신 후 버퍼 초기화 ?
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage()); 		//예외처리
        }
        finally {
            try { 		// 소켓 닫기 구문
                socket.close(); 
            } 
            catch (Exception ignored) {
            }
        }
    }
}
