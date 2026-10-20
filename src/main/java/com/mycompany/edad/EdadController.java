package com.mycompany.edad;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EdadController implements Initializable {

    @FXML
    private TextField txtedad;

    @FXML
    private Button btncalcular;

    @FXML
    private Button btnlimpiar;

    @FXML
    private Label txtresultado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void CalcularEdad(ActionEvent event) {

 String fechaIngresada = txtedad.getText();
    String textoFecha = txtedad.getText();
    
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate fechaNacimiento = LocalDate.parse(textoFecha, formato);
    LocalDate fechaActual = LocalDate.now();
    
    Period periodo = Period.between(fechaNacimiento, fechaActual);
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
    txtresultado.setText("Tiene " + anos + " años con " + meses + " meses");
    }

    @FXML
    private void LimpiarCampos(ActionEvent event) {
        txtedad.setText("");
        txtresultado.setText("");
        txtedad.requestFocus();
    }
}