package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * CentrumFXController as a *.fxml generated through SceneBuilder format class responsible for Central (root) window functionality;
 */

public class CentrumFXController {

    public String login;
    public DBUtil dbUtil;
    public BankiDAO bankiDAO;
    public JednostkiKrwiDAO jednostkiKrwiDAO;
    public ZapasyDAO zapasyDAO;

    /**
     * @param login - input username
     * @param dbUtil - DB connection pass;
     * @param (...)DAO - objects enabling the app window's tables columns/rows/values setup;
     */

    private int roznicaDniEmpty;

    /**
     * @param roznicaDniEmpty - a helpful variable being a pass to the addBloodUnitButtonOnClick() for the 1st. blood unit donation of a patient;
     */

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Banki> centrum_tabela_banki;

    @FXML
    private TableColumn<Banki, Integer> centrum_tabela_banki_bank_id;

    @FXML
    private TableColumn<Banki, String> centrum_tabela_banki_bank_nazwa;

    @FXML
    private TableColumn<Banki, String> centrum_tabela_banki_bank_miasto;

    @FXML
    private TableColumn<Banki, String> centrum_tabela_banki_bank_kod_pocztowy;

    @FXML
    private TableColumn<Banki, String> centrum_tabela_banki_bank_ulica;

    @FXML
    private TableColumn<Banki, String> centrum_tabela_banki_bank_email;

    @FXML
    private TableColumn<Banki, String> centrum_tabela_banki_bank_tel;

    @FXML
    private TextField dodaj_dawce_dawca_id;

    @FXML
    private TextField dodaj_dawce_dawca_waga;

    @FXML
    private TextField dodaj_dawce_dawca_data_urodzenia;

    @FXML
    private TextField dodaj_dawce_imie_nazwisko;

    @FXML
    private Button addDonorButton;

    @FXML
    private TextField dodaj_jednostke_jednostka_krwi_id;

    @FXML
    private TextField dodaj_jednostke_dawca_id;

    @FXML
    private TextField dodaj_jednostke_jednostka_krwi_Rh;

    @FXML
    private TextField dodaj_jednostke_jednostka_krwi_grupa;

    @FXML
    private TextField dodaj_jednostke_jednostka_krwi_data_oddania;

    @FXML
    private TextField dodaj_jednostke_bank_id;

    @FXML
    private Button addBloodUnitButton;

    @FXML
    private TableView<JednostkiKrwi> centrum_tabela_jednostki_krwi;

    @FXML
    private TableColumn<JednostkiKrwi, Integer> centrum_tabela_jednostki_krwi_dawca_id;

    @FXML
    private TableColumn<JednostkiKrwi, Float> centrum_tabela_jednostki_krwi_dawca_waga;

    @FXML
    private TableColumn<JednostkiKrwi, String> centrum_tabela_jednostki_krwi_dawca_data_urodzenia;

    @FXML
    private TableColumn<JednostkiKrwi, String> centrum_tabela_jednostki_krwi_dawca_imie_nazwisko;

    @FXML
    private TableColumn<JednostkiKrwi, Integer> centrum_tabela_jednostki_krwi_jednostka_krwi_id;

    @FXML
    private TableColumn<JednostkiKrwi, String> centrum_tabela_jednostki_krwi_jednostka_krwi_grupa;

    @FXML
    private TableColumn<JednostkiKrwi, String> centrum_tabela_jednostki_krwi_jednostka_krwi_Rh;

    @FXML
    private TableColumn<JednostkiKrwi, String> centrum_tabela_jednostki_krwi_jednostka_krwi_data_oddania;

    @FXML
    private TableColumn<JednostkiKrwi, String> centrum_tabela_jednostki_krwi_jednostka_krwi_status_var;

    @FXML
    private TableColumn<JednostkiKrwi, Integer> centrum_tabela_jednostki_krwi_bank_id;

    @FXML
    private TableView<Zapasy> centrum_tabela_zapasy;

