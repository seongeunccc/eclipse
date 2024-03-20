package tcp.chat.multi;

import java.io.*;
import java.net.*;
class ReceiverThread extends Thread {
    Socket socket;
    ReceiverThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //입력 버퍼 : getInputStream 을 담은 InputStreamReader 을 BufferedReader 에 담음
            while (true) {//무한 루프
		
		//서버로부터 수신된 메시지를 모니터로 출력
                String str = reader.readLine();
                if (str == null)
                    break;		 //서버에서 수신된게 널값이면 종료
                System.out.println(str); 
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
