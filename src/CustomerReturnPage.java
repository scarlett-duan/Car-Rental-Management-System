import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.io.*;
public class CustomerReturnPage implements ActionListener {
	JDesktopPane desktop;
	JFrame mainwindow3;
	JLabel name_label;	
	JLabel Number_label;
	JLabel Rent_label;
	JLabel check_label;
	JTextField name_txt;
	JTextField Number_txt;
	JTextField Rent_txt;
	JTextField check_txt;
	JButton add_button;
	JButton update_button;
	JButton delete_button;
	JButton search_button;
	JButton clear_button;
	JButton next_button;
	JButton prev_button;
	JButton first_button;
	JButton last_button;
	JPanel pnlcrud, pnlnavig;
	JInternalFrame frame;
	public void CreateInterface(){
		JFrame mainwindow3=new JFrame("顾客归还登记");
		mainwindow3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainwindow3.setResizable(false);
		mainwindow3.setBounds(180, 40, 1000, 650); 
		mainwindow3.setLayout(null);
		Number_label=new JLabel("车牌号");
		Number_label.setBounds(100,50,60,30);
		Number_txt=new JTextField();
		Number_txt.setBounds(170,50,100,25);
		name_label=new JLabel("姓名");
		name_label.setBounds(330,50,60,30);
		name_txt=new JTextField();
		name_txt.setBounds(400,50,100,25);
		Rent_label=new JLabel("应缴费用");
		Rent_label.setBounds(530,50,60,30);
		Rent_txt=new JTextField();
		Rent_txt.setBounds(600, 50, 100, 25);
		check_label=new JLabel("缴费状态");
		check_label.setBounds(730,50,60,30);
		check_txt=new JTextField();
		check_txt.setBounds(800,50,100,25);
		pnlcrud = new JPanel();
		pnlcrud.setBounds(250, 110, 420, 60);
		pnlcrud.setBorder(BorderFactory.createTitledBorder("操作面板"));
		delete_button= new JButton("一键归还");
		delete_button.setBounds(280,140,80,30);
		delete_button.addActionListener(this);
		clear_button= new JButton("清空输入");
		clear_button.setBounds(460,140,80,30);
		clear_button.addActionListener(this);
		pnlcrud.add(delete_button);
		pnlcrud.add(clear_button);
		mainwindow3.add(pnlcrud);
		mainwindow3.add(name_label);
		mainwindow3.add(name_txt);
		mainwindow3.add(Number_label);
		mainwindow3.add(Number_txt);
		mainwindow3.add(Rent_label);
		mainwindow3.add(Rent_txt);
		mainwindow3.add(check_label);
		mainwindow3.add(check_txt);
		Container con = mainwindow3.getContentPane();
		Color color = new Color(174,213,213); 
		con.setBackground(color);
		mainwindow3.setVisible(true);
	    desktop = new JDesktopPane();   
	}
	public void actionPerformed(ActionEvent btnref) {
			if (btnref.getActionCommand() == "一键归还") {
			try{
				String[] a={};
			    int count=0;
			    File inputFile = new File("Customer.txt");
			    File tempFile = new File("TempCustomer.txt");
			    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			    String currentLine;
			    while((currentLine = reader.readLine()) != null) {
			    a= currentLine.split(" ");
			    String[] arr = currentLine.split("\\s+");
			    if(arr.length >= 2 && arr[0].equals(Number_txt.getText())) {
			    	count=1;
			    	arr[2]="0";
			    	arr[3]="已缴费";
			    	name_txt.setText(arr[1]);
			    	Rent_txt.setText(arr[2]);
			    	check_txt.setText(arr[3]);
				    for(int i =0; i<arr.length; i++){
				    	writer.write(arr[i]); // 向文件中写入数据
				    	writer.write(' '); // 空格分隔
				        }
				    writer.write('\n');
			    	JOptionPane.showMessageDialog(delete_button, "缴费成功!","TIPS",JOptionPane.WARNING_MESSAGE);
			    	continue;	
			    }
			    writer.write(currentLine + System.getProperty("line.separator")); 
			    }
			    writer.close(); 
			    reader.close(); 
			    inputFile.delete();
			    tempFile.renameTo(inputFile);
			    boolean successful = tempFile.renameTo(inputFile);
				if(count==0){
			    	JOptionPane.showMessageDialog(delete_button, "未找到呜呜呜","TIPS",JOptionPane.WARNING_MESSAGE);
			    }}
			    catch(IOException e1)
			    {
			    	e1.printStackTrace();
			    }
		}else if (btnref.getActionCommand() == "清空输入") {
			txtclear();
		}
	}

	private void txtclear() {
		name_txt.setText(" ");
		Number_txt.setText(" ");
		Rent_txt.setText(" ");
		check_txt.setText(" ");
	}
	public static void main(String[] args) {
		CustomerReturnPage obj=new CustomerReturnPage();
		obj.CreateInterface();
	}
}
