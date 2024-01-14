import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
public class Game implements ActionListener{
    private JFrame frame;
    private JButton[][] numberButtons = new JButton[4][4];
    private JButton regenerate;
    private JTextField textField;
    private int emptyX,emptyY;
    private int searchedX,searchedY;

    /**
     * Constructor that creates the frame, play buttons, text field, regenerate button and number buttons.
     * Constructor in which the frame, play buttons, text box, regeneration button and number buttons are sets.
     * */
    public Game(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(616, 630);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("15-Image.jpg").getImage());

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setVisible(false);
        textField.setFont(new Font("Helvetica Neue",Font.BOLD,30));
        textField.setBackground(new Color(95, 95, 95));
        textField.setForeground(Color.white);
        frame.add(textField);

        regenerate = new JButton("Play again");
        regenerate.setFocusable(false);
        regenerate.setFont(new Font("Helvetica Neue",Font.BOLD,30));
        regenerate.setVisible(false);
        regenerate.addActionListener(this);
        regenerate.setBackground(new Color(95, 95, 95));
        regenerate.setBounds(200,300,210,100);
        regenerate.setForeground(Color.white);
        frame.add(regenerate);

        for(int i =0;i<4;i++) {
            for(int j = 0; j < 4; j++){
                numberButtons[i][j] = new JButton(String.valueOf(i+1));
                numberButtons[i][j].addActionListener(this);
                numberButtons[i][j].setFocusable(false);
                numberButtons[i][j].setFont(new Font("Fjalla One",Font.BOLD,40));
                numberButtons[i][j].setBackground(new Color(95, 95, 95));
                numberButtons[i][j].setForeground(Color.WHITE);
                frame.add(numberButtons[i][j]);
            }
        }

        numberButtons[0][0].setBounds(0,0,150,150);
        numberButtons[0][1].setBounds(150,0,150,150);
        numberButtons[0][2].setBounds(300,0,150,150);
        numberButtons[0][3].setBounds(450,0,150,150);
        numberButtons[1][0].setBounds(0,150,150,150);
        numberButtons[1][1].setBounds(150,150,150,150);
        numberButtons[1][2].setBounds(300,150,150,150);
        numberButtons[1][3].setBounds(450,150,150,150);
        numberButtons[2][0].setBounds(0,300,150,150);
        numberButtons[2][1].setBounds(150,300,150,150);
        numberButtons[2][2].setBounds(300,300,150,150);
        numberButtons[2][3].setBounds(450,300,150,150);
        numberButtons[3][0].setBounds(0,450,150,150);
        numberButtons[3][1].setBounds(150,450,150,150);
        numberButtons[3][2].setBounds(300,450,150,150);
        numberButtons[3][3].setBounds(450,450,150,150);

        this.generateNumbest();

