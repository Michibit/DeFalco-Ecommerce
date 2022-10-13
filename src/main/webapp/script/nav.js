function createNav() {
    document.querySelector(".navbar").innerHTML = `
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
         <div class="nav">
                <img src="./icons/eagle.png" class="brand-logo" alt="">
                <div class="nav-items">
                    <div class="search">
                    <form action="SearchServlet" method="get">
                        <input type="text"  name="search" id="search" class="search-box" placeholder="Cerca qui...">
                        <button type="submit" class="search-btn">Cerca</button>
                        </form>
                    </div>
        <a  href="EntryServlet?get=profile"><i class='bx bx-user bx-md '></i></a>
        <a href="EntryServlet?get=car"><i class='bx bx-cart bx-md' ></i></a>
        <a href="EntryServlet?get=login"><i class='bx bx-log-in bx-flip-vertical bx-md bx-fade-right-hover'></i></a>


                </div>
            </div>
            <ul class="links-container">
                <li class="link-item"><a href="UtenteServlet?act=homepage" class="link">Home</a></li>
                <li class="link-item"><a href="UtenteServlet?act=prodotto&genere=Uomo" class="link">Uomo</a></li>
                <li class="link-item"><a href="UtenteServlet?act=prodotto&genere=Donna" class="link">Donna</a></li>
                <li class="link-item"><a href="UtenteServlet?act=prodotto&genere=Bambino" class="link">Bambino</a></li>
            </ul>
    `;
}

createNav();