package count;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class Windows extends JFrame implements ActionListener{
	JTextField textField=new JTextField();
	JTextArea taContent=new JTextArea(10,10);//记录框
	JButton button=new JButton("确定");//确定按钮
	JLabel text1=new JLabel("随机出题");
	JLabel text2=new JLabel("题目如下:");
	
	
	Windows(){
		init();
	}

	//窗体显示
	public void init() {
		setBounds(400,300,500,400);
		setLayout(null);
		setTitle("panq随机出题小软件");
		
		text1.setBounds(50, 10, 60, 30);
		add(text1);
		
		textField.setBounds(120, 10, 180, 30);
		add(textField);
		
		text2.setBounds(150, 50, 200, 30);
		add(text2);
		
		button.setBounds(300, 10, 60, 30);
		button.addActionListener(this);
		add(button);

		JScrollPane js = new JScrollPane(taContent);
		js.setBounds(50, 100, 400, 200);//将文本区放入这个卷轴面板（JScrollPane）里面，这个卷轴面板的大小就是你的文本区大小。
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED#看英文也该知道，这个表示超过当前范围出现；也就是该出来的时候出来，不该出来的时候，没有。
//		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER 
//		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
		
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		VERTICAL_SCROLLBAR_AS_NEEDED#用于设置垂直滚动条策略，以便只在需要时显示垂直滚动条。 
//		VERTICAL_SCROLLBAR_NEVER#用于设置垂直滚动条策略，从而不会显示垂直滚动条。
//		VERTICAL_SCROLLBAR_ALWAYS#用于设置垂直滚动条策略，以便始终显示垂直滚动条。 
		add(js);
        taContent.setLineWrap(true);  
        taContent.setFont(new Font("微软雅黑",Font.BOLD,12));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//释放窗口
		setVisible(true);
	}
	
	//点击确定按钮的点击事件
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			String num=textField.getText().toString().trim();
			Main s=new Main();
			String result=s.readNUM(Integer.parseInt(num));
			taContent.setText(result+'\n');
		}
		
	}
	
	//测试
		public static void main(String[] args) {
			new Windows();
		}
}
