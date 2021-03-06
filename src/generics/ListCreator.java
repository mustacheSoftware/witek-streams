package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListCreator<T, R> {

    private List<T> src;

    ListCreator(List<T> src) {
        this.src = src;
    }

    public static <T, R> ListCreator<T, R> collectFrom(List<T> list) {
        return new ListCreator<T, R>(list);
    }

    public ListCreator<T, R> when(Selector<T> selector) {
        this.src = this.src.stream().filter(selector::select).collect(Collectors.toList());

        List<T> temp = new ArrayList<>();
        for(T t: src){
            if(selector.select(t)){
                temp.add(t);
            }
        }
        this.src = temp;

        return this;
    }

    public List<R> mapEvery(Mapper<T, R> mapper) {
        return this.src.stream().map(mapper::map).collect(Collectors.toList());
    }
}
