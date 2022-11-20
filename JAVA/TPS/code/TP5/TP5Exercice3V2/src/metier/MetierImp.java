package metier;

import java.io.*;
import java.util.List;

public class MetierImp<T> implements IMetier<T> {
    private List<T> list;
    private String fileName;

    public MetierImp(List<T> list, String fileName) throws IOException, ClassNotFoundException {
        this.list = list;
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (file.length() != 0) {
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fos);

                while (true){
                   try{
                       list.add((T) ois.readObject());
                   }catch(EOFException e){
                       break;
                   }
                }
            }

        }
    }


    @Override
    public T add(T t) {
        list.add(t);
        return t;
    }

    @Override
    public void saveAll() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(list);
        for (T object : list) {
            oos.writeObject(object);
        }
        oos.close();
        fos.close();
    }

    @Override
    public void delete(long id) {
        list.removeIf(t -> ((Client) t).getId() == id);
    }

    @Override
    public T findById(long id) {
        for (T t : list) {
            if (((Client) t).getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return list;
    }


}
