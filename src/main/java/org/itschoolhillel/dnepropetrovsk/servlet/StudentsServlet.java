package org.itschoolhillel.dnepropetrovsk.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by stephenvolf on 05/02/17.
 */
public class StudentsServlet extends HttpServlet {

    // /students/subscription?course_id=1/подписки студента
    // /students/courses?courses=java12/студенты на курсе
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String paramName = "";
        if (!pathInfo.isEmpty()) {
            String[] pathTokens = pathInfo.split("/");
            if (pathTokens.length > 1) {
                paramName = pathTokens[1];
            }
        }

        String userType;
        switch (paramName) {
            case "subscription":
                userType = "subscription";
                break;
            case "courses":
                userType = "courses";
                break;
            default:
                return;
        }

        Map<String, String[]> pathParams = req.getParameterMap();
        String course_id = pathParams.get("course_id")[0];
        String courses = pathParams.get("courses")[0];


    }
}
