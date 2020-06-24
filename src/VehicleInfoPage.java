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
public class VehicleInfoPage implements ActionListener {
	JDesktopPane desktop;
	JFrame mainwindow3;
	JLabel brand_label;	
	JLabel carmodel_label;
	JLabel number_label;
	JLabel rent_label;
	JTextField brand_txt;
	JTextField carmodel_txt;
	JTextField number_txt;
	JTextField rent_txt;
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
		JFrame mainwindow3=new JFrame("汽车信息管理界面");
		mainwindow3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainwindow3.setResizable(false);
		mainwindow3.setBounds(180, 40, 1000, 650); 
		mainwindow3.setLayout(null);
		number_label=new JLabel("车牌号");
		number_label.setBounds(100,50,60,30);	
		number_txt=new JTextField();
		number_txt.setBounds(170,50,100,25);
		carmodel_label=new JLabel("汽车型号");
		carmodel_label.setBounds(330,50,60,30);
		carmodel_txt=new JTextField();
		carmodel_txt.setBounds(400,50,100,25);
		brand_label=new JLabel("品牌");
		brand_label.setBounds(530,50,60,30);
		brand_txt=new JTextField();
		brand_txt.setBounds(600, 50, 100, 25);
		rent_label=new JLabel("费用/day");
		rent_label.setBounds(730,50,60,30);
		rent_txt=new JTextField();
		rent_txt.setBounds(800,50,100,25);
		pnlcrud = new JPanel();
		pnlcrud.setBounds(250, 110, 420, 60);      
		pnlcrud.setBorder(BorderFactory.createDashedBorder(Color.RED));
		pnlcrud.setBorder(BorderFactory.createTitledBorder("操作面板"));
		add_button = new JButton("添加");
		add_button.setBounds(100,140,80,30);
		add_button.addActionListener(this);
		update_button = new JButton("更改");
		update_button.setBounds(190,140,80,30);
		update_button.addActionListener(this);
		delete_button= new JButton("删除");
		delete_button.setBounds(280,140,80,30);
		delete_button.addActionListener(this);
		search_button= new JButton("查找");
		search_button.setBounds(370,140,80,30);
		search_button.addActionListener(this);
		clear_button= new JButton("清空");
		clear_button.setBounds(460,140,80,30);
		clear_button.addActionListener(this);
	    pnlcrud.add(add_button);
		pnlcrud.add(update_button);
		pnlcrud.add(delete_button);
		pnlcrud.add(search_button);
		pnlcrud.add(clear_button);
		mainwindow3.add(pnlcrud);

		mainwindow3.add(brand_label);
		mainwindow3.add(brand_txt);
		mainwindow3.add(carmodel_label);
		mainwindow3.add(carmodel_txt);
		mainwindow3.add(number_label);
		mainwindow3.add(number_txt);
		mainwindow3.add(rent_label);
		mainwindow3.add(rent_txt);
		Container con = mainwindow3.getContentPane();
		Color color = new Color(174,213,213); 
		con.setBackground(color);
		mainwindow3.setVisible(true);
	    desktop = new JDesktopPane();   
   				
	}
	@Override
	public void actionPerformed(ActionEvent btnref) {

		if (btnref.getActionCommand() == "添加") {  
				try {
					String brand=(String) brand_txt.getText();
					String carmodel=(String) carmodel_txt.getText();
					String number=(String) number_txt.getText();
					String rent = (String) rent_txt.getText();
					String[] str = {number,carmodel,brand,rent};
					FileWriter w=new FileWriter("Car.txt",true); //true追加模式
			        FileReader r=new FileReader("Car.txt");
			        BufferedWriter out=new BufferedWriter(w);
			        BufferedReader in=new BufferedReader(r);
			        for(int i =0; i<str.length; i++){
			        	out.write(str[i]); //向文件中写入数据
			        	out.write(' '); // 空格分隔
			        	}
			        out.write('\n');
					out.close();
					in.close();
		            JOptionPane.showMessageDialog(add_button, "录入成功！","TIPS",JOptionPane.WARNING_MESSAGE);
				} catch (Exception e1) {
					 e1.printStackTrace();
				}
		} else if (btnref.getActionCommand() == "更改") {
			try{
				String[] a={};
			    int count=0;
			    File inputFile = new File("Car.txt");
			    File tempFile = new File("TempCar.txt");
			    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			    String currentLine;
			    while((currentLine = reader.readLine()) != null) {
			    a= currentLine.split(" ");
			    String[] arr = currentLine.split("\\s+");
			    if(arr.length >= 2 && arr[0].equals(number_txt.getText())) {
			    	count=1;
			    	if(carmodel_txt.getText().length()!=0) {
			    		arr[1]=(String) carmodel_txt.getText();}
				    if(brand_txt.getText().length()!=0) {
				    	arr[2]=(String) brand_txt.getText();}
				    if(rent_txt.getText().length()!=0) {
				    	arr[3]=(String) rent_txt.getText();}
				    for(int i =0; i<arr.length; i++){
				    	writer.write(arr[i]); // 向文件中写入数据
				    	writer.write(' '); // 空格分隔
				        }
				    writer.write('\n');
			    	JOptionPane.showMessageDialog(delete_button, "更改成功!","TIPS",JOptionPane.WARNING_MESSAGE);
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
		} else if (btnref.getActionCommand() == "删除") {
			try{
			    String[] a={};
			    int count=0;
			    File inputFile = new File("Car.txt");
			    File tempFile = new File("TempCar.txt");
			    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			    String currentLine;
			    while((currentLine = reader.readLine()) != null) {
			    a= currentLine.split(" ");
			    String[] arr = currentLine.split("\\s+");
			    if(arr.length >= 2 && arr[0].equals(number_txt.getText())) {
			    	count=1;
			    	JOptionPane.showMessageDialog(delete_button, "删除成功!","TIPS",JOptionPane.WARNING_MESSAGE);
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
		} else if (btnref.getActionCommand() == "查找") {
			try{
		    FileReader fr=new FileReader("Car.txt");
		    BufferedReader br=new BufferedReader(fr);
		    String[] a={};
		    String line= br.readLine();
		    int count=0;
			while(line != null){
		    a= line.split(" ");
		    String[] arr = line.split("\\s+");
		    if(arr.length >= 2 && arr[0].equals(number_txt.getText())) {
		    	count=1;
		    	carmodel_txt.setText(arr[1]);
		    	brand_txt.setText(arr[2]);
		    	rent_txt.setText(arr[3]);
		    }
			line = br.readLine();  
		    }
			br.close();
			if(count==0){
		    	JOptionPane.showMessageDialog(search_button, "未找到呜呜呜","TIPS",JOptionPane.WARNING_MESSAGE);
		    }}
		    catch(IOException e1)
		    {
		    	e1.printStackTrace();
		    }
		} else if (btnref.getActionCommand() == "清空") {
			txtclear();
		}
	}
	public void FillTextBoxes() {
		 
	}
	private void txtclear() {
		brand_txt.setText("");
		carmodel_txt.setText("");
		number_txt.setText("");
		rent_txt.setText("");
	}
	public static void main(String[] args)
	{
		VehicleInfoPage obj=new VehicleInfoPage();
		obj.CreateInterface();
	}
}
