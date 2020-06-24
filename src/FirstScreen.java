import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class FirstScreen  {  //首页
	 JButton imagebutton1;
	 JLabel image1label;
	 JButton imagebutton2;
	 JLabel image2label;
	 JButton imagebutton3,returncar;
	 JLabel image3label;
	 JMenuBar menubar;
	 JMenu miscellaneous;
	 JMenuItem changepasswd;
	 JMenuItem logout;	
	public void CreateInterface(){		 
		JFrame mainwindow2=new JFrame("汽车租赁信息管理系统");
		mainwindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainwindow2.setBounds(140, 60, 1000, 650); 
		mainwindow2.setResizable(false);
		Container cntr=mainwindow2.getContentPane();
		cntr.setLayout(null);
		ImageIcon imageref = new ImageIcon("images/bg.jpg");
		JLabel imagehost = new JLabel(imageref);
		JPanel jp=new JPanel();
		jp.add(imagehost);
		jp.setBounds(0,0,1000,650);
		cntr.add(jp);
		imagebutton1=new JButton();//
		imagebutton1.setIcon(new ImageIcon("images/1.jpg"));
		imagebutton1.setBounds(150,220,150,150);
		imagebutton1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						VehicleInfoPage obj=new VehicleInfoPage();
						obj.CreateInterface();
					}
	});
		image1label=new JLabel("汽车信息");
		image1label.setFont(new Font("微软雅黑", 0, 18));
		image1label.setForeground(Color.DARK_GRAY);  
		image1label.setBounds(195,380,100,50);
		imagebutton2=new JButton();
		imagebutton2.setIcon(new ImageIcon("images/2.jpg"));
		imagebutton2.setBounds(400,220,150,150);
		imagebutton2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CustomerInfoPage obj=new CustomerInfoPage();
				obj.CreateInterface();
			}
});
		image2label=new JLabel("客户信息");
		image2label.setFont(new Font("微软雅黑", 0, 18));
		image2label.setBounds(445,380,100,50);  
		image2label.setForeground(Color.DARK_GRAY);
		imagebutton3=new JButton();
		imagebutton3.setIcon(new ImageIcon("images/3.jpg"));
		imagebutton3.setBounds(650,220,150,150);
		image3label=new JLabel("归还登记");
		image3label.setFont(new Font("微软雅黑", 0, 18));
		image3label.setBounds(700,380,100,50);
		image3label.setForeground(Color.DARK_GRAY);
		imagebutton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				CustomerReturnPage obj=new CustomerReturnPage();
				obj.CreateInterface();	
			}
});	
		cntr.add(imagebutton1);
		cntr.add(image1label);
		cntr.add(imagebutton2);
		cntr.add(image2label);
		cntr.add(imagebutton3);
		cntr.add(image3label);
		cntr.add(jp);
		mainwindow2.add(jp);
		mainwindow2.setVisible(true);	
	}
	public static void main(String[] args) {
		FirstScreen first_obj=new FirstScreen();
		first_obj.CreateInterface();
	}
}