        frame.setVisible(true);
    }

    /**
     * Method that records button presses.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == numberButtons[0][0]){
            searchedX = 0;
            searchedY = 0;
            this.swap(0,0);
        } else if(e.getSource() == numberButtons[0][1]){
            searchedX = 1;
            searchedY = 0;
            this.swap(0,1);
        } else if(e.getSource() == numberButtons[0][2]){
            searchedX = 2;
            searchedY = 0;
            this.swap(0,2);
        } else if(e.getSource() == numberButtons[0][3]){
            searchedX = 3;
            searchedY = 0;
            this.swap(0,3);
        } else if(e.getSource() == numberButtons[1][0]){
            searchedX = 0;
            searchedY = 1;
            this.swap(1,0);
        } else if(e.getSource() == numberButtons[1][1]){
            searchedX = 1;
            searchedY = 1;
            this.swap(1,1);
        } else if(e.getSource() == numberButtons[1][2]){
            searchedX = 2;
            searchedY = 1;
            this.swap(1,2);
        } else if(e.getSource() == numberButtons[1][3]){
            searchedX = 3;
            searchedY = 1;
            this.swap(1,3);
        } else if(e.getSource() == numberButtons[2][0]){
            searchedX = 0;
            searchedY = 2;
            this.swap(2,0);
        } else if(e.getSource() == numberButtons[2][1]){
            searchedX = 1;
            searchedY = 2;
            this.swap(2,1);
        } else if(e.getSource() == numberButtons[2][2]){
            searchedX = 2;
            searchedY = 2;
            this.swap(2,2);
        } else if(e.getSource() == numberButtons[2][3]){
            searchedX = 3;
            searchedY = 2;
            this.swap(2,3);
        } else if(e.getSource() == numberButtons[3][0]){
            searchedX = 0;
            searchedY = 3;
            this.swap(3,0);
        } else if(e.getSource() == numberButtons[3][1]){
            searchedX = 1;
            searchedY = 3;
            this.swap(3,1);
        } else if(e.getSource() == numberButtons[3][2]){
            searchedX = 2;
            searchedY = 3;
            this.swap(3,2);
        } else if(e.getSource() == numberButtons[3][3]){
            searchedX = 3;
            searchedY = 3;
            this.swap(3,3);
        } else if(e.getSource()== regenerate){
            textField.setVisible(false);
            frame.getContentPane().setBackground(Color.WHITE);
            regenerate.setVisible(false);
            for (int i = 0; i < numberButtons.length; i++){
                for(int j = 0; j < numberButtons.length; j++){
                    numberButtons[i][j].setVisible(true);
                }
            }
            this.generateNumbest();

        }
    }

    /**
     * Generates text of numbers 1-15 and " " into number buttons.
     */
    public void generateNumbest(){
        Random random = new Random();
        ArrayList<String> nums = new ArrayList<>();

        nums.add(" ");
        for(int i = 1; i < 16; i++){
            nums.add(String.valueOf(i));
        }
        int sum = 0;
        int rand = random.nextInt(16);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                numberButtons[i][j].setText(nums.get(rand));
                nums.remove(rand);

                if(numberButtons[i][j].getText().equals(" ")){
                    numberButtons[i][j].setVisible(false);
                    emptyX = j;
                    emptyY = i;
                }
                if(nums.size()!=0){
                    sum++;
                }else{
                    return ;
                }

                rand = random.nextInt(16-sum);
            }
        }
    }

    /**
     * Method that swaps the text from pressed button and button that has nothing in it.
     * If the checkEnd method returns 1 or 2, this method ends the game.
     * @param a Parameter, which determines the pressed button to swap the text with the empty button.
     * @param b Parameter, which determines the pressed button to swap the text with the empty button.
     */
    public void swap(int a, int b){

        if((emptyX + 1 == searchedX && emptyY == searchedY) ||(emptyX - 1 == searchedX && emptyY == searchedY) || (emptyY + 1 == searchedY && emptyX == searchedX) || (emptyY - 1 == searchedY && emptyX == searchedX)){
            String fill = numberButtons[emptyY][emptyX].getText();
            numberButtons[emptyY][emptyX].setVisible(true);
            numberButtons[emptyY][emptyX].setText(numberButtons[a][b].getText());
            numberButtons[a][b].setText(fill);
            numberButtons[a][b].setVisible(false);
            emptyX = b;
            emptyY = a;

            if(checkEnd() == 1){
                for (int i = 0; i < numberButtons.length; i++){
                    for(int j = 0; j < numberButtons.length; j++){
                        numberButtons[i][j].setVisible(false);
                    }
                }
                frame.getContentPane().setBackground(new Color(95, 95, 95));
                textField.setBounds(75,150,460,100);
                textField.setText("       You have won the game!");
                textField.setVisible(true);
                regenerate.setVisible(true);

            } else if(checkEnd() == 2){
                for (int i = 0; i < numberButtons.length; i++){
                    for(int j = 0; j < numberButtons.length; j++){
                        numberButtons[i][j].setVisible(false);
                    }
                }
                frame.getContentPane().setBackground(new Color(95, 95, 95));
                textField.setBounds(20,150,551,100);
                textField.setText("  There is no way to finish this puzzle!");
                textField.setVisible(true);
                regenerate.setVisible(true);
            }
        }
    }
    /**
     * Method that checks if the game is completed.
     * @return If the method returns 1, then all blocks are in the order in which player wins the game. If the method returns 2, then blocks are in the order where the puzzle cannot be solved. If the method returns 0, the buttons are not in any special configuration.
     */
    public int checkEnd(){
        if(numberButtons[0][0].getText().equals("1") && numberButtons[0][1].getText().equals("2") && numberButtons[0][2].getText().equals("3") && numberButtons[0][3].getText().equals("4") && numberButtons[1][0].getText().equals("5") && numberButtons[1][1].getText().equals("6") && numberButtons[1][2].getText().equals("7") && numberButtons[1][3].getText().equals("8") && numberButtons[2][0].getText().equals("9") && numberButtons[2][1].getText().equals("10") && numberButtons[2][2].getText().equals("11") && numberButtons[2][3].getText().equals("12") && numberButtons[3][0].getText().equals("13") && numberButtons[3][1].getText().equals("14") && numberButtons[3][2].getText().equals("15") && numberButtons[3][3].getText().equals(" ")){
            return 1;
        } else if(numberButtons[0][0].getText().equals("1") && numberButtons[0][1].getText().equals("2") && numberButtons[0][2].getText().equals("3") && numberButtons[0][3].getText().equals("4") && numberButtons[1][0].getText().equals("5") && numberButtons[1][1].getText().equals("6") && numberButtons[1][2].getText().equals("7") && numberButtons[1][3].getText().equals("8") && numberButtons[2][0].getText().equals("9") && numberButtons[2][1].getText().equals("10") && numberButtons[2][2].getText().equals("11") && numberButtons[2][3].getText().equals("12") && numberButtons[3][0].getText().equals("13") && numberButtons[3][1].getText().equals("15") && numberButtons[3][2].getText().equals("14") && numberButtons[3][3].getText().equals(" ")){
            return 2;
        }
        return 0;
    }
}