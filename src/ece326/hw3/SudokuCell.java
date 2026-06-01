
package ece326.hw3;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class SudokuCell extends JLabel{
   
   public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 24);

   
   int row, col;      
   String number;        
   CellStatus status; 
   
   int cells_row;
   int cells_col;
   
   public SudokuCell() {}

   public SudokuCell(int row, int col) {
      super();   
      this.row = row;
      this.col = col; 
      super.setBackground(Color.WHITE);
      super.setBorder(BorderFactory.createEtchedBorder());
      super.setOpaque(true);
      super.setHorizontalAlignment(JLabel.CENTER);
      super.setFont(FONT_NUMBERS);
   }

   
   public void init(String number) {
      this.number = number;
      
      if(".".equals(number)){
            this.number = " ";
            status = CellStatus.TO_GUESS ;
        }
        else{ 
            status = CellStatus.GIVEN ;
            super.setBackground(Color.LIGHT_GRAY);
            super.setForeground(Color.BLACK);
            super.setText(number);
        }
   }
   
   public void paint(String number) {
       this.number = number; 
       
       if(status == CellStatus.GIVEN ){
           super.setBackground(Color.LIGHT_GRAY);
       }
       else{
           super.setBackground(Color.WHITE);
       }
       super.setForeground(Color.BLACK);
       super.setText(number);
   }
   
   public void setText(String number){
       this.number = number;
   }
   
   public String getText(){
       return number;
   }
    
}
