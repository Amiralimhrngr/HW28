package ir.maktabsharif.servlet;

import ir.maktabsharif.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = getCustomerNameFromCookie(request);

        if (customerName != null) {
            request.setAttribute("customerName", customerName);
        }

        request.getRequestDispatcher("order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String customerName = request.getParameter("customerName");

        String productName = request.getParameter("productName");

        String priceText = request.getParameter("productPrice");

        String quantityText = request.getParameter("quantity");
        try {

            BigDecimal productPrice = new BigDecimal(priceText);

            int quantity = Integer.parseInt(quantityText);

            if (customerName == null || customerName.isBlank() || productName == null || productName.isBlank()
                    || productPrice.compareTo(BigDecimal.ZERO) < 0
                    || quantity <= 0) {

                request.setAttribute("error", "Invalid order information.");

                request.setAttribute("customerName", customerName);

                request.getRequestDispatcher("order.jsp").forward(request, response);

                return;
            }

            Order order = new Order(customerName, productName, productPrice, quantity);


            HttpSession session = request.getSession();

            session.setAttribute("latestOrder", order);

            // Store customer name in Cookie
            Cookie customerCookie = new Cookie("customerName", customerName);


//            customerCookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());

            response.addCookie(customerCookie);

            // Request attribute for JSP
            request.setAttribute("order", order);

            // Forward to result JSP
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (NumberFormatException e) {

            request.setAttribute("error", "Price and quantity must be valid numbers.");

            request.setAttribute("customerName", customerName);

            request.getRequestDispatcher("order.jsp").forward(request, response);
        }
    }

    private String getCustomerNameFromCookie(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {

            if ("customerName".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return null;
    }
}
