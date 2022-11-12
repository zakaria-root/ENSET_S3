package metier;

import metier.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IMetierClient {

    public Client addClient(Client c) throws IOException;

    public void saveAllClients() throws IOException, ClassNotFoundException;

    public void deleteClient(long id) throws IOException;

    public List<Client> getAllClients() throws IOException, ClassNotFoundException;

    public Client findClinetById(long id);
}
