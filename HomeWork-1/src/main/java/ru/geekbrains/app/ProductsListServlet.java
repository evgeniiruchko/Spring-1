package ru.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductsList", urlPatterns = "/list.html")
public class ProductsListServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductsListServlet.class);

    // Метод вызывается для каждого нового HTTP запроса к данному сервлету
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request");
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "яблоко", 59.9f));
        products.add(new Product(2, "огурец", 229.9f));
        products.add(new Product(3, "банан", 159.9f));
        products.add(new Product(4, "сахар-песок", 59.9f));
        products.add(new Product(5, "горох колотый", 89.9f));
        // получаем объект типа BufferedWriter и пишем в него ответ на пришедший запрос
        for (Product product: products) {
            //проблемы с кодировкой, вместо русских букв знаки вопросов
            res.getWriter().println("<h1>" + product.toString() + "</h1>");
        }
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    // При завершении работы веб приложения, контейнер вызывает этот метод для всех сервлетов из этого приложения
    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }

}
