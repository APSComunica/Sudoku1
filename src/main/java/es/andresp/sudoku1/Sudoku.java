package es.andresp.sudoku1;

public class Sudoku {
    char[][] cuadricula = new char[9][9];
    
    public Sudoku() {
        for(int f=1; f<9; f++) {
            for(int c=1; c<9; c++) {
                cuadricula[f][c] = '.';
            }
        }
    }
    
    public void mostrarConsola() {
        for(int f=1; f<9; f++) {
            for(int c=1; c<9; c++) {
                System.out.print(cuadricula[f][c]);
            }
            System.out.println(".");
        }        
    }
}
