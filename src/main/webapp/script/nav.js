function createNav(){
    document.querySelector(".navbar").innerHTML = `
         <div class="nav">
                <img src="./icons/eagle.png" class="brand-logo" alt="">
                <div class="nav-items">
                    <div class="search">
                        <input type="text" class="search-box" placeholder="Cerca qui...">
                        <button class="search-btn">Cerca</button>
                    </div>
                    <a  href="EntryServlet?get=login"><img src="./icons/iconmonstr-user-6.svg" alt=""></a>
                    <a href="#"><img src="./icons/iconmonstr-shopping-cart-thin.svg" alt=""></a>

                </div>
            </div>
            <ul class="links-container">
                <li class="link-item"><a href="#" class="link">Home</a></li>
                <li class="link-item"><a href="#" class="link">Uomo</a></li>
                <li class="link-item"><a href="#" class="link">Donna</a></li>
                <li class="link-item"><a href="#" class="link">Bambino</a></li>
            </ul>
    `;
}
createNav();