package ece326.hw3;

import java.awt.*;
import javax.swing.*;

public class SudokuBoard extends JPanel{


   
   SudokuCell[][] cells = new SudokuCell[9][9];
   
   
   
   public SudokuBoard() {
   
    super.setLayout(new GridLayout(3,3,5,5));
    
    JPanel panel1=new JPanel(new GridLayout(3, 3));
    JPanel panel2=new JPanel(new GridLayout(3, 3));
    JPanel panel3=new JPanel(new GridLayout(3, 3));
    JPanel panel4=new JPanel(new GridLayout(3, 3));
    JPanel panel5=new JPanel(new GridLayout(3, 3));
    JPanel panel6=new JPanel(new GridLayout(3, 3));
    JPanel panel7=new JPanel(new GridLayout(3, 3));
    JPanel panel8=new JPanel(new GridLayout(3, 3));
    JPanel panel9=new JPanel(new GridLayout(3, 3));
   
    panel1.setBorder(BorderFactory.createRaisedBevelBorder());
    panel2.setBorder(BorderFactory.createRaisedBevelBorder());
    panel3.setBorder(BorderFactory.createRaisedBevelBorder());
    panel4.setBorder(BorderFactory.createRaisedBevelBorder());
    panel5.setBorder(BorderFactory.createRaisedBevelBorder());
    panel6.setBorder(BorderFactory.createRaisedBevelBorder());
    panel7.setBorder(BorderFactory.createRaisedBevelBorder());
    panel8.setBorder(BorderFactory.createRaisedBevelBorder());
    panel9.setBorder(BorderFactory.createRaisedBevelBorder());
    
    for(int i=0;i<3;i++){
       for(int j=0;j<3;j++){
           cells[i][j] = new SudokuCell(i, j);
           
           panel1.add(cells[i][j]);
       }  
    }
    for(int i=0;i<3;i++){
       for(int j=3;j<6;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel2.add(cells[i][j]);
            
       }  
    }
    for(int i=0;i<3;i++){
       for(int j=6;j<9;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel3.add(cells[i][j]);
       }  
    }
    for(int i=3;i<6;i++){
       for(int j=0;j<3;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel4.add(cells[i][j]);
       }  
    }
    for(int i=3;i<6;i++){
       for(int j=3;j<6;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel5.add(cells[i][j]);
       }  
    }
    for(int i=3;i<6;i++){
       for(int j=6;j<9;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel6.add(cells[i][j]);
       }  
    }
    for(int i=6;i<9;i++){
       for(int j=0;j<3;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel7.add(cells[i][j]);
       }  
    }
    for(int i=6;i<9;i++){
       for(int j=3;j<6;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel8.add(cells[i][j]);
       }  
    }
    for(int i=6;i<9;i++){
       for(int j=6;j<9;j++){
           cells[i][j] = new SudokuCell(i, j);
            panel9.add(cells[i][j]);
       }  
    }
 
    super.add(panel1);
    super.add(panel2);
    super.add(panel3);
    super.add(panel4);
    super.add(panel5);
    super.add(panel6);
    super.add(panel7);
    super.add(panel8);
    super.add(panel9);
    
    
   }
   
   public void init(int i,int j,String s){
       
       cells[i][j].cells_col = j;
       cells[i][j].cells_row = i;
       cells[i][j].init(s);
   }
   
   public void paint(int i,int j,String s){
       cells[i][j].cells_col = j;
       cells[i][j].cells_row = i;
       cells[i][j].paint(s);
   }
   
}