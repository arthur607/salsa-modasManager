package com.project.salsa_Modas_Manager.model.pk;

import com.project.salsa_Modas_Manager.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
public class OrderProductPK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "order_productPK")
    @Getter @Setter
    Produto produto;

}
