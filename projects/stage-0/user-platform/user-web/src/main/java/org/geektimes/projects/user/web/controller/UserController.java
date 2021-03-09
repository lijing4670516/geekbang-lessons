package org.geektimes.projects.user.web.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.logging.Logger;

@Path("/user")
public class UserController implements PageController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());
    @Resource(name = "bean/UserService")
    private UserService userService;

//    @PostConstruct
//    public void init(){
//        this.userService = ComponentContext.getInstance().getComponent("bean/UserService");
//    }

    @Override
    @Path("/registerUser")
    @GET
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = parsingRequest(request, User.class);
        // 生成ID
//        user.GenerateId();
        if (!checkParam(user)) {
            return "fail.jsp";
        }
        boolean register = userService.register(user);
        if (register) {
            return "success.jsp";
        } else {
            return "fail.jsp";
        }

    }


    /**
     * 解析请求参数
     *
     * @param request 请求
     * @param clazz   需要的参数类型
     * @param <T>     参数
     * @return 请求参数
     * @throws IOException io异常
     */
    private <T> T parsingRequest(HttpServletRequest request, Class<T> clazz) throws IOException {
        StringBuilder data = new StringBuilder();
        String line = null;
        try (BufferedReader reader = request.getReader()) {
            while (null != (line = reader.readLine())) {
                data.append(line);
            }
        } catch (IOException e) {
            logger.info("执行失败：" + e.getMessage());
        }
        String dataString = data.toString();
        if (dataString.contains("&")) {
            try {
                T obj = clazz.newInstance();
                String[] split = dataString.split("&");
                for (String s : split) {
                    String[] name = s.split("=");
                    Field field = clazz.getDeclaredField(name[0]);
                    field.setAccessible(true);
                    field.set(obj, name[1]);
                }
                return obj;
            } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        String s = dataString.replace("/t", "");
        return JSON.parseObject(s, clazz);
    }

    /**
     * 参数检查
     * @param obj 检查对象
     * @param <T> 对象类型
     * @return 检查是否通过
     */
    private <T> Boolean checkParam(T obj){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        violations.forEach(c -> {
            logger.info(c.getPropertyPath() + ":" + c.getMessage());
        });
        if (CollectionUtils.isEmpty(violations)) {
            return true;
        }
        return false;
    }
}
