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

    //����������
    private int selectedNo;
    private int inputNo;

    //�������
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
        alert.setTitle("����");
        alert.setContentText("��ո�����������ǿգ�����������");
        if(event.getSource()==nextButton){
            //�ж�����
            if(inputNoTextField.getText().equalsIgnoreCase("")) {
                alert.showAndWait();
                return;
            }else if(selectedRedBalls.contains(Integer.parseInt(inputNoTextField.getText()))){
                alert.setTitle("����");
                alert.setContentText("��ո�����������ظ�������������");
                alert.showAndWait();
                return;
            }
            //��ȡ����Ĳ���
            inputNo=Integer.parseInt(inputNoTextField.getText());
            //������ɫ�򼯺�
            selectedRedBalls.add(inputNo);
            inputNoTextField.setText("");
            inforTextArea.setText("�������"+(selectedRedBalls.size()+1)+"������");
        }
        else if(event.getSource()==finishButton){
            RedBall.setSelectedRedBalls(selectedRedBalls);
            redBalls=RedBall.getRedBalls();
            inforTextArea.setText("��ɫ�����������ϣ�һ��"+redBalls.length+"����������"+"\r\n"+ Arrays.toString(redBalls));
        }
        else if(event.getSource()==countButton){
            //�ж�����
            if(selectedNoTextField.getText().equalsIgnoreCase("")) {
                alert.showAndWait();
                return;
            }
            //��ȡ����Ĳ���
            selectedNo=Integer.parseInt(selectedNoTextField.getText());
            //�����ɫ�����
            combinationsNo=CalculateCombination.calculatedCombinationsNo(selectedNo,redBalls.length);
            CalculateCombination.combine(0,selectedNo,redBalls);
            combinations=CalculateCombination.getCombinations();
            //�����excel���
            //Documents.storedinText(combinations);
            //inforTextArea.setText("������ϣ�һ��"+combinationsNo+"����ϣ�������Ͻ������ڼ��±��ļ���");
            Documents.storedinExcel(combinations);
            inforTextArea.setText("������ϣ�һ��"+combinationsNo+"����ϣ�������Ͻ�������Excel�ļ���");
        }
    }
}