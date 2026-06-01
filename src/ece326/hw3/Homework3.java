
package ece326.hw3;


import static ece326.hw3.SudokuCell.FONT_NUMBERS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Stack;

public class Homework3 extends JFrame implements ActionListener{

  public static final int WIDTH = 750;
  public static final int HEIGHT = 650;
  
  JMenu difficulty;
  boolean checked;
  URL url=null;
  JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,erase,back,rubik;
  JCheckBox check;
  SudokuBoard board;
  int solved_board[][] ;
  SudokuCell cell = new SudokuCell();
  MouseAdapter m1;
  Stack<String> history = new Stack<>();
  Stack<Integer> row_his = new Stack<>();
  Stack<Integer> col_his = new Stack<>();
  JOptionPane optPane = new JOptionPane("Congratulations!!!", JOptionPane.PLAIN_MESSAGE);
  JDialog d = new JDialog();

  public static final Color light_yellow = new Color(255, 255, 200);
  
  public static void main(String args[]) {
    Homework3 gui = new Homework3();
    gui.setVisible(true);
  }
  
  public Homework3() {
    super();
    setSize(WIDTH, HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    Container c=getContentPane();
    
    ImageIcon eraserIcon = new ImageIcon("eraser.png");
    Image new_eraserIcon = eraserIcon.getImage().getScaledInstance(20, 20,  
            java.awt.Image.SCALE_SMOOTH);
    ImageIcon undoIcon = new ImageIcon("undo.png");
    Image new_undoIcon = undoIcon.getImage().getScaledInstance(20, 20,  
            java.awt.Image.SCALE_SMOOTH);
    ImageIcon rubikIcon = new ImageIcon("rubik.png");
    Image new_rubikIcon = rubikIcon.getImage().getScaledInstance(20, 20,  
            java.awt.Image.SCALE_SMOOTH);

    difficulty = new JMenu("New Game");
    difficulty.setBackground(Color.LIGHT_GRAY);
    
    JMenuItem EasyMenuItem = new JMenuItem("Easy");
    EasyMenuItem.setBackground(Color.WHITE);
    EasyMenuItem.addActionListener(this);    
    difficulty.add(EasyMenuItem);
    
    JMenuItem IntermediateMenuItem = new JMenuItem("Intermediate");
    IntermediateMenuItem.setBackground(Color.WHITE);
    IntermediateMenuItem.addActionListener(this);
    difficulty.add(IntermediateMenuItem);
    
    JMenuItem ExpertMenuItem = new JMenuItem("Expert");
    ExpertMenuItem.setBackground(Color.WHITE);
    ExpertMenuItem.addActionListener(this);
    difficulty.add(ExpertMenuItem);
    
    JMenuBar bar = new JMenuBar();
    bar.add(difficulty);
    setJMenuBar(bar);
    
    board = new SudokuBoard();
    
    solved_board =new int[9][9];
    
    board.setBounds(0,100,735,300);
    
    c.add(board);
    
    JPanel buttonpanel=new JPanel(null);
    
    b1 = new JButton("1");
    b2 = new JButton("2");
    b3 = new JButton("3");
    b4 = new JButton("4");
    b5 = new JButton("5");
    b6 = new JButton("6");
    b7 = new JButton("7");
    b8 = new JButton("8");
    b9 = new JButton("9");
    erase = new JButton(new ImageIcon(new_eraserIcon));
    back = new JButton(new ImageIcon(new_undoIcon));
    check = new JCheckBox("Verify against solution");  
    rubik = new JButton(new ImageIcon(new_rubikIcon));
    
    check.setFont(new Font(check.getFont().getName(),check.getFont().getStyle(),24));
    
    b1.setBounds(0,0,75,35);
    b2.setBounds(85,0,75,35);
    b3.setBounds(170,0,75,35);
    b4.setBounds(255,0,75,35);
    b5.setBounds(340,0,75,35);
    b6.setBounds(425,0,75,35);
    b7.setBounds(510,0,75,35);
    b8.setBounds(595,0,75,35);
    b9.setBounds(0,45,75,35);
    erase.setBounds(85,45,75,35);
    back.setBounds(170,45,75,35);
    check.setBounds(255,45,330,35);
    rubik.setBounds(595,45,75,35);
    
    buttonpanel.add(b1);
    buttonpanel.add(b2);
    buttonpanel.add(b3);
    buttonpanel.add(b4);
    buttonpanel.add(b5);
    buttonpanel.add(b6);
    buttonpanel.add(b7);
    buttonpanel.add(b8);
    buttonpanel.add(b9);
    buttonpanel.add(erase);
    buttonpanel.add(back);
    buttonpanel.add(check);
    buttonpanel.add(rubik);
    
    buttonpanel.setBounds(5,450,700,100);
    
    c.add(buttonpanel);  
    
    
    }
  
  
   void buttons(){
  
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                            
                if(cell.status != CellStatus.GIVEN){  
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("1");
                    after_action();
                } 
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
             
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("2");
                    after_action();
                }
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                     
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("3");
                    after_action();
                }
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                       
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("4");
                    after_action();
                }
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                         
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("5");
                    after_action();
                }
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }
        });
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("6");
                    after_action();
                }
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }
        });
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("7");
                    after_action();
                }
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }    
        });
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("8");
                    after_action();
                } 
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }    
        });
        b9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText("9");
                    after_action();
                }
                red_warning();
                cell.setFocusable(true);
                cell.requestFocus();
                GameEnd();
            }    
        });
        
        erase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(cell.status != CellStatus.GIVEN){
                    history.push(cell.getText());
                    col_his.push(cell.cells_col);
                    row_his.push(cell.cells_row);
                    cell.setBackground(Color.WHITE);
                    cell.setText(" ");
                    after_action();
                }
                cell.setFocusable(true);
                cell.requestFocus();
            }    
        });
         
        check.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                JCheckBox checkbox = (JCheckBox)e.getSource();   
                
                if(checkbox.isSelected()){
                    check_solution();
                    checked=true;
                }
                else{
                    checked=false;
                    after_action();   
                        }
                cell.setFocusable(true);
                cell.requestFocus();  
            }
        });
        
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int row,col;
                if(!history.isEmpty()){
                    row=row_his.pop();
                    col=col_his.pop();
                    board.cells[row][col].setText(history.pop());
                    board.cells[row][col].setBackground(Color.LIGHT_GRAY);
                    board.cells[row][col].setBackground(Color.WHITE);
                }
                cell.setFocusable(true);
                cell.requestFocus();
            }
        });
        
        
        
    }
  
  public void Cells_Click_keyboard(){

        m1 = new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                cell = (SudokuCell) e.getComponent();
                    
                after_action();
                cell.setBackground(light_yellow);
                     
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if(cell.getText()!=null){
                            if(board.cells[i][j].getText().equals(cell.getText())
                            &(!" ".equals(cell.getText()))){           
                                board.cells[i][j].setBackground(light_yellow);
                                }
                            }      
                        }
                    }
                }
        };
        
        
        rubik.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
  
                for (int row = 0; row < 9; ++row) {
                    for (int col = 0; col < 9; ++col) {
                        board.paint(row, col, String.valueOf(solved_board[row][col]));
                        int k=0;
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            
                            if(board.cells[i][j].getText().equals(String.valueOf(solved_board[i][j]))){
                                k++;
                           
                            }     
                        }
                    }       
                    if(k==81){
                        cell.removeMouseListener (m1);
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        b5.setEnabled(false);
                        b6.setEnabled(false);
                        b7.setEnabled(false);
                        b8.setEnabled(false);
                        b9.setEnabled(false);
                        erase.setEnabled(false);
                        check.setEnabled(false);
                        rubik.setEnabled(false);
                        back.setEnabled(false);
                        difficulty.setEnabled(true);
                        check.setSelected(false);
                    }
                    }
                }     
            }
        });


        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                
               
                board.cells[row][col].setFocusable(true);
                board.cells[row][col].requestFocus();
                board.cells[row][col].addMouseListener(m1);
 
                 board.cells[row][col].addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent event) {
                    int key = event.getKeyCode();
                    
                    
                    if (key == 49) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("1");   
                            after_action();
  
                        }
                        red_warning();
                         
                    }
                    if (key == 50) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("2");
                            after_action();

                        }
                        red_warning();
                    }
                    if (key == 51) {
                        if(cell.status != CellStatus.GIVEN){
                             history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("3");
                            after_action();

                        }
                        red_warning();
                    }
                    if (key == 52) {
                        if(cell.status != CellStatus.GIVEN){
                             history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("4");
                            after_action();

                        }
                        red_warning();
                    }
                    if (key == 53) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("5");
                            after_action();
                        }
                        red_warning();
                    }
                    if (key == 54) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("6");
                            after_action();
                        }
                        red_warning();
                    }
                    if (key == 55) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("7");
                            after_action();
                        }
                        red_warning();
                    }
                    if (key == 56) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("8");
                            after_action();

                        }
                        red_warning();
                    }
                    if (key == 57) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText("9");
                            after_action();

                        }
                        red_warning();
                    }
                    if (key == 8 || key == 127) {
                        if(cell.status != CellStatus.GIVEN){
                            history.push(cell.getText());
                            col_his.push(cell.cells_col);
                            row_his.push(cell.cells_row);
                            cell.setBackground(Color.WHITE);
                            cell.setText(" ");
                            after_action();

                        }
                    }
                    GameEnd();
                    
                }
            }); 
            }  
        }
        buttons();
    
    }
  
    public void GameEnd(){
        int k=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                            
                if(board.cells[i][j].getText().equals(String.valueOf(solved_board[i][j]))){
                    k++;
                           
                }     
            }
        }
        if(k==81){
            cell.removeMouseListener (m1);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            erase.setEnabled(false);
            check.setEnabled(false);
            rubik.setEnabled(false);
            back.setEnabled(false);
            difficulty.setEnabled(true);
            check.setSelected(false);         
            d.setVisible(true);
        }
        
         
    }
  
    public boolean isNumberInRow(int cells[][],int s,int row){
       
       for(int i=0;i<9;i++){
            if(cells[row][i]==s){
               return true;
            }
       }
       return false;
   }
   
    public boolean isNumberInCol(int cells[][],int s,int col){
       
       for(int i=0;i<9;i++){
            if(cells[i][col]==s){
               return true;
            }
       }
       return false;
   }
   
    public boolean isNumberInBox(int cells[][],int s,int row,int col){
       int localrow = row - row % 3;
       int localcol = col -col %3;
       
       for(int i=localrow;i<localrow+3;i++){
            for(int j=localcol;j<localcol+3;j++){
                if(cells[i][j] == s){
                    return true;
                }
            }
       }
       return false;
   }
    
    public boolean isValidPlacement(int cells[][],int s,int row,int col){
       return !isNumberInRow(cells,s,row) && !isNumberInCol(cells,s,col)
               && !isNumberInBox(cells,s,row,col);
    }
   
   public boolean SolveSudoku(int[][] cells){
       for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(cells[i][j]==0){   
                    for(int trynum = 1; trynum <= 9;trynum++){ 
                        if(isValidPlacement(cells,trynum,i,j)){  
                           cells[i][j]=trynum;
                           
                            if(SolveSudoku(cells)){
                                return true;
                            }
                            else{
                                cells[i][j]=0;
                            }
                        } 
                    }
                    return false;
                }
            }
       }
       return true;
   }
   
   void check_solution(){
       for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if(!" ".equals(board.cells[i][j].getText())){
                    if(!board.cells[i][j].getText().equals(String.valueOf(solved_board[i][j]))){
                        board.cells[i][j].setBackground(Color.BLUE);
                    }
                }
            }
       }
   }
   
   
  
    void after_action(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board.cells[i][j].status == CellStatus.GIVEN ) {
                        board.cells[i][j].setBackground(Color.LIGHT_GRAY);        
                }
                else{
                    board.cells[i][j].setBackground(Color.WHITE);
                    if(checked){
                            check_solution();
                        }
                }  
            }
        }   
    }
    
    void red_warning(){
        int i,j,z,k,vertical=0,horizontal=0,box=0,row=0,col=0;
        
        for (i = 0; i < 9; i++) {
                if((cell.getText() == null ? board.cells[i][cell.cells_col].getText() == null 
                    : cell.getText().equals(board.cells[i][cell.cells_col].getText())) 
                    && board.cells[i][cell.cells_col].cells_row !=cell.cells_row){

                        vertical=1;
                        break;
                      
                }
            }
            for (j = 0; j < 9; j++) {
                if((cell.getText() == null ? board.cells[cell.cells_row][j].getText() == null 
                    : cell.getText().equals(board.cells[cell.cells_row][j].getText())) 
                    && board.cells[cell.cells_row][j].cells_col !=cell.cells_col){
                    
                    horizontal=1;
                    break;
                }      
            }
            
            if(cell.cells_col<3 && cell.cells_row<3){
                for (z = 0; z < 3; z++) {
                    for (k =0; k < 3; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
            else if((cell.cells_col>=3 && cell.cells_col<6) && cell.cells_row<3){
                for (z = 0; z < 3; z++) {
                    for (k =3; k < 6; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
            else if((cell.cells_col>=6 && cell.cells_col<9) && cell.cells_row<3){
                for (z = 0; z < 3; z++) {
                    for (k =6; k < 9; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
            else if((cell.cells_row>=3 && cell.cells_row<6) && cell.cells_col<3){
               for (z = 3; z < 6; z++) {
                    for (k =0; k < 3; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
            else if((cell.cells_row>=3 && cell.cells_row<6) && (cell.cells_col>=3 && cell.cells_col<6)){
               for (z = 3; z < 6; z++) {
                    for (k =3; k < 6; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
             else if((cell.cells_row>=3 && cell.cells_row<6) && (cell.cells_col>=6 && cell.cells_col<9)){
               for (z = 3; z < 6; z++) {
                    for (k =6; k < 9; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
            else if((cell.cells_row>=6 && cell.cells_row<9) && (cell.cells_col<3)){
               for (z = 6; z < 9; z++) {
                    for (k =0; k < 3; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
            else if((cell.cells_row>=6 && cell.cells_row<9) && (cell.cells_col>=3 && cell.cells_col<6)){
               for (z = 6; z < 9; z++) {
                    for (k =3; k < 6; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
            else if((cell.cells_row>=6 && cell.cells_row<9) && (cell.cells_col>=6 && cell.cells_col<9)){
               for (z = 6; z < 9; z++) {
                    for (k =6; k < 9; k++) {
                        if((cell.getText() == null ? board.cells[z][k].getText() == null 
                            : cell.getText().equals(board.cells[z][k].getText())) 
                            &&(cell.cells_row !=board.cells[z][k].cells_row 
                            && cell.cells_col !=board.cells[z][k].cells_col)){
                        
                            box=1;
                            row = z;
                            col = k;
                        }
                    }
                }
            }
   
            if(box==1){
                board.cells[row][col].setBackground(Color.RED);
                cell.setBackground(Color.WHITE);
                cell.setText(" ");
                
            }
            if(vertical==1){
                board.cells[i][cell.cells_col].setBackground(Color.RED);
                cell.setBackground(Color.WHITE);
                cell.setText(" ");
                
            }
            if(horizontal==1){
                board.cells[cell.cells_row][j].setBackground(Color.RED);
                cell.setBackground(Color.WHITE);
                cell.setText(" ");
                
            }
    }
  
  
  public void actionPerformed(ActionEvent e){
      String String = e.getActionCommand();
      
      
      ImageIcon penguinIcon = new ImageIcon("club-penguin.gif");
      optPane.setIcon(penguinIcon);
      JPanel buttonPanel = (JPanel)optPane.getComponent(1);
      JButton buttonOk = (JButton)buttonPanel.getComponent(0);
      buttonOk.setText("Continue");
      d = optPane.createDialog(null,"Sudoku Solved");

      if(String.equals("Easy")) { 
        try {
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            erase.setEnabled(true);
            check.setEnabled(true);
            rubik.setEnabled(true);
            back.setEnabled(true);
            url = new URL("http://gthanos.inf.uth.gr/~gthanos/sudoku/exec.php?difficulty=easy");    
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()) );
            StringBuilder builder = new StringBuilder();
            String inputLine;    
            while ((inputLine = in.readLine()) != null) {   
                    builder.append(inputLine);
                }
            in.close();
            
            int k=0;
            
            for(int i=0;i<9;i++){
               for(int j=0;j<9;j++){ 
                board.init(i, j, String.valueOf(" "));
                solved_board[i][j] = 0;
                board.cells[i][j].setBackground(Color.WHITE);
                k++;
               }
            }
            k=0;
            
            for(int i=0;i<9;i++){
               for(int j=0;j<9;j++){ 
                board.init(i, j, String.valueOf(builder.charAt(k)));
                if(".".equals(String.valueOf(builder.charAt(k)))){
                    solved_board[i][j] = 0;
                }
                else{
                    solved_board[i][j] = Integer.parseInt(String.valueOf(builder.charAt(k)));
                }
                k++;
               }
            }
            SolveSudoku(solved_board);
            Cells_Click_keyboard();
        } 
        catch(MalformedURLException ex) {}  
        catch(IOException ex) {}
      }
      
      else if(String.equals("Intermediate")){
          try {
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            erase.setEnabled(true);
            check.setEnabled(true);
            rubik.setEnabled(true);
            back.setEnabled(true);
            url = new URL("http://gthanos.inf.uth.gr/~gthanos/sudoku/exec.php?difficulty=intermediate");    
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()) );
            String inputLine;
            StringBuilder builder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) { 
                
                builder.append(inputLine);
                }      
            in.close();
            
            int k=0;
            
            for(int i=0;i<9;i++){
               for(int j=0;j<9;j++){ 
                board.init(i, j, String.valueOf(" "));
                solved_board[i][j] = 0;
                board.cells[i][j].setBackground(Color.WHITE);
                k++;
               }
            }

            k=0;
            
            for(int i=0;i<9;i++){
               for(int j=0;j<9;j++){ 
                board.init(i, j, String.valueOf(builder.charAt(k)));
                if(".".equals(String.valueOf(builder.charAt(k)))){
                    solved_board[i][j] = 0;
                }
                else{
                    solved_board[i][j] = Integer.parseInt(String.valueOf(builder.charAt(k)));
                }
                k++;
               }
            }
            SolveSudoku(solved_board);
            Cells_Click_keyboard();
            
        } 
        catch(MalformedURLException ex) {}  
        catch(IOException ex) {}   
      }
      
      else if(String.equals("Expert")){
          try {
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            erase.setEnabled(true);
            check.setEnabled(true);
            rubik.setEnabled(true);
            back.setEnabled(true);
            url = new URL("http://gthanos.inf.uth.gr/~gthanos/sudoku/exec.php?difficulty=expert");    
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()) );
            String inputLine;
            StringBuilder builder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                
                builder.append(inputLine);
                }      
            in.close();
            
            
            int k=0;
            
            
            for(int i=0;i<9;i++){
               for(int j=0;j<9;j++){ 
                board.init(i, j, String.valueOf(" "));
                solved_board[i][j] = 0;
                board.cells[i][j].setBackground(Color.WHITE);
                k++;
               }
            }
            
            k=0;
            
            for(int i=0;i<9;i++){
               for(int j=0;j<9;j++){ 
                board.init(i, j, String.valueOf(builder.charAt(k)));
                if(".".equals(String.valueOf(builder.charAt(k)))){
                    solved_board[i][j] = 0;
                }
                else{
                    solved_board[i][j] = Integer.parseInt(String.valueOf(builder.charAt(k)));
                }
                    
                k++;
               }
            }
            SolveSudoku(solved_board);
            Cells_Click_keyboard();
            
        } 
        catch(MalformedURLException ex) {}  
        catch(IOException ex) {}       
      }
     
  }
  
}

