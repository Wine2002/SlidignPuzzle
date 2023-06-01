package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import View.SPview;
import model.SPmodel;

public class SPwin implements ActionListener {
	public  SPview v;
	public  SPmodel m=new SPmodel(4,4);
	public SPwin(SPview v) {
		super();
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if(s.equals("wingame")){
			System.out.println("da chay");
	    	int count=1;
	    	String filename;
	    	for(int i=0;i<m.getRows();i++){
	    		for(int j=0;j<m.getCols();j++){
	    			filename="Pics/" + count + ".png";
	    			if(count!=16){
	    			v.label[i][j].setIcon(new ImageIcon(filename));
	    			v.board[i][j]=count;
	    			}else{
	    			v.label[i][j].setIcon(new ImageIcon(""));
	    			v.board[i][j]=-1;
	    			}
	    			count=count+1;
	    		}
	    	}
		}
		boolean flag=false;
	    flag=v.isWin();
//	    if(flag)
//	    	v.displayWinMsg();
	    v.shuffleBoard();
	    String filename;
	    int count =1;
	    for(int i=0;i<m.getRows();i++){
    		for(int j=0;j<m.getCols();j++){
    			if(v.board[i][j] == count){
    				System.out.print("1\t");
    			}else{
    				System.out.print("0\t");
    			}
    			count ++;
    		}
    		System.out.println("");
	}
}
}