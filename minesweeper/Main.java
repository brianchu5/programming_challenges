import java.io.*;
import java.util.StringTokenizer;


class Main{
    public static void main(String args[]) throws IOException{
        int a,n,m;
        a=0;
        m=0;
        n=0;
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            a++;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                 n=Integer.parseInt(st.nextToken());
                 m=Integer.parseInt(st.nextToken());
            }
            if (n==0&&m==0){
                break;
            }
            char ar[][] = new char[n][m];
            initializeMines(ar);
            for (int i = 0; i<n; i++){
                s = br.readLine();
                for (int j=0; j<m;j++){
                    if (s.charAt(j) == '*'){
                        ar[i][j] = '*';
                        addMines(ar,i,j,n,m);
                       
                    }
                }
            }
            printMines(ar);
        }
    }


    public static void initializeMines(char[][] mines){
            for (int i = 0; i<mines.length;i++){
                for (int j = 0; j<mines[0].length;j++){
                    mines[i][j] = '0';
            }
        }
    }


    public static void addMines(char[][] mines ,int i, int j,int r, int c){

            for (int k = i - 1 ; k < i + 2; k++){
                for (int l = j - 1; l < j + 2; l++){
                    if ((k!=i | l!=j) & k>-1 & k<r & l>-1 & l<c ){
                        System.out.println(k+","+l);
                        mines[k][l] = Integer.toString(Character.getNumericValue(mines[k][l])+1).charAt(0);
                    }
                }
            }



    }
    public static void printMines(char[][]mines){
        for (int i = 0; i<mines.length;i++){
            for (int j = 0; j<mines[0].length;j++){
                System.out.print(mines[i][j]);
            }
            System.out.println();
        }
    }



}
