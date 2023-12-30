package Package2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import Package1.*;

public class ServedScreen extends MyFrame implements  ActionListener, ItemListener, MouseMotionListener{
	//Font
	Font font1 = new Font("Arial", Font.BOLD, 90) ;
	Font font2 = new Font("Arial", Font.BOLD, 50) ;
	Font font3 = new Font("Dialog", Font.BOLD, 25) ;
	
	// JButton
	JLabel ExitLabel = new JLabel("Exit",SwingConstants.CENTER) ;
	JButton TestBt2 = new JButton("Test2") ;
	//InterfacePanel
	JPanel PaymentPanel = new JPanel() ;
	//InsidePaymentPanel
	JPanel InsidePanel = new JPanel() ;
	//InsideInsidePanel
	JPanel NorthOutputPanel = new JPanel() ;
	JPanel SouthOutputPanel = new JPanel() ;
	//MembershipPanel
		//JLabel
		JPanel MemberRegist = new JPanel() ;
		JLabel MembershipLabel = new JLabel("Membership ID",SwingConstants.CENTER);
		JTextField GetPhoneNum = new JTextField("",20);
		String MemberID = GetPhoneNum.getText() ;
		JRadioButton FirstRegisCheck = new JRadioButton("First Time Register");
		JRadioButton AlreadyRegisCheck = new JRadioButton("Already Registerd");
		
	//MousePlaceHome
		int x = 100 ;
		int y = 100 ;
		
	//UserIntScreen
	JPanel UserIntScreen = new JPanel() ;
	//PaymentRemainPanel
	JPanel PaymentRemainPanel = new JPanel() ;
	//UserPaymentRemianInput
	JPanel UserPaymentInputPanel = new JPanel() ;
	JLabel CafeImg256x = new JLabel("",SwingConstants.CENTER) ;
	//OrderReady
	JLabel FinishOrderLebel = new JLabel("Your order is ready",SwingConstants.CENTER) ;
	
	JLabel CounterLabel = new JLabel("",SwingConstants.CENTER) ;
	Timer timer ;
	int second ;
	int minute ;
	String ddSecond , ddMinute ;
	
	DecimalFormat dFormat = new DecimalFormat("00") ;
	
	
	public ServedScreen(){
		super("ServedScreen") ;
		GetPhoneNum.addActionListener(this);
		FirstRegisCheck.addItemListener(this);
		AlreadyRegisCheck.addItemListener(this);
		this.addMouseMotionListener(this) ;
		
		//SetIcon
		CafeImg256x.setIcon(new ImageIcon(getClass().getResource("Cafe256x.png")));
		
		//SetLayout (North,South)
		NorthOutputPanel.setLayout(new BorderLayout());
		SouthOutputPanel.setLayout(new BorderLayout());
		NorthOutputPanel.add(CafeImg256x) ;
		//NorthOutputPanel.add((LatteTxtCon),BorderLayout.SOUTH) ;
		//SouthOutputPanel.add((RemainTimetxt),BorderLayout.NORTH) ;
		SouthOutputPanel.add((UserIntScreen),BorderLayout.CENTER) ;
		UserIntScreen.setLayout(new GridLayout(2,1));
		FinishOrderLebel.setFont(font2) ;
		UserIntScreen.add(FinishOrderLebel) ;
		//CounterLabel
		CounterLabel.setFont(font1) ;
		UserIntScreen.add(CounterLabel) ;
		SouthOutputPanel.add((MemberRegist),BorderLayout.SOUTH) ;
		
		//InsidePanel
		InsidePanel.setLayout(new GridLayout(2,1));
		InsidePanel.add(NorthOutputPanel) ;
		InsidePanel.add(SouthOutputPanel) ;
		
		//OutSidePanel
		PaymentPanel.setLayout(new BorderLayout());
		PaymentPanel.add((ExitLabel),BorderLayout.NORTH) ;
		//Center
		PaymentPanel.add((InsidePanel),BorderLayout.CENTER) ;
		//South
		PaymentPanel.add((MemberRegist),BorderLayout.SOUTH) ;
		MemberRegist.setLayout(new GridLayout(1,4));
		MemberRegist.add(MembershipLabel) ;
		MemberRegist.add(FirstRegisCheck);
		MemberRegist.add(AlreadyRegisCheck);
		MemberRegist.add(GetPhoneNum) ;
		
		add(PaymentPanel) ;
		setSize(600,900) ;
		setLocationRelativeTo(null);
		setVisible(true) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServedScreen() ;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == GetPhoneNum) {
			GetPhoneNum.setForeground(Color.green);
			MemberID = e.getActionCommand() ;
			String PhoneString = MemberID ; 
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == FirstRegisCheck) {
			AlreadyRegisCheck.setSelected(false);
			GetPhoneNum.setForeground(Color.red);
			
		}
		if(e.getSource() == AlreadyRegisCheck) {
			FirstRegisCheck.setSelected(false);
			GetPhoneNum.setForeground(Color.black);
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX() ;
		y = e.getY();
		//System.out.println("X :"+x+ " Y : "+y) ; //Check XY
		if(y < 38 && x < 301) {
			new HomeScreen() ;
			System.exit(0);
		
	}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}}

