import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
public class login{  
	JFrame mainwindow;
	JLabel username;
	JLabel passwd;
	JButton login_button;
	JTextField username_tf;
	JPasswordField passwd_tf;
	public void CreateInterface() {
		mainwindow = new JFrame();
		mainwindow.setTitle("汽车租赁信息管理系统");
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainwindow.setBounds(500, 100, 400, 220); 	
		mainwindow.setLayout(null);
		username=new JLabel("用户名");
		username.setFont(new Font("微软雅黑", 0, 16));
		username.setBounds(20,20,100,30);
		username_tf=new JTextField();
		username_tf.setBounds(140, 20, 150, 25);
		username_tf.setToolTipText("默认admin");
		passwd=new JLabel("密码");
		passwd.setFont(new Font("微软雅黑", 0, 16));
		passwd.setBounds(20,70,100,30);
		passwd_tf=new JPasswordField();
		passwd_tf.setBounds(140,70,150,25);
		passwd_tf.setToolTipText("默认root");
		login_button=new JButton("登录");
		login_button.setBounds(150,120,100,30);
		login_button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						String user=username_tf.getText().trim();   //get text will assign entered value to variable 'user'
						String pass=passwd_tf.getText().trim();
						if(user.equals("admin")&&pass.equals("root")) {
							FirstScreen obj=new FirstScreen();		
							obj.CreateInterface();	
							mainwindow.dispose();
						}
						else {
							JOptionPane.showMessageDialog(login_button,"请检查输入！", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
					}
	            }
				);
		mainwindow.add(username);
		mainwindow.add(username_tf);
		mainwindow.add(passwd);
		mainwindow.add(passwd_tf);
		mainwindow.add(login_button);
		Container con = mainwindow.getContentPane();
		Color color = new Color(174,213,213); 
		con.setBackground(color);
	    mainwindow.setVisible(true);
	}
	public static void main(String[] args){
		login loginobj=new login();
		loginobj.CreateInterface();
	}
}
