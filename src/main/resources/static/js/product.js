window.onload = function () {

    loadProducts();
    insertProduct();
    deletehandeler();

}

function deletehandeler(){
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

function modal(){
     const openModalBtn = document.getElementById("openModal");
     const clostModalBtn = document.getElementById("closeModal");
     const myModal = document.getElementById("myModal");

     openModalBtn.addEventListener("click", () => {
         myModal.showModal();
     })

    clostModalBtn.addEventListener("click", () => {
        myModal.close();
    })

}