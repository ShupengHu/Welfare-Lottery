package user_interfance;
import balls.RedBall;
import computation.CalculateCombination;
import dataStorage.Documents;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    @FXML
    private AnchorPane pane;

    @FXML
    private Label selectedNoLable;

    @FXML
    private TextField selectedNoTextField;

    @FXML
    private TextField inputNoTextField;

    @FXML
    private Label inputNoLable;

    @FXML
    private TextArea inforTextArea;

    @FXML
    private Button countButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button finishButton;

    //软件输入参数
    private int selectedNo;
    private int inputNo;

    //计算参数
    private int[] redBalls;
    private ArrayList selectedRedBalls=new ArrayList();
    private int combinationsNo;
    private ArrayList<int[]> combinations;
    private Alert alert;

    @FXML
    public void initialize(){

    }

    @FXML
    void onButtonClick(ActionEvent event) throws IOException {
        alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle("警告");
        alert.setContentText("你刚刚输入的数据是空，请重新输入");
        if(event.getSource()==nextButton){
            //判断输入
            if(inputNoTextField.getText().equalsIgnoreCase("")) {
                alert.showAndWait();
                return;
            }else if(selectedRedBalls.contains(Integer.parseInt(inputNoTextField.getText()))){
                alert.setTitle("警告");
                alert.setContentText("你刚刚输入的数据重复，请重新输入");
                alert.showAndWait();
                return;
            }
            //获取输入的参数
            inputNo=Integer.parseInt(inputNoTextField.getText());
            //建立红色球集合
            selectedRedBalls.add(inputNo);
            inputNoTextField.setText("");
            inforTextArea.setText("请输入第"+(selectedRedBalls.size()+1)+"个号码");
        }
        else if(event.getSource()==finishButton){
            RedBall.setSelectedRedBalls(selectedRedBalls);
            redBalls=RedBall.getRedBalls();
            inforTextArea.setText("红色球号码输入完毕，一共"+redBalls.length+"个。他们是"+"\r\n"+ Arrays.toString(redBalls));
        }
        else if(event.getSource()==countButton){
            //判断输入
            if(selectedNoTextField.getText().equalsIgnoreCase("")) {
                alert.showAndWait();
                return;
            }
            //获取输入的参数
            selectedNo=Integer.parseInt(selectedNoTextField.getText());
            //计算红色球组合
            combinationsNo=CalculateCombination.calculatedCombinationsNo(selectedNo,redBalls.length);
            CalculateCombination.combine(0,selectedNo,redBalls);
            combinations=CalculateCombination.getCombinations();
            //输出到excel表格
            //Documents.storedinText(combinations);
            //inforTextArea.setText("计算完毕，一共"+combinationsNo+"个组合，所有组合结果输出在记事本文件内");
            Documents.storedinExcel(combinations);
            inforTextArea.setText("计算完毕，一共"+combinationsNo+"个组合，所有组合结果输出在Excel文件内");
        }
    }
}