package ir.maktabsharif.servlet;

import ir.maktabsharif.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "latestOrder", value = "/latest-order")
public class LatestOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        Order order = (Order) session.getAttribute("latestOrder");

        request.setAttribute("order", order);

        request.getRequestDispatcher("latest-order.jsp").forward(request, response);
    }
}
