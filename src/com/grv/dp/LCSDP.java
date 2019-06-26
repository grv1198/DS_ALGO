package com.grv.dp;

public class LCSDP {

	
	
	
	public int max(int a, int b){
		return a>b?a:b;
	}
	
	
	public int  getLCSLength(char[] a, char[] b, int m, int n){
		
		int[][] lcs= new int [m+1][n+1];
		for(int i=0;i<m;i++){
			
			
			
			for(int j=0;j<m;j++){
				
				
				if(i==0||j==0){
					lcs[i][j]=0;
				}
				else if(a[i-1]==b[j-1]){
					
					lcs[i][j]= 1+lcs[i-1][j-1]; 
				}
				
				else{
					lcs[i][j]= max(lcs[i-1][j],lcs[i][j-1]);
				}
					
				
			}
		}
		
		return lcs[m][n];
	}
	 
	
	public void getLCSSequence(char []a, char []b, int lcs[][], int m,int  n){
		
		
		
		
		
	}
}
