package com.example.testtablevew;

import com.example.testtablevew.Dao.ClientDao;
import com.example.testtablevew.Dao.CommandeDao;
import com.example.testtablevew.Etities.Client;
import com.example.testtablevew.Etities.Commande;
import com.example.testtablevew.Services.ClientService;
import com.example.testtablevew.Services.ClientServiceImp;
import com.example.testtablevew.Services.CommadeService;
import com.example.testtablevew.Services.CommandeServiceImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HelloController implements Initializable {

    @FXML
    private TableColumn<Commande, String> referenceCol;
    @FXML
    private TableColumn<Commande, String> dateCol;
    @FXML
    private TableColumn<Commande, Client> clientCol;
    @FXML
    private TableColumn<Commande, Double> prixCol;

    @FXML
    private TableColumn<Client, String> nomcol;
    @FXML
    private TableColumn<Client, String> prenomcol;
    @FXML
    private TableColumn<Client, String> adressecol;
    @FXML
    private TableColumn<Client, Integer> ageCol;
    @FXML
    private TableColumn<Client, String> telephoneCol;
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField searchClientFeild;
    @FXML
    private TextField searchCommandeFeild;
    @FXML
    private TextField refernceField;

    @FXML
    private TextField prixField;
    @FXML
    private ComboBox<Client> clientComboBox;
    @FXML
    private TableView<Client> tableClient;
    @FXML
    private TableView<Commande> tableCommande;
    private CommadeService commadeService;
    private ObservableList<Commande> commandes;

    @FXML
    public void onSearchClient(KeyEvent event) {
        if (event.getCode().equals(event.getCode().ENTER)) {
            String search = searchClientFeild.getText();
            tableClient.setItems(clients.stream().filter(client -> client.getNom().contains(search)).collect(Collectors.toCollection(FXCollections::observableArrayList)));
        }

    }

    @FXML
    void onAddClient(ActionEvent event) {
        Client client = new Client();
        client.setId((int) (Math.random() * 1000));
        client.setNom(nomField.getText());
        client.setPrenom(prenomField.getText());
        client.setAdresse(adresseField.getText());
        client.setAge(Integer.parseInt(ageField.getText()));
        client.setTelephone(telephoneField.getText());
        clientService.add(client);
        loadClient();
        clearClientFields();

    }

    public void clearClientFields() {
        nomField.clear();
        prenomField.clear();
        adresseField.clear();
        ageField.clear();
        telephoneField.clear();
    }

    @FXML
    void onUpdateClient(ActionEvent event) {
        Client client = tableClient.getSelectionModel().getSelectedItem();
        client.setNom(nomField.getText());
        client.setPrenom(prenomField.getText());
        client.setAdresse(adresseField.getText());
        client.setAge(Integer.parseInt(ageField.getText()));
        client.setTelephone(telephoneField.getText());
        clientService.update(client);
        loadClient();
    }

    @FXML
    void onDeleteClient(ActionEvent event) {
        Client client = tableClient.getSelectionModel().getSelectedItem();
        clientService.delete(client);
        loadClient();
    }

    @FXML
    void onDeleteAllClient(ActionEvent event) {
        clientService.deleteAll();
        loadClient();
    }


    @FXML
    void onSelectClient(MouseEvent event) {
        Client client = tableClient.getSelectionModel().getSelectedItem();
        if (client == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        } else {
            nomField.setText(client.getNom());
            prenomField.setText(client.getPrenom());
            adresseField.setText(client.getAdresse());
            ageField.setText(String.valueOf(client.getAge()));
            telephoneField.setText(client.getTelephone());
        }
    }

    @FXML
    public void onSearchCommande(KeyEvent event) {
        if (event.getCode().equals(event.getCode().ENTER)) {
            String search = searchCommandeFeild.getText();
            tableCommande.setItems(commandes.stream().filter(commande -> commande.getReference().contains(search)).collect(Collectors.toCollection(FXCollections::observableArrayList)));
        }
    }


    @FXML
    void onsearchClientByButton(ActionEvent event) {
        String search = searchClientFeild.getText();
        tableClient.setItems(clients.stream().filter(client -> client.getNom().contains(search)).collect(Collectors.toCollection(FXCollections::observableArrayList)));
    }

    @FXML
    void searchCommandeByButton(ActionEvent event) {
        String search = searchCommandeFeild.getText();
        tableCommande.setItems(commandes.stream().filter(commande -> commande.getReference().contains(search)).collect(Collectors.toCollection(FXCollections::observableArrayList)));
    }

    @FXML
    void onSelectCommande(MouseEvent event) {
        Commande commande = tableCommande.getSelectionModel().getSelectedItem();
        if (commande == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        } else {
            refernceField.setText(commande.getReference());


            prixField.setText(String.valueOf(commande.getPrix()));
            clientComboBox.setValue(commande.getClient());
        }
    }


    public void loadCommande() {
        commandes.clear();
        commandes.addAll(commadeService.findAll());
    }

    @FXML
    void onAddCommande(ActionEvent event) {
        Commande commande = new Commande();
        commande.setId((int) (Math.random() * 1000));
        commande.setReference(String.valueOf(refernceField.getText()));
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateCreation = dateFormat.format(date);
        commande.setDateCreation(dateCreation);
        commande.setPrix(Double.parseDouble(prixField.getText()));
        commande.setClient(clientComboBox.getSelectionModel().getSelectedItem());
        System.out.println(commande);
        commadeService.add(commande);
        loadCommande();
        clearCommandeFields();

    }

    public void clearCommandeFields() {
        refernceField.clear();
        prixField.clear();
    }

    @FXML
    void onUpdateCommande(ActionEvent event) {
        Commande commande = tableCommande.getSelectionModel().getSelectedItem();
        commande.setReference(String.valueOf(refernceField.getText()));
        commande.setPrix(Double.parseDouble(prixField.getText()));
        commande.setClient(clientComboBox.getSelectionModel().getSelectedItem());
        System.out.println(commande);
        commadeService.update(commande);
        loadCommande();
    }

    @FXML
    void onDeleteCommande(ActionEvent event) {
        Commande commande = tableCommande.getSelectionModel().getSelectedItem();
        commadeService.delete(commande);
        loadCommande();
    }

    @FXML
    void onDeleteAllCommande(ActionEvent event) {
        commadeService.deleteAll();
        loadCommande();
    }

    private ObservableList<Client> clients;
    private ClientService clientService;

    public void loadClient() {
        clients.clear();
        clients.addAll(clientService.findAll());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientService = new ClientServiceImp(new ClientDao());
        commadeService = new CommandeServiceImp(new CommandeDao());
        clients = FXCollections.observableArrayList(clientService.findAll());
        commandes = FXCollections.observableArrayList(commadeService.findAll());
        //todo : cols Client
        nomcol.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
        prenomcol.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
        adressecol.setCellValueFactory(new PropertyValueFactory<Client, String>("adresse"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("age"));
        telephoneCol.setCellValueFactory(new PropertyValueFactory<Client, String>("telephone"));
        // todo : cols Commande
        referenceCol.setCellValueFactory(new PropertyValueFactory<Commande, String>("reference"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Commande, String>("dateCreation"));
        prixCol.setCellValueFactory(new PropertyValueFactory<Commande, Double>("prix"));
        clientCol.setCellValueFactory(new PropertyValueFactory<Commande, Client>("client"));
        // todo: set combobox
        clientComboBox.setItems(clients);
        tableClient.setItems(clients);
        tableCommande.setItems(commandes);
    }
}