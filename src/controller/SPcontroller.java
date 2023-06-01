package controller;

import View.SPview;
import model.SPmodel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class SPcontroller implements ActionListener {
	public  SPview v;
	public SPmodel m=new SPmodel(4,4);
	public  SPcontroller(SPview v) {
		this.v = v;
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
        v.flag = v.isWin();
        int temp;
        String fileName;
        if(v.flag==false)
        {
             String s = ae.getActionCommand();
            int r = Integer.parseInt(s.split(",")[0]);
            int c = Integer.parseInt(s.split(",")[1]);
        //get row no and column of clicked button
            if(v.board[r][c]!=-1)
            {
                if(r+1<m.getRows() && v.board[r+1][c]==-1)   //for up
                {
                    v.label[r][c].setIcon(new ImageIcon(""));
                    fileName= "Pics/" + v.board[r][c] + ".png";
                    v.label[r+1][c].setIcon(new ImageIcon(fileName));
                    temp = v.board[r][c];
                    v.board[r][c] = v.board[r+1][c];
                  v.board[r+1][c] = temp;
                }
                else if(r-1>=0 && v.board[r-1][c]==-1) //for down
                {
                	v.label[r][c].setIcon(new ImageIcon(""));
                    fileName = "Pics/" + v.board[r][c] + ".png";
                    v.label[r-1][c].setIcon(new ImageIcon(fileName));
                    temp = v.board[r][c];
                    v.board[r][c] = v.board[r-1][c];
                    v.board[r-1][c] = temp;
                }
                else if(c+1<m.getCols() && v.board[r][c+1]==-1) // for right
                {
                	v.label[r][c].setIcon(new ImageIcon(""));
                    fileName = "Pics/" + v.board[r][c] + ".png";
                    v.label[r][c+1].setIcon(new ImageIcon(fileName));
                    temp = v.board[r][c];
                    v.board[r][c] = v.board[r][c+1];
                    v.board[r][c+1] = temp;
                }
                else if(c-1>=0 && v.board[r][c-1]==-1) // for left
                {
                	v.label[r][c].setIcon(new ImageIcon(""));
                    fileName = "Pics/" + v.board[r][c] + ".png";
                    v.label[r][c-1].setIcon(new ImageIcon(fileName));
                    temp = v.board[r][c];
                    v.board[r][c] = v.board[r][c-1];
                    v.board[r][c-1] = temp;
                }
            }              
            
            v.flag = v.isWin();
            
            if(v.flag==true)
            {
               v.displayWinMsg();
            }
        }
       
    }
}
