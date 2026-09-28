package ir.maktabsharif.filter;

import ir.maktabsharif.model.Order;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/latest-order")
public class LatestOrderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        if (session == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/order");
            return;
        }

        Order order = (Order) session.getAttribute("latestOrder");

        if (order == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/order");
            return;
        }
        chain.doFilter(request, response);
    }
}
