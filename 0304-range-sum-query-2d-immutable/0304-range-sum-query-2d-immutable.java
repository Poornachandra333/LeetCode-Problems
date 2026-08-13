class NumMatrix {
    int prefix[][];
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j = 1;j < n+1;j++){
                prefix[i][j] = prefix[i][j-1]+prefix[i-1][j]-prefix[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        // for(int arr[]:prefix){
        //     System.out.println(Arrays.toString(arr));
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int i = row1+1;
        int j = col1+1;
        int k = row2+1;
        int l = col2+1;
        return prefix[k][l]-prefix[i-1][l]-prefix[k][j-1]+prefix[i-1][j-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */