package metier;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class MetierClientImpl implements IMetier<Client> {
    private List<Client> clients;
    private String fileName;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MetierClientImpl(List<Client> clients, String fileName) throws IOException, ClassNotFoundException {
        this.clients = clients;
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fos);

            this.clients = (List<Client>) ois.readObject();
            ois.close();
            fos.close();
        }
    }

    @Override
    public Client add(Client c)  {
        if (c != null) {
            if (clients.contains(c)) {
                System.out.println("Client already exists");
            } else {
                clients.add(c);
//                saveAllClients();
                System.out.println("Client added successfully");
            }
            return c;
        }
        return null;
    }

    @Override
    public void saveAll() throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(clients);
        oos.close();
        fos.close();
        //sleep
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        FileInputStream fis = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//            clients.clear();
//            this.clients = (List<Client>) ois.readObject();

    }

    @Override
    public void delete(long id)  {
        clients.removeIf(client -> client.getId() == id);
//        saveAllClients();
    }

    @Override
    public List<Client> getAll() {

        if (clients.isEmpty()) {
            System.out.println("No clients found");
        } else {

            return clients;

        }
        return null;
    }

    @Override
    public Client findById(long id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MetierClientImpl that = (MetierClientImpl) o;
        return Objects.equals(clients, that.clients);
    }


}
