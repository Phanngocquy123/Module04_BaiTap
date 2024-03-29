package com.example.entity;

import com.example.util.Column;
import com.example.util.Id;
import com.example.util.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "Product")
public class Product {
    @Id(autoIncrement = false)
    @Column(name = "Product_id")
    private String productId;
    @Column(name = "Product_Name")
    private String productName;
    @Column(name = "Manufacturer")
    private String manufacturer;
    @Column(name = "Created")
    private Date created;
    @Column(name = "Batch")
    private int batch;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Product_Status")
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, String manufacturer, Date created, int batch, int quantity, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.created = created;
        this.batch = batch;
        this.quantity = quantity;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Date getCreated() {
        return created;
    }

    public int getBatch() {
        return batch;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductId(String productId) throws Exception {
        this.productId = productId;
    }

    public void setProductName(String productName) throws Exception {
        this.productName = productName;
    }

    public void setManufacturer(String manufacturer) throws Exception{
        this.manufacturer = manufacturer;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setBatch(int batch) throws Exception{
        this.batch = batch;
    }

    public void setQuantity(int quantity) throws Exception{
        this.quantity = quantity;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
    public static void showHeader(){
        System.out.println("===========================================DANH SÁCH SẢN PHẨM===========================================");
        System.out.println("| Product ID | Product Name | Manufacturer      | Created            | Batch | Quantity | Product Satus");
    }
    public void show(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(this.created);
        System.out.printf("| %-11s| %-13s| %-18s| %-19s| %-6d| %-9d| %s\n",
                this.productId, this.productName, this.manufacturer, formattedDate, this.batch, this.quantity, this.productStatus?"Hoạt động":"Không hoạt động");
    }
}
