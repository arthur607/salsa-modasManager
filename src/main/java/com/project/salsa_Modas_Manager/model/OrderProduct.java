package com.project.salsa_Modas_Manager.model;

import com.project.salsa_Modas_Manager.model.pk.OrderProductPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "tb_order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductPK id;
    private Integer quantity;
    private BigDecimal price;

    public OrderProduct() {
    }

    public OrderProduct(Integer quantity,Produto produto ,BigDecimal price) {
        id.setProduto(produto);
        this.quantity = quantity;
        this.price = price;
    }

    public Produto getProduto(){
       return id.getProduto();
    }

    public void setProduto(Produto produto){
       this.id.setProduto(produto);
    }

}
