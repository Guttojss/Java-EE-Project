package firstcup.ejb;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String userName;
    private static final Logger logger = Logger.getLogger(LoginBean.class.getName());

    public LoginBean() {
        // Construtor vazio, necessário para o CDI gerenciar o bean
    }

    // Método para processar o nome do usuário
    public String processUser() {
        // Simula o processamento do nome do usuário
        if (userName == null || userName.isEmpty()) {
            userName = "Visitante";  // Define "Guest" como nome padrão se não houver valor
        }
        logger.log(Level.INFO, "User logged in: {0}", userName);
        return "/user.xhtml";  // Navega para a página user.xhtml
    }

    // Getter e Setter para o nome do usuário
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}