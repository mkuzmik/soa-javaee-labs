package soa.mkuzmik.ex4;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named("shoppingCart")
@SessionScoped
public class ShoppingCart implements Serializable {
    
    private Map<String, Integer> idPiecesMap = new HashMap<>();
    
    public void addProduct(String id, int amount) {
        if (idPiecesMap.containsKey(id)) {
            int targetAmount = idPiecesMap.get(id) + amount;
            if (targetAmount > 0) {
                idPiecesMap.put(id, targetAmount);
            } else {
                idPiecesMap.remove(id);
            }
        } else {
            idPiecesMap.put(id, amount);
        }
    }
    
    public void setAmount(String id, int amount) {
        if (amount <= 0)
            idPiecesMap.remove(id);
        else
            idPiecesMap.put(id, amount);
    }

    public Map<String, Integer> getIdPiecesMap() {
        return new HashMap<>(idPiecesMap);
    }
}
