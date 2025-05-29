let product = {
    productName: "",
    productPrice: 0,
    productDescription: "",
    productImage: "",
    productCategory: "",
    productQuantity: 0,
    productBrand: ""
};

function addNewProduct(e) {
    e.preventDefault();
    product.productName = document.getElementById("product-name").value;
    product.productPrice = document.getElementById("product-price").value;
    product.productDescription = document.getElementById("product-description").value;
    product.productImage = document.getElementById("product-image").value;
    product.productCategory = document.getElementById("product-category").value;
    product.productQuantity = document.getElementById("product-quantity").value;
    product.productBrand = document.getElementById("product-brand").value;
    printProducts();
}
function printProducts() {
    let table = document.getElementById("product-list");
    let row = document.createElement('tr');

    for (let key in product) {
        let cell = document.createElement('td');
        cell.innerHTML = product[key];
        row.appendChild(cell);
    }
    table.appendChild(row);
}

