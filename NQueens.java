public class NQueens 
{
	int n; 
	int [][] board;

	public NQueens(int n)
	{
		this.n = n;
		board = new int[n][n];
	}

	boolean placeNQueens() throws Exception 
	{
		if(n<1)
		{
			throw new IllegalArgumentException("n can't be 1!");
		}

		if(n<4 && n>1)
		{
			throw new Exception("n can't be smaller than 4!");
		}
		return placeNQueens(0);
	}
	boolean placeNQueens(int row)
	{	
		if(row==n)
			return true;
	
	
		for(int col=0;col<n;col++){
			if(canPlaceAQueen(row,col))
			{
				board[row][col] = 1;
				if(placeNQueens(row+1))
				{
					return true;
				}
				else
				{
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	//This method will check if one can place a queen in a certain position on the chessboard
	boolean canPlaceAQueen(int row,int col)
	{
		int i,j;

		for(i=0;i<col;i++)
			if(board[row][i]==1)
				return false;
		for(i=row;i>=0;i--)
			for(j=col;j>=0;j--)
				if(board[i][j]==1)
					return false;
		for(i=row,j=col;j>=0 && i<n;i++,j--)
			if(board[i][j]==1)
				return false;
		return true;
	}

	//This method will print the board upon the successful placement of queens
	void printToConsole(int board[][], int n) throws Exception
	{
		if(n<1)
		{
			throw new IllegalArgumentException("n can't be 1!");
		}
		if(n<4 && n>1)
		{
			throw new Exception("n can't be smaller than 4!");
		}
	}

	// public void main(String[] args)
	// {
	// 	for(int col=0;col<n;col++) 
	// 	{
	// 		if(canPlaceAQueen(row,col))
	// 		{
	// 			board[row][col] = 1;
	// 		}
	// 		if(placeNQueens(row+1)){
	// 			return true;
	// 		}
	// 		else
	// 			board[row][col]=0;
	// 	}
	// 	return false;
	// }

}
