import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class RequestLoggingFilter implements Filter {
    private static final Logger logger = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("✅ RequestLoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String ipAddress = request.getRemoteAddr();
        String method = req.getMethod();
        String uri = req.getRequestURI();
        String queryString = req.getQueryString();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        String fullURL = uri + (queryString != null ? "?" + queryString : "");

        logger.info("📥 [" + time + "] " +
                "IP: " + ipAddress +
                " | Method: " + method +
                " | URL: " + fullURL);

        // Tiếp tục chuỗi filter/servlet
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("❌ RequestLoggingFilter destroyed");
    }
}