    @FXML
    private TableColumn<Zapasy, String> centrum_tabela_zapasy_grupa;

    @FXML
    private TableColumn<Zapasy, String> centrum_tabela_zapasy_Rh;

    @FXML
    private TableColumn<Zapasy, Integer> centrum_tabela_zapasy_ilosc;

    @FXML
    private TableColumn<Zapasy, String> centrum_tabela_zapasy_potrzeba;

    @FXML
    private TableColumn<Zapasy, Integer> centrum_tabela_zapasy_bank_id;

    @FXML
    private TextField bank_id;

    @FXML
    private TextField bank_nazwa;

    @FXML
    private TextField bank_miasto;

    @FXML
    private TextField bank_kod_pocztowy;

    @FXML
    private TextField bank_ulica;

    @FXML
    private TextField bank_email;

    @FXML
    private TextField bank_tel;

    @FXML
    private Button addBankButton;

    @FXML
    private TextArea consoleTextArea;

    @FXML
    private Button disconnectButton;

    @FXML
    private Button pokazDaneButton;

    /**
     * ddBankButtonOnClick(ActionEvent event) as a class responsible for SQL INSERT operation;
     * contains a condition responsible for delivering all of the required user input data;
     * Carries exceptions;
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    @FXML
    void addBankButtonOnClick(ActionEvent event) throws SQLException, ClassNotFoundException {

        if (!bank_id.getText().isEmpty() && !bank_nazwa.getText().isEmpty() && !bank_nazwa.getText().isEmpty()
                && !bank_miasto.getText().isEmpty() && !bank_kod_pocztowy.getText().isEmpty()
                && !bank_ulica.getText().isEmpty() && !bank_email.getText().isEmpty()
                && !bank_tel.getText().isEmpty()) {

            StringBuilder sb = new StringBuilder("INSERT INTO bank (bank_id, bank_nazwa, bank_miasto, bank_kod_pocztowy, bank_ulica, bank_email, bank_tel)\n" +
                    "VALUES (");
            sb.append(bank_id.getText() + ",");
            sb.append("'" + bank_nazwa.getText() + "'" + ",");
            sb.append("'" + bank_miasto.getText() + "'" + ",");
            sb.append("'" + bank_kod_pocztowy.getText() + "'" + ",");
            sb.append("'" + bank_ulica.getText() + "'" + ",");
            sb.append("'" + bank_email.getText() + "'" + ",");
            sb.append("'" + bank_tel.getText() + "'");
            sb.append(");");
            String insertStmt = sb.toString();


            try {
                dbUtil.dbExecuteUpdate(insertStmt);
            } catch (SQLException e) {
                consoleTextArea.appendText("Error occurred while INSERT Operation."  + "\n");
                throw e;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            consoleTextArea.appendText("Bank added successfully!" + "\n");
        }
        else {consoleTextArea.appendText("Bank addition failed! - all textfields must be filled with data." + "\n");}

        loadData();

    }

    /**
     * addBloodUnitButtonOnClick(ActionEvent event) as a class responsible for SQL INSERT operation;
     * contains a condition responsible for delivering all of the required user input data;
     * takes care of the case when the return table variables are null;
     * Carries exceptions;
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    @FXML
    void addBloodUnitButtonOnClick(ActionEvent event) throws SQLException, ClassNotFoundException {

        if (!dodaj_jednostke_jednostka_krwi_id.getText().isEmpty() && !dodaj_jednostke_dawca_id.getText().isEmpty() && !dodaj_jednostke_jednostka_krwi_Rh.getText().isEmpty()
                && !dodaj_jednostke_jednostka_krwi_grupa.getText().isEmpty() && !dodaj_jednostke_jednostka_krwi_data_oddania.getText().isEmpty()
                && !dodaj_jednostke_bank_id.getText().isEmpty()) {

            ResultSet ostatniDzien = dbUtil.dbExecuteQuery("select ostatni_dzien("+dodaj_jednostke_dawca_id.getText()+");");
            ostatniDzien.next();
            String ostatniDzienString = ostatniDzien.getString(1);
            System.out.println("Ostatni dzien " + ostatniDzienString);

            String dzienOddaniaString = null;
            if(ostatniDzienString != null && !ostatniDzienString.isEmpty()){
                ResultSet dzienOddania = dbUtil.dbExecuteQuery("select dzien_oddania('"+dodaj_jednostke_jednostka_krwi_data_oddania.getText()+"');");
                dzienOddania.next();
                dzienOddaniaString = dzienOddania.getString(1);
            } else {
                roznicaDniEmpty=-1;
            }
            System.out.println("Dzien oddania: " + dzienOddaniaString);
            ResultSet roznicaRs = dbUtil.dbExecuteQuery("SELECT DATEDIFF('"+dzienOddaniaString+"', '"+ostatniDzienString+"');");
            roznicaRs.next();
            int roznicaDni = roznicaRs.getInt(1);


            System.out.println(roznicaDni);
            if (roznicaDni > 56 || roznicaDniEmpty==-1){


                roznicaDniEmpty=roznicaDniEmpty+1;
                StringBuilder sb = new StringBuilder("INSERT INTO jednostka_krwi (jednostka_krwi_id, dawca_id, jednostka_krwi_Rh, jednostka_krwi_grupa, jednostka_krwi_data_oddania, bank_id)\n" +
                        "VALUES (");
                sb.append(dodaj_jednostke_jednostka_krwi_id.getText() + ",");
                sb.append(dodaj_jednostke_dawca_id.getText() + ",");
                sb.append("'" + dodaj_jednostke_jednostka_krwi_Rh.getText() + "'" + ",");
                sb.append("'" + dodaj_jednostke_jednostka_krwi_grupa.getText() + "'" + ",");
                sb.append("'" + dodaj_jednostke_jednostka_krwi_data_oddania.getText() + "'" + ",");
                sb.append(dodaj_jednostke_bank_id.getText());
                sb.append(");");
                String insertStmt = sb.toString();

                try {
                    dbUtil.dbExecuteUpdate(insertStmt);
                } catch (SQLException e) {
                    consoleTextArea.appendText("Error occurred while INSERT Operation."+"\n");
                    throw e;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                consoleTextArea.appendText("Unit added successfully!"+"\n");
            } else {
                consoleTextArea.appendText("" + "\n"
                +  "Unit addition can succeed ONLY IF: donor's last visit did not took place within the last 56 days! " +
                "Otherwise, added unit is dropped immediately!" + "\n");
            }
        }

        else {consoleTextArea.appendText("Unit addition failed! - all textfields must be filled with data."+"\n");}

        loadData();


    }

    /**
     * addDonorButtonOnClick(ActionEvent event) as a class responsible for SQL INSERT operation;
     * contains a condition responsible for delivering all of the required user input data;
     * Carries exceptions;
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    @FXML
    void addDonorButtonOnClick(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        if (!dodaj_dawce_dawca_id.getText().isEmpty() && !dodaj_dawce_dawca_waga.getText().isEmpty() && !dodaj_dawce_dawca_data_urodzenia.getText().isEmpty()
                && !centrum_tabela_jednostki_krwi_dawca_imie_nazwisko.getText().isEmpty() && !centrum_tabela_jednostki_krwi_jednostka_krwi_id.getText().isEmpty()
                && !dodaj_dawce_imie_nazwisko.getText().isEmpty()) {

            if (Integer.parseInt(dodaj_dawce_dawca_waga.getText()) < 50) {
                consoleTextArea.appendText("Donor cannot weight less than 50kg!" + "\n");
                throw new IllegalArgumentException("Donor cannot weight less than 50kg!");
            }

            StringBuilder sb = new StringBuilder("INSERT INTO dawca (dawca_id, dawca_waga, dawca_data_urodzenia, dawca_imie_nazwisko)\n" +
                    "VALUES (");
            sb.append(dodaj_dawce_dawca_id.getText() + ",");
            sb.append(dodaj_dawce_dawca_waga.getText() + ",");
            sb.append("'" + dodaj_dawce_dawca_data_urodzenia.getText() + "'" + ",");
            sb.append("'" + dodaj_dawce_imie_nazwisko.getText() + "'");
            sb.append(");");
            String insertStmt = sb.toString();

            try {
                dbUtil.dbExecuteUpdate(insertStmt);
            } catch (SQLException e) {
                consoleTextArea.appendText("Error occurred while INSERT Operation."+"\n");
                throw e;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            consoleTextArea.appendText("Donor added successfully!" + "\n");
        }
        else {consoleTextArea.appendText("Donor addition failed! - all textfields must be filled with data." + "\n");}


        loadData();

    }

    /**
     * disconnectButtonOnClick(ActionEvent event) responsible for DB disconnection and the centrum window process termination;
     * @param event
     * @throws SQLException
     */

