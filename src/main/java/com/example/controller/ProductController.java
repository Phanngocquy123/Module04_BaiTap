package com.example.controller;

import com.example.entity.Product;
import com.example.repository.IRepository;
import com.example.repository.impl.Repository;
import com.example.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "products", value = "/products")
public class ProductController extends Controller {
    private IRepository<Product, String> productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new Repository<>();
    }

    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize = 5;
        int currentPage = Integer.parseInt(req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage"));

        final String key = req.getParameter("key");
        List<Product> products = productRepository.findAll(Product.class);

        if (key != null) {
            products = products.stream()
                    .filter(d -> d.getProductId().contains(key.toLowerCase()) || d.getProductName().contains(key.toLowerCase()) || d.getManufacturer().contains(key.toLowerCase()))
                    .collect(Collectors.toList());
        }

        int total = (int) Math.ceil((double) products.size() / pageSize);
        products = products.stream().skip((currentPage - 1) * pageSize).limit(pageSize).collect(Collectors.toList());

        // truyền dữ liệu đến JSP
        req.setAttribute("products", products);
        req.setAttribute("total", total);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("key", key);
        req.getRequestDispatcher("views/products/list.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        String productName = req.getParameter("productName");
        String manufacturer = req.getParameter("manufacturer");
        int batch = Integer.parseInt(req.getParameter("batch"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        boolean productStatus = req.getParameter("productStatus") != null && req.getParameter("productStatus").equals("true");

        Product newProduct = new Product(productId, productName, manufacturer, new Date(), batch, quantity, productStatus);
        productRepository.add(newProduct);

        // resp.sendRedirect(req.getContextPath() + "/products");
        req.getRequestDispatcher("views/products/add.jsp").forward(req, resp);
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String deleteId = req.getParameter("id");
            productRepository.remove(Product.class, deleteId);
            index(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) {
        String editId = req.getParameter("id");
        try {
            if (editId != null){
                Product editProduct = productRepository.findId(editId, Product.class);
                req.setAttribute("product", editProduct);
                req.getRequestDispatcher("views/products/edit.jsp").forward(req, resp);
            } else {
                String productId = req.getParameter("productId");
                String productName = req.getParameter("productName");
                String manufacturer = req.getParameter("manufacturer");
                int batch = Integer.parseInt(req.getParameter("batch"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                boolean productStatus = req.getParameter("productStatus") != null && req.getParameter("productStatus").equals("true");

                Product saveProduct = new Product(productId, productName, manufacturer, new Date(), batch, quantity, productStatus);
                productRepository.edit(saveProduct);
                index(req, resp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
