import java.util.Random;

/**
 * Created by Acer on 10.04.2017.
 */
public class Example {

    static Random generator = new Random();

    static int[][] fillArray(int[][] tab, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< m; j++) {
                tab[i][j] = generator.nextInt(1000);
            }
        }
        return tab;
    }

    static int[][] sortRows(int[][] tab, int n, int m) {
        int min, tmp;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m-1; j++) {
                min = j;
                for(int k = j+1; k < m; k++) {
                    if(tab[i][k] < tab[i][min]) {
                        min = k;
                    }
                }
                tmp = tab[i][min];
                tab[i][min] = tab[i][j];
                tab[i][j] = tmp;
            }
        }
        return tab;
    }

    static int[][] sortCols(int[][] tab, int n, int m) {
        int min, tmp;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n-1; j++) {
                min = j;
                for(int k = j+1; k < n; k++) {
                    if(tab[k][i] < tab[min][i]) {
                        min = k;
                    }
                }
                tmp = tab[min][i];
                tab[min][i] = tab[j][i];
                tab[j][i] = tmp;

            }
        }
        return tab;
    }

    static void printAll(int[][] tab, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println(System.lineSeparator());
        }
    }

    static int[][] sortAll(int[][] tab, int n, int m) {
        return sortCols(sortRows(tab, n, m), n, m);
    }

    public static void main(String[] args) {
        int N = 30;
        int M = 30;
        int[][] tab = new int[N][M];
        tab = fillArray(tab, N, M);
        printAll(tab, N, M);
        tab = sortAll(tab, N, M);
        printAll(tab, N, M);
    }
}
