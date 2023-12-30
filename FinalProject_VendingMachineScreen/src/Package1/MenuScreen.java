package Package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JPanel implements  ActionListener  {
	// Center Panel
	JPanel MenuListPn = new JPanel() ;
	JPanel MenuSelection = new JPanel() ;
	// LattePanel
	JPanel LatteMenuPanel = new JPanel() ;
	JPanel LatteHotColdPanel = new JPanel() ;
	// ChocolatePanel
	JPanel ChocolateMenuPanel = new JPanel() ;
	JPanel ChocolateHotColdPanel = new JPanel() ;
	// BubbleTeaPanel
	JPanel BubbleTeaMenuPanel = new JPanel() ;
	JPanel BubbleTeaHotColdPanel = new JPanel() ;
	// TeaPanel
	JPanel TeaMenuPanel = new JPanel() ;
	JPanel TeaHotColdPanel = new JPanel() ;
	
	
	/////////////////////////////////////////////////// MenuBt
	// Latte
	JLabel LatteTxt = new JLabel("Latte ( 35 Baht )",SwingConstants.CENTER) ;
	JButton LatteHotBt = new JButton("Hot") ;
	JButton LatteColdBt = new JButton("Cold") ;
	// Chocolate
	JLabel ChocoTxt = new JLabel("Chocolate ( 40 Baht )",SwingConstants.CENTER) ;
	JButton ChocHotBt = new JButton("Hot") ;
	JButton ChocColdBt = new JButton("Cold") ;
	// Bubble Tea
	JLabel BubbleTeaTxt = new JLabel("Bubble Tea ( 50 Baht )",SwingConstants.CENTER) ;
	JButton BubbleTeaHotBt = new JButton("Hot") ;
	JButton BubbleTeaColdBt = new JButton("Cold") ;
	// Tea
	JLabel TeaTxt = new JLabel("Tea ( 20 Baht )",SwingConstants.CENTER) ;
	JButton TeaHotBt = new JButton("Hot") ;
	JButton TeaColdBt = new JButton("Cold") ;
	
	//South Panel
	JPanel MenuScreenPanel = new JPanel() ;
	//JButton
	JButton HomeBt = new JButton("Home")	;
	//JLabel
	JLabel LattePic = new JLabel() ;
	JLabel MenuTxt = new JLabel("Menu",SwingConstants.CENTER) ;
	JLabel LatteImg = new JLabel("",SwingConstants.CENTER) ;
	JLabel ChocolateImg = new JLabel("",SwingConstants.CENTER) ;
	JLabel BubbleTeaImg = new JLabel("",SwingConstants.CENTER) ;
	JLabel TeaImg = new JLabel("",SwingConstants.CENTER) ;
	//MenuLabel
	JFrame f ;
	
	int UserPriceToPay = 0 ;
	
		
public MenuScreen(){
	super() ;
	HomeBt.addActionListener(this);
	LatteHotBt.addActionListener(this);
	LatteColdBt.addActionListener(this);
	ChocHotBt.addActionListener(this);
	ChocColdBt.addActionListener(this);
	BubbleTeaHotBt.addActionListener(this);
	BubbleTeaColdBt.addActionListener(this);
	TeaHotBt.addActionListener(this);
	TeaColdBt.addActionListener(this);
	this.setFocusable(true) ;
	
	//SetIcon
	LatteImg.setIcon(new ImageIcon(getClass().getResource("latte128x.png")));
	ChocolateImg.setIcon(new ImageIcon(getClass().getResource("choco128x.png")));
	BubbleTeaImg.setIcon(new ImageIcon(getClass().getResource("bbtea128x.png")));
	TeaImg.setIcon(new ImageIcon(getClass().getResource("tea128x.png")));

	// LattePanel
	LatteMenuPanel.setLayout(new BorderLayout());
	LatteMenuPanel.add((LatteTxt),BorderLayout.NORTH) ;
	LatteMenuPanel.add((LatteHotColdPanel),BorderLayout.CENTER) ;
	LatteHotColdPanel.setLayout(new GridLayout(1,2));
	LatteHotColdPanel.add(LatteHotBt) ;
	LatteHotColdPanel.add(LatteColdBt) ;
	
	// ChocolatePanel
	ChocolateMenuPanel.setLayout(new BorderLayout());
	ChocolateMenuPanel.add((ChocoTxt),BorderLayout.NORTH) ;
	ChocolateMenuPanel.add((ChocolateHotColdPanel),BorderLayout.CENTER) ;
	ChocolateHotColdPanel.setLayout(new GridLayout(1,2));
	ChocolateHotColdPanel.add(ChocHotBt) ;
	ChocolateHotColdPanel.add(ChocColdBt) ;
	
	// BubbleTeaPanel
	BubbleTeaMenuPanel.setLayout(new BorderLayout());
	BubbleTeaMenuPanel.add((BubbleTeaTxt),BorderLayout.NORTH) ;
	BubbleTeaMenuPanel.add((BubbleTeaHotColdPanel),BorderLayout.CENTER) ;
	BubbleTeaHotColdPanel.setLayout(new GridLayout(1,2));
	BubbleTeaHotColdPanel.add(BubbleTeaHotBt) ;
	BubbleTeaHotColdPanel.add(BubbleTeaColdBt) ;
	
	// TeaPanel
	TeaMenuPanel.setLayout(new BorderLayout());
	TeaMenuPanel.add((TeaTxt),BorderLayout.NORTH) ;
	TeaMenuPanel.add((TeaHotColdPanel),BorderLayout.CENTER) ;
	TeaHotColdPanel.setLayout(new GridLayout(1,2));
	TeaHotColdPanel.add(TeaHotBt) ;
	TeaHotColdPanel.add(TeaColdBt) ;
	
	//////////////Center//////////////////
	MenuSelection.setLayout(new GridLayout(4,2));
	MenuSelection.add(LatteImg) ;
	MenuSelection.add(ChocolateImg) ;
	MenuSelection.add(LatteMenuPanel) ;
	MenuSelection.add(ChocolateMenuPanel) ;
	MenuSelection.add(BubbleTeaImg) ;
	MenuSelection.add(TeaImg) ;
	MenuSelection.add(BubbleTeaMenuPanel) ;
	MenuSelection.add(TeaMenuPanel) ;
	//MenuSelection.add(TeaBt) ;
	
	//////////////South///////////////////
	MenuScreenPanel.setLayout(new BorderLayout());
	MenuScreenPanel.add((MenuTxt),BorderLayout.NORTH) ;
	MenuScreenPanel.add((MenuSelection),BorderLayout.CENTER) ;
	MenuScreenPanel.add((HomeBt),BorderLayout.SOUTH) ;
	
	//////////////JFrame
	f = new JFrame("Vending Machine Screen") ;
	f.add(MenuScreenPanel) ;
	f.setSize(600,900) ;
	f.setLocationRelativeTo(null);
	f.setVisible(true) ;
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	if (e.getSource() == HomeBt) {
		new HomeScreen()	;
		f.dispose();
	}
	
	if (e.getSource() == LatteHotBt) {
			UserPriceToPay += 35 * Math.sqrt(1) ;
			PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)LatteImg.getIcon());
			f.dispose();
			
		}
	
	if (e.getSource() == LatteColdBt) {
			UserPriceToPay += 35 * Math.sqrt(1) ;
			PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)LatteImg.getIcon());
			f.dispose();
			
		}

	if (e.getSource() == ChocHotBt) {
			UserPriceToPay += 40 * Math.sqrt(1) ;
			PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)ChocolateImg.getIcon());
			f.dispose();
			
		}
	
	if (e.getSource() == ChocColdBt) {
		UserPriceToPay += 40 * Math.sqrt(1) ;
		PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)ChocolateImg.getIcon());
		f.dispose();
		
		}
	
	if (e.getSource() == BubbleTeaHotBt) {
		UserPriceToPay += 50 * Math.sqrt(1) ;
		PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)BubbleTeaImg.getIcon());
		f.dispose();
		
		}
	
	if (e.getSource() == BubbleTeaColdBt) {
		UserPriceToPay += 50 * Math.sqrt(1) ;
		PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)BubbleTeaImg.getIcon());
		f.dispose();
		
		}
	
	if (e.getSource() == TeaHotBt) {
		UserPriceToPay += 20 * Math.sqrt(1) ;
		PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)TeaImg.getIcon());
		f.dispose();
		
		}
	
	if (e.getSource() == TeaColdBt) {
		UserPriceToPay += 20 * Math.sqrt(1) ;
		PaymentScreen pn = new PaymentScreen(UserPriceToPay, (ImageIcon)TeaImg.getIcon());
		f.dispose();
		
		}
		
	}
		

	public static void main(String[] args) {
		new MenuScreen() ;

		
	}

}



