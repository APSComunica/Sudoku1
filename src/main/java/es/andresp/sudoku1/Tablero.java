package es.andresp.sudoku1;

import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Tablero extends Pane{
    
    Sudoku sudoku;
   // static final short TAM_CASILLA = 30;
    TextField txf = new TextField();
    
    public Tablero() {
        sudoku = new Sudoku();
        sudoku.mostrarConsola();
        this.getChildren().add(txf);
        txf.setLayoutX(320);
        txf.setLayoutY(20);
        
        
//        //Posición que yo le ponga
//        Numeros numero = new Numeros();
//        int filaY = 1;
//        int columnaX = 3;
//        numero.setLayoutY((filaY * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/10);
//        numero.setLayoutX((columnaX * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/3);
//        this.getChildren().add(numero);
        
        //Posición aleatoria
        
        Random random = new Random();
        
        
        for(int i=0; i<10; i++) {
            int numeroR = random.nextInt(9)+1;
            Numeros numero2 = new Numeros(numeroR);
            int fila2;
            int columna2;        
            do{
                fila2 = random.nextInt(9);
                columna2 = random.nextInt(9);
            }
            while(sudoku.cuadricula[fila2][columna2]!='.');
            numero2.setLayoutY((fila2 * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/10);
            numero2.setLayoutX((columna2 * Numeros.TAM_FICHA)+ Numeros.TAM_FICHA/3);
            this.getChildren().add(numero2);
            System.out.println(fila2+","+columna2);
            sudoku.colocarFicha(fila2, columna2, numeroR);
            sudoku.mostrarConsola();
            
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
            System.out.println(txf.getText());
            String enteroString = txf.getText();
            int entero = Integer.valueOf(enteroString);
            
            
            
            if(fila<9 && columna<9){
                //si la casilla del array hay un . coloca la ficha
                if(sudoku.cuadricula[fila][columna]=='.'){
                    //solo si la fila y columna está dentro del tablero
                    //texto cuando lo cojo preguntar que solo sea 1 digito entre 1 y 9
                    if (entero>0 && entero<10){
                        colocarFicha(columna, fila, entero);
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Mensaje");
                        alert.setContentText("Error debes colocar un numero entre 1 y 9");
                        alert.showAndWait();
                    }
                }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Mensaje");
                        alert.setContentText("Debes colocar el numero en un sitio vacio");
                        alert.showAndWait();
                 }
            }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Mensaje");
                        alert.setContentText("Debes colocar el numero en las casillas del tablero");
                        alert.showAndWait();
             }           
            
            
            
            
        });
    }
    private void colocarFicha(int columna, int fila, int textf) {
        Numeros numero = new Numeros(textf);
        numero.setLayoutX((columna * Numeros.TAM_FICHA) + Numeros.TAM_FICHA/3);
        numero.setLayoutY((fila * Numeros.TAM_FICHA) + Numeros.TAM_FICHA/10);
        this.getChildren().add(numero);
        sudoku.colocarFicha(fila, columna, textf);
        sudoku.mostrarConsola();
    }
}

