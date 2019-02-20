package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> simpleArray = new SimpleArray<>(12);

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }


    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int index = 0; index < simpleArray.size; index++) {
            if (simpleArray.get(index).getId().equals(id)) {
                simpleArray.set(index, model);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < simpleArray.size; index++) {
            if (simpleArray.get(index).getId().equals(id)) {
                simpleArray.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (int index = 0; index < simpleArray.size; index++) {
            if (simpleArray.get(index).getId().equals(id)) {
                result = simpleArray.get(index);
                break;
            }
        }
        return result;
    }

    public T ByObjectsIndex(int index) {
        return simpleArray.get(index);
    }
}
