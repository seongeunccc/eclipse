package Week2_Tue;

class Tv {
	boolean power ; //전원 on/off
	int channel ;
	
	void power() {
		power = !power;
	}
	void channelUp() {
		channel ++;
	}
	void channelDown() {
		channel --;
	}
}

class CaptionTv extends Tv{
	boolean caption;  //캡션 상태(on/off) ture = ON / False = OFF
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}
class ExtendTest01 {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello, World");
		ctv.caption = true;
		ctv.displayCaption("Hello, World");
	}
}
