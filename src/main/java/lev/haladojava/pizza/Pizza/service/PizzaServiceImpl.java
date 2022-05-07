package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.Pizza;
import lev.haladojava.pizza.Pizza.persist.PizzaDAO;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService{

    private PizzaDAO pizzaDAO;

    public PizzaServiceImpl(PizzaDAO pizzaDAO){
        this.pizzaDAO = pizzaDAO;
    }

    @Override
    public List listAllPizza() {
        return pizzaDAO.getAllPizza();
    }

    @Override
    public void modifyPasta(int id, String pasta) {
        Pizza pizza = pizzaDAO.getPizza(id);
        pizza.setPasta(pasta);
        pizzaDAO.updatePizza(pizza);
    }

    @Override
    public void modifyPizza(Pizza pizza) {
        pizzaDAO.updatePizza(pizza);
    }

    @Override
    public void createPizza(Pizza pizza) {
        if (pizza.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (pizzaDAO.idUsed(pizza.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        pizzaDAO.insertPizza(pizza);
    }
}
