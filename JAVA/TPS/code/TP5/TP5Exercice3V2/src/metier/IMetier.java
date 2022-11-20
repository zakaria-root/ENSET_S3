package metier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IMetier <T>{
    public T add(T t);
    public void saveAll() throws IOException, ClassNotFoundException;
    public void delete(long id);
    public T findById(long id);
    public List<T> getAll();
}
