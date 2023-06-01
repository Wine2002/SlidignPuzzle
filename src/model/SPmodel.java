package model;


public class SPmodel {
	private int rows ;
	private int cols ;
    
    
	public SPmodel() {
		super();
	}


	public SPmodel(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getCols() {
		return cols;
	}


	public void setCols(int cols) {
		this.cols = cols;
	}

}
