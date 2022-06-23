package controller;

import dao.ConnectionDB;
import dao.ProdottoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Prodotto;

import javax.management.timer.TimerMBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

@MultipartConfig
@WebServlet(name = "NewProductServlet", value = "/NewProductServlet")
public class NewProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // IMG caricata
        Part f = request.getPart("image");

        //Nome caricato
        String nomeP = request.getParameter("nome");

        //Descrizione caricata
        String Descrizione = request.getParameter("descrizione");

        //Prezzo caricato
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));

        //Categoria scelta
        //int idCategoria = Integer.parseInt(request.getParameter("Categoria"));


        // Prendo il nome dell'immagine caricata
        String imageFileName = f.getSubmittedFileName();

        // upload path where we have to upload our actual image
        String imgProduct = "./img/images/" + nomeP + "/" +   imageFileName;
        String uploadPath = "/Users/michelemenzione/Desktop/WebsiteEsame/src/main/webapp/img/images/" + nomeP;

        File file = new File(uploadPath);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            ProdottoDAO dao = new ProdottoDAO(ConnectionDB.getConnection());

            if ((dao.insertNewProduct(nomeP, prezzo, Descrizione, imgProduct, 1)) != 0) {
                try {

                    FileOutputStream fos = new FileOutputStream(uploadPath + "/" + imageFileName);
                    InputStream is = f.getInputStream();
                    byte[] data = new byte[is.available()];
                    is.read(data);
                    fos.write(data);
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Failed to create directory!");
        }


        // Uploading our selected image into the images folder
    }
}
