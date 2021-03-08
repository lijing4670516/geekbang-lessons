package org.geektimes.projects.user.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

@Path("/user")
public class UserController implements PageController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private UserService userService;

    @Override
    @Path("/registerUser")
    @GET
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = parsingRequest(request, User.class);
        UserServiceImpl userService = new UserServiceImpl();
        boolean register = userService.register(user);
        if (register) {
            return "success.jsp";
        } else {
            return "fail.jsp";
        }

    }


    /**
     * 解析请求参数
     * @param request 请求
     * @param clazz 需要的参数类型
     * @param <T> 参数
     * @return 请求参数
     * @throws IOException io异常
     */
    private <T> T parsingRequest(HttpServletRequest request, Class<T> clazz) throws IOException {
        StringBuilder data = new StringBuilder();
        String line = null;
        try(BufferedReader reader = request.getReader()) {
            while(null != (line = reader.readLine())) {
                data.append(line);
            }
        } catch (IOException e) {
            logger.info("执行失败：" + e.getMessage());
        }
        String s = data.toString().replace("/t", "");
        return JSON.parseObject(s, clazz);
    }
}
