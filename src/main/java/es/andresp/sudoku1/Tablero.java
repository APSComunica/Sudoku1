package es.andresp.sudoku1;

import java.util.Random;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Tablero extends Pane{
    
    Sudoku sudoku;
   // static final short TAM_CASILLA = 30;
    
    public Tablero() {
        sudoku = new Sudoku();
        sudoku.mostrarConsola();
        
        
        //Posición que yo le ponga
        Numeros numero = new Numeros();
        int filaY = 1;
        int columnaX = 3;
        numero.setLayoutY((filaY * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/10);
        numero.setLayoutX((columnaX * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/3);
        this.getChildren().add(numero);
        
        //Posición aleatoria
        
        Random random = new Random();
        
        for(int i=0; i<10; i++) {
            Numeros numero2 = new Numeros();
            int fila2 = random.nextInt(9);
            int columna2 = random.nextInt(9);
            numero2.setLayoutY((fila2 * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/10);
            numero2.setLayoutX((columna2 * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/3);
            this.getChildren().add(numero2);
            System.out.println(fila2+","+columna2);
        }

        
        
        // Verticales
        for(int i=0; i<10; i++) {
            
            Line line = new Line(Numeros.TAM_FICHA*i,0,Numeros.TAM_FICHA*i,Numeros.TAM_FICHA*9);
            this.getChildren().add(line);
            if(i==3) {
                line.setStroke(Color.RED);
            }
            if(i==6) {
                line.setStroke(Color.RED);
            }
        }

        // horizontales
        for(int i=0; i<10; i++) {
            Line line2 = new Line(0,Numeros.TAM_FICHA*i,Numeros.TAM_FICHA*9,Numeros.TAM_FICHA*i);
            this.getChildren().add(line2);
            if(i==3) {
                line2.setStroke(Color.RED);
            }
            if(i==6) {
                line2.setStroke(Color.RED);
            }
        }
        
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("Mouse clicked X,Y: " +
                    mouseEvent.getX() + " : " + mouseEvent.getY());
            int clicX = (int)mouseEvent.getX();
            int columna = clicX / Numeros.TAM_FICHA;
            //filas
            System.out.println("Columna: " + columna);
            int clicY = (int)mouseEvent.getY();
            int fila = clicY / Numeros.TAM_FICHA;
            System.out.println("Fila: " + fila);
            
            colocarFicha(columna, fila);
            
        });
    }
    private void colocarFicha(int columna, int fila) {
        Numeros numero = new Numeros();
        numero.setLayoutX((columna * Numeros.TAM_FICHA) + Numeros.TAM_FICHA/3);
        numero.setLayoutY((fila * Numeros.TAM_FICHA) + Numeros.TAM_FICHA/10);
        this.getChildren().add(numero);
        sudoku.colocarFicha(fila, columna);
        sudoku.mostrarConsola();
    }
}

