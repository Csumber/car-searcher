package hu.bme.vik.ambrustorok.authserver.workaround;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WorkAroundFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if ("/oauth2/token".equals(((HttpServletRequest)request).getServletPath())){
            chain.doFilter(new ClientIdHidingRequestWrapper((HttpServletRequest) request), response);
        } else {
            chain.doFilter(request, response);
        }
    }

    /**
     * Hides the client_id parameter from the request.
     */
    private static class ClientIdHidingRequestWrapper extends HttpServletRequestWrapper {

        public ClientIdHidingRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            Map<String, String[]> result = new HashMap<>();
            super.getParameterMap().entrySet().stream().filter(e -> !"client_id".equals(e.getKey())).forEach(e -> result.put(e.getKey(), e.getValue()));
            return result;
        }
    }
}