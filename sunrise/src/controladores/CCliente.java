package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Cliente;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.ClienteDao;

@WebServlet("/CCliente")
public class CCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	List<Cliente> lstCliente = new ArrayList<Cliente>();
	private ClienteDao clienteDAO;

	public CCliente() {
		clienteDAO = new ClienteDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String action = (String) req.getParameter("action");
		String relacion = (String) req.getParameter("relacion");

		res.setContentType("application/json");

		if (action != null) {

			if (action.equals("list")) {

				Listado(req, res, relacion);

			} else if (action.equals("create") || action.equals("update")) {
				Cliente c = new Cliente();

				if (req.getParameter("IdCliente") != null) {
					int IdCliente = Integer.parseInt(req
							.getParameter("IdCliente"));
					c.setIdCliente(IdCliente);
				}

				if (req.getParameter("DisplayText") != null) {
					String Nombre = req.getParameter("DisplayText");
					c.setNombre(Nombre);
				}
				if (req.getParameter("Apellido") != null) {
					String Apellido = req.getParameter("Apellido");
					c.setApellido(Apellido);
				}
				if (req.getParameter("Telefono") != null) {
					String Telefono = req.getParameter("Telefono");
					c.setTelefono(Telefono);
				}

				if (req.getParameter("Notas") != null) {
					String Notas = req.getParameter("Notas");
					c.setNotas(Notas);
				}

				if (action.equals("create")) {
					// Create new record
					clienteDAO.addCliente(c);
					lstCliente.add(c);
				} else if (action.equals("update")) {
					// Update existing record
					clienteDAO.updateCliente(c);
				}

				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Record", c);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);
			} else if (action.equals("delete")) {
				// Delete record
				if (req.getParameter("Value") != null) {
					String IdCliente = req.getParameter("Value");
					clienteDAO.deleteCliente(Integer.parseInt(IdCliente));

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);
					res.getWriter().print(jsonArray);
				}
			}

		}

	}

	void Listado(HttpServletRequest req, HttpServletResponse res,
			String relacion) {

		// Fetch Data from User Table
		try {
			System.out.print("entrando a listado" + "\n");
			if (relacion.equals("Hijo")) {
				System.out.print("entrando a if hijo" + "\n");
				// Fetch Data from Student Table

				lstCliente = clienteDAO.getAllClientes();
				// lstHabitacion=Habitaciondao.getAllRooms();
				System.out.print("saliendo de lista cliente Hijo"
						+ lstCliente.size());
				// Get Total Record Count for Pagination

				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Options", lstCliente);
				// JSONROOT.put("TotalRecordCount", total);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			} else if (relacion.equals("Padre")) {
				System.out.print("entrando a if Padre" + "\n");
				int startPageIndex = Integer.parseInt(req
						.getParameter("jtStartIndex"));
				int recordsPerPage = Integer.parseInt(req
						.getParameter("jtPageSize"));

				// Fetch Data from Student Table
				lstCliente = clienteDAO.getAllClientes(startPageIndex,
						recordsPerPage);

				System.out.print("saliendo de lista cliente Padre"
						+ lstCliente.size());
				// Get Total Record Count for Pagination

				int total = clienteDAO.getTotalRecordCount();

				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Records", lstCliente);
				JSONROOT.put("TotalRecordCount", total);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			}

		} catch (IOException e) {

			try {
				System.out.print("Error en listado Cliente");
				JSONROOT.put("Result", "ERROR");
				JSONROOT.put("Message", e + "dfdf");
				System.out.print(e);
				String error = gson.toJson(JSONROOT);

				res.getWriter().print(error);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

		}
	}
}
