package Package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import Package2.*;

public class WaitingScreen extends JPanel implements  ActionListener {
	//Font
	Font font1 = new Font("Arial", Font.BOLD, 90) ;
	Font font2 = new Font("Arial", Font.BOLD, 50) ;
	Font font3 = new Font("Dialog", Font.BOLD, 25) ;
	
	// JButton
	JButton PreparingTxt = new JButton("We're prepairing your drink" ) ;
	//InterfacePanel
	JPanel PaymentPanel = new JPanel() ;
	//InsidePaymentPanel
	JPanel InsidePanel = new JPanel() ;
	//InsideInsidePanel
	JPanel NorthOutputPanel = new JPanel() ;
	JPanel SouthOutputPanel = new JPanel() ;
	//UserIntScreen
	JPanel UserIntScreen = new JPanel() ;
	//JLabel
	JLabel Bartender256x = new JLabel("",SwingConstants.CENTER) ;
	JLabel TimeRemianLebel = new JLabel("Time Remaining",SwingConstants.CENTER) ;
	
	JLabel CounterLabel = new JLabel("",SwingConstants.CENTER) ;
	Timer timer  = new Timer(1000, new CountdownTimerListener());
	int second ;
	int minute ;
	String ddSecond , ddMinute ;
	DecimalFormat dFormat = new DecimalFormat("00") ;
	JFrame f ;
	
	protected class CountdownTimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			second--;
			ddSecond = dFormat.format(second) ;
			ddMinute = dFormat.format(minute) ;
			CounterLabel.setText(ddMinute + ":" + ddSecond);
			
			if(second==-1) {
				second = 59 ;
				minute--;
				ddSecond = dFormat.format(second) ;
				ddMinute = dFormat.format(minute) ;
				CounterLabel.setText(ddMinute + ":" + ddSecond);
			}
			if(minute==0 && second==0) {
				timer.stop();
				new ServedScreen();
			}
		}
	}
	
	
	public WaitingScreen(){
		//SetIcon
		Bartender256x.setIcon(new ImageIcon(getClass().getResource("Bartender.256x.png")));
		
		//SetLayout (North,South)
		NorthOutputPanel.setLayout(new BorderLayout());
		SouthOutputPanel.setLayout(new BorderLayout());
		NorthOutputPanel.add(Bartender256x) ;
		SouthOutputPanel.add((UserIntScreen),BorderLayout.CENTER) ;
		UserIntScreen.setLayout(new GridLayout(2,1));
		TimeRemianLebel.setFont(font2) ;
		UserIntScreen.add(TimeRemianLebel) ;
		//CounterLabel
		CounterLabel.setFont(font1) ;
		UserIntScreen.add(CounterLabel) ;
		//InsidePanel
		InsidePanel.setLayout(new GridLayout(2,1));
		InsidePanel.add(NorthOutputPanel) ;
		InsidePanel.add(SouthOutputPanel) ;
		
		//OutSidePanel
		PaymentPanel.setLayout(new BorderLayout());
		//North
		//Center
		PaymentPanel.add((InsidePanel),BorderLayout.CENTER) ;
		//South
		PaymentPanel.add((PreparingTxt),BorderLayout.SOUTH) ;
		
		JFrame f = new JFrame("Waiting Screen") ;
		f.add(PaymentPanel) ;
		f.setSize(600,900) ;
		f.setLocationRelativeTo(null);
		f.setVisible(true) ;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CounterLabel.setText("00:10");
		second = 10 ;
		minute = 0 ;
		timer.start() ;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WaitingScreen() ;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(second == 0) {
			ServedScreen ServePn = new ServedScreen() ;
			f.dispose();
		}
	}
}
