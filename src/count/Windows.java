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
	JTextArea taContent=new JTextArea(10,10);//��¼��
	JButton button=new JButton("ȷ��");//ȷ����ť
	JLabel text1=new JLabel("�������");
	JLabel text2=new JLabel("��Ŀ����:");
	
	
	Windows(){
		init();
	}

	//������ʾ
	public void init() {
		setBounds(400,300,500,400);
		setLayout(null);
		setTitle("panq�������С���");
		
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
		js.setBounds(50, 100, 400, 200);//���ı����������������壨JScrollPane�����棬����������Ĵ�С��������ı�����С��
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED#��Ӣ��Ҳ��֪���������ʾ������ǰ��Χ���֣�Ҳ���Ǹó�����ʱ����������ó�����ʱ��û�С�
//		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER 
//		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
		
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		VERTICAL_SCROLLBAR_AS_NEEDED#�������ô�ֱ���������ԣ��Ա�ֻ����Ҫʱ��ʾ��ֱ�������� 
//		VERTICAL_SCROLLBAR_NEVER#�������ô�ֱ���������ԣ��Ӷ�������ʾ��ֱ��������
//		VERTICAL_SCROLLBAR_ALWAYS#�������ô�ֱ���������ԣ��Ա�ʼ����ʾ��ֱ�������� 
		add(js);
        taContent.setLineWrap(true);  
        taContent.setFont(new Font("΢���ź�",Font.BOLD,12));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//�ͷŴ���
		setVisible(true);
	}
	
	//���ȷ����ť�ĵ���¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			String num=textField.getText().toString().trim();
			Main s=new Main();
			String result=s.readNUM(Integer.parseInt(num));
			taContent.setText(result+'\n');
		}
		
	}
	
	//����
		public static void main(String[] args) {
			new Windows();
		}
}
