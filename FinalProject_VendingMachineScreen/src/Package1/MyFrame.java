package Package1;
import java.awt.BorderLayout;
import javax.swing.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		this("My Frame") ;
		
	}
	
	public MyFrame(String x) {
		super(x) ;
		setLayout(new BorderLayout()) ;
	}
}
