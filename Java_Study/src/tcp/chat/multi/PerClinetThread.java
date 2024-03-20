// 각 클라이언트 접속에 대해 하나씩 작동하는 스레드 클래스 

package tcp.chat.multi;

import java.io.*;
import java.net.*;
import java.util.*;
class PerClinetThread extends Thread {
	
    // ArrayList 객체를 여러 스레드가 안전하게 공유할 수 있는 동기화된 리스트로 만듭니다.
    static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
    //Collections.synchronizedList = 동기화 
    

    Socket socket;	//클라이언트 소켓
    PrintWriter writer;  //데이터 출력 클래스
    PerClinetThread(Socket socket) {   //생성자 함수
        this.socket= socket; //PerClinetThread를 호출한 소켓 번호를 받음
        try {
            writer = new PrintWriter(socket.getOutputStream()); 
            //outputStream 에서 받은 값을 PrintWriter로 한번 더 씌워서 writer에 저장
            list.add(writer);  //arraylist  에 writer 값 저장 후 접속한 클라이언트 모두에게 전송
        }
        catch (Exception e) {		//스레드 사용을 위한 예외처리
            System.out.println(e.getMessage());
        }
    }
    public void run() {
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));  //소켓에서 받아온 값을 스트림리더에 넣고 버퍼로 감쌈.
	    
            // 수신된 첫번째 문자열을 대화명으로 사용하기 위해 저장
            name = reader.readLine();         
            //args를 사용하기 위한 부분임. 프로그램을 시작할 때 사용자가 값을 넘겨줄 때 args 사용한다고 함.
            //처음 값을 넣어 준 개수에 따라 args가 배열로 생성된다. 
            sendAll("#" + name + "님이 들어오셨습니다");
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                sendAll(name + ">" + str);  // 수신된 메시지 앞에 대화명을 붙여서 모든 클라이언트로 송신
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage()); //예외 발생시 오류발생 메세지 출력
        }
        finally {				//프로그램 오류가 걸리더라도 프로그램 종료 전 실행될 구문 (종료 : 소켓 닫기)
            list.remove(writer);
            sendAll("#" + name + "님이 나가셨습니다"); // 사용자가 채팅을 종료했다는 메시지를 모든 클라이언트로 보냅니다.
            try {
                socket.close(); //(종료 : 소켓 닫기)
            }
            catch (Exception ignored) {
            }
        }
    }
	
    
    // 서버에 연결되어 있는 모든 클라이언트로 똑같은 메시지를 보냅니다.
    private void sendAll(String str) {  //입력 받은 메세지
        for (PrintWriter writer : list) {
            writer.println(str);
            writer.flush();  // flush : 버퍼에 있는 모든 것을 내보냄.
        }
    }
}