    @FXML
    void disconnectButtonOnClick(ActionEvent event) throws SQLException {

        dbUtil.dbDisconnect();

        Stage stage = (Stage) disconnectButton.getScene().getWindow();
        stage.close();

    }

    /**
     * pokazDaneButtonOnClick(ActionEvent event) carrying "on click" data load;
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    @FXML
    void pokazDaneButtonOnClick(ActionEvent event) throws SQLException, ClassNotFoundException {


        loadData();

    }

    /**
     * loadData() as a class responsible for the blood unit's reserves and last donation date update;
     * fills all the tables with data retrieved from the populate Objects (values) list;
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    private void loadData() throws SQLException, ClassNotFoundException {

        dbUtil.dbExecuteUpdate("call sprawdzenie_zapasow();");
        dbUtil.dbExecuteUpdate("call sprawdzenie_daty();");

        ObservableList<Banki> bankiObservableList = null;
        try {
            bankiObservableList = bankiDAO.showAllBanki();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        populateBanki(bankiObservableList);



        ObservableList<JednostkiKrwi> jednostkiKrwiObservableList = null;
        try {
            jednostkiKrwiObservableList = jednostkiKrwiDAO.showAllJednostki();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        populateJednostki(jednostkiKrwiObservableList);



        ObservableList<Zapasy> zapasyObservableList = null;
        try {
            zapasyObservableList = zapasyDAO.showAllZapasy();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        populateZapasy(zapasyObservableList);

    }

    private void populateBanki(ObservableList<Banki> bankiObservableList) {
        centrum_tabela_banki.setItems(bankiObservableList);
    }
    private void populateJednostki(ObservableList<JednostkiKrwi> jednostkiKrwiObservableList) {
        centrum_tabela_jednostki_krwi.setItems(jednostkiKrwiObservableList);
    }
    private void populateZapasy(ObservableList<Zapasy> zapasyObservableList) {
        centrum_tabela_zapasy.setItems(zapasyObservableList);
    }

    @FXML
    void initialize() {
        assert centrum_tabela_banki != null : "fx:id=\"centrum_tabela_banki\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_banki_bank_id != null : "fx:id=\"centrum_tabela_banki_bank_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_banki_bank_nazwa != null : "fx:id=\"centrum_tabela_banki_bank_nazwa\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_banki_bank_miasto != null : "fx:id=\"centrum_tabela_banki_bank_miasto\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_banki_bank_kod_pocztowy != null : "fx:id=\"centrum_tabela_banki_bank_kod_pocztowy\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_banki_bank_ulica != null : "fx:id=\"centrum_tabela_banki_bank_ulica\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_banki_bank_email != null : "fx:id=\"centrum_tabela_banki_bank_email\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_banki_bank_tel != null : "fx:id=\"centrum_tabela_banki_bank_tel\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_dawce_dawca_id != null : "fx:id=\"dodaj_dawce_dawca_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_dawce_dawca_waga != null : "fx:id=\"dodaj_dawce_dawca_waga\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_dawce_dawca_data_urodzenia != null : "fx:id=\"dodaj_dawce_dawca_data_urodzenia\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_dawce_imie_nazwisko != null : "fx:id=\"dodaj_dawce_imie_nazwisko\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert addDonorButton != null : "fx:id=\"addDonorButton\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_jednostke_jednostka_krwi_id != null : "fx:id=\"dodaj_jednostke_jednostka_krwi_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_jednostke_dawca_id != null : "fx:id=\"dodaj_jednostke_dawca_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_jednostke_jednostka_krwi_Rh != null : "fx:id=\"dodaj_jednostke_jednostka_krwi_Rh\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_jednostke_jednostka_krwi_grupa != null : "fx:id=\"dodaj_jednostke_jednostka_krwi_grupa\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_jednostke_jednostka_krwi_data_oddania != null : "fx:id=\"dodaj_jednostke_jednostka_krwi_data_oddania\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert dodaj_jednostke_bank_id != null : "fx:id=\"dodaj_jednostke_bank_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert addBloodUnitButton != null : "fx:id=\"addBloodUnitButton\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi != null : "fx:id=\"centrum_tabela_jednostki_krwi\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_dawca_id != null : "fx:id=\"centrum_tabela_jednostki_krwi_dawca_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_dawca_waga != null : "fx:id=\"centrum_tabela_jednostki_krwi_dawca_waga\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_dawca_data_urodzenia != null : "fx:id=\"centrum_tabela_jednostki_krwi_dawca_data_urodzenia\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_dawca_imie_nazwisko != null : "fx:id=\"centrum_tabela_jednostki_krwi_dawca_imie_nazwisko\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_jednostka_krwi_id != null : "fx:id=\"centrum_tabela_jednostki_krwi_jednostka_krwi_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_jednostka_krwi_grupa != null : "fx:id=\"centrum_tabela_jednostki_krwi_jednostka_krwi_grupa\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_jednostka_krwi_Rh != null : "fx:id=\"centrum_tabela_jednostki_krwi_jednostka_krwi_Rh\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_jednostka_krwi_data_oddania != null : "fx:id=\"centrum_tabela_jednostki_krwi_jednostka_krwi_data_oddania\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_jednostka_krwi_status_var != null : "fx:id=\"centrum_tabela_jednostki_krwi_jednostka_krwi_status_var\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_jednostki_krwi_bank_id != null : "fx:id=\"centrum_tabela_jednostki_krwi_bank_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_zapasy != null : "fx:id=\"centrum_tabela_zapasy\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_zapasy_grupa != null : "fx:id=\"centrum_tabela_zapasy_grupa\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_zapasy_Rh != null : "fx:id=\"centrum_tabela_zapasy_Rh\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_zapasy_ilosc != null : "fx:id=\"centrum_tabela_zapasy_ilosc\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_zapasy_potrzeba != null : "fx:id=\"centrum_tabela_zapasy_potrzeba\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert centrum_tabela_zapasy_bank_id != null : "fx:id=\"centrum_tabela_zapasy_bank_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert bank_id != null : "fx:id=\"bank_id\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert bank_nazwa != null : "fx:id=\"bank_nazwa\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert bank_miasto != null : "fx:id=\"bank_miasto\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert bank_kod_pocztowy != null : "fx:id=\"bank_kod_pocztowy\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert bank_ulica != null : "fx:id=\"bank_ulica\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert bank_email != null : "fx:id=\"bank_email\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert bank_tel != null : "fx:id=\"bank_tel\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert addBankButton != null : "fx:id=\"addBankButton\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert consoleTextArea != null : "fx:id=\"consoleTextArea\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert disconnectButton != null : "fx:id=\"disconnectButton\" was not injected: check your FXML file 'centrumFX.fxml'.";
        assert pokazDaneButton != null : "fx:id=\"pokazDaneButton\" was not injected: check your FXML file 'centrumFX.fxml'.";

    }
}
