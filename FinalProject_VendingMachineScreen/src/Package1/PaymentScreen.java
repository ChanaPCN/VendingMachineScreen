package Package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentScreen extends JFrame implements  ActionListener {
	
	// JButton
	JButton BlankBt = new JButton() ;
	//CashButton
	JButton FiveBt = new JButton("5") ;
	JButton TenBt = new JButton("10") ;
	JButton TwentyBt = new JButton("20") ;
	JButton FiftyBt = new JButton("50") ;
	JButton HundredBt = new JButton("100") ;
	
	//InterfacePanel
	static  JPanel PaymentPanel = new JPanel() ;
	//InsidePaymentPanel
	JPanel InsidePanel = new JPanel() ;
	//InsideInsidePanel
	JPanel NorthOutputPanel = new JPanel() ;
	static JPanel SouthOutputPanel = new JPanel() ;
	//CashPaymentPanel
	JPanel CashButtonPanel = new JPanel() ;
	//UserIntScreen
	//JPanel UserIntScreen = new JPanel() ;
	//PaymentRemainPanel
	JPanel PaymentRemainPanel = new JPanel() ;
	//UserPaymentRemianInput
	JPanel UserPaymentInputPanel = new JPanel() ;
	//JLabel
	JLabel PaymentTxt = new JLabel("Payment",SwingConstants.CENTER) ;
	JLabel LatteImg256x = new JLabel("",SwingConstants.CENTER) ;
	JLabel ChocolateImg256x = new JLabel("",SwingConstants.CENTER) ;
	JLabel BubbleTeaImg256x = new JLabel("",SwingConstants.CENTER) ;
	JLabel TeaImg256x = new JLabel("",SwingConstants.CENTER) ;
	//MenuConfirmationLabel
//	JLabel LatteTxtCon = new JLabel("Latte",SwingConstants.CENTER) ;
//	JLabel ChocoTxtCon = new JLabel("Chocolate",SwingConstants.CENTER) ;
//	JLabel BubbleTeaTxtCon = new JLabel("BubbleTea",SwingConstants.CENTER) ;
//	JLabel TeaTxtCon = new JLabel("Tea",SwingConstants.CENTER) ;
	//TotalLabel
	JButton RemainPaytxt = new JButton("Remaining Payment") ;
	JLabel IconLab;
	PaymentGraphics paymentGraphics;
	//Price
	int UserPriceToPay ;
	double IntPriceToPay = (double)UserPriceToPay ;
	
	
	public PaymentScreen(int UserPriceToPay, ImageIcon menuIcon){
		super() ;
		paymentGraphics = new PaymentGraphics(menuIcon);
		this.UserPriceToPay=UserPriceToPay;
		FiveBt.addActionListener(this);
		TenBt.addActionListener(this);
		TwentyBt.addActionListener(this);
		FiftyBt.addActionListener(this);
		HundredBt.addActionListener(this);
	//	MenuBt.addActionListener(this);
		
		
		//this.setFocusable(true) ;
		//CashPanelSet
		CashButtonPanel.setLayout(new GridLayout(1,5));
		CashButtonPanel.add(FiveBt) ;
		CashButtonPanel.add(TenBt) ;
		CashButtonPanel.add(TwentyBt) ;
		CashButtonPanel.add(FiftyBt) ;
		CashButtonPanel.add(HundredBt) ;
		
		//SetIcon
		LatteImg256x.setIcon(new ImageIcon(getClass().getResource("Latte256x.png")));
		ChocolateImg256x.setIcon(new ImageIcon(getClass().getResource("Choco256x.png")));
		BubbleTeaImg256x.setIcon(new ImageIcon(getClass().getResource("BubbleTea256x.png")));
		TeaImg256x.setIcon(new ImageIcon(getClass().getResource("Tea256x.png")));
		
		//SetLayout (North,South)
		NorthOutputPanel.setLayout(new BorderLayout());
		IconLab = new JLabel(menuIcon) ;
		NorthOutputPanel.add(IconLab) ;
		
		SouthOutputPanel.setLayout(new BorderLayout());
		SouthOutputPanel.add((RemainPaytxt),BorderLayout.NORTH) ;
		SouthOutputPanel.add((paymentGraphics),BorderLayout.CENTER) ;
		SouthOutputPanel.add((CashButtonPanel),BorderLayout.SOUTH) ;
		
		//InsidePanel
		InsidePanel.setLayout(new GridLayout(2,1));
		InsidePanel.add(NorthOutputPanel) ;
		InsidePanel.add(SouthOutputPanel) ;
		
		//OutSidePanel
		PaymentPanel.setLayout(new BorderLayout());
		//North
		PaymentPanel.add((PaymentTxt),BorderLayout.NORTH) ;
		//Center
		PaymentPanel.add((InsidePanel),BorderLayout.CENTER) ;
		//South
		PaymentPanel.add((BlankBt),BorderLayout.SOUTH) ;
		add(PaymentPanel);
		setSize(600,900);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private class PaymentGraphics extends JPanel{
		
		ImageIcon ImageGet ;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.white);
			g.fillRoundRect(135, 135, 325, 100, 50, 50);
			g.setColor(Color.gray);
			g.fillArc(185, 90, 200, 200, 0, 360);
			g.setColor(Color.black);
			g.drawArc(185, 90, 200, 200, 0, 360);
			g.setColor(Color.gray);
			g.drawRoundRect(135, 135, 325, 100, 50, 50);
			g.setFont(new Font("Arial", Font.BOLD , 40));
			g.setColor(Color.white);
			g.drawString("Total : " + UserPriceToPay , 200, 200);
		}
		
		public PaymentGraphics(ImageIcon x) {
			this.ImageGet = ImageGet ;
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == FiveBt) {
			UserPriceToPay -= 5 ;
			repaint() ;
		}
		if (e.getSource() == TenBt) {
			UserPriceToPay -= 10 ;
			repaint() ;
		}
		if (e.getSource() == TwentyBt) {
			UserPriceToPay -= 20 ;
			repaint() ;
		}
		if (e.getSource() == FiftyBt) {
			UserPriceToPay -= 50 ;
			repaint() ;
		}
		if (e.getSource() == HundredBt) {
			UserPriceToPay -= 100 ;
			repaint() ;
		}
		if (UserPriceToPay <= 0) {
			new WaitingScreen() ;
			dispose() ;
			
		} 
		
	}
	
}
