package ru.geekbrains.homework6.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.homework6.model.Costumer;
import ru.geekbrains.homework6.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class CostumerRepo {
    private List<Costumer> costumersList;

    public Optional<Costumer> getProductByIndex(long index) {
        return costumersList.stream().filter(p -> p.getId() == index).findFirst();
    }
    public void addCostumer (Costumer costumer) {
        costumersList.add(costumer);
    }

    public void updateCostumer (Costumer costumer) {
        int index = costumersList.indexOf(costumer);
        costumersList.set(index, costumer);
    }

    public void deleteCostumer (Optional<Costumer> costumer) {
        costumersList.remove(costumer);
    }

    public void deleteById (float id) {
        costumersList.removeIf(p -> p.getId() == id);
    }

    public List<Costumer> getCostumersList() {
        return Collections.unmodifiableList(costumersList);
    }

}
