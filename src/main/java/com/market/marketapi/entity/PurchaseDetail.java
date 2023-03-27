package com.market.marketapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class PurchaseDetail {
    @EmbeddedId
    private PurchaseDetailPK id;
    @Column(name = "cantidad")
    private Integer quantity;
    private Double total;
    @Column(name = "estado")
    private Boolean active;
    @JsonIgnore
    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Purchase purchase;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private Product product;


    public PurchaseDetailPK getId() {
        return id;
    }

    public void setId(PurchaseDetailPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
