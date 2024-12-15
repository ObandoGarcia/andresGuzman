package com.obando.springcloud.msvc.items.models;

public class Items {

    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public Items() {
    }

    public Items(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal(){
        return product.getPrice() * quantity;
    }
}
