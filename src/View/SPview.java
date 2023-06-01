package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.SPcontroller;
import controller.SPwin;
import model.SPmodel;
public class SPview   {
	private SPmodel      m=new SPmodel(4,4);
	public SPcontroller ac=new SPcontroller(this);
	public SPwin		w =new SPwin(this);
    public int [][] board;
    public JFrame fr;
    public JPanel showpl;
	public JPanel mainPanel;
	public JButton [][] button;
	public JLabel [][] label;
	public Boolean flag;
//	public int m.getRows();
//	public int m.getCols();

    public SPview() 
    {
//    	m.getRows()=4;
//    	m.getCols()=4;
        board =new  int[m.getRows()][m.getCols()];
        initGUI();
    }
    public void initGUI()
    {
        fr = new JFrame("15 Puzzle Game");
        fr.setLayout(new BorderLayout());
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new GridLayout(4,4));
        showpl=new JPanel();
        showpl.setLayout(new GridLayout(1,1));
        button = new JButton[m.getRows()][m.getCols()];
        label  = new JLabel[m.getRows()][m.getCols()];
        Font ft=new Font("TimesRoman",Font.PLAIN,0);
        String text;
        JButton show=new JButton();
        show.setText("wingame");
        show.setBackground(Color.gray);
        show.setBorder(BorderFactory.createLineBorder(null));
        show.addActionListener(w);
        showpl.add(show);
        
        this.shuffleBoard();
        
        for(int i=0;i<m.getRows();i++)
        {
            for(int j=0;j<m.getCols();j++)
            {
            	button[i][j] = new JButton();
                text = i+","+j; 
                button[i][j].setText(text);
                button[i][j].setFont(ft);
                button[i][j].addActionListener(ac);
                //add text in jbutton 
                //add image in label;
                int val = board[i][j];
                String fileName;
                if(val!=-1)
                {
                    fileName = "Pics/" + val + ".png";
                    label[i][j] = new JLabel(new ImageIcon(fileName), JLabel.CENTER);                
//                    val = 16;
                }
                else
                {
                	label[i][j] = new JLabel("");                
                }
                button[i][j].add(label[i][j]);
                button[i][j].setBorder(BorderFactory.createLineBorder(Color.black,1));
                button[i][j].setBackground(Color.white);
                mainPanel.add(button[i][j]);
            }
        }
        
        fr.add(mainPanel,BorderLayout.CENTER);
        fr.setVisible(true);
        fr.setSize(1000,1000);
        fr.add(showpl,BorderLayout.SOUTH);
        fr.setLocationRelativeTo(null); 
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void shuffleBoard()
    {
        Random rand = new Random();
        int [] array = new int[16];
        for(int i=0;i<16;i++)
        {
            array[i] = i+1;
        }
        array[15] = -1;
        //đặt giá trị nút thứ 16 bằng -1
        //lấy 1 chỉ số ngầu nhiên từ 0 đến 15 bằng hàm random để swap cho giá trị thứ [i][j]
        for(int i=0;i<16;i++)
        {
            int index =  rand.nextInt(16);
            //replace element at random index with i index element
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        //lưu các gia trị vừa đảo vào mảng board
        //kiểm tra các giá trị bằng cách in ra màn hình console
        int count = 0;
        for(int i=0;i<m.getRows();i++)
        {
            for(int j=0;j<m.getCols();j++)
            {
            	board[i][j] = array[count];
                count = count + 1;
             System.out.print(board[i][j] + "\t");
            }
            //it is working
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }
    public Boolean isWin()
    {
        int count = 1;
        for(int i=0;i<m.getRows();i++)
        {
            for(int j=0;j<m.getCols();j++)
            {
                if(board[i][j]!=count && board[i][j]!=-1)
                {
                    return false;
                }
                count = count + 1;
            }
        }
        return true;
    }
    public void displayWinMsg()
    {
         JFrame frame = new JFrame("Chiến thắng!!!");
         JLabel label = new JLabel("Bạn đã chiến thắng!!! \n chúc mừng!!!",JLabel.CENTER);
         label.setFont(new Font("TimesRoman",Font.BOLD,20));
         label.setIcon(new ImageIcon("Pics/win.png"));
         frame.add(label);
        frame.setLayout(new GridLayout(1,1));
        frame.setSize(400,400);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }    	
}
