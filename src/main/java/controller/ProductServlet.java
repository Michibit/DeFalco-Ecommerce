package controller;

import dao.CategoriaDAO;
import dao.ConnectionDB;
import dao.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Prodotto;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String work = request.getParameter("act");

        // IMG caricata
        Part f = request.getPart("image");
        //Nome caricato
        String nomeP = request.getParameter("nome");
        //Descrizione caricata
        String Descrizione = request.getParameter("descrizione");
        //Prezzo caricato
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        //Categoria scelta
        String genereCat = request.getParameter("Genere");
        String nomeCat = request.getParameter("NomeCategoria");

        CategoriaDAO dao1 = new CategoriaDAO(ConnectionDB.getConnection());
        if (!dao1.isCategoryIn(genereCat, nomeCat)) {
            dao1.insertNewCategory(genereCat, nomeCat);
        }

        // Prendo il nome dell'immagine caricata
        String imageFileName = f.getSubmittedFileName();

        // upload path where we have to upload our actual image
        String imgProduct = "./img/images/" + nomeP + "/" + imageFileName;
        String uploadPath = "/Users/michelemenzione/Desktop/WebsiteEsame/src/main/webapp/img/images/" + nomeP;


        String s1 = null;

        if (work.equalsIgnoreCase("add")) {
            File file = new File(uploadPath);
            // true se la cartella è stata creata, false altrimenti
            if (file.mkdirs()) {
                ProdottoDAO dao = new ProdottoDAO(ConnectionDB.getConnection());

                if ((dao.insertNewProduct(nomeP, prezzo, Descrizione, imgProduct, genereCat, nomeCat)) != 0) {
                    try {

                        FileOutputStream fos = new FileOutputStream(uploadPath + "/" + imageFileName);
                        InputStream is = f.getInputStream();
                        byte[] data = new byte[is.available()];
                        is.read(data);
                        fos.write(data);
                        fos.close();
                        s1 = "/WEB-INF/view/status/SuccesAdmin.jsp";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else s1 = "/WEB-INF/view/status/FailedAdmin.jsp";
            } else s1 = "/WEB-INF/view/status/FailedAdmin.jsp";
        } else if (work.equalsIgnoreCase("mod")) {
            ProdottoDAO dao = new ProdottoDAO(ConnectionDB.getConnection());
            Prodotto oldPr = (Prodotto) request.getSession().getAttribute("Prodotto");
            request.getSession().removeAttribute("Prodotto");
            String olduploadPath = "/Users/michelemenzione/Desktop/WebsiteEsame/src/main/webapp/img/images/" + oldPr.getNome();
            //Se la vecchia img è stata modificata
            if (!olduploadPath.equalsIgnoreCase(uploadPath)) {
                FileUtils.deleteDirectory(new File(olduploadPath));
            } else {
                File file = new File(uploadPath);
                if (!file.mkdirs()) {
                    s1 = "/WEB-INF/view/status/FailedAdmin.jsp";
                }
            }
            if ((dao.modificaProduct(nomeP, prezzo, Descrizione, imgProduct, genereCat, nomeCat, oldPr.getID())) != 0) {
                try {

                    FileOutputStream fos = new FileOutputStream(uploadPath + "/" + imageFileName);
                    InputStream is = f.getInputStream();
                    byte[] data = new byte[is.available()];
                    is.read(data);
                    fos.write(data);
                    fos.close();
                    s1 = "/WEB-INF/view/status/SuccesAdmin.jsp";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else s1 = "/WEB-INF/view/status/FailedAdmin.jsp";

        } else s1 = "/WEB-INF/view/DashboardAdminPage.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);

        dispatcher.forward(request, response);


        // Uploading our selected image into the images folder
    }
}
