package Package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeScreen extends JPanel implements ActionListener{
	//Panel
	static JPanel HomeSCreenPn = new JPanel(new BorderLayout()) ;
	JButton ClickToStartBt = new JButton("Start Order") ;
	JFrame HomeFrame;

	public HomeScreen() {
		super() ;
		ClickToStartBt.addActionListener(this);
		this.setFocusable(true) ;
		HomeSCreenPn.add((ClickToStartBt),BorderLayout.CENTER) ;
		HomeFrame = new JFrame("Vending Machine Screen") ;
		HomeFrame.setLayout(new BorderLayout());
		HomeFrame.add(HomeSCreenPn) ;
		HomeFrame.setSize(600,900) ;
		HomeFrame.setLocationRelativeTo(null);
		HomeFrame.setVisible(true) ;
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	public static void main(String[] args) {
		HomeScreen testScreenHome = new HomeScreen() ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		if (e.getSource() == ClickToStartBt) {
			new MenuScreen() ;
			HomeFrame.dispose();
			
			
		}
	}
}
