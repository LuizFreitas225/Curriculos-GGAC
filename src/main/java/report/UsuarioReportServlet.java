package report;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import br.unitins.curriculoggac.application.JDBCUtil;

// nao esquecer da barra /
@WebServlet("/usuarioreportservlet")
public class UsuarioReportServlet extends ReportServlet {

	private static final long serialVersionUID = -2694551539315919270L;

	@Override
	public String getArquivoJasper() {
		return "Template1.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("perfil", Integer.class);
		return param;
	}

	@Override
	public Connection getConnection() {
		return JDBCUtil.getConnection();
	}

}
