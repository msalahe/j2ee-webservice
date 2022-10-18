package org.im.java.web;

import java.io.IOException;
import java.util.List;

import org.im.java.actions.TestAction;
import org.im.java.models.Candidat;
import org.json.JSONObject;

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
		if (req.getRequestURI().endsWith("/saveuser")) {
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String date_naissance = req.getParameter("date_naissance");
			Candidat cn = new Candidat(0, "salah", "el mamouni", "01/01/2001");
			action.addUser(cn);

		}else if(req.getRequestURI().endsWith("/listusers")) {
			List<Candidat> candidats = action.listCandidat();
			resp.getWriter().print(JSONMapper.getCandidat(candidats));
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
