package es.andresp.sudoku1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Numeros extends Group{
    static final short TAM_FICHA = 30; 
    public Numeros (int jugador1){
        Circle circle1 = new Circle();
        circle1.setRadius(TAM_FICHA * 0.5);
        this.getChildren().add(circle1);
        circle1.setFill(Color.RED);
    }
}
