window.onload = function () {

    loadProducts();
    insertProduct();
    deletehandeler();
    updateProduct();
}

function updateProduct(){
    const updateBtn = document.querySelector("#updateBtn")
    const selectEl = document.querySelector("select[name='p_no']")
    const nameEl = document.querySelector("#up-name")
    const priceEl = document.querySelector("#up-price")

    updateBtn.addEventListener("click", ()=>{

        const obj = {
            p_no : selectEl.value,
            p_name : nameEl.value,
            p_price : priceEl.value
        }

        fetch("/api/product", {
            method : "PUT",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(obj)
        })
        .then(res => res.text())
        .then(result => {
            console.log(result)
            loadProducts()
        })
    });
}

function deletehandeler() {
    const delBtn = document.querySelector("#delBtn");
    delBtn.addEventListener("click", () => {
        const pk = document.querySelector("input[name='pk']");
        deleteProduct(pk.value);
        pk.value = "";
    })
}

function loadProducts() {

    fetch("/api/product/all")
        .then(res => res.json())
        .then(products => {
            console.log(products)

            const productList = document.getElementById
            ("product-list");

            productList.innerHTML = "";

            products.forEach(product => {

                const item = document.querySelector(".item.temp")
                    .cloneNode(true);

                item.querySelector(".no").innerText = product.p_no;
                item.querySelector(".name").innerText = product.p_name;
                item.querySelector(".price").innerText = product.p_price;

                item.querySelector(".no").dataset.no = product.p_no;
                item.querySelector(".no").dataset.name = product.p_name;
                item.querySelector(".no").dataset.price = product.p_price;

                item.classList.remove("temp");
                productList.appendChild(item);

                item.lastElementChild.addEventListener("click", () => {
                    console.log(product.p_no);
                    deleteProduct(product.p_no);
                })
            })
            modal();

            //option
            const noEl = document.querySelectorAll(".no");
            const selectEl = document.querySelector("select[name='p_no']");

            let optionEl;
            noEl.forEach(noDiv => {
                let no = noDiv.innerText;
                optionEl += `<option value="${no}">no. ${no}</option>`;
            })
            selectEl.innerHTML = optionEl;
        }).catch(err => {
        console.log(err);
    })
}

function deleteProduct(no) {
    fetch(`/api/product/${no}`, {
        method: "DELETE"
    })
        .then(response => response.json())
        .then((result) => {
            console.log(result);
            loadProducts();
        }).catch(err => {
        console.log(err);
    })
}

function insertProduct() {

    const addBtn = document.querySelector("#add");
    const nameEl = document.querySelector("#name");
    const priceEl = document.querySelector("input[name='p_price']");

    console.log(addBtn, nameEl, priceEl);

    addBtn.addEventListener("click", () => {
        const obj = {
            p_name: nameEl.value,
            p_price: priceEl.value
        }
        console.log("add btn clicked");

        fetch(`/api/product`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(obj)
        })
            .then(res => res.json())
            .then((result) => {
                console.log(result);
                loadProducts();
            })
            .catch(err => {
                console.log(err);
            })

    })

}

function modal() {
    const openModalBtn = document.getElementById("openModal");
    const clostModalBtn = document.getElementById("closeModal");
    const myModal = document.getElementById("myModal");

    const openModalNo = document.querySelectorAll(".no");
    const openModalName = document.querySelector(".name");
    const openModalPrice = document.querySelector(".price");
    console.log(openModalNo, openModalName, openModalPrice);

    openModalNo.forEach(noEl => {
        noEl.addEventListener("click", (e) => {
            myModal.showModal();
            console.log(e.target.dataset);
            console.log(e.target.dataset.no);
            console.log(e.target.dataset.name);
            console.log(e.target.dataset.price);
        })

    })

    openModalBtn.addEventListener("click", () => {
        myModal.showModal();
    })

    clostModalBtn.addEventListener("click", () => {
        myModal.close();
    })

}