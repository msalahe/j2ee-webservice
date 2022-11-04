package org.im.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.im.java.actions.TestAction;
import org.im.java.models.Candidat;
import org.im.java.models.Quiz;
import org.im.java.models.Test;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestController extends HttpServlet {
	private TestAction action;

	public TestController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		action = new TestAction();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (req.getRequestURI().endsWith("/saveuser")) {
				String nom = req.getParameter("nom");
				String prenom = req.getParameter("prenom");
				String idC = req.getParameter("idC");

				Candidat cn = new Candidat(0, prenom, nom, idC);
				System.out.println(cn.toJson());
				action.addUser(cn);
				resp.getWriter().print(cn.toJson());

			} else if (req.getRequestURI().endsWith("/listusers")) {
				List<Candidat> candidats = action.listCandidat();
				resp.getWriter().print(JSONMapper.getCandidat(candidats));
			} else if (req.getRequestURI().endsWith("/listquiz")) {
				List<Quiz> quiz = action.listQuiz();
				String json = new Gson().toJson(quiz);
				resp.getWriter().print(json);

			} else if (req.getRequestURI().endsWith("/addQuiz")) {
				String date = req.getParameter("date");
				System.out.println("date "+date);
				String sujet = req.getParameter("sujet");
				System.out.println("sujet "+sujet);

				int idC = Integer.parseInt(req.getParameter("idC"));
				System.out.println("idC "+req.getParameter("idC"));

				Test test = new Test(0, date, sujet, 0, idC);
				action.addTest(test);
				List<Test> tests = new ArrayList<>();
				tests.add(test);
				resp.getWriter().print(JSONMapper.getTest(tests));


			} else if (req.getRequestURI().endsWith("/listTest")) {
				List<Test> test = action.listTest();
				resp.getWriter().print(JSONMapper.getTest(test));
				
			}
		} catch (Exception e) {
			System.out.println("error " +e.getMessage());

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
