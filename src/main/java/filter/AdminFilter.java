package filter;

import service.StatisticsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", value = "/indexAdmin.jsp")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        Integer totalOrder = (Integer) request.getAttribute("totalOrder");
        if (totalOrder != null) filterChain.doFilter(servletRequest, servletResponse);
        else totalOrder = StatisticsService.getTotalBills();
        request.setAttribute("totalOrder", totalOrder);

        Double proceed = (Double) request.getAttribute("proceed");
        if ( proceed != null) filterChain.doFilter(servletRequest, servletResponse);
        else  proceed = StatisticsService.getProceed();
        request.setAttribute(" proceed",  proceed);

        Integer soldProduct = (Integer) request.getAttribute("soldProduct");
        if (soldProduct != null) filterChain.doFilter(servletRequest, servletResponse);
        else soldProduct = StatisticsService.getSoldProducts();
        request.setAttribute("soldProduct", soldProduct);

        Integer users = (Integer) request.getAttribute("users");
        if (users != null) filterChain.doFilter(servletRequest, servletResponse);
        else users = StatisticsService.getUsers();
        request.setAttribute("users", users);
        
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}