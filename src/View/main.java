package View;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MainPageView v = new MainPageView();
         v.setVisible(true);
         Thread t = new Thread(v);
         t.start();
	}

}
