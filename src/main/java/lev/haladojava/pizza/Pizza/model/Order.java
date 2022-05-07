package lev.haladojava.pizza.Pizza.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//id, pizza id, hotdogid, hamburgerid, extratopping, quantity, size, orderstatus amit figyelni kell pl módosításnál !
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @NotNull
    private int id;
    @NotBlank
    private String customer;
    @NotNull
    private int hamburgerID;
    @NotNull
    private int hamburgerQuantity;
    @NotNull
    private int hotDogID;
    @NotNull
    private int hotDogQuantity;
    @NotNull
    private int pizzaID;
    @NotNull
    private int pizzaQuantity;
    @NotNull
    @Min(25)
    @Max(50)
    private int pizzaSize;
    private String extraTopping;
    @NotBlank
    private String orderStatus;
}
