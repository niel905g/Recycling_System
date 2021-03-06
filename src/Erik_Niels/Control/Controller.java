package Erik_Niels.Control;

import Erik_Niels.Database.Calculate;
import Erik_Niels.Database.DB_Statements;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    // Deklaration af FXML variabler
    @FXML
    private Button typeAButton;
    @FXML
    private Button typeBButton;
    @FXML
    private Button typeCButton;
    @FXML
    private Button kvitteringButton;
    @FXML
    private TextField typeATotal;
    @FXML
    private TextField typeBTotal;
    @FXML
    private TextField typeCTotal;
    @FXML
    private TextField total;
    @FXML
    private TextField totalKr;
    @FXML
    private TextField typeAKr;
    @FXML
    private TextField typeBKr;
    @FXML
    private TextField typeCKr;
    @FXML
    private TextArea KtTextArea;


    // Metoderne til knapperne
    @FXML
    protected void typeAButtonAction() {

        // Lægger 1 til typeATotal
        typeATotal.setText(Calculate.addOne(typeATotal));

        // Lægger 1 til total
        total.setText(Calculate.addOne(total));

        // Lægger værdien for a fra databasen til typeAKr
        typeAKr.setText(Calculate.addA(typeAKr));

        // Lægger værdien for a fra databasen til totalKr
        totalKr.setText(Calculate.addA(totalKr));
    }

    @FXML
    protected void typeBButtonAction() {

        // Lægger 1 til typeBTotal
        typeBTotal.setText(Calculate.addOne(typeBTotal));

        // Lægger 1 til total
        total.setText(Calculate.addOne(total));

        // Lægger værdien for b fra databasen til typeBKr
        typeBKr.setText(Calculate.addB(typeBKr));

        // Lægger værdien for b fra databasen til totalKr
        totalKr.setText(Calculate.addB(totalKr));
    }

    @FXML
    protected void typeCButtonAction() {

        // Lægger 1 til typeCTotal
        typeCTotal.setText(Calculate.addOne(typeCTotal));

        // Lægger 1 til total
        total.setText(Calculate.addOne(total));

        // Lægger værdien for c fra databasen til typeCKr
        typeCKr.setText(Calculate.addC(typeCKr));

        // Lægger værdien for c fra databasen til totalKr
        totalKr.setText(Calculate.addC(totalKr));
    }

    @FXML
    protected void kvitteringButtonAction() {
        if (total.getText().equals("0") || total.getText().equals("")) {
            KtTextArea.appendText("*******************************************************\n" + "        Please insert container(s) first!! - Dummy!\n" + "*******************************************************");
        } else {

            String svarTekst = "              ************Kvittering************" + "\n" + "Type A: - " + typeATotal.getText() + " stk. - " + typeAKr.getText() + " kr." + "\n" + "Type A: Cans and bottles less than 1 liter" + "\n" + "Type B: - " + typeBTotal.getText() + " stk. - " + typeBKr.getText() + " kr." + "\n" + "Type B: Bottles of plastic 0,5 liters" + "\n" + "Type Control: - " + typeCTotal.getText() + " stk. - " + typeCKr.getText() + " kr." + "\n" + "Type Control: Cans and bottles more than 1 liter" + "\n" + "Total: - " + total.getText() + " stk. - " + totalKr.getText() + " kr." + "\n" + "Thank You kindly, for your business!\n"
                    + "              **********************************\n";
            KtTextArea.appendText(svarTekst + "\n");

            DB_Statements.insertTransaction(typeATotal,typeBTotal, typeCTotal, total, totalKr);

            typeATotal.setText("0");
            typeBTotal.setText("0");
            typeCTotal.setText("0");
            typeAKr.setText("0");
            typeBKr.setText("0");
            typeCKr.setText("0");
            total.setText("0");
            totalKr.setText("0");


        }
    }
}
