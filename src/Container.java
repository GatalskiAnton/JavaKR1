import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Container<T extends Comparable<T>> {
    private ArrayList<T> container;

    public Container(ArrayList<T> container) {
        this.container = container;
    }

    public T max()
    {
        Optional<T> max = container.stream().max(Comparator.naturalOrder());
       return max.get();
    }

    public T min()
    {
        Optional<T> min = container.stream().min(Comparator.naturalOrder());
        return min.get();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(T element : container)
            str.append(element.toString() + "\n");
        return str.toString();
    }
}
